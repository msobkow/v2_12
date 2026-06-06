// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamSubProjectTableObj
	implements ICFBamSubProjectTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntSubProjectPKey, ICFIntSubProjectObj> members;
	private Map<CFIntSubProjectPKey, ICFIntSubProjectObj> allSubProject;
	private Map< CFIntSubProjectByTenantIdxKey,
		Map<CFIntSubProjectPKey, ICFIntSubProjectObj > > indexByTenantIdx;
	private Map< CFIntSubProjectByTopProjectIdxKey,
		Map<CFIntSubProjectPKey, ICFIntSubProjectObj > > indexByTopProjectIdx;
	private Map< CFIntSubProjectByNameIdxKey,
		ICFIntSubProjectObj > indexByNameIdx;
	public static String TABLE_NAME = "SubProject";
	public static String TABLE_DBNAME = "sprjdef";

	public CFBamSubProjectTableObj() {
		schema = null;
		members = new HashMap<CFIntSubProjectPKey, ICFIntSubProjectObj>();
		allSubProject = null;
		indexByTenantIdx = null;
		indexByTopProjectIdx = null;
		indexByNameIdx = null;
	}

	public CFBamSubProjectTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntSubProjectPKey, ICFIntSubProjectObj>();
		allSubProject = null;
		indexByTenantIdx = null;
		indexByTopProjectIdx = null;
		indexByNameIdx = null;
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( ICFBamTenantObj.class );
	}


	public void minimizeMemory() {
		allSubProject = null;
		indexByTenantIdx = null;
		indexByTopProjectIdx = null;
		indexByNameIdx = null;
		List<ICFIntSubProjectObj> toForget = new LinkedList<ICFIntSubProjectObj>();
		ICFIntSubProjectObj cur = null;
		Iterator<ICFIntSubProjectObj> iter = members.values().iterator();
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
	 *	CFBamSubProjectObj.
	 */
	public ICFIntSubProjectObj newInstance() {
		ICFIntSubProjectObj inst = new CFBamSubProjectObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSubProjectObj.
	 */
	public ICFIntSubProjectEditObj newEditInstance( ICFIntSubProjectObj orig ) {
		ICFIntSubProjectEditObj edit = new CFBamSubProjectEditObj( orig );
		return( edit );
	}

	public ICFIntSubProjectObj realiseSubProject( ICFIntSubProjectObj Obj ) {
		ICFIntSubProjectObj obj = Obj;
		CFIntSubProjectPKey pkey = obj.getPKey();
		ICFIntSubProjectObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntSubProjectObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFIntSubProjectByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTopProjectIdx != null ) {
				CFIntSubProjectByTopProjectIdxKey keyTopProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.remove( keepObj.getPKey() );
					if( mapTopProjectIdx.size() <= 0 ) {
						indexByTopProjectIdx.remove( keyTopProjectIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntSubProjectByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFIntSubProjectByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopProjectIdx != null ) {
				CFIntSubProjectByTopProjectIdxKey keyTopProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntSubProjectByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allSubProject != null ) {
				allSubProject.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSubProject != null ) {
				allSubProject.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFIntSubProjectByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopProjectIdx != null ) {
				CFIntSubProjectByTopProjectIdxKey keyTopProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntSubProjectByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSubProject( ICFIntSubProjectObj Obj ) {
		forgetSubProject( Obj, false );
	}

	public void forgetSubProject( ICFIntSubProjectObj Obj, boolean forgetSubObjects ) {
		ICFIntSubProjectObj obj = Obj;
		CFIntSubProjectPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntSubProjectObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFIntSubProjectByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTopProjectIdx != null ) {
				CFIntSubProjectByTopProjectIdxKey keyTopProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.remove( keepObj.getPKey() );
					if( mapTopProjectIdx.size() <= 0 ) {
						indexByTopProjectIdx.remove( keyTopProjectIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntSubProjectByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allSubProject != null ) {
				allSubProject.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFIntSchemaObj)schema).getMajorVersionTableObj().forgetMajorVersionBySubProjectIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
	}

	public void forgetSubProjectByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFIntSubProjectPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFIntSubProjectObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSubProjectByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFIntSubProjectObj> toForget = new LinkedList<ICFIntSubProjectObj>();
		ICFIntSubProjectObj cur = null;
		CFIntSubProjectByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFIntSubProjectObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntSubProjectObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntSubProjectObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSubProjectByTopProjectIdx( long TenantId,
		long TopProjectId )
	{
		if( indexByTopProjectIdx == null ) {
			return;
		}
		List<ICFIntSubProjectObj> toForget = new LinkedList<ICFIntSubProjectObj>();
		ICFIntSubProjectObj cur = null;
		CFIntSubProjectByTopProjectIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopProjectId( TopProjectId );
		if( indexByTopProjectIdx.containsKey( key ) ) {
			Map<CFIntSubProjectPKey, ICFIntSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( key );
			if( mapTopProjectIdx != null ) {
				Iterator<ICFIntSubProjectObj> iterDup = mapTopProjectIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTopProjectIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntSubProjectObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntSubProjectObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSubProjectByNameIdx( long TenantId,
		long TopProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFIntSubProjectObj> toForget = new LinkedList<ICFIntSubProjectObj>();
		ICFIntSubProjectObj cur = null;
		CFIntSubProjectByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntSubProjectObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntSubProjectObj createSubProject( ICFIntSubProjectObj Obj ) {
		ICFIntSubProjectObj obj = Obj;
		CFIntSubProjectBuff buff = obj.getSubProjectBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableSubProject().createSubProject(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntSubProjectObj readSubProject( CFIntSubProjectPKey pkey ) {
		return( readSubProject( pkey, false ) );
	}

	public ICFIntSubProjectObj readSubProject( CFIntSubProjectPKey pkey, boolean forceRead ) {
		ICFIntSubProjectObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntSubProjectBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSubProject().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntSubProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntSubProjectObj lockSubProject( CFIntSubProjectPKey pkey ) {
		ICFIntSubProjectObj locked = null;
		CFIntSubProjectBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSubProject().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSubProjectTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntSubProjectObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSubProject", pkey );
		}
		return( locked );
	}

	public List<ICFIntSubProjectObj> readAllSubProject() {
		return( readAllSubProject( false ) );
	}

	public List<ICFIntSubProjectObj> readAllSubProject( boolean forceRead ) {
		final String S_ProcName = "readAllSubProject";
		if( ( allSubProject == null ) || forceRead ) {
			Map<CFIntSubProjectPKey, ICFIntSubProjectObj> map = new HashMap<CFIntSubProjectPKey,ICFIntSubProjectObj>();
			allSubProject = map;
			CFIntSubProjectBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSubProject().readAllDerived( schema.getAuthorization() );
			CFIntSubProjectBuff buff;
			ICFIntSubProjectObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey() );
				obj.setBuff( buff );
				ICFIntSubProjectObj realised = (ICFIntSubProjectObj)obj.realise();
			}
		}
		int len = allSubProject.size();
		ICFIntSubProjectObj arr[] = new ICFIntSubProjectObj[len];
		Iterator<ICFIntSubProjectObj> valIter = allSubProject.values().iterator();
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
		ArrayList<ICFIntSubProjectObj> arrayList = new ArrayList<ICFIntSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntSubProjectObj> cmp = new Comparator<ICFIntSubProjectObj>() {
			public int compare( ICFIntSubProjectObj lhs, ICFIntSubProjectObj rhs ) {
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
					CFIntSubProjectPKey lhsPKey = lhs.getPKey();
					CFIntSubProjectPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntSubProjectObj readSubProjectByIdIdx( long TenantId,
		long Id )
	{
		return( readSubProjectByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFIntSubProjectObj readSubProjectByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFIntSubProjectPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntSubProjectObj obj = readSubProject( pkey, forceRead );
		return( obj );
	}

	public List<ICFIntSubProjectObj> readSubProjectByTenantIdx( long TenantId )
	{
		return( readSubProjectByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFIntSubProjectObj> readSubProjectByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSubProjectByTenantIdx";
		CFIntSubProjectByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFIntSubProjectPKey, ICFIntSubProjectObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntSubProjectByTenantIdxKey,
				Map< CFIntSubProjectPKey, ICFIntSubProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntSubProjectPKey, ICFIntSubProjectObj>();
			ICFIntSubProjectObj obj;
			CFIntSubProjectBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSubProject().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFIntSubProjectBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey() );
				obj.setBuff( buff );
				ICFIntSubProjectObj realised = (ICFIntSubProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntSubProjectObj arr[] = new ICFIntSubProjectObj[len];
		Iterator<ICFIntSubProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntSubProjectObj> arrayList = new ArrayList<ICFIntSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntSubProjectObj> cmp = new Comparator<ICFIntSubProjectObj>() {
			public int compare( ICFIntSubProjectObj lhs, ICFIntSubProjectObj rhs ) {
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
					CFIntSubProjectPKey lhsPKey = lhs.getPKey();
					CFIntSubProjectPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFIntSubProjectObj> readSubProjectByTopProjectIdx( long TenantId,
		long TopProjectId )
	{
		return( readSubProjectByTopProjectIdx( TenantId,
			TopProjectId,
			false ) );
	}

	public List<ICFIntSubProjectObj> readSubProjectByTopProjectIdx( long TenantId,
		long TopProjectId,
		boolean forceRead )
	{
		final String S_ProcName = "readSubProjectByTopProjectIdx";
		CFIntSubProjectByTopProjectIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopProjectId( TopProjectId );
		Map<CFIntSubProjectPKey, ICFIntSubProjectObj> dict;
		if( indexByTopProjectIdx == null ) {
			indexByTopProjectIdx = new HashMap< CFIntSubProjectByTopProjectIdxKey,
				Map< CFIntSubProjectPKey, ICFIntSubProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTopProjectIdx.containsKey( key ) ) {
			dict = indexByTopProjectIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntSubProjectPKey, ICFIntSubProjectObj>();
			ICFIntSubProjectObj obj;
			CFIntSubProjectBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSubProject().readDerivedByTopProjectIdx( schema.getAuthorization(),
				TenantId,
				TopProjectId );
			CFIntSubProjectBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey() );
				obj.setBuff( buff );
				ICFIntSubProjectObj realised = (ICFIntSubProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTopProjectIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntSubProjectObj arr[] = new ICFIntSubProjectObj[len];
		Iterator<ICFIntSubProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntSubProjectObj> arrayList = new ArrayList<ICFIntSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntSubProjectObj> cmp = new Comparator<ICFIntSubProjectObj>() {
			public int compare( ICFIntSubProjectObj lhs, ICFIntSubProjectObj rhs ) {
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
					CFIntSubProjectPKey lhsPKey = lhs.getPKey();
					CFIntSubProjectPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntSubProjectObj readSubProjectByNameIdx( long TenantId,
		long TopProjectId,
		String Name )
	{
		return( readSubProjectByNameIdx( TenantId,
			TopProjectId,
			Name,
			false ) );
	}

	public ICFIntSubProjectObj readSubProjectByNameIdx( long TenantId,
		long TopProjectId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntSubProjectByNameIdxKey,
				ICFIntSubProjectObj >();
		}
		CFIntSubProjectByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		ICFIntSubProjectObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFIntSubProjectBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSubProject().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				TopProjectId,
				Name );
			if( buff != null ) {
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntSubProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntSubProjectObj updateSubProject( ICFIntSubProjectObj Obj ) {
		ICFIntSubProjectObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSubProject().updateSubProject( schema.getAuthorization(),
			Obj.getSubProjectBuff() );
		obj = (ICFIntSubProjectObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSubProject( ICFIntSubProjectObj Obj ) {
		ICFIntSubProjectObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProject( schema.getAuthorization(),
			obj.getSubProjectBuff() );
		obj.forget( true );
	}

	public void deleteSubProjectByIdIdx( long TenantId,
		long Id )
	{
		CFIntSubProjectPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntSubProjectObj obj = readSubProject( pkey );
		if( obj != null ) {
			ICFIntSubProjectEditObj editObj = (ICFIntSubProjectEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntSubProjectEditObj)obj.beginEdit();
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

	public void deleteSubProjectByTenantIdx( long TenantId )
	{
		CFIntSubProjectByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntSubProjectByTenantIdxKey,
				Map< CFIntSubProjectPKey, ICFIntSubProjectObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntSubProjectPKey, ICFIntSubProjectObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFIntSubProjectObj> iter = dict.values().iterator();
			ICFIntSubProjectObj obj;
			List<ICFIntSubProjectObj> toForget = new LinkedList<ICFIntSubProjectObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteSubProjectByTopProjectIdx( long TenantId,
		long TopProjectId )
	{
		CFIntSubProjectByTopProjectIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newTopProjectIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopProjectId( TopProjectId );
		if( indexByTopProjectIdx == null ) {
			indexByTopProjectIdx = new HashMap< CFIntSubProjectByTopProjectIdxKey,
				Map< CFIntSubProjectPKey, ICFIntSubProjectObj > >();
		}
		if( indexByTopProjectIdx.containsKey( key ) ) {
			Map<CFIntSubProjectPKey, ICFIntSubProjectObj> dict = indexByTopProjectIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProjectByTopProjectIdx( schema.getAuthorization(),
				TenantId,
				TopProjectId );
			Iterator<ICFIntSubProjectObj> iter = dict.values().iterator();
			ICFIntSubProjectObj obj;
			List<ICFIntSubProjectObj> toForget = new LinkedList<ICFIntSubProjectObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTopProjectIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProjectByTopProjectIdx( schema.getAuthorization(),
				TenantId,
				TopProjectId );
		}
	}

	public void deleteSubProjectByNameIdx( long TenantId,
		long TopProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntSubProjectByNameIdxKey,
				ICFIntSubProjectObj >();
		}
		CFIntSubProjectByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySubProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		ICFIntSubProjectObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				TopProjectId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSubProject().deleteSubProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				TopProjectId,
				Name );
		}
	}
}
