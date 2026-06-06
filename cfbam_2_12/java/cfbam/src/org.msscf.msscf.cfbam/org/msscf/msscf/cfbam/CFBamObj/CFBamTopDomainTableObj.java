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

public class CFBamTopDomainTableObj
	implements ICFBamTopDomainTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntTopDomainPKey, ICFIntTopDomainObj> members;
	private Map<CFIntTopDomainPKey, ICFIntTopDomainObj> allTopDomain;
	private Map< CFIntTopDomainByTenantIdxKey,
		Map<CFIntTopDomainPKey, ICFIntTopDomainObj > > indexByTenantIdx;
	private Map< CFIntTopDomainByTldIdxKey,
		Map<CFIntTopDomainPKey, ICFIntTopDomainObj > > indexByTldIdx;
	private Map< CFIntTopDomainByNameIdxKey,
		ICFIntTopDomainObj > indexByNameIdx;
	public static String TABLE_NAME = "TopDomain";
	public static String TABLE_DBNAME = "tdomdef";

	public CFBamTopDomainTableObj() {
		schema = null;
		members = new HashMap<CFIntTopDomainPKey, ICFIntTopDomainObj>();
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
	}

	public CFBamTopDomainTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntTopDomainPKey, ICFIntTopDomainObj>();
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
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
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
		List<ICFIntTopDomainObj> toForget = new LinkedList<ICFIntTopDomainObj>();
		ICFIntTopDomainObj cur = null;
		Iterator<ICFIntTopDomainObj> iter = members.values().iterator();
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
	 *	CFBamTopDomainObj.
	 */
	public ICFIntTopDomainObj newInstance() {
		ICFIntTopDomainObj inst = new CFBamTopDomainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamTopDomainObj.
	 */
	public ICFIntTopDomainEditObj newEditInstance( ICFIntTopDomainObj orig ) {
		ICFIntTopDomainEditObj edit = new CFBamTopDomainEditObj( orig );
		return( edit );
	}

	public ICFIntTopDomainObj realiseTopDomain( ICFIntTopDomainObj Obj ) {
		ICFIntTopDomainObj obj = Obj;
		CFIntTopDomainPKey pkey = obj.getPKey();
		ICFIntTopDomainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntTopDomainObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFIntTopDomainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTldIdx != null ) {
				CFIntTopDomainByTldIdxKey keyTldIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.remove( keepObj.getPKey() );
					if( mapTldIdx.size() <= 0 ) {
						indexByTldIdx.remove( keyTldIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopDomainByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFIntTopDomainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTldIdx != null ) {
				CFIntTopDomainByTldIdxKey keyTldIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopDomainByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allTopDomain != null ) {
				allTopDomain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTopDomain != null ) {
				allTopDomain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFIntTopDomainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTldIdx != null ) {
				CFIntTopDomainByTldIdxKey keyTldIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopDomainByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTopDomain( ICFIntTopDomainObj Obj ) {
		forgetTopDomain( Obj, false );
	}

	public void forgetTopDomain( ICFIntTopDomainObj Obj, boolean forgetSubObjects ) {
		ICFIntTopDomainObj obj = Obj;
		CFIntTopDomainPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntTopDomainObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFIntTopDomainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTldIdx != null ) {
				CFIntTopDomainByTldIdxKey keyTldIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
				keyTldIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.remove( keepObj.getPKey() );
					if( mapTldIdx.size() <= 0 ) {
						indexByTldIdx.remove( keyTldIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopDomainByNameIdxKey keyNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allTopDomain != null ) {
				allTopDomain.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFIntSchemaObj)schema).getLicenseTableObj().forgetLicenseByDomainIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
				((ICFIntSchemaObj)schema).getTopProjectTableObj().forgetTopProjectByTopDomainIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
	}

	public void forgetTopDomainByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFIntTopDomainPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFIntTopDomainObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTopDomainByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFIntTopDomainObj> toForget = new LinkedList<ICFIntTopDomainObj>();
		ICFIntTopDomainObj cur = null;
		CFIntTopDomainByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFIntTopDomainObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntTopDomainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntTopDomainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTopDomainByTldIdx( long TenantId,
		long TldId )
	{
		if( indexByTldIdx == null ) {
			return;
		}
		List<ICFIntTopDomainObj> toForget = new LinkedList<ICFIntTopDomainObj>();
		ICFIntTopDomainObj cur = null;
		CFIntTopDomainByTldIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		if( indexByTldIdx.containsKey( key ) ) {
			Map<CFIntTopDomainPKey, ICFIntTopDomainObj > mapTldIdx = indexByTldIdx.get( key );
			if( mapTldIdx != null ) {
				Iterator<ICFIntTopDomainObj> iterDup = mapTldIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTldIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntTopDomainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntTopDomainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFIntTopDomainObj> toForget = new LinkedList<ICFIntTopDomainObj>();
		ICFIntTopDomainObj cur = null;
		CFIntTopDomainByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntTopDomainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntTopDomainObj createTopDomain( ICFIntTopDomainObj Obj ) {
		ICFIntTopDomainObj obj = Obj;
		CFIntTopDomainBuff buff = obj.getTopDomainBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().createTopDomain(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntTopDomainObj readTopDomain( CFIntTopDomainPKey pkey ) {
		return( readTopDomain( pkey, false ) );
	}

	public ICFIntTopDomainObj readTopDomain( CFIntTopDomainPKey pkey, boolean forceRead ) {
		ICFIntTopDomainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntTopDomainBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntTopDomainObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntTopDomainObj lockTopDomain( CFIntTopDomainPKey pkey ) {
		ICFIntTopDomainObj locked = null;
		CFIntTopDomainBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTopDomainTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntTopDomainObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTopDomain", pkey );
		}
		return( locked );
	}

	public List<ICFIntTopDomainObj> readAllTopDomain() {
		return( readAllTopDomain( false ) );
	}

	public List<ICFIntTopDomainObj> readAllTopDomain( boolean forceRead ) {
		final String S_ProcName = "readAllTopDomain";
		if( ( allTopDomain == null ) || forceRead ) {
			Map<CFIntTopDomainPKey, ICFIntTopDomainObj> map = new HashMap<CFIntTopDomainPKey,ICFIntTopDomainObj>();
			allTopDomain = map;
			CFIntTopDomainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().readAllDerived( schema.getAuthorization() );
			CFIntTopDomainBuff buff;
			ICFIntTopDomainObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey() );
				obj.setBuff( buff );
				ICFIntTopDomainObj realised = (ICFIntTopDomainObj)obj.realise();
			}
		}
		int len = allTopDomain.size();
		ICFIntTopDomainObj arr[] = new ICFIntTopDomainObj[len];
		Iterator<ICFIntTopDomainObj> valIter = allTopDomain.values().iterator();
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
		ArrayList<ICFIntTopDomainObj> arrayList = new ArrayList<ICFIntTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTopDomainObj> cmp = new Comparator<ICFIntTopDomainObj>() {
			public int compare( ICFIntTopDomainObj lhs, ICFIntTopDomainObj rhs ) {
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
					CFIntTopDomainPKey lhsPKey = lhs.getPKey();
					CFIntTopDomainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntTopDomainObj readTopDomainByIdIdx( long TenantId,
		long Id )
	{
		return( readTopDomainByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFIntTopDomainObj readTopDomainByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFIntTopDomainPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntTopDomainObj obj = readTopDomain( pkey, forceRead );
		return( obj );
	}

	public List<ICFIntTopDomainObj> readTopDomainByTenantIdx( long TenantId )
	{
		return( readTopDomainByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFIntTopDomainObj> readTopDomainByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopDomainByTenantIdx";
		CFIntTopDomainByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFIntTopDomainPKey, ICFIntTopDomainObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntTopDomainByTenantIdxKey,
				Map< CFIntTopDomainPKey, ICFIntTopDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntTopDomainPKey, ICFIntTopDomainObj>();
			ICFIntTopDomainObj obj;
			CFIntTopDomainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFIntTopDomainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey() );
				obj.setBuff( buff );
				ICFIntTopDomainObj realised = (ICFIntTopDomainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntTopDomainObj arr[] = new ICFIntTopDomainObj[len];
		Iterator<ICFIntTopDomainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntTopDomainObj> arrayList = new ArrayList<ICFIntTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTopDomainObj> cmp = new Comparator<ICFIntTopDomainObj>() {
			public int compare( ICFIntTopDomainObj lhs, ICFIntTopDomainObj rhs ) {
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
					CFIntTopDomainPKey lhsPKey = lhs.getPKey();
					CFIntTopDomainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFIntTopDomainObj> readTopDomainByTldIdx( long TenantId,
		long TldId )
	{
		return( readTopDomainByTldIdx( TenantId,
			TldId,
			false ) );
	}

	public List<ICFIntTopDomainObj> readTopDomainByTldIdx( long TenantId,
		long TldId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopDomainByTldIdx";
		CFIntTopDomainByTldIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		Map<CFIntTopDomainPKey, ICFIntTopDomainObj> dict;
		if( indexByTldIdx == null ) {
			indexByTldIdx = new HashMap< CFIntTopDomainByTldIdxKey,
				Map< CFIntTopDomainPKey, ICFIntTopDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTldIdx.containsKey( key ) ) {
			dict = indexByTldIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntTopDomainPKey, ICFIntTopDomainObj>();
			ICFIntTopDomainObj obj;
			CFIntTopDomainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().readDerivedByTldIdx( schema.getAuthorization(),
				TenantId,
				TldId );
			CFIntTopDomainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey() );
				obj.setBuff( buff );
				ICFIntTopDomainObj realised = (ICFIntTopDomainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTldIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntTopDomainObj arr[] = new ICFIntTopDomainObj[len];
		Iterator<ICFIntTopDomainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntTopDomainObj> arrayList = new ArrayList<ICFIntTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTopDomainObj> cmp = new Comparator<ICFIntTopDomainObj>() {
			public int compare( ICFIntTopDomainObj lhs, ICFIntTopDomainObj rhs ) {
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
					CFIntTopDomainPKey lhsPKey = lhs.getPKey();
					CFIntTopDomainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntTopDomainObj readTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name )
	{
		return( readTopDomainByNameIdx( TenantId,
			TldId,
			Name,
			false ) );
	}

	public ICFIntTopDomainObj readTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntTopDomainByNameIdxKey,
				ICFIntTopDomainObj >();
		}
		CFIntTopDomainByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		ICFIntTopDomainObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFIntTopDomainBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				TldId,
				Name );
			if( buff != null ) {
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntTopDomainObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntTopDomainObj updateTopDomain( ICFIntTopDomainObj Obj ) {
		ICFIntTopDomainObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().updateTopDomain( schema.getAuthorization(),
			Obj.getTopDomainBuff() );
		obj = (ICFIntTopDomainObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTopDomain( ICFIntTopDomainObj Obj ) {
		ICFIntTopDomainObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomain( schema.getAuthorization(),
			obj.getTopDomainBuff() );
		obj.forget( true );
	}

	public void deleteTopDomainByIdIdx( long TenantId,
		long Id )
	{
		CFIntTopDomainPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntTopDomainObj obj = readTopDomain( pkey );
		if( obj != null ) {
			ICFIntTopDomainEditObj editObj = (ICFIntTopDomainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntTopDomainEditObj)obj.beginEdit();
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

	public void deleteTopDomainByTenantIdx( long TenantId )
	{
		CFIntTopDomainByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntTopDomainByTenantIdxKey,
				Map< CFIntTopDomainPKey, ICFIntTopDomainObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntTopDomainPKey, ICFIntTopDomainObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomainByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFIntTopDomainObj> iter = dict.values().iterator();
			ICFIntTopDomainObj obj;
			List<ICFIntTopDomainObj> toForget = new LinkedList<ICFIntTopDomainObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomainByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTopDomainByTldIdx( long TenantId,
		long TldId )
	{
		CFIntTopDomainByTldIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newTldIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		if( indexByTldIdx == null ) {
			indexByTldIdx = new HashMap< CFIntTopDomainByTldIdxKey,
				Map< CFIntTopDomainPKey, ICFIntTopDomainObj > >();
		}
		if( indexByTldIdx.containsKey( key ) ) {
			Map<CFIntTopDomainPKey, ICFIntTopDomainObj> dict = indexByTldIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomainByTldIdx( schema.getAuthorization(),
				TenantId,
				TldId );
			Iterator<ICFIntTopDomainObj> iter = dict.values().iterator();
			ICFIntTopDomainObj obj;
			List<ICFIntTopDomainObj> toForget = new LinkedList<ICFIntTopDomainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTldIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomainByTldIdx( schema.getAuthorization(),
				TenantId,
				TldId );
		}
	}

	public void deleteTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntTopDomainByNameIdxKey,
				ICFIntTopDomainObj >();
		}
		CFIntTopDomainByNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryTopDomain().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		ICFIntTopDomainObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomainByNameIdx( schema.getAuthorization(),
				TenantId,
				TldId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableTopDomain().deleteTopDomainByNameIdx( schema.getAuthorization(),
				TenantId,
				TldId,
				Name );
		}
	}
}
