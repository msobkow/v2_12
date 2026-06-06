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

public class CFBamMajorVersionTableObj
	implements ICFBamMajorVersionTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> members;
	private Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> allMajorVersion;
	private Map< CFIntMajorVersionByTenantIdxKey,
		Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > > indexByTenantIdx;
	private Map< CFIntMajorVersionBySubProjectIdxKey,
		Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > > indexBySubProjectIdx;
	private Map< CFIntMajorVersionByNameIdxKey,
		ICFIntMajorVersionObj > indexByNameIdx;
	public static String TABLE_NAME = "MajorVersion";
	public static String TABLE_DBNAME = "mjvrdef";

	public CFBamMajorVersionTableObj() {
		schema = null;
		members = new HashMap<CFIntMajorVersionPKey, ICFIntMajorVersionObj>();
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexBySubProjectIdx = null;
		indexByNameIdx = null;
	}

	public CFBamMajorVersionTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntMajorVersionPKey, ICFIntMajorVersionObj>();
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexBySubProjectIdx = null;
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
		allMajorVersion = null;
		indexByTenantIdx = null;
		indexBySubProjectIdx = null;
		indexByNameIdx = null;
		List<ICFIntMajorVersionObj> toForget = new LinkedList<ICFIntMajorVersionObj>();
		ICFIntMajorVersionObj cur = null;
		Iterator<ICFIntMajorVersionObj> iter = members.values().iterator();
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
	 *	CFBamMajorVersionObj.
	 */
	public ICFIntMajorVersionObj newInstance() {
		ICFIntMajorVersionObj inst = new CFBamMajorVersionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamMajorVersionObj.
	 */
	public ICFIntMajorVersionEditObj newEditInstance( ICFIntMajorVersionObj orig ) {
		ICFIntMajorVersionEditObj edit = new CFBamMajorVersionEditObj( orig );
		return( edit );
	}

	public ICFIntMajorVersionObj realiseMajorVersion( ICFIntMajorVersionObj Obj ) {
		ICFIntMajorVersionObj obj = Obj;
		CFIntMajorVersionPKey pkey = obj.getPKey();
		ICFIntMajorVersionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntMajorVersionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFIntMajorVersionByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexBySubProjectIdx != null ) {
				CFIntMajorVersionBySubProjectIdxKey keySubProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
				keySubProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.remove( keepObj.getPKey() );
					if( mapSubProjectIdx.size() <= 0 ) {
						indexBySubProjectIdx.remove( keySubProjectIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntMajorVersionByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFIntMajorVersionByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySubProjectIdx != null ) {
				CFIntMajorVersionBySubProjectIdxKey keySubProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
				keySubProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntMajorVersionByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allMajorVersion != null ) {
				allMajorVersion.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allMajorVersion != null ) {
				allMajorVersion.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFIntMajorVersionByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySubProjectIdx != null ) {
				CFIntMajorVersionBySubProjectIdxKey keySubProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
				keySubProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntMajorVersionByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetMajorVersion( ICFIntMajorVersionObj Obj ) {
		forgetMajorVersion( Obj, false );
	}

	public void forgetMajorVersion( ICFIntMajorVersionObj Obj, boolean forgetSubObjects ) {
		ICFIntMajorVersionObj obj = Obj;
		CFIntMajorVersionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntMajorVersionObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFIntMajorVersionByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexBySubProjectIdx != null ) {
				CFIntMajorVersionBySubProjectIdxKey keySubProjectIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
				keySubProjectIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keySubProjectIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( keySubProjectIdx );
				if( mapSubProjectIdx != null ) {
					mapSubProjectIdx.remove( keepObj.getPKey() );
					if( mapSubProjectIdx.size() <= 0 ) {
						indexBySubProjectIdx.remove( keySubProjectIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntMajorVersionByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredSubProjectId( keepObj.getRequiredSubProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allMajorVersion != null ) {
				allMajorVersion.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFIntSchemaObj)schema).getMinorVersionTableObj().forgetMinorVersionByMajorVerIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
	}

	public void forgetMajorVersionByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFIntMajorVersionPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFIntMajorVersionObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetMajorVersionByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFIntMajorVersionObj> toForget = new LinkedList<ICFIntMajorVersionObj>();
		ICFIntMajorVersionObj cur = null;
		CFIntMajorVersionByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFIntMajorVersionObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntMajorVersionObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntMajorVersionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetMajorVersionBySubProjectIdx( long TenantId,
		long SubProjectId )
	{
		if( indexBySubProjectIdx == null ) {
			return;
		}
		List<ICFIntMajorVersionObj> toForget = new LinkedList<ICFIntMajorVersionObj>();
		ICFIntMajorVersionObj cur = null;
		CFIntMajorVersionBySubProjectIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubProjectId( SubProjectId );
		if( indexBySubProjectIdx.containsKey( key ) ) {
			Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj > mapSubProjectIdx = indexBySubProjectIdx.get( key );
			if( mapSubProjectIdx != null ) {
				Iterator<ICFIntMajorVersionObj> iterDup = mapSubProjectIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexBySubProjectIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntMajorVersionObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntMajorVersionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetMajorVersionByNameIdx( long TenantId,
		long SubProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFIntMajorVersionObj> toForget = new LinkedList<ICFIntMajorVersionObj>();
		ICFIntMajorVersionObj cur = null;
		CFIntMajorVersionByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntMajorVersionObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntMajorVersionObj createMajorVersion( ICFIntMajorVersionObj Obj ) {
		ICFIntMajorVersionObj obj = Obj;
		CFIntMajorVersionBuff buff = obj.getMajorVersionBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().createMajorVersion(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntMajorVersionObj readMajorVersion( CFIntMajorVersionPKey pkey ) {
		return( readMajorVersion( pkey, false ) );
	}

	public ICFIntMajorVersionObj readMajorVersion( CFIntMajorVersionPKey pkey, boolean forceRead ) {
		ICFIntMajorVersionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntMajorVersionBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntMajorVersionObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntMajorVersionObj lockMajorVersion( CFIntMajorVersionPKey pkey ) {
		ICFIntMajorVersionObj locked = null;
		CFIntMajorVersionBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getMajorVersionTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntMajorVersionObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockMajorVersion", pkey );
		}
		return( locked );
	}

	public List<ICFIntMajorVersionObj> readAllMajorVersion() {
		return( readAllMajorVersion( false ) );
	}

	public List<ICFIntMajorVersionObj> readAllMajorVersion( boolean forceRead ) {
		final String S_ProcName = "readAllMajorVersion";
		if( ( allMajorVersion == null ) || forceRead ) {
			Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> map = new HashMap<CFIntMajorVersionPKey,ICFIntMajorVersionObj>();
			allMajorVersion = map;
			CFIntMajorVersionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().readAllDerived( schema.getAuthorization() );
			CFIntMajorVersionBuff buff;
			ICFIntMajorVersionObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey() );
				obj.setBuff( buff );
				ICFIntMajorVersionObj realised = (ICFIntMajorVersionObj)obj.realise();
			}
		}
		int len = allMajorVersion.size();
		ICFIntMajorVersionObj arr[] = new ICFIntMajorVersionObj[len];
		Iterator<ICFIntMajorVersionObj> valIter = allMajorVersion.values().iterator();
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
		ArrayList<ICFIntMajorVersionObj> arrayList = new ArrayList<ICFIntMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntMajorVersionObj> cmp = new Comparator<ICFIntMajorVersionObj>() {
			public int compare( ICFIntMajorVersionObj lhs, ICFIntMajorVersionObj rhs ) {
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
					CFIntMajorVersionPKey lhsPKey = lhs.getPKey();
					CFIntMajorVersionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntMajorVersionObj readMajorVersionByIdIdx( long TenantId,
		long Id )
	{
		return( readMajorVersionByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFIntMajorVersionObj readMajorVersionByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFIntMajorVersionPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntMajorVersionObj obj = readMajorVersion( pkey, forceRead );
		return( obj );
	}

	public List<ICFIntMajorVersionObj> readMajorVersionByTenantIdx( long TenantId )
	{
		return( readMajorVersionByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFIntMajorVersionObj> readMajorVersionByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readMajorVersionByTenantIdx";
		CFIntMajorVersionByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntMajorVersionByTenantIdxKey,
				Map< CFIntMajorVersionPKey, ICFIntMajorVersionObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntMajorVersionPKey, ICFIntMajorVersionObj>();
			ICFIntMajorVersionObj obj;
			CFIntMajorVersionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFIntMajorVersionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey() );
				obj.setBuff( buff );
				ICFIntMajorVersionObj realised = (ICFIntMajorVersionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntMajorVersionObj arr[] = new ICFIntMajorVersionObj[len];
		Iterator<ICFIntMajorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntMajorVersionObj> arrayList = new ArrayList<ICFIntMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntMajorVersionObj> cmp = new Comparator<ICFIntMajorVersionObj>() {
			public int compare( ICFIntMajorVersionObj lhs, ICFIntMajorVersionObj rhs ) {
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
					CFIntMajorVersionPKey lhsPKey = lhs.getPKey();
					CFIntMajorVersionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFIntMajorVersionObj> readMajorVersionBySubProjectIdx( long TenantId,
		long SubProjectId )
	{
		return( readMajorVersionBySubProjectIdx( TenantId,
			SubProjectId,
			false ) );
	}

	public List<ICFIntMajorVersionObj> readMajorVersionBySubProjectIdx( long TenantId,
		long SubProjectId,
		boolean forceRead )
	{
		final String S_ProcName = "readMajorVersionBySubProjectIdx";
		CFIntMajorVersionBySubProjectIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubProjectId( SubProjectId );
		Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> dict;
		if( indexBySubProjectIdx == null ) {
			indexBySubProjectIdx = new HashMap< CFIntMajorVersionBySubProjectIdxKey,
				Map< CFIntMajorVersionPKey, ICFIntMajorVersionObj > >();
		}
		if( ( ! forceRead ) && indexBySubProjectIdx.containsKey( key ) ) {
			dict = indexBySubProjectIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntMajorVersionPKey, ICFIntMajorVersionObj>();
			ICFIntMajorVersionObj obj;
			CFIntMajorVersionBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().readDerivedBySubProjectIdx( schema.getAuthorization(),
				TenantId,
				SubProjectId );
			CFIntMajorVersionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey() );
				obj.setBuff( buff );
				ICFIntMajorVersionObj realised = (ICFIntMajorVersionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySubProjectIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntMajorVersionObj arr[] = new ICFIntMajorVersionObj[len];
		Iterator<ICFIntMajorVersionObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntMajorVersionObj> arrayList = new ArrayList<ICFIntMajorVersionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntMajorVersionObj> cmp = new Comparator<ICFIntMajorVersionObj>() {
			public int compare( ICFIntMajorVersionObj lhs, ICFIntMajorVersionObj rhs ) {
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
					CFIntMajorVersionPKey lhsPKey = lhs.getPKey();
					CFIntMajorVersionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntMajorVersionObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntMajorVersionObj readMajorVersionByNameIdx( long TenantId,
		long SubProjectId,
		String Name )
	{
		return( readMajorVersionByNameIdx( TenantId,
			SubProjectId,
			Name,
			false ) );
	}

	public ICFIntMajorVersionObj readMajorVersionByNameIdx( long TenantId,
		long SubProjectId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntMajorVersionByNameIdxKey,
				ICFIntMajorVersionObj >();
		}
		CFIntMajorVersionByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		ICFIntMajorVersionObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFIntMajorVersionBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				SubProjectId,
				Name );
			if( buff != null ) {
				obj = schema.getMajorVersionTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntMajorVersionObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntMajorVersionObj updateMajorVersion( ICFIntMajorVersionObj Obj ) {
		ICFIntMajorVersionObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().updateMajorVersion( schema.getAuthorization(),
			Obj.getMajorVersionBuff() );
		obj = (ICFIntMajorVersionObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteMajorVersion( ICFIntMajorVersionObj Obj ) {
		ICFIntMajorVersionObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersion( schema.getAuthorization(),
			obj.getMajorVersionBuff() );
		obj.forget( true );
	}

	public void deleteMajorVersionByIdIdx( long TenantId,
		long Id )
	{
		CFIntMajorVersionPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntMajorVersionObj obj = readMajorVersion( pkey );
		if( obj != null ) {
			ICFIntMajorVersionEditObj editObj = (ICFIntMajorVersionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntMajorVersionEditObj)obj.beginEdit();
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

	public void deleteMajorVersionByTenantIdx( long TenantId )
	{
		CFIntMajorVersionByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntMajorVersionByTenantIdxKey,
				Map< CFIntMajorVersionPKey, ICFIntMajorVersionObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFIntMajorVersionObj> iter = dict.values().iterator();
			ICFIntMajorVersionObj obj;
			List<ICFIntMajorVersionObj> toForget = new LinkedList<ICFIntMajorVersionObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersionByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteMajorVersionBySubProjectIdx( long TenantId,
		long SubProjectId )
	{
		CFIntMajorVersionBySubProjectIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newSubProjectIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubProjectId( SubProjectId );
		if( indexBySubProjectIdx == null ) {
			indexBySubProjectIdx = new HashMap< CFIntMajorVersionBySubProjectIdxKey,
				Map< CFIntMajorVersionPKey, ICFIntMajorVersionObj > >();
		}
		if( indexBySubProjectIdx.containsKey( key ) ) {
			Map<CFIntMajorVersionPKey, ICFIntMajorVersionObj> dict = indexBySubProjectIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersionBySubProjectIdx( schema.getAuthorization(),
				TenantId,
				SubProjectId );
			Iterator<ICFIntMajorVersionObj> iter = dict.values().iterator();
			ICFIntMajorVersionObj obj;
			List<ICFIntMajorVersionObj> toForget = new LinkedList<ICFIntMajorVersionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexBySubProjectIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersionBySubProjectIdx( schema.getAuthorization(),
				TenantId,
				SubProjectId );
		}
	}

	public void deleteMajorVersionByNameIdx( long TenantId,
		long SubProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntMajorVersionByNameIdxKey,
				ICFIntMajorVersionObj >();
		}
		CFIntMajorVersionByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryMajorVersion().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredSubProjectId( SubProjectId );
		key.setRequiredName( Name );
		ICFIntMajorVersionObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersionByNameIdx( schema.getAuthorization(),
				TenantId,
				SubProjectId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableMajorVersion().deleteMajorVersionByNameIdx( schema.getAuthorization(),
				TenantId,
				SubProjectId,
				Name );
		}
	}
}
