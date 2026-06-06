// Description: Java 11 Table Object implementation for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGelCounterTableObj
	implements ICFGenKbGelCounterTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> members;
	private Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> allGelCounter;
	private Map< CFGenKbGelInstructionByTenantIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > > indexByTenantIdx;
	private Map< CFGenKbGelInstructionByGelCacheIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > > indexByGelCacheIdx;
	private Map< CFGenKbGelInstructionByChainIdxKey,
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > > indexByChainIdx;
	public static String TABLE_NAME = "GelCounter";
	public static String TABLE_DBNAME = "gelcounter";

	public CFGenKbGelCounterTableObj() {
		schema = null;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj>();
		allGelCounter = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
	}

	public CFGenKbGelCounterTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj>();
		allGelCounter = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
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
		allGelCounter = null;
		indexByTenantIdx = null;
		indexByGelCacheIdx = null;
		indexByChainIdx = null;
	}
	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelCounterObj.
	 */
	public ICFGenKbGelCounterObj newInstance() {
		ICFGenKbGelCounterObj inst = new CFGenKbGelCounterObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbGelCounterObj.
	 */
	public ICFGenKbGelCounterEditObj newEditInstance( ICFGenKbGelCounterObj orig ) {
		ICFGenKbGelCounterEditObj edit = new CFGenKbGelCounterEditObj( orig );
		return( edit );
	}

	public ICFGenKbGelCounterObj realiseGelCounter( ICFGenKbGelCounterObj Obj ) {
		ICFGenKbGelCounterObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		ICFGenKbGelCounterObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbGelCounterObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					indexByGelCacheIdx.remove( keyGelCacheIdx );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}
			// Keep passing the new object because it's the one with the buffer
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().realiseGelInstruction( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					mapGelCacheIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allGelCounter != null ) {
				allGelCounter.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().realiseGelInstruction( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allGelCounter != null ) {
				allGelCounter.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					mapGelCacheIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					mapChainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetGelCounter( ICFGenKbGelCounterObj Obj ) {
		forgetGelCounter( Obj, false );
	}

	public void forgetGelCounter( ICFGenKbGelCounterObj Obj, boolean forgetSubObjects ) {
		ICFGenKbGelCounterObj obj = Obj;
		CFGenKbGelInstructionPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbGelCounterObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFGenKbGelInstructionByTenantIdxKey keyTenantIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByGelCacheIdx != null ) {
				CFGenKbGelInstructionByGelCacheIdxKey keyGelCacheIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
				keyGelCacheIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGelCacheIdx.setRequiredGelCacheId( keepObj.getRequiredGelCacheId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapGelCacheIdx = indexByGelCacheIdx.get( keyGelCacheIdx );
				if( mapGelCacheIdx != null ) {
					indexByGelCacheIdx.remove( keyGelCacheIdx );
				}
			}

			if( indexByChainIdx != null ) {
				CFGenKbGelInstructionByChainIdxKey keyChainIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
				keyChainIdx.setOptionalChainInstTenantId( keepObj.getOptionalChainInstTenantId() );
				keyChainIdx.setOptionalChainInstGelCacheId( keepObj.getOptionalChainInstGelCacheId() );
				keyChainIdx.setOptionalChainInstGelInstId( keepObj.getOptionalChainInstGelInstId() );
				Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapChainIdx = indexByChainIdx.get( keyChainIdx );
				if( mapChainIdx != null ) {
					indexByChainIdx.remove( keyChainIdx );
				}
			}

			if( allGelCounter != null ) {
				allGelCounter.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( obj );
	}

	public void forgetGelCounterByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbGelInstructionPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		key.setRequiredGelInstId( GelInstId );
		if( members.containsKey( key ) ) {
			ICFGenKbGelCounterObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetGelCounterByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFGenKbGelCounterObj> toForget = new LinkedList<ICFGenKbGelCounterObj>();
		ICFGenKbGelCounterObj cur = null;
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFGenKbGelCounterObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCounterObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCounterObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCounterByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		if( indexByGelCacheIdx == null ) {
			return;
		}
		List<ICFGenKbGelCounterObj> toForget = new LinkedList<ICFGenKbGelCounterObj>();
		ICFGenKbGelCounterObj cur = null;
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapGelCacheIdx = indexByGelCacheIdx.get( key );
			if( mapGelCacheIdx != null ) {
				Iterator<ICFGenKbGelCounterObj> iterDup = mapGelCacheIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGelCacheIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCounterObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCounterObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetGelCounterByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		if( indexByChainIdx == null ) {
			return;
		}
		List<ICFGenKbGelCounterObj> toForget = new LinkedList<ICFGenKbGelCounterObj>();
		ICFGenKbGelCounterObj cur = null;
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > mapChainIdx = indexByChainIdx.get( key );
			if( mapChainIdx != null ) {
				Iterator<ICFGenKbGelCounterObj> iterDup = mapChainIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbGelCounterObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbGelCounterObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbGelCounterObj createGelCounter( ICFGenKbGelCounterObj Obj ) {
		ICFGenKbGelCounterObj obj = Obj;
		CFGenKbGelCounterBuff buff = obj.getGelCounterBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().createGelCounter(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		if( obj.getPKey().getClassCode().equals( "GCNT" ) ) {
			obj = (ICFGenKbGelCounterObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbGelCounterObj readGelCounter( CFGenKbGelInstructionPKey pkey ) {
		return( readGelCounter( pkey, false ) );
	}

	public ICFGenKbGelCounterObj readGelCounter( CFGenKbGelInstructionPKey pkey, boolean forceRead ) {
		ICFGenKbGelCounterObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbGelCounterBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().readDerivedByPIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredGelCacheId(),
				pkey.getRequiredGelInstId() );
			if( readBuff != null ) {
				obj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().constructByClassCode( readBuff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbGelCounterObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbGelCounterObj lockGelCounter( CFGenKbGelInstructionPKey pkey ) {
		ICFGenKbGelCounterObj locked = null;
		CFGenKbGelCounterBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().constructByClassCode( lockBuff.getClassCode() );
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbGelCounterObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockGelCounter", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbGelCounterObj> readAllGelCounter() {
		return( readAllGelCounter( false ) );
	}

	public List<ICFGenKbGelCounterObj> readAllGelCounter( boolean forceRead ) {
		final String S_ProcName = "readAllGelCounter";
		if( ( allGelCounter == null ) || forceRead ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> map = new HashMap<CFGenKbGelInstructionPKey,ICFGenKbGelCounterObj>();
			allGelCounter = map;
			CFGenKbGelCounterBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().readAllDerived( schema.getAuthorization() );
			CFGenKbGelCounterBuff buff;
			ICFGenKbGelCounterObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCounterObj realised = (ICFGenKbGelCounterObj)obj.realise();
			}
		}
		int len = allGelCounter.size();
		ICFGenKbGelCounterObj arr[] = new ICFGenKbGelCounterObj[len];
		Iterator<ICFGenKbGelCounterObj> valIter = allGelCounter.values().iterator();
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
		ArrayList<ICFGenKbGelCounterObj> arrayList = new ArrayList<ICFGenKbGelCounterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCounterObj> cmp = new Comparator<ICFGenKbGelCounterObj>() {
			public int compare( ICFGenKbGelCounterObj lhs, ICFGenKbGelCounterObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelCounterObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelCounterObj readGelCounterByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		return( readGelCounterByPIdx( TenantId,
			GelCacheId,
			GelInstId,
			false ) );
	}

	public ICFGenKbGelCounterObj readGelCounterByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId, boolean forceRead )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelCounterObj obj = readGelCounter( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbGelCounterObj> readGelCounterByTenantIdx( long TenantId )
	{
		return( readGelCounterByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFGenKbGelCounterObj> readGelCounterByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCounterByTenantIdx";
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCounterObj realised = (ICFGenKbGelCounterObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCounterObj arr[] = new ICFGenKbGelCounterObj[len];
		Iterator<ICFGenKbGelCounterObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCounterObj> arrayList = new ArrayList<ICFGenKbGelCounterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCounterObj> cmp = new Comparator<ICFGenKbGelCounterObj>() {
			public int compare( ICFGenKbGelCounterObj lhs, ICFGenKbGelCounterObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelCounterObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCounterObj> readGelCounterByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		return( readGelCounterByGelCacheIdx( TenantId,
			GelCacheId,
			false ) );
	}

	public List<ICFGenKbGelCounterObj> readGelCounterByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCounterByGelCacheIdx";
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> dict;
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > >();
		}
		if( ( ! forceRead ) && indexByGelCacheIdx.containsKey( key ) ) {
			dict = indexByGelCacheIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCounterObj realised = (ICFGenKbGelCounterObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGelCacheIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCounterObj arr[] = new ICFGenKbGelCounterObj[len];
		Iterator<ICFGenKbGelCounterObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCounterObj> arrayList = new ArrayList<ICFGenKbGelCounterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCounterObj> cmp = new Comparator<ICFGenKbGelCounterObj>() {
			public int compare( ICFGenKbGelCounterObj lhs, ICFGenKbGelCounterObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelCounterObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbGelCounterObj> readGelCounterByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		return( readGelCounterByChainIdx( ChainInstTenantId,
			ChainInstGelCacheId,
			ChainInstGelInstId,
			false ) );
	}

	public List<ICFGenKbGelCounterObj> readGelCounterByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead )
	{
		final String S_ProcName = "readGelCounterByChainIdx";
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> dict;
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > >();
		}
		if( ( ! forceRead ) && indexByChainIdx.containsKey( key ) ) {
			dict = indexByChainIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj>();
			ICFGenKbGelInstructionObj obj;
			CFGenKbGelInstructionBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			CFGenKbGelInstructionBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = (ICFGenKbGelCounterObj)schema.getGelInstructionTableObj().constructByClassCode( buff.getClassCode() );
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey() );
				obj.setBuff( buff );
				ICFGenKbGelCounterObj realised = (ICFGenKbGelCounterObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbGelCounterObj arr[] = new ICFGenKbGelCounterObj[len];
		Iterator<ICFGenKbGelCounterObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbGelCounterObj> arrayList = new ArrayList<ICFGenKbGelCounterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbGelCounterObj> cmp = new Comparator<ICFGenKbGelCounterObj>() {
			public int compare( ICFGenKbGelCounterObj lhs, ICFGenKbGelCounterObj rhs ) {
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
					CFGenKbGelInstructionPKey lhsPKey = lhs.getPKey();
					CFGenKbGelInstructionPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbGelCounterObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbGelCounterObj updateGelCounter( ICFGenKbGelCounterObj Obj ) {
		ICFGenKbGelCounterObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().updateGelCounter( schema.getAuthorization(),
			Obj.getGelCounterBuff() );
		if( Obj.getClassCode().equals( "GCNT" ) ) {
			obj = (ICFGenKbGelCounterObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	public void deleteGelCounter( ICFGenKbGelCounterObj Obj ) {
		ICFGenKbGelCounterObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounter( schema.getAuthorization(),
			obj.getGelCounterBuff() );
		obj.forget( true );
	}

	public void deleteGelCounterByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId )
	{
		CFGenKbGelInstructionPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredGelCacheId( GelCacheId );
		pkey.setRequiredGelInstId( GelInstId );
		ICFGenKbGelCounterObj obj = readGelCounter( pkey );
		if( obj != null ) {
			ICFGenKbGelCounterEditObj editObj = (ICFGenKbGelCounterEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbGelCounterEditObj)obj.beginEdit();
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

	public void deleteGelCounterByTenantIdx( long TenantId )
	{
		CFGenKbGelInstructionByTenantIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFGenKbGelInstructionByTenantIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> dict = indexByTenantIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounterByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFGenKbGelCounterObj> iter = dict.values().iterator();
			ICFGenKbGelCounterObj obj;
			List<ICFGenKbGelCounterObj> toForget = new LinkedList<ICFGenKbGelCounterObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounterByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteGelCounterByGelCacheIdx( long TenantId,
		long GelCacheId )
	{
		CFGenKbGelInstructionByGelCacheIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newGelCacheIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredGelCacheId( GelCacheId );
		if( indexByGelCacheIdx == null ) {
			indexByGelCacheIdx = new HashMap< CFGenKbGelInstructionByGelCacheIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > >();
		}
		if( indexByGelCacheIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> dict = indexByGelCacheIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounterByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
			Iterator<ICFGenKbGelCounterObj> iter = dict.values().iterator();
			ICFGenKbGelCounterObj obj;
			List<ICFGenKbGelCounterObj> toForget = new LinkedList<ICFGenKbGelCounterObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGelCacheIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounterByGelCacheIdx( schema.getAuthorization(),
				TenantId,
				GelCacheId );
		}
	}

	public void deleteGelCounterByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId )
	{
		CFGenKbGelInstructionByChainIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newChainIdxKey();
		key.setOptionalChainInstTenantId( ChainInstTenantId );
		key.setOptionalChainInstGelCacheId( ChainInstGelCacheId );
		key.setOptionalChainInstGelInstId( ChainInstGelInstId );
		if( indexByChainIdx == null ) {
			indexByChainIdx = new HashMap< CFGenKbGelInstructionByChainIdxKey,
				Map< CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj > >();
		}
		if( indexByChainIdx.containsKey( key ) ) {
			Map<CFGenKbGelInstructionPKey, ICFGenKbGelCounterObj> dict = indexByChainIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounterByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
			Iterator<ICFGenKbGelCounterObj> iter = dict.values().iterator();
			ICFGenKbGelCounterObj obj;
			List<ICFGenKbGelCounterObj> toForget = new LinkedList<ICFGenKbGelCounterObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByChainIdx.remove( key );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableGelCounter().deleteGelCounterByChainIdx( schema.getAuthorization(),
				ChainInstTenantId,
				ChainInstGelCacheId,
				ChainInstGelInstId );
		}
	}
}
