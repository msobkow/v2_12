// Description: Java 11 Table Object implementation for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public class CFSecSecGroupTableObj
	implements ICFSecSecGroupTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecGroupPKey, ICFSecSecGroupObj> members;
	private Map<CFSecSecGroupPKey, ICFSecSecGroupObj> allSecGroup;
	private Map< CFSecSecGroupByClusterIdxKey,
		Map<CFSecSecGroupPKey, ICFSecSecGroupObj > > indexByClusterIdx;
	private Map< CFSecSecGroupByClusterVisIdxKey,
		Map<CFSecSecGroupPKey, ICFSecSecGroupObj > > indexByClusterVisIdx;
	private Map< CFSecSecGroupByUNameIdxKey,
		ICFSecSecGroupObj > indexByUNameIdx;
	public static String TABLE_NAME = "SecGroup";
	public static String TABLE_DBNAME = "secgrp";

	public CFSecSecGroupTableObj() {
		schema = null;
		members = new HashMap<CFSecSecGroupPKey, ICFSecSecGroupObj>();
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByClusterVisIdx = null;
		indexByUNameIdx = null;
	}

	public CFSecSecGroupTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecGroupPKey, ICFSecSecGroupObj>();
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByClusterVisIdx = null;
		indexByUNameIdx = null;
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
		allSecGroup = null;
		indexByClusterIdx = null;
		indexByClusterVisIdx = null;
		indexByUNameIdx = null;
		List<ICFSecSecGroupObj> toForget = new LinkedList<ICFSecSecGroupObj>();
		ICFSecSecGroupObj cur = null;
		Iterator<ICFSecSecGroupObj> iter = members.values().iterator();
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
	 *	CFSecSecGroupObj.
	 */
	public ICFSecSecGroupObj newInstance() {
		ICFSecSecGroupObj inst = new CFSecSecGroupObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFSecSecGroupObj.
	 */
	public ICFSecSecGroupEditObj newEditInstance( ICFSecSecGroupObj orig ) {
		ICFSecSecGroupEditObj edit = new CFSecSecGroupEditObj( orig );
		return( edit );
	}

	public ICFSecSecGroupObj realiseSecGroup( ICFSecSecGroupObj Obj ) {
		ICFSecSecGroupObj obj = Obj;
		CFSecSecGroupPKey pkey = obj.getPKey();
		ICFSecSecGroupObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecGroupObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFSecSecGroupByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFSecSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.remove( keepObj.getPKey() );
					if( mapClusterVisIdx.size() <= 0 ) {
						indexByClusterVisIdx.remove( keyClusterVisIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecSecGroupByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFSecSecGroupByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFSecSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecSecGroupByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
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
				CFSecSecGroupByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFSecSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecSecGroupByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGroup( ICFSecSecGroupObj Obj ) {
		forgetSecGroup( Obj, false );
	}

	public void forgetSecGroup( ICFSecSecGroupObj Obj, boolean forgetSubObjects ) {
		ICFSecSecGroupObj obj = Obj;
		CFSecSecGroupPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecGroupObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFSecSecGroupByClusterIdxKey keyClusterIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByClusterVisIdx != null ) {
				CFSecSecGroupByClusterVisIdxKey keyClusterVisIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
				keyClusterVisIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyClusterVisIdx.setRequiredIsVisible( keepObj.getRequiredIsVisible() );
				Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( keyClusterVisIdx );
				if( mapClusterVisIdx != null ) {
					mapClusterVisIdx.remove( keepObj.getPKey() );
					if( mapClusterVisIdx.size() <= 0 ) {
						indexByClusterVisIdx.remove( keyClusterVisIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFSecSecGroupByUNameIdxKey keyUNameIdx =
					((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
				keyUNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( allSecGroup != null ) {
				allSecGroup.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFSecSchemaObj)schema).getSecGrpIncTableObj().forgetSecGrpIncByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				((ICFSecSchemaObj)schema).getSecGrpMembTableObj().forgetSecGrpMembByGroupIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				((ICFSecSchemaObj)schema).getSecGrpIncTableObj().forgetSecGrpIncByIncludeIdx( keepObj.getRequiredClusterId(),
					keepObj.getRequiredSecGroupId() );
				((ICFSecSchemaObj)schema).getSecGroupFormTableObj().forgetSecGroupFormByGroupIdx( keepObj.getRequiredClusterId(),
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
		CFSecSecGroupPKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( members.containsKey( key ) ) {
			ICFSecSecGroupObj probed = members.get( key );
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
		List<ICFSecSecGroupObj> toForget = new LinkedList<ICFSecSecGroupObj>();
		ICFSecSecGroupObj cur = null;
		CFSecSecGroupByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFSecSecGroupObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGroupObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGroupObj> iter = toForget.iterator();
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
		List<ICFSecSecGroupObj> toForget = new LinkedList<ICFSecSecGroupObj>();
		ICFSecSecGroupObj cur = null;
		CFSecSecGroupByClusterVisIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );
		if( indexByClusterVisIdx.containsKey( key ) ) {
			Map<CFSecSecGroupPKey, ICFSecSecGroupObj > mapClusterVisIdx = indexByClusterVisIdx.get( key );
			if( mapClusterVisIdx != null ) {
				Iterator<ICFSecSecGroupObj> iterDup = mapClusterVisIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterVisIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGroupObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGroupObj> iter = toForget.iterator();
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
		List<ICFSecSecGroupObj> toForget = new LinkedList<ICFSecSecGroupObj>();
		ICFSecSecGroupObj cur = null;
		CFSecSecGroupByUNameIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecGroupObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecGroupObj createSecGroup( ICFSecSecGroupObj Obj ) {
		ICFSecSecGroupObj obj = Obj;
		CFSecSecGroupBuff buff = obj.getSecGroupBuff();
		((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().createSecGroup(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecGroupObj readSecGroup( CFSecSecGroupPKey pkey ) {
		return( readSecGroup( pkey, false ) );
	}

	public ICFSecSecGroupObj readSecGroup( CFSecSecGroupPKey pkey, boolean forceRead ) {
		ICFSecSecGroupObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecGroupBuff readBuff = ((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecGroupObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecGroupObj lockSecGroup( CFSecSecGroupPKey pkey ) {
		ICFSecSecGroupObj locked = null;
		CFSecSecGroupBuff lockBuff = ((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupTableObj().newInstance();
			locked.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecGroupObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGroup", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecGroupObj> readAllSecGroup() {
		return( readAllSecGroup( false ) );
	}

	public List<ICFSecSecGroupObj> readAllSecGroup( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroup";
		if( ( allSecGroup == null ) || forceRead ) {
			Map<CFSecSecGroupPKey, ICFSecSecGroupObj> map = new HashMap<CFSecSecGroupPKey,ICFSecSecGroupObj>();
			allSecGroup = map;
			CFSecSecGroupBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().readAllDerived( schema.getAuthorization() );
			CFSecSecGroupBuff buff;
			ICFSecSecGroupObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupObj realised = (ICFSecSecGroupObj)obj.realise();
			}
		}
		int len = allSecGroup.size();
		ICFSecSecGroupObj arr[] = new ICFSecSecGroupObj[len];
		Iterator<ICFSecSecGroupObj> valIter = allSecGroup.values().iterator();
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
		ArrayList<ICFSecSecGroupObj> arrayList = new ArrayList<ICFSecSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupObj> cmp = new Comparator<ICFSecSecGroupObj>() {
			public int compare( ICFSecSecGroupObj lhs, ICFSecSecGroupObj rhs ) {
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
					CFSecSecGroupPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecSecGroupObj readSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupByIdIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public ICFSecSecGroupObj readSecGroupByIdIdx( long ClusterId,
		int SecGroupId, boolean forceRead )
	{
		CFSecSecGroupPKey pkey = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupId( SecGroupId );
		ICFSecSecGroupObj obj = readSecGroup( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecSecGroupObj> readSecGroupByClusterIdx( long ClusterId )
	{
		return( readSecGroupByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFSecSecGroupObj> readSecGroupByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupByClusterIdx";
		CFSecSecGroupByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFSecSecGroupPKey, ICFSecSecGroupObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecGroupByClusterIdxKey,
				Map< CFSecSecGroupPKey, ICFSecSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGroupPKey, ICFSecSecGroupObj>();
			ICFSecSecGroupObj obj;
			CFSecSecGroupBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFSecSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupObj realised = (ICFSecSecGroupObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGroupObj arr[] = new ICFSecSecGroupObj[len];
		Iterator<ICFSecSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGroupObj> arrayList = new ArrayList<ICFSecSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupObj> cmp = new Comparator<ICFSecSecGroupObj>() {
			public int compare( ICFSecSecGroupObj lhs, ICFSecSecGroupObj rhs ) {
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
					CFSecSecGroupPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecGroupObj> readSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible )
	{
		return( readSecGroupByClusterVisIdx( ClusterId,
			IsVisible,
			false ) );
	}

	public List<ICFSecSecGroupObj> readSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupByClusterVisIdx";
		CFSecSecGroupByClusterVisIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );
		Map<CFSecSecGroupPKey, ICFSecSecGroupObj> dict;
		if( indexByClusterVisIdx == null ) {
			indexByClusterVisIdx = new HashMap< CFSecSecGroupByClusterVisIdxKey,
				Map< CFSecSecGroupPKey, ICFSecSecGroupObj > >();
		}
		if( ( ! forceRead ) && indexByClusterVisIdx.containsKey( key ) ) {
			dict = indexByClusterVisIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGroupPKey, ICFSecSecGroupObj>();
			ICFSecSecGroupObj obj;
			CFSecSecGroupBuff[] buffList = ((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByClusterVisIdx( schema.getAuthorization(),
				ClusterId,
				IsVisible );
			CFSecSecGroupBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupObj realised = (ICFSecSecGroupObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterVisIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGroupObj arr[] = new ICFSecSecGroupObj[len];
		Iterator<ICFSecSecGroupObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGroupObj> arrayList = new ArrayList<ICFSecSecGroupObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupObj> cmp = new Comparator<ICFSecSecGroupObj>() {
			public int compare( ICFSecSecGroupObj lhs, ICFSecSecGroupObj rhs ) {
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
					CFSecSecGroupPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecSecGroupObj readSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		return( readSecGroupByUNameIdx( ClusterId,
			Name,
			false ) );
	}

	public ICFSecSecGroupObj readSecGroupByUNameIdx( long ClusterId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFSecSecGroupByUNameIdxKey,
				ICFSecSecGroupObj >();
		}
		CFSecSecGroupByUNameIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ICFSecSecGroupObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFSecSecGroupBuff buff = ((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
			if( buff != null ) {
				obj = schema.getSecGroupTableObj().newInstance();
				obj.setPKey( ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecGroupObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecGroupObj updateSecGroup( ICFSecSecGroupObj Obj ) {
		ICFSecSecGroupObj obj = Obj;
		((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().updateSecGroup( schema.getAuthorization(),
			Obj.getSecGroupBuff() );
		obj = (ICFSecSecGroupObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGroup( ICFSecSecGroupObj Obj ) {
		ICFSecSecGroupObj obj = Obj;
		((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroup( schema.getAuthorization(),
			obj.getSecGroupBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupByIdIdx( long ClusterId,
		int SecGroupId )
	{
		CFSecSecGroupPKey pkey = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupId( SecGroupId );
		ICFSecSecGroupObj obj = readSecGroup( pkey );
		if( obj != null ) {
			ICFSecSecGroupEditObj editObj = (ICFSecSecGroupEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecGroupEditObj)obj.beginEdit();
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
		CFSecSecGroupByClusterIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecGroupByClusterIdxKey,
				Map< CFSecSecGroupPKey, ICFSecSecGroupObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecGroupPKey, ICFSecSecGroupObj> dict = indexByClusterIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFSecSecGroupObj> iter = dict.values().iterator();
			ICFSecSecGroupObj obj;
			List<ICFSecSecGroupObj> toForget = new LinkedList<ICFSecSecGroupObj>();
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
			((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible )
	{
		CFSecSecGroupByClusterVisIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newClusterVisIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredIsVisible( IsVisible );
		if( indexByClusterVisIdx == null ) {
			indexByClusterVisIdx = new HashMap< CFSecSecGroupByClusterVisIdxKey,
				Map< CFSecSecGroupPKey, ICFSecSecGroupObj > >();
		}
		if( indexByClusterVisIdx.containsKey( key ) ) {
			Map<CFSecSecGroupPKey, ICFSecSecGroupObj> dict = indexByClusterVisIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterVisIdx( schema.getAuthorization(),
				ClusterId,
				IsVisible );
			Iterator<ICFSecSecGroupObj> iter = dict.values().iterator();
			ICFSecSecGroupObj obj;
			List<ICFSecSecGroupObj> toForget = new LinkedList<ICFSecSecGroupObj>();
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
			((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByClusterVisIdx( schema.getAuthorization(),
				ClusterId,
				IsVisible );
		}
	}

	public void deleteSecGroupByUNameIdx( long ClusterId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFSecSecGroupByUNameIdxKey,
				ICFSecSecGroupObj >();
		}
		CFSecSecGroupByUNameIdxKey key = ((ICFSecSchema)schema.getBackingStore()).getFactorySecGroup().newUNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredName( Name );
		ICFSecSecGroupObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFSecSchema)schema.getBackingStore()).getTableSecGroup().deleteSecGroupByUNameIdx( schema.getAuthorization(),
				ClusterId,
				Name );
		}
	}
}
