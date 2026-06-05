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

public class CFGenKbHostNodeTableObj
	implements ICFGenKbHostNodeTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj> members;
	private Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj> allHostNode;
	private Map< CFGenKbHostNodeByClusterIdxKey,
		Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj > > indexByClusterIdx;
	private Map< CFGenKbHostNodeByUDescrIdxKey,
		ICFGenKbHostNodeObj > indexByUDescrIdx;
	private Map< CFGenKbHostNodeByHostNameIdxKey,
		ICFGenKbHostNodeObj > indexByHostNameIdx;
	public static String TABLE_NAME = "HostNode";
	public static String TABLE_DBNAME = "hostnode";

	public CFGenKbHostNodeTableObj() {
		schema = null;
		members = new HashMap<CFGenKbHostNodePKey, ICFGenKbHostNodeObj>();
		allHostNode = null;
		indexByClusterIdx = null;
		indexByUDescrIdx = null;
		indexByHostNameIdx = null;
	}

	public CFGenKbHostNodeTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbHostNodePKey, ICFGenKbHostNodeObj>();
		allHostNode = null;
		indexByClusterIdx = null;
		indexByUDescrIdx = null;
		indexByHostNameIdx = null;
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
		allHostNode = null;
		indexByClusterIdx = null;
		indexByUDescrIdx = null;
		indexByHostNameIdx = null;
		List<ICFGenKbHostNodeObj> toForget = new LinkedList<ICFGenKbHostNodeObj>();
		ICFGenKbHostNodeObj cur = null;
		Iterator<ICFGenKbHostNodeObj> iter = members.values().iterator();
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
	 *	CFGenKbHostNodeObj.
	 */
	public ICFGenKbHostNodeObj newInstance() {
		ICFGenKbHostNodeObj inst = new CFGenKbHostNodeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbHostNodeObj.
	 */
	public ICFGenKbHostNodeEditObj newEditInstance( ICFGenKbHostNodeObj orig ) {
		ICFGenKbHostNodeEditObj edit = new CFGenKbHostNodeEditObj( orig );
		return( edit );
	}

	public ICFGenKbHostNodeObj realiseHostNode( ICFGenKbHostNodeObj Obj ) {
		ICFGenKbHostNodeObj obj = Obj;
		CFGenKbHostNodePKey pkey = obj.getPKey();
		ICFGenKbHostNodeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbHostNodeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbHostNodeByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbHostNodeByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( indexByHostNameIdx != null ) {
				CFGenKbHostNodeByHostNameIdxKey keyHostNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.remove( keyHostNameIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbHostNodeByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbHostNodeByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( indexByHostNameIdx != null ) {
				CFGenKbHostNodeByHostNameIdxKey keyHostNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.put( keyHostNameIdx, keepObj );
			}

			if( allHostNode != null ) {
				allHostNode.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allHostNode != null ) {
				allHostNode.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFGenKbHostNodeByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbHostNodeByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( indexByHostNameIdx != null ) {
				CFGenKbHostNodeByHostNameIdxKey keyHostNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.put( keyHostNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetHostNode( ICFGenKbHostNodeObj Obj ) {
		forgetHostNode( Obj, false );
	}

	public void forgetHostNode( ICFGenKbHostNodeObj Obj, boolean forgetSubObjects ) {
		ICFGenKbHostNodeObj obj = Obj;
		CFGenKbHostNodePKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbHostNodeObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbHostNodeByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByUDescrIdx != null ) {
				CFGenKbHostNodeByUDescrIdxKey keyUDescrIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
				keyUDescrIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			if( indexByHostNameIdx != null ) {
				CFGenKbHostNodeByHostNameIdxKey keyHostNameIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
				keyHostNameIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyHostNameIdx.setRequiredHostName( keepObj.getRequiredHostName() );
				indexByHostNameIdx.remove( keyHostNameIdx );
			}

			if( allHostNode != null ) {
				allHostNode.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetHostNodeByIdIdx( long ClusterId,
		long HostNodeId )
	{
		if( members == null ) {
			return;
		}
		CFGenKbHostNodePKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostNodeId( HostNodeId );
		if( members.containsKey( key ) ) {
			ICFGenKbHostNodeObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetHostNodeByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFGenKbHostNodeObj> toForget = new LinkedList<ICFGenKbHostNodeObj>();
		ICFGenKbHostNodeObj cur = null;
		CFGenKbHostNodeByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbHostNodeObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbHostNodeObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbHostNodeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetHostNodeByUDescrIdx( long ClusterId,
		String Description )
	{
		if( indexByUDescrIdx == null ) {
			return;
		}
		List<ICFGenKbHostNodeObj> toForget = new LinkedList<ICFGenKbHostNodeObj>();
		ICFGenKbHostNodeObj cur = null;
		CFGenKbHostNodeByUDescrIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx.containsKey( key ) ) {
			cur = indexByUDescrIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbHostNodeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetHostNodeByHostNameIdx( long ClusterId,
		String HostName )
	{
		if( indexByHostNameIdx == null ) {
			return;
		}
		List<ICFGenKbHostNodeObj> toForget = new LinkedList<ICFGenKbHostNodeObj>();
		ICFGenKbHostNodeObj cur = null;
		CFGenKbHostNodeByHostNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );
		if( indexByHostNameIdx.containsKey( key ) ) {
			cur = indexByHostNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbHostNodeObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbHostNodeObj createHostNode( ICFGenKbHostNodeObj Obj ) {
		ICFGenKbHostNodeObj obj = Obj;
		CFGenKbHostNodeBuff buff = obj.getHostNodeBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().createHostNode(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbHostNodeObj readHostNode( CFGenKbHostNodePKey pkey ) {
		return( readHostNode( pkey, false ) );
	}

	public ICFGenKbHostNodeObj readHostNode( CFGenKbHostNodePKey pkey, boolean forceRead ) {
		ICFGenKbHostNodeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbHostNodeBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredHostNodeId() );
			if( readBuff != null ) {
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbHostNodeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbHostNodeObj lockHostNode( CFGenKbHostNodePKey pkey ) {
		ICFGenKbHostNodeObj locked = null;
		CFGenKbHostNodeBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getHostNodeTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbHostNodeObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockHostNode", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbHostNodeObj> readAllHostNode() {
		return( readAllHostNode( false ) );
	}

	public List<ICFGenKbHostNodeObj> readAllHostNode( boolean forceRead ) {
		final String S_ProcName = "readAllHostNode";
		if( ( allHostNode == null ) || forceRead ) {
			Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj> map = new HashMap<CFGenKbHostNodePKey,ICFGenKbHostNodeObj>();
			allHostNode = map;
			CFGenKbHostNodeBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().readAllDerived( schema.getAuthorization() );
			CFGenKbHostNodeBuff buff;
			ICFGenKbHostNodeObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				ICFGenKbHostNodeObj realised = (ICFGenKbHostNodeObj)obj.realise();
			}
		}
		int len = allHostNode.size();
		ICFGenKbHostNodeObj arr[] = new ICFGenKbHostNodeObj[len];
		Iterator<ICFGenKbHostNodeObj> valIter = allHostNode.values().iterator();
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
		ArrayList<ICFGenKbHostNodeObj> arrayList = new ArrayList<ICFGenKbHostNodeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbHostNodeObj> cmp = new Comparator<ICFGenKbHostNodeObj>() {
			public int compare( ICFGenKbHostNodeObj lhs, ICFGenKbHostNodeObj rhs ) {
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
					CFGenKbHostNodePKey lhsPKey = lhs.getPKey();
					CFGenKbHostNodePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbHostNodeObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbHostNodeObj> pageAllHostNode(Long priorClusterId,
		Long priorHostNodeId )
	{
		final String S_ProcName = "pageAllHostNode";
		Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj> map = new HashMap<CFGenKbHostNodePKey,ICFGenKbHostNodeObj>();
		CFGenKbHostNodeBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorHostNodeId );
		CFGenKbHostNodeBuff buff;
		ICFGenKbHostNodeObj obj;
		ICFGenKbHostNodeObj realised;
		ArrayList<ICFGenKbHostNodeObj> arrayList = new ArrayList<ICFGenKbHostNodeObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbHostNodeObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbHostNodeObj readHostNodeByIdIdx( long ClusterId,
		long HostNodeId )
	{
		return( readHostNodeByIdIdx( ClusterId,
			HostNodeId,
			false ) );
	}

	public ICFGenKbHostNodeObj readHostNodeByIdIdx( long ClusterId,
		long HostNodeId, boolean forceRead )
	{
		CFGenKbHostNodePKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredHostNodeId( HostNodeId );
		ICFGenKbHostNodeObj obj = readHostNode( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbHostNodeObj> readHostNodeByClusterIdx( long ClusterId )
	{
		return( readHostNodeByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbHostNodeObj> readHostNodeByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readHostNodeByClusterIdx";
		CFGenKbHostNodeByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbHostNodeByClusterIdxKey,
				Map< CFGenKbHostNodePKey, ICFGenKbHostNodeObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbHostNodePKey, ICFGenKbHostNodeObj>();
			ICFGenKbHostNodeObj obj;
			CFGenKbHostNodeBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbHostNodeBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				ICFGenKbHostNodeObj realised = (ICFGenKbHostNodeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbHostNodeObj arr[] = new ICFGenKbHostNodeObj[len];
		Iterator<ICFGenKbHostNodeObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbHostNodeObj> arrayList = new ArrayList<ICFGenKbHostNodeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbHostNodeObj> cmp = new Comparator<ICFGenKbHostNodeObj>() {
			public int compare( ICFGenKbHostNodeObj lhs, ICFGenKbHostNodeObj rhs ) {
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
					CFGenKbHostNodePKey lhsPKey = lhs.getPKey();
					CFGenKbHostNodePKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbHostNodeObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbHostNodeObj readHostNodeByUDescrIdx( long ClusterId,
		String Description )
	{
		return( readHostNodeByUDescrIdx( ClusterId,
			Description,
			false ) );
	}

	public ICFGenKbHostNodeObj readHostNodeByUDescrIdx( long ClusterId,
		String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFGenKbHostNodeByUDescrIdxKey,
				ICFGenKbHostNodeObj >();
		}
		CFGenKbHostNodeByUDescrIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );
		ICFGenKbHostNodeObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			CFGenKbHostNodeBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().readDerivedByUDescrIdx( schema.getAuthorization(),
				ClusterId,
				Description );
			if( buff != null ) {
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbHostNodeObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbHostNodeObj readHostNodeByHostNameIdx( long ClusterId,
		String HostName )
	{
		return( readHostNodeByHostNameIdx( ClusterId,
			HostName,
			false ) );
	}

	public ICFGenKbHostNodeObj readHostNodeByHostNameIdx( long ClusterId,
		String HostName, boolean forceRead )
	{
		if( indexByHostNameIdx == null ) {
			indexByHostNameIdx = new HashMap< CFGenKbHostNodeByHostNameIdxKey,
				ICFGenKbHostNodeObj >();
		}
		CFGenKbHostNodeByHostNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );
		ICFGenKbHostNodeObj obj = null;
		if( ( ! forceRead ) && indexByHostNameIdx.containsKey( key ) ) {
			obj = indexByHostNameIdx.get( key );
		}
		else {
			CFGenKbHostNodeBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().readDerivedByHostNameIdx( schema.getAuthorization(),
				ClusterId,
				HostName );
			if( buff != null ) {
				obj = schema.getHostNodeTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbHostNodeObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of HostNode-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	A List of HostNode-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFGenKbHostNodeObj> pageHostNodeByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorHostNodeId )
	{
		final String S_ProcName = "pageHostNodeByClusterIdx";
		CFGenKbHostNodeByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFGenKbHostNodeObj> retList = new LinkedList<ICFGenKbHostNodeObj>();
		ICFGenKbHostNodeObj obj;
		CFGenKbHostNodeBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorHostNodeId );
		CFGenKbHostNodeBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getHostNodeTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey() );
			obj.setBuff( buff );
			ICFGenKbHostNodeObj realised = (ICFGenKbHostNodeObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbHostNodeObj updateHostNode( ICFGenKbHostNodeObj Obj ) {
		ICFGenKbHostNodeObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().updateHostNode( schema.getAuthorization(),
			Obj.getHostNodeBuff() );
		obj = (ICFGenKbHostNodeObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteHostNode( ICFGenKbHostNodeObj Obj ) {
		ICFGenKbHostNodeObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNode( schema.getAuthorization(),
			obj.getHostNodeBuff() );
		obj.forget( true );
	}

	public void deleteHostNodeByIdIdx( long ClusterId,
		long HostNodeId )
	{
		CFGenKbHostNodePKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredHostNodeId( HostNodeId );
		ICFGenKbHostNodeObj obj = readHostNode( pkey );
		if( obj != null ) {
			ICFGenKbHostNodeEditObj editObj = (ICFGenKbHostNodeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbHostNodeEditObj)obj.beginEdit();
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

	public void deleteHostNodeByClusterIdx( long ClusterId )
	{
		CFGenKbHostNodeByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbHostNodeByClusterIdxKey,
				Map< CFGenKbHostNodePKey, ICFGenKbHostNodeObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbHostNodePKey, ICFGenKbHostNodeObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNodeByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbHostNodeObj> iter = dict.values().iterator();
			ICFGenKbHostNodeObj obj;
			List<ICFGenKbHostNodeObj> toForget = new LinkedList<ICFGenKbHostNodeObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNodeByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteHostNodeByUDescrIdx( long ClusterId,
		String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< CFGenKbHostNodeByUDescrIdxKey,
				ICFGenKbHostNodeObj >();
		}
		CFGenKbHostNodeByUDescrIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newUDescrIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredDescription( Description );
		ICFGenKbHostNodeObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNodeByUDescrIdx( schema.getAuthorization(),
				ClusterId,
				Description );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNodeByUDescrIdx( schema.getAuthorization(),
				ClusterId,
				Description );
		}
	}

	public void deleteHostNodeByHostNameIdx( long ClusterId,
		String HostName )
	{
		if( indexByHostNameIdx == null ) {
			indexByHostNameIdx = new HashMap< CFGenKbHostNodeByHostNameIdxKey,
				ICFGenKbHostNodeObj >();
		}
		CFGenKbHostNodeByHostNameIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryHostNode().newHostNameIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredHostName( HostName );
		ICFGenKbHostNodeObj obj = null;
		if( indexByHostNameIdx.containsKey( key ) ) {
			obj = indexByHostNameIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNodeByHostNameIdx( schema.getAuthorization(),
				ClusterId,
				HostName );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableHostNode().deleteHostNodeByHostNameIdx( schema.getAuthorization(),
				ClusterId,
				HostName );
		}
	}
}
