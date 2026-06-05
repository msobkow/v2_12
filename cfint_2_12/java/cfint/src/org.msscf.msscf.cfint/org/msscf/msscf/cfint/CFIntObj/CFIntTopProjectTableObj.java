// Description: Java 11 Table Object implementation for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntTopProjectTableObj
	implements ICFIntTopProjectTableObj
{
	protected ICFIntSchemaObj schema;
	private Map<CFIntTopProjectPKey, ICFIntTopProjectObj> members;
	private Map<CFIntTopProjectPKey, ICFIntTopProjectObj> allTopProject;
	private Map< CFIntTopProjectByTenantIdxKey,
		Map<CFIntTopProjectPKey, ICFIntTopProjectObj > > indexByTenantIdx;
	private Map< CFIntTopProjectByTopDomainIdxKey,
		Map<CFIntTopProjectPKey, ICFIntTopProjectObj > > indexByTopDomainIdx;
	private Map< CFIntTopProjectByNameIdxKey,
		ICFIntTopProjectObj > indexByNameIdx;
	public static String TABLE_NAME = "TopProject";
	public static String TABLE_DBNAME = "tprjdef";

	public CFIntTopProjectTableObj() {
		schema = null;
		members = new HashMap<CFIntTopProjectPKey, ICFIntTopProjectObj>();
		allTopProject = null;
		indexByTenantIdx = null;
		indexByTopDomainIdx = null;
		indexByNameIdx = null;
	}

	public CFIntTopProjectTableObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFIntTopProjectPKey, ICFIntTopProjectObj>();
		allTopProject = null;
		indexByTenantIdx = null;
		indexByTopDomainIdx = null;
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
		return( ICFIntTenantObj.class );
	}


	public void minimizeMemory() {
		allTopProject = null;
		indexByTenantIdx = null;
		indexByTopDomainIdx = null;
		indexByNameIdx = null;
		List<ICFIntTopProjectObj> toForget = new LinkedList<ICFIntTopProjectObj>();
		ICFIntTopProjectObj cur = null;
		Iterator<ICFIntTopProjectObj> iter = members.values().iterator();
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
	 *	CFIntTopProjectObj.
	 */
	public ICFIntTopProjectObj newInstance() {
		ICFIntTopProjectObj inst = new CFIntTopProjectObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntTopProjectObj.
	 */
	public ICFIntTopProjectEditObj newEditInstance( ICFIntTopProjectObj orig ) {
		ICFIntTopProjectEditObj edit = new CFIntTopProjectEditObj( orig );
		return( edit );
	}

	public ICFIntTopProjectObj realiseTopProject( ICFIntTopProjectObj Obj ) {
		ICFIntTopProjectObj obj = Obj;
		CFIntTopProjectPKey pkey = obj.getPKey();
		ICFIntTopProjectObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFIntTopProjectObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFIntTopProjectByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTopDomainIdx != null ) {
				CFIntTopProjectByTopDomainIdxKey keyTopDomainIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.remove( keepObj.getPKey() );
					if( mapTopDomainIdx.size() <= 0 ) {
						indexByTopDomainIdx.remove( keyTopDomainIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopProjectByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFIntTopProjectByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopDomainIdx != null ) {
				CFIntTopProjectByTopDomainIdxKey keyTopDomainIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopProjectByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allTopProject != null ) {
				allTopProject.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTopProject != null ) {
				allTopProject.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFIntTopProjectByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopDomainIdx != null ) {
				CFIntTopProjectByTopDomainIdxKey keyTopDomainIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopProjectByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTopProject( ICFIntTopProjectObj Obj ) {
		forgetTopProject( Obj, false );
	}

	public void forgetTopProject( ICFIntTopProjectObj Obj, boolean forgetSubObjects ) {
		ICFIntTopProjectObj obj = Obj;
		CFIntTopProjectPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFIntTopProjectObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFIntTopProjectByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTopDomainIdx != null ) {
				CFIntTopProjectByTopDomainIdxKey keyTopDomainIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.remove( keepObj.getPKey() );
					if( mapTopDomainIdx.size() <= 0 ) {
						indexByTopDomainIdx.remove( keyTopDomainIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				CFIntTopProjectByNameIdxKey keyNameIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
				keyNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			if( allTopProject != null ) {
				allTopProject.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
				((ICFIntSchemaObj)schema).getSubProjectTableObj().forgetSubProjectByTopProjectIdx( keepObj.getRequiredTenantId(),
					keepObj.getRequiredId() );
			}
		}
	}

	public void forgetTopProjectByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFIntTopProjectPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFIntTopProjectObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTopProjectByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFIntTopProjectObj> toForget = new LinkedList<ICFIntTopProjectObj>();
		ICFIntTopProjectObj cur = null;
		CFIntTopProjectByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFIntTopProjectObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntTopProjectObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntTopProjectObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId )
	{
		if( indexByTopDomainIdx == null ) {
			return;
		}
		List<ICFIntTopProjectObj> toForget = new LinkedList<ICFIntTopProjectObj>();
		ICFIntTopProjectObj cur = null;
		CFIntTopProjectByTopDomainIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopDomainId( TopDomainId );
		if( indexByTopDomainIdx.containsKey( key ) ) {
			Map<CFIntTopProjectPKey, ICFIntTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( key );
			if( mapTopDomainIdx != null ) {
				Iterator<ICFIntTopProjectObj> iterDup = mapTopDomainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTopDomainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFIntTopProjectObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFIntTopProjectObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTopProjectByNameIdx( long TenantId,
		long TopDomainId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			return;
		}
		List<ICFIntTopProjectObj> toForget = new LinkedList<ICFIntTopProjectObj>();
		ICFIntTopProjectObj cur = null;
		CFIntTopProjectByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		if( indexByNameIdx.containsKey( key ) ) {
			cur = indexByNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFIntTopProjectObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFIntTopProjectObj createTopProject( ICFIntTopProjectObj Obj ) {
		ICFIntTopProjectObj obj = Obj;
		CFIntTopProjectBuff buff = obj.getTopProjectBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableTopProject().createTopProject(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFIntTopProjectObj readTopProject( CFIntTopProjectPKey pkey ) {
		return( readTopProject( pkey, false ) );
	}

	public ICFIntTopProjectObj readTopProject( CFIntTopProjectPKey pkey, boolean forceRead ) {
		ICFIntTopProjectObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFIntTopProjectBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFIntTopProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntTopProjectObj lockTopProject( CFIntTopProjectPKey pkey ) {
		ICFIntTopProjectObj locked = null;
		CFIntTopProjectBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTopProjectTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFIntTopProjectObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTopProject", pkey );
		}
		return( locked );
	}

	public List<ICFIntTopProjectObj> readAllTopProject() {
		return( readAllTopProject( false ) );
	}

	public List<ICFIntTopProjectObj> readAllTopProject( boolean forceRead ) {
		final String S_ProcName = "readAllTopProject";
		if( ( allTopProject == null ) || forceRead ) {
			Map<CFIntTopProjectPKey, ICFIntTopProjectObj> map = new HashMap<CFIntTopProjectPKey,ICFIntTopProjectObj>();
			allTopProject = map;
			CFIntTopProjectBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().readAllDerived( schema.getAuthorization() );
			CFIntTopProjectBuff buff;
			ICFIntTopProjectObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey() );
				obj.setBuff( buff );
				ICFIntTopProjectObj realised = (ICFIntTopProjectObj)obj.realise();
			}
		}
		int len = allTopProject.size();
		ICFIntTopProjectObj arr[] = new ICFIntTopProjectObj[len];
		Iterator<ICFIntTopProjectObj> valIter = allTopProject.values().iterator();
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
		ArrayList<ICFIntTopProjectObj> arrayList = new ArrayList<ICFIntTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTopProjectObj> cmp = new Comparator<ICFIntTopProjectObj>() {
			public int compare( ICFIntTopProjectObj lhs, ICFIntTopProjectObj rhs ) {
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
					CFIntTopProjectPKey lhsPKey = lhs.getPKey();
					CFIntTopProjectPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntTopProjectObj readTopProjectByIdIdx( long TenantId,
		long Id )
	{
		return( readTopProjectByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFIntTopProjectObj readTopProjectByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFIntTopProjectPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntTopProjectObj obj = readTopProject( pkey, forceRead );
		return( obj );
	}

	public List<ICFIntTopProjectObj> readTopProjectByTenantIdx( long TenantId )
	{
		return( readTopProjectByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFIntTopProjectObj> readTopProjectByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopProjectByTenantIdx";
		CFIntTopProjectByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFIntTopProjectPKey, ICFIntTopProjectObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntTopProjectByTenantIdxKey,
				Map< CFIntTopProjectPKey, ICFIntTopProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntTopProjectPKey, ICFIntTopProjectObj>();
			ICFIntTopProjectObj obj;
			CFIntTopProjectBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFIntTopProjectBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey() );
				obj.setBuff( buff );
				ICFIntTopProjectObj realised = (ICFIntTopProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntTopProjectObj arr[] = new ICFIntTopProjectObj[len];
		Iterator<ICFIntTopProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntTopProjectObj> arrayList = new ArrayList<ICFIntTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTopProjectObj> cmp = new Comparator<ICFIntTopProjectObj>() {
			public int compare( ICFIntTopProjectObj lhs, ICFIntTopProjectObj rhs ) {
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
					CFIntTopProjectPKey lhsPKey = lhs.getPKey();
					CFIntTopProjectPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFIntTopProjectObj> readTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId )
	{
		return( readTopProjectByTopDomainIdx( TenantId,
			TopDomainId,
			false ) );
	}

	public List<ICFIntTopProjectObj> readTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopProjectByTopDomainIdx";
		CFIntTopProjectByTopDomainIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopDomainId( TopDomainId );
		Map<CFIntTopProjectPKey, ICFIntTopProjectObj> dict;
		if( indexByTopDomainIdx == null ) {
			indexByTopDomainIdx = new HashMap< CFIntTopProjectByTopDomainIdxKey,
				Map< CFIntTopProjectPKey, ICFIntTopProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTopDomainIdx.containsKey( key ) ) {
			dict = indexByTopDomainIdx.get( key );
		}
		else {
			dict = new HashMap<CFIntTopProjectPKey, ICFIntTopProjectObj>();
			ICFIntTopProjectObj obj;
			CFIntTopProjectBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().readDerivedByTopDomainIdx( schema.getAuthorization(),
				TenantId,
				TopDomainId );
			CFIntTopProjectBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey() );
				obj.setBuff( buff );
				ICFIntTopProjectObj realised = (ICFIntTopProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTopDomainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFIntTopProjectObj arr[] = new ICFIntTopProjectObj[len];
		Iterator<ICFIntTopProjectObj> valIter = dict.values().iterator();
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
		ArrayList<ICFIntTopProjectObj> arrayList = new ArrayList<ICFIntTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFIntTopProjectObj> cmp = new Comparator<ICFIntTopProjectObj>() {
			public int compare( ICFIntTopProjectObj lhs, ICFIntTopProjectObj rhs ) {
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
					CFIntTopProjectPKey lhsPKey = lhs.getPKey();
					CFIntTopProjectPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFIntTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFIntTopProjectObj readTopProjectByNameIdx( long TenantId,
		long TopDomainId,
		String Name )
	{
		return( readTopProjectByNameIdx( TenantId,
			TopDomainId,
			Name,
			false ) );
	}

	public ICFIntTopProjectObj readTopProjectByNameIdx( long TenantId,
		long TopDomainId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntTopProjectByNameIdxKey,
				ICFIntTopProjectObj >();
		}
		CFIntTopProjectByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		ICFIntTopProjectObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			CFIntTopProjectBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().readDerivedByNameIdx( schema.getAuthorization(),
				TenantId,
				TopDomainId,
				Name );
			if( buff != null ) {
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey() );
				obj.setBuff( buff );
				obj = (ICFIntTopProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFIntTopProjectObj updateTopProject( ICFIntTopProjectObj Obj ) {
		ICFIntTopProjectObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTopProject().updateTopProject( schema.getAuthorization(),
			Obj.getTopProjectBuff() );
		obj = (ICFIntTopProjectObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTopProject( ICFIntTopProjectObj Obj ) {
		ICFIntTopProjectObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProject( schema.getAuthorization(),
			obj.getTopProjectBuff() );
		obj.forget( true );
	}

	public void deleteTopProjectByIdIdx( long TenantId,
		long Id )
	{
		CFIntTopProjectPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFIntTopProjectObj obj = readTopProject( pkey );
		if( obj != null ) {
			ICFIntTopProjectEditObj editObj = (ICFIntTopProjectEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFIntTopProjectEditObj)obj.beginEdit();
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

	public void deleteTopProjectByTenantIdx( long TenantId )
	{
		CFIntTopProjectByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFIntTopProjectByTenantIdxKey,
				Map< CFIntTopProjectPKey, ICFIntTopProjectObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFIntTopProjectPKey, ICFIntTopProjectObj> dict = indexByTenantIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFIntTopProjectObj> iter = dict.values().iterator();
			ICFIntTopProjectObj obj;
			List<ICFIntTopProjectObj> toForget = new LinkedList<ICFIntTopProjectObj>();
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
			((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProjectByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId )
	{
		CFIntTopProjectByTopDomainIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newTopDomainIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopDomainId( TopDomainId );
		if( indexByTopDomainIdx == null ) {
			indexByTopDomainIdx = new HashMap< CFIntTopProjectByTopDomainIdxKey,
				Map< CFIntTopProjectPKey, ICFIntTopProjectObj > >();
		}
		if( indexByTopDomainIdx.containsKey( key ) ) {
			Map<CFIntTopProjectPKey, ICFIntTopProjectObj> dict = indexByTopDomainIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProjectByTopDomainIdx( schema.getAuthorization(),
				TenantId,
				TopDomainId );
			Iterator<ICFIntTopProjectObj> iter = dict.values().iterator();
			ICFIntTopProjectObj obj;
			List<ICFIntTopProjectObj> toForget = new LinkedList<ICFIntTopProjectObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByTopDomainIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProjectByTopDomainIdx( schema.getAuthorization(),
				TenantId,
				TopDomainId );
		}
	}

	public void deleteTopProjectByNameIdx( long TenantId,
		long TopDomainId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< CFIntTopProjectByNameIdxKey,
				ICFIntTopProjectObj >();
		}
		CFIntTopProjectByNameIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		ICFIntTopProjectObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				TopDomainId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTopProject().deleteTopProjectByNameIdx( schema.getAuthorization(),
				TenantId,
				TopDomainId,
				Name );
		}
	}
}
