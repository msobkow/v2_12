// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbSecGroupTableObj
	implements ICFGenKbSecGroupTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> members;
	private Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> allSecGroup;
	private Map< CFGenKbSecGroupByClusterIdxKey,
		Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > > indexByClusterIdx;
	private Map< CFGenKbSecGroupByClusterVisIdxKey,
		Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > > indexByClusterVisIdx;
	private Map< CFGenKbSecGroupByUNameIdxKey,
		ICFGenKbSecGroupObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecGroup";
	public static String TABLE_DBNAME = "secgrp";

	public CFGenKbSecGroupTableObj() {
		schema = null;
		members = new HashMap<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj>();
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByClusterVisIdx = null;
		indexByUNameIdx = null;
	}

	public CFGenKbSecGroupTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj>();
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByClusterVisIdx = null;
		indexByUNameIdx = null;
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
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByClusterVisIdx = null;
		indexByUNameIdx = null;
		List<ICFGenKbSecGroupObj> toForget = new LinkedList<ICFGenKbSecGroupObj>();
		ICFGenKbSecGroupObj cur = null;
		Iterator<ICFGenKbSecGroupObj> iter = members.values().iterator();
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
	 *	CFGenKbSecGroupObj.
	 */
	public ICFGenKbSecGroupObj newInstance() {
		ICFGenKbSecGroupObj inst = new CFGenKbSecGroupObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbSecGroupObj.
	 */
	public ICFGenKbSecGroupEditObj newEditInstance( ICFGenKbSecGroupObj orig ) {
		ICFGenKbSecGroupEditObj edit = new CFGenKbSecGroupEditObj( orig );
		return( edit );
	}

	public ICFGenKbSecGroupObj realiseSecGroup( ICFGenKbSecGroupObj Obj ) {
		ICFGenKbSecGroupObj obj = Obj;
		CFGenKbSecGroupPKey pkey = obj.getPKey();
		ICFGenKbSecGroupObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbSecGroupObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFGenKbSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.remove( keepObj.getPKey() );
					if( mapClusterVisIdx.size() <= 0 ) {
						indexByClusterVisIdx.remove( keyClusterVisIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbSecGroupByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFGenKbSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbSecGroupByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allSecGroup != null ) {
				allSecGroup.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGroup != null ) {
				allSecGroup.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFGenKbSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbSecGroupByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGroup( ICFGenKbSecGroupObj Obj ) {
		forgetSecGroup( Obj, false );
	}

	public void forgetSecGroup( ICFGenKbSecGroupObj Obj, boolean forgetSubObjects ) {
		ICFGenKbSecGroupObj obj = Obj;
		CFGenKbSecGroupPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbSecGroupObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFGenKbSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.remove( keepObj.getPKey() );
					if( mapClusterVisIdx.size() <= 0 ) {
						indexByClusterVisIdx.remove( keyClusterVisIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFGenKbSecGroupByUNameIdxKey keyUNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allSecGroup != null ) {
				allSecGroup.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFGenKbSchemaObj)schema).getSecGrpIncTableObj().forgetSecGrpIncByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				((ICFGenKbSchemaObj)schema).getSecGrpMembTableObj().forgetSecGrpMembByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				((ICFGenKbSchemaObj)schema).getSecGrpIncTableObj().forgetSecGrpIncByIncludeIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				((ICFGenKbSchemaObj)schema).getSecGroupFormTableObj().forgetSecGroupFormByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
			}
		}
	}

	public void forgetSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbSecGroupPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( members.containsKey( key ) ) {
			ICFGenKbSecGroupObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGroupByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFGenKbSecGroupObj> toForget = new LinkedList<ICFGenKbSecGroupObj>();
		ICFGenKbSecGroupObj cur = null;
		CFGenKbSecGroupByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbSecGroupObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGroupObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible )
	{
		if( indexByClusterVisIdx == null ) {
			return;
		}
		List<ICFGenKbSecGroupObj> toForget = new LinkedList<ICFGenKbSecGroupObj>();
		ICFGenKbSecGroupObj cur = null;
		CFGenKbSecGroupByClusterVisIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );
		if( indexByClusterVisIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( key );
			if( mapClusterVisIdx != null ) {
				Iterator<ICFGenKbSecGroupObj> iterDup = mapClusterVisIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterVisIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGroupObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFGenKbSecGroupObj> toForget = new LinkedList<ICFGenKbSecGroupObj>();
		ICFGenKbSecGroupObj cur = null;
		CFGenKbSecGroupByUNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbSecGroupObj createSecGroup( ICFGenKbSecGroupObj Obj ) {
		ICFGenKbSecGroupObj obj = Obj;
		CFGenKbSecGroupBuff buff = obj.getSecGroupBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().createSecGroup(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbSecGroupObj readSecGroup( CFGenKbSecGroupPKey pkey ) {
		return( readSecGroup( pkey, false ) );
	}

	public ICFGenKbSecGroupObj readSecGroup( CFGenKbSecGroupPKey pkey, boolean forceRead ) {
		ICFGenKbSecGroupObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbSecGroupBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbSecGroupObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbSecGroupObj lockSecGroup( CFGenKbSecGroupPKey pkey ) {
		ICFGenKbSecGroupObj locked = null;
		CFGenKbSecGroupBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbSecGroupObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGroup", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbSecGroupObj> readAllSecGroup() {
		return( readAllSecGroup( false ) );
	}

	public List<ICFGenKbSecGroupObj> readAllSecGroup( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroup";
		if( ( allSecGroup == null ) || forceRead ) {
			Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> map = new HashMap<CFGenKbSecGroupPKey,ICFGenKbSecGroupObj>();
			allSecGroup = map;
			CFGenKbSecGroupBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().readAllDerived( schema.getAuthorization() );
			CFGenKbSecGroupBuff buff;
			ICFGenKbSecGroupObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupObj realised = (ICFGenKbSecGroupObj)obj.realise();
			}
		}
		int len = allSecGroup.size();
		ICFGenKbSecGroupObj arr[] = new ICFGenKbSecGroupObj[len];
		Iterator<ICFGenKbSecGroupObj> valIter = allSecGroup.values().iterator();
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
		ArrayList<ICFGenKbSecGroupObj> arrayList = new ArrayList<ICFGenKbSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupObj> cmp = new Comparator<ICFGenKbSecGroupObj>() {
			public int compare( ICFGenKbSecGroupObj lhs, ICFGenKbSecGroupObj rhs ) {
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
					CFGenKbSecGroupPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbSecGroupObj readSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupByIdIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public ICFGenKbSecGroupObj readSecGroupByIdIdx( long ClusterId,
		int SecGroupId, boolean forceRead )
	{
		CFGenKbSecGroupPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupId( SecGroupId );
		ICFGenKbSecGroupObj obj = readSecGroup( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbSecGroupObj> readSecGroupByClusterIdx( long ClusterId )
	{
		return( readSecGroupByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbSecGroupObj> readSecGroupByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupByClusterIdx";
		CFGenKbSecGroupByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGroupByClusterIdxKey,
				Map< CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj>();
			ICFGenKbSecGroupObj obj;
			CFGenKbSecGroupBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupObj realised = (ICFGenKbSecGroupObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGroupObj arr[] = new ICFGenKbSecGroupObj[len];
		Iterator<ICFGenKbSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGroupObj> arrayList = new ArrayList<ICFGenKbSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupObj> cmp = new Comparator<ICFGenKbSecGroupObj>() {
			public int compare( ICFGenKbSecGroupObj lhs, ICFGenKbSecGroupObj rhs ) {
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
					CFGenKbSecGroupPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGroupObj> readSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible )
	{
		return( readSecGroupByClusterVisIdx( ClusterId,
			IsVisible,
			false ) );
	}

	public List<ICFGenKbSecGroupObj> readSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupByClusterVisIdx";
		CFGenKbSecGroupByClusterVisIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );
		Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> dict;
		if( indexByClusterVisIdx == null ) {
			indexByClusterVisIdx = new HashMap< CFGenKbSecGroupByClusterVisIdxKey,
				Map< CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByClusterVisIdx.containsKey( key ) ) {
			dict = indexByClusterVisIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj>();
			ICFGenKbSecGroupObj obj;
			CFGenKbSecGroupBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByClusterVisIdx( schema.getAuthorization(),
				ClusterId,
				IsVisible );
			CFGenKbSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupObj realised = (ICFGenKbSecGroupObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterVisIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGroupObj arr[] = new ICFGenKbSecGroupObj[len];
		Iterator<ICFGenKbSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGroupObj> arrayList = new ArrayList<ICFGenKbSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupObj> cmp = new Comparator<ICFGenKbSecGroupObj>() {
			public int compare( ICFGenKbSecGroupObj lhs, ICFGenKbSecGroupObj rhs ) {
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
					CFGenKbSecGroupPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbSecGroupObj readSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		return( readSecGroupByUNameIdx( ClusterId,
			Name,
			false ) );
	}

	public ICFGenKbSecGroupObj readSecGroupByUNameIdx( long ClusterId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFGenKbSecGroupByUNameIdxKey,
				ICFGenKbSecGroupObj >();
		}
		CFGenKbSecGroupByUNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ICFGenKbSecGroupObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFGenKbSecGroupBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
			if( buff != null ) {
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbSecGroupObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbSecGroupObj updateSecGroup( ICFGenKbSecGroupObj Obj ) {
		ICFGenKbSecGroupObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().updateSecGroup( schema.getAuthorization(),
			Obj.getSecGroupBuff() );
		obj = (ICFGenKbSecGroupObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGroup( ICFGenKbSecGroupObj Obj ) {
		ICFGenKbSecGroupObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroup( schema.getAuthorization(),
			obj.getSecGroupBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		CFGenKbSecGroupPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupId( SecGroupId );
		ICFGenKbSecGroupObj obj = readSecGroup( pkey );
		if( obj != null ) {
			ICFGenKbSecGroupEditObj editObj = (ICFGenKbSecGroupEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbSecGroupEditObj)obj.beginEdit();
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

	public void deleteSecGroupByClusterIdx( long ClusterId )
	{
		CFGenKbSecGroupByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGroupByClusterIdxKey,
				Map< CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbSecGroupObj> iter = dict.values().iterator();
			ICFGenKbSecGroupObj obj;
			List<ICFGenKbSecGroupObj> toForget = new LinkedList<ICFGenKbSecGroupObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible )
	{
		CFGenKbSecGroupByClusterVisIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );
		if( indexByClusterVisIdx == null ) {
			indexByClusterVisIdx = new HashMap< CFGenKbSecGroupByClusterVisIdxKey,
				Map< CFGenKbSecGroupPKey, ICFGenKbSecGroupObj > >();
		}
		if( indexByClusterVisIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupPKey, ICFGenKbSecGroupObj> dict = indexByClusterVisIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterVisIdx( schema.getAuthorization(),
				ClusterId,
				IsVisible );
			Iterator<ICFGenKbSecGroupObj> iter = dict.values().iterator();
			ICFGenKbSecGroupObj obj;
			List<ICFGenKbSecGroupObj> toForget = new LinkedList<ICFGenKbSecGroupObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByClusterVisIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterVisIdx( schema.getAuthorization(),
				ClusterId,
				IsVisible );
		}
	}

	public void deleteSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFGenKbSecGroupByUNameIdxKey,
				ICFGenKbSecGroupObj >();
		}
		CFGenKbSecGroupByUNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ICFGenKbSecGroupObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
		}
	}
}
