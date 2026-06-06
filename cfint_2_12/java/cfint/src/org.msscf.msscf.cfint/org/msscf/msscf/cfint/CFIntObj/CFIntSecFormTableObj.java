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

public class CFIntSecFormTableObj
	implements ICFIntSecFormTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecFormPKey, ICFSecSecFormObj> members;
	private Map<CFSecSecFormPKey, ICFSecSecFormObj> allSecForm;
	private Map< CFSecSecFormByClusterIdxKey,
		Map<CFSecSecFormPKey, ICFSecSecFormObj > > indexByClusterIdx;
	private Map< CFSecSecFormBySecAppIdxKey,
		Map<CFSecSecFormPKey, ICFSecSecFormObj > > indexBySecAppIdx;
	private Map< CFSecSecFormByUJEEServletIdxKey,
		ICFSecSecFormObj > indexByUJEEServletIdx;
	public static String TABLE_NAME = "SecForm";
	public static String TABLE_DBNAME = "secform";

	public CFIntSecFormTableObj() {
		schema = null;
		members = new HashMap<CFSecSecFormPKey, ICFSecSecFormObj>();
		allSecForm = null;
		indexByClusterIdx = null;
		indexBySecAppIdx = null;
		indexByUJEEServletIdx = null;
	}

	public CFIntSecFormTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecFormPKey, ICFSecSecFormObj>();
		allSecForm = null;
		indexByClusterIdx = null;
		indexBySecAppIdx = null;
		indexByUJEEServletIdx = null;
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
		allSecForm = null;
		indexByClusterIdx = null;
		indexBySecAppIdx = null;
		indexByUJEEServletIdx = null;
		List<ICFSecSecFormObj> toForget = new LinkedList<ICFSecSecFormObj>();
		ICFSecSecFormObj cur = null;
		Iterator<ICFSecSecFormObj> iter = members.values().iterator();
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
	 *	CFIntSecFormObj.
	 */
	public ICFSecSecFormObj newInstance() {
		ICFSecSecFormObj inst = new CFIntSecFormObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntSecFormObj.
	 */
	public ICFSecSecFormEditObj newEditInstance( ICFSecSecFormObj orig ) {
		ICFSecSecFormEditObj edit = new CFIntSecFormEditObj( orig );
		return( edit );
	}

	public ICFSecSecFormObj realiseSecForm( ICFSecSecFormObj Obj ) {
		ICFSecSecFormObj obj = Obj;
		CFSecSecFormPKey pkey = obj.getPKey();
		ICFSecSecFormObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecFormObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFSecSecFormByClusterIdxKey keyClusterIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexBySecAppIdx != null ) {
				CFSecSecFormBySecAppIdxKey keySecAppIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.remove( keepObj.getPKey() );
					if( mapSecAppIdx.size() <= 0 ) {
						indexBySecAppIdx.remove( keySecAppIdx );
					}
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFSecSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.remove( keyUJEEServletIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFSecSecFormByClusterIdxKey keyClusterIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecAppIdx != null ) {
				CFSecSecFormBySecAppIdxKey keySecAppIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFSecSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.put( keyUJEEServletIdx, keepObj );
			}

			if( allSecForm != null ) {
				allSecForm.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecForm != null ) {
				allSecForm.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFSecSecFormByClusterIdxKey keyClusterIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecAppIdx != null ) {
				CFSecSecFormBySecAppIdxKey keySecAppIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFSecSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.put( keyUJEEServletIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecForm( ICFSecSecFormObj Obj ) {
		forgetSecForm( Obj, false );
	}

	public void forgetSecForm( ICFSecSecFormObj Obj, boolean forgetSubObjects ) {
		ICFSecSecFormObj obj = Obj;
		CFSecSecFormPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecFormObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFSecSecFormByClusterIdxKey keyClusterIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexBySecAppIdx != null ) {
				CFSecSecFormBySecAppIdxKey keySecAppIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
				keySecAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keySecAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecFormPKey, ICFSecSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( keySecAppIdx );
				if( mapSecAppIdx != null ) {
					mapSecAppIdx.remove( keepObj.getPKey() );
					if( mapSecAppIdx.size() <= 0 ) {
						indexBySecAppIdx.remove( keySecAppIdx );
					}
				}
			}

			if( indexByUJEEServletIdx != null ) {
				CFSecSecFormByUJEEServletIdxKey keyUJEEServletIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
				keyUJEEServletIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUJEEServletIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				keyUJEEServletIdx.setRequiredJEEServletMapName( keepObj.getRequiredJEEServletMapName() );
				indexByUJEEServletIdx.remove( keyUJEEServletIdx );
			}

			if( allSecForm != null ) {
				allSecForm.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecFormByIdIdx( long ClusterId,
		int SecFormId )
	{
		if( members == null ) {
			return;
		}
		CFSecSecFormPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( members.containsKey( key ) ) {
			ICFSecSecFormObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecFormByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFSecSecFormObj> toForget = new LinkedList<ICFSecSecFormObj>();
		ICFSecSecFormObj cur = null;
		CFSecSecFormByClusterIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecFormPKey, ICFSecSecFormObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFSecSecFormObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecFormBySecAppIdx( long ClusterId,
		int SecAppId )
	{
		if( indexBySecAppIdx == null ) {
			return;
		}
		List<ICFSecSecFormObj> toForget = new LinkedList<ICFSecSecFormObj>();
		ICFSecSecFormObj cur = null;
		CFSecSecFormBySecAppIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexBySecAppIdx.containsKey( key ) ) {
			Map<CFSecSecFormPKey, ICFSecSecFormObj > mapSecAppIdx = indexBySecAppIdx.get( key );
			if( mapSecAppIdx != null ) {
				Iterator<ICFSecSecFormObj> iterDup = mapSecAppIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySecAppIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		if( indexByUJEEServletIdx == null ) {
			return;
		}
		List<ICFSecSecFormObj> toForget = new LinkedList<ICFSecSecFormObj>();
		ICFSecSecFormObj cur = null;
		CFSecSecFormByUJEEServletIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );
		if( indexByUJEEServletIdx.containsKey( key ) ) {
			cur = indexByUJEEServletIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecFormObj createSecForm( ICFSecSecFormObj Obj ) {
		ICFSecSecFormObj obj = Obj;
		CFSecSecFormBuff buff = obj.getSecFormBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableSecForm().createSecForm(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecFormObj readSecForm( CFSecSecFormPKey pkey ) {
		return( readSecForm( pkey, false ) );
	}

	public ICFSecSecFormObj readSecForm( CFSecSecFormPKey pkey, boolean forceRead ) {
		ICFSecSecFormObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecFormBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecFormId() );
			if( readBuff != null ) {
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecFormObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecFormObj lockSecForm( CFSecSecFormPKey pkey ) {
		ICFSecSecFormObj locked = null;
		CFSecSecFormBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecFormTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecFormObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecForm", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecFormObj> readAllSecForm() {
		return( readAllSecForm( false ) );
	}

	public List<ICFSecSecFormObj> readAllSecForm( boolean forceRead ) {
		final String S_ProcName = "readAllSecForm";
		if( ( allSecForm == null ) || forceRead ) {
			Map<CFSecSecFormPKey, ICFSecSecFormObj> map = new HashMap<CFSecSecFormPKey,ICFSecSecFormObj>();
			allSecForm = map;
			CFSecSecFormBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().readAllDerived( schema.getAuthorization() );
			CFSecSecFormBuff buff;
			ICFSecSecFormObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecFormObj realised = (ICFSecSecFormObj)obj.realise();
			}
		}
		int len = allSecForm.size();
		ICFSecSecFormObj arr[] = new ICFSecSecFormObj[len];
		Iterator<ICFSecSecFormObj> valIter = allSecForm.values().iterator();
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
		ArrayList<ICFSecSecFormObj> arrayList = new ArrayList<ICFSecSecFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecFormObj> cmp = new Comparator<ICFSecSecFormObj>() {
			public int compare( ICFSecSecFormObj lhs, ICFSecSecFormObj rhs ) {
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
					CFSecSecFormPKey lhsPKey = lhs.getPKey();
					CFSecSecFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecFormObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecForm-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecFormObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecSecFormObj> pageAllSecForm(Long priorClusterId,
		Integer priorSecFormId )
	{
		final String S_ProcName = "pageAllSecForm";
		Map<CFSecSecFormPKey, ICFSecSecFormObj> map = new HashMap<CFSecSecFormPKey,ICFSecSecFormObj>();
		CFSecSecFormBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecFormId );
		CFSecSecFormBuff buff;
		ICFSecSecFormObj obj;
		ICFSecSecFormObj realised;
		ArrayList<ICFSecSecFormObj> arrayList = new ArrayList<ICFSecSecFormObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecSecFormObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecSecFormObj readSecFormByIdIdx( long ClusterId,
		int SecFormId )
	{
		return( readSecFormByIdIdx( ClusterId,
			SecFormId,
			false ) );
	}

	public ICFSecSecFormObj readSecFormByIdIdx( long ClusterId,
		int SecFormId, boolean forceRead )
	{
		CFSecSecFormPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecFormId( SecFormId );
		ICFSecSecFormObj obj = readSecForm( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecSecFormObj> readSecFormByClusterIdx( long ClusterId )
	{
		return( readSecFormByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFSecSecFormObj> readSecFormByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecFormByClusterIdx";
		CFSecSecFormByClusterIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFSecSecFormPKey, ICFSecSecFormObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecFormByClusterIdxKey,
				Map< CFSecSecFormPKey, ICFSecSecFormObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecFormPKey, ICFSecSecFormObj>();
			ICFSecSecFormObj obj;
			CFSecSecFormBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFSecSecFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecFormObj realised = (ICFSecSecFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecFormObj arr[] = new ICFSecSecFormObj[len];
		Iterator<ICFSecSecFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecFormObj> arrayList = new ArrayList<ICFSecSecFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecFormObj> cmp = new Comparator<ICFSecSecFormObj>() {
			public int compare( ICFSecSecFormObj lhs, ICFSecSecFormObj rhs ) {
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
					CFSecSecFormPKey lhsPKey = lhs.getPKey();
					CFSecSecFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecFormObj> readSecFormBySecAppIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecFormBySecAppIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public List<ICFSecSecFormObj> readSecFormBySecAppIdx( long ClusterId,
		int SecAppId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecFormBySecAppIdx";
		CFSecSecFormBySecAppIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		Map<CFSecSecFormPKey, ICFSecSecFormObj> dict;
		if( indexBySecAppIdx == null ) {
			indexBySecAppIdx = new HashMap< CFSecSecFormBySecAppIdxKey,
				Map< CFSecSecFormPKey, ICFSecSecFormObj > >();
		}
		if( ( ! forceRead ) && indexBySecAppIdx.containsKey( key ) ) {
			dict = indexBySecAppIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecFormPKey, ICFSecSecFormObj>();
			ICFSecSecFormObj obj;
			CFSecSecFormBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().readDerivedBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			CFSecSecFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecFormObj realised = (ICFSecSecFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecAppIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecFormObj arr[] = new ICFSecSecFormObj[len];
		Iterator<ICFSecSecFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecFormObj> arrayList = new ArrayList<ICFSecSecFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecFormObj> cmp = new Comparator<ICFSecSecFormObj>() {
			public int compare( ICFSecSecFormObj lhs, ICFSecSecFormObj rhs ) {
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
					CFSecSecFormPKey lhsPKey = lhs.getPKey();
					CFSecSecFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecSecFormObj readSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		return( readSecFormByUJEEServletIdx( ClusterId,
			SecAppId,
			JEEServletMapName,
			false ) );
	}

	public ICFSecSecFormObj readSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName, boolean forceRead )
	{
		if( indexByUJEEServletIdx == null ) {
			indexByUJEEServletIdx = new HashMap< CFSecSecFormByUJEEServletIdxKey,
				ICFSecSecFormObj >();
		}
		CFSecSecFormByUJEEServletIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );
		ICFSecSecFormObj obj = null;
		if( ( ! forceRead ) && indexByUJEEServletIdx.containsKey( key ) ) {
			obj = indexByUJEEServletIdx.get( key );
		}
		else {
			CFSecSecFormBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().readDerivedByUJEEServletIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
				JEEServletMapName );
			if( buff != null ) {
				obj = schema.getSecFormTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecFormObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of SecForm-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecForm key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecForm-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecFormObj> pageSecFormByClusterIdx( long ClusterId,
		Long priorClusterId,
		Integer priorSecFormId )
	{
		final String S_ProcName = "pageSecFormByClusterIdx";
		CFSecSecFormByClusterIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFSecSecFormObj> retList = new LinkedList<ICFSecSecFormObj>();
		ICFSecSecFormObj obj;
		CFSecSecFormBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecFormId );
		CFSecSecFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecFormTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
			obj.setBuff( buff );
			ICFSecSecFormObj realised = (ICFSecSecFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecForm-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecAppIdx key attributes.
	 *
	 *	@param	argClusterId	The SecForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecForm key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecForm-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecFormObj> pageSecFormBySecAppIdx( long ClusterId,
		int SecAppId,
		Long priorClusterId,
		Integer priorSecFormId )
	{
		final String S_ProcName = "pageSecFormBySecAppIdx";
		CFSecSecFormBySecAppIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		List<ICFSecSecFormObj> retList = new LinkedList<ICFSecSecFormObj>();
		ICFSecSecFormObj obj;
		CFSecSecFormBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableSecForm().pageBuffBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
			priorClusterId,
			priorSecFormId );
		CFSecSecFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecFormTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey() );
			obj.setBuff( buff );
			ICFSecSecFormObj realised = (ICFSecSecFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecSecFormObj updateSecForm( ICFSecSecFormObj Obj ) {
		ICFSecSecFormObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableSecForm().updateSecForm( schema.getAuthorization(),
			Obj.getSecFormBuff() );
		obj = (ICFSecSecFormObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecForm( ICFSecSecFormObj Obj ) {
		ICFSecSecFormObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecForm( schema.getAuthorization(),
			obj.getSecFormBuff() );
		obj.forget( true );
	}

	public void deleteSecFormByIdIdx( long ClusterId,
		int SecFormId )
	{
		CFSecSecFormPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecFormId( SecFormId );
		ICFSecSecFormObj obj = readSecForm( pkey );
		if( obj != null ) {
			ICFSecSecFormEditObj editObj = (ICFSecSecFormEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecFormEditObj)obj.beginEdit();
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

	public void deleteSecFormByClusterIdx( long ClusterId )
	{
		CFSecSecFormByClusterIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecFormByClusterIdxKey,
				Map< CFSecSecFormPKey, ICFSecSecFormObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecFormPKey, ICFSecSecFormObj> dict = indexByClusterIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFSecSecFormObj> iter = dict.values().iterator();
			ICFSecSecFormObj obj;
			List<ICFSecSecFormObj> toForget = new LinkedList<ICFSecSecFormObj>();
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
			((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecFormBySecAppIdx( long ClusterId,
		int SecAppId )
	{
		CFSecSecFormBySecAppIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newSecAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexBySecAppIdx == null ) {
			indexBySecAppIdx = new HashMap< CFSecSecFormBySecAppIdxKey,
				Map< CFSecSecFormPKey, ICFSecSecFormObj > >();
		}
		if( indexBySecAppIdx.containsKey( key ) ) {
			Map<CFSecSecFormPKey, ICFSecSecFormObj> dict = indexBySecAppIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecFormBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			Iterator<ICFSecSecFormObj> iter = dict.values().iterator();
			ICFSecSecFormObj obj;
			List<ICFSecSecFormObj> toForget = new LinkedList<ICFSecSecFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySecAppIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecFormBySecAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
		}
	}

	public void deleteSecFormByUJEEServletIdx( long ClusterId,
		int SecAppId,
		String JEEServletMapName )
	{
		if( indexByUJEEServletIdx == null ) {
			indexByUJEEServletIdx = new HashMap< CFSecSecFormByUJEEServletIdxKey,
				ICFSecSecFormObj >();
		}
		CFSecSecFormByUJEEServletIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactorySecForm().newUJEEServletIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		key.setRequiredJEEServletMapName( JEEServletMapName );
		ICFSecSecFormObj obj = null;
		if( indexByUJEEServletIdx.containsKey( key ) ) {
			obj = indexByUJEEServletIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecFormByUJEEServletIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
				JEEServletMapName );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableSecForm().deleteSecFormByUJEEServletIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
				JEEServletMapName );
		}
	}
}
