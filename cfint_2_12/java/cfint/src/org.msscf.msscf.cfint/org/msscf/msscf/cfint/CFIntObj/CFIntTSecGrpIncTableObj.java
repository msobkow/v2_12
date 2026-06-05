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

public class CFIntTSecGrpIncTableObj
	implements ICFIntTSecGrpIncTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> members;
	private Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> allTSecGrpInc;
	private Map< CFSecTSecGrpIncByTenantIdxKey,
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > > indexByTenantIdx;
	private Map< CFSecTSecGrpIncByGroupIdxKey,
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > > indexByGroupIdx;
	private Map< CFSecTSecGrpIncByIncludeIdxKey,
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > > indexByIncludeIdx;
	private Map< CFSecTSecGrpIncByUIncludeIdxKey,
		ICFSecTSecGrpIncObj > indexByUIncludeIdx;
	public static String TABLE_NAME = "TSecGrpInc";
	public static String TABLE_DBNAME = "tsecinc";

	public CFIntTSecGrpIncTableObj() {
		schema = null;
		members = new HashMap<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj>();
		allTSecGrpInc = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
	}

	public CFIntTSecGrpIncTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj>();
		allTSecGrpInc = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
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
		allTSecGrpInc = null;
		indexByTenantIdx = null;
		indexByGroupIdx = null;
		indexByIncludeIdx = null;
		indexByUIncludeIdx = null;
		List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj cur = null;
		Iterator<ICFSecTSecGrpIncObj> iter = members.values().iterator();
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
	 *	CFIntTSecGrpIncObj.
	 */
	public ICFSecTSecGrpIncObj newInstance() {
		ICFSecTSecGrpIncObj inst = new CFIntTSecGrpIncObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFIntTSecGrpIncObj.
	 */
	public ICFSecTSecGrpIncEditObj newEditInstance( ICFSecTSecGrpIncObj orig ) {
		ICFSecTSecGrpIncEditObj edit = new CFIntTSecGrpIncEditObj( orig );
		return( edit );
	}

	public ICFSecTSecGrpIncObj realiseTSecGrpInc( ICFSecTSecGrpIncObj Obj ) {
		ICFSecTSecGrpIncObj obj = Obj;
		CFSecTSecGrpIncPKey pkey = obj.getPKey();
		ICFSecTSecGrpIncObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecTSecGrpIncObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpIncByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByIncludeIdx != null ) {
				CFSecTSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
					if( mapIncludeIdx.size() <= 0 ) {
						indexByIncludeIdx.remove( keyIncludeIdx );
					}
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFSecTSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpIncByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFSecTSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFSecTSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}

			if( allTSecGrpInc != null ) {
				allTSecGrpInc.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTSecGrpInc != null ) {
				allTSecGrpInc.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpIncByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIncludeIdx != null ) {
				CFSecTSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFSecTSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.put( keyUIncludeIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetTSecGrpInc( ICFSecTSecGrpIncObj Obj ) {
		forgetTSecGrpInc( Obj, false );
	}

	public void forgetTSecGrpInc( ICFSecTSecGrpIncObj Obj, boolean forgetSubObjects ) {
		ICFSecTSecGrpIncObj obj = Obj;
		CFSecTSecGrpIncPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecTSecGrpIncObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFSecTSecGrpIncByTenantIdxKey keyTenantIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecTSecGrpIncByGroupIdxKey keyGroupIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
				keyGroupIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyGroupIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByIncludeIdx != null ) {
				CFSecTSecGrpIncByIncludeIdxKey keyIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
				keyIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( keyIncludeIdx );
				if( mapIncludeIdx != null ) {
					mapIncludeIdx.remove( keepObj.getPKey() );
					if( mapIncludeIdx.size() <= 0 ) {
						indexByIncludeIdx.remove( keyIncludeIdx );
					}
				}
			}

			if( indexByUIncludeIdx != null ) {
				CFSecTSecGrpIncByUIncludeIdxKey keyUIncludeIdx =
					((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
				keyUIncludeIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUIncludeIdx.setRequiredTSecGroupId( keepObj.getRequiredTSecGroupId() );
				keyUIncludeIdx.setRequiredIncludeGroupId( keepObj.getRequiredIncludeGroupId() );
				indexByUIncludeIdx.remove( keyUIncludeIdx );
			}

			if( allTSecGrpInc != null ) {
				allTSecGrpInc.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetTSecGrpIncByIdIdx( long TenantId,
		long TSecGrpIncId )
	{
		if( members == null ) {
			return;
		}
		CFSecTSecGrpIncPKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGrpIncId( TSecGrpIncId );
		if( members.containsKey( key ) ) {
			ICFSecTSecGrpIncObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetTSecGrpIncByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj cur = null;
		CFSecTSecGrpIncByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFSecTSecGrpIncObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGrpIncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGrpIncByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj cur = null;
		CFSecTSecGrpIncByGroupIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFSecTSecGrpIncObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGrpIncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGrpIncByIncludeIdx( long TenantId,
		int IncludeGroupId )
	{
		if( indexByIncludeIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj cur = null;
		CFSecTSecGrpIncByIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > mapIncludeIdx = indexByIncludeIdx.get( key );
			if( mapIncludeIdx != null ) {
				Iterator<ICFSecTSecGrpIncObj> iterDup = mapIncludeIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByIncludeIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecTSecGrpIncObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecTSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetTSecGrpIncByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			return;
		}
		List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj cur = null;
		CFSecTSecGrpIncByUIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByUIncludeIdx.containsKey( key ) ) {
			cur = indexByUIncludeIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecTSecGrpIncObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecTSecGrpIncObj createTSecGrpInc( ICFSecTSecGrpIncObj Obj ) {
		ICFSecTSecGrpIncObj obj = Obj;
		CFSecTSecGrpIncBuff buff = obj.getTSecGrpIncBuff();
		((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().createTSecGrpInc(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecTSecGrpIncObj readTSecGrpInc( CFSecTSecGrpIncPKey pkey ) {
		return( readTSecGrpInc( pkey, false ) );
	}

	public ICFSecTSecGrpIncObj readTSecGrpInc( CFSecTSecGrpIncPKey pkey, boolean forceRead ) {
		ICFSecTSecGrpIncObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecTSecGrpIncBuff readBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredTSecGrpIncId() );
			if( readBuff != null ) {
				obj = schema.getTSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecTSecGrpIncObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecTSecGrpIncObj lockTSecGrpInc( CFSecTSecGrpIncPKey pkey ) {
		ICFSecTSecGrpIncObj locked = null;
		CFSecTSecGrpIncBuff lockBuff = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getTSecGrpIncTableObj().newInstance();
			locked.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecTSecGrpIncObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockTSecGrpInc", pkey );
		}
		return( locked );
	}

	public List<ICFSecTSecGrpIncObj> readAllTSecGrpInc() {
		return( readAllTSecGrpInc( false ) );
	}

	public List<ICFSecTSecGrpIncObj> readAllTSecGrpInc( boolean forceRead ) {
		final String S_ProcName = "readAllTSecGrpInc";
		if( ( allTSecGrpInc == null ) || forceRead ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> map = new HashMap<CFSecTSecGrpIncPKey,ICFSecTSecGrpIncObj>();
			allTSecGrpInc = map;
			CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().readAllDerived( schema.getAuthorization() );
			CFSecTSecGrpIncBuff buff;
			ICFSecTSecGrpIncObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
			}
		}
		int len = allTSecGrpInc.size();
		ICFSecTSecGrpIncObj arr[] = new ICFSecTSecGrpIncObj[len];
		Iterator<ICFSecTSecGrpIncObj> valIter = allTSecGrpInc.values().iterator();
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
		ArrayList<ICFSecTSecGrpIncObj> arrayList = new ArrayList<ICFSecTSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpIncObj> cmp = new Comparator<ICFSecTSecGrpIncObj>() {
			public int compare( ICFSecTSecGrpIncObj lhs, ICFSecTSecGrpIncObj rhs ) {
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
					CFSecTSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the TSecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecTSecGrpIncObj> pageAllTSecGrpInc(Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageAllTSecGrpInc";
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> map = new HashMap<CFSecTSecGrpIncPKey,ICFSecTSecGrpIncObj>();
		CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().pageAllBuff( schema.getAuthorization(),
			priorTenantId,
			priorTSecGrpIncId );
		CFSecTSecGrpIncBuff buff;
		ICFSecTSecGrpIncObj obj;
		ICFSecTSecGrpIncObj realised;
		ArrayList<ICFSecTSecGrpIncObj> arrayList = new ArrayList<ICFSecTSecGrpIncObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecTSecGrpIncObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecTSecGrpIncObj readTSecGrpIncByIdIdx( long TenantId,
		long TSecGrpIncId )
	{
		return( readTSecGrpIncByIdIdx( TenantId,
			TSecGrpIncId,
			false ) );
	}

	public ICFSecTSecGrpIncObj readTSecGrpIncByIdIdx( long TenantId,
		long TSecGrpIncId, boolean forceRead )
	{
		CFSecTSecGrpIncPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGrpIncId( TSecGrpIncId );
		ICFSecTSecGrpIncObj obj = readTSecGrpInc( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecTSecGrpIncObj> readTSecGrpIncByTenantIdx( long TenantId )
	{
		return( readTSecGrpIncByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFSecTSecGrpIncObj> readTSecGrpIncByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpIncByTenantIdx";
		CFSecTSecGrpIncByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFSecTSecGrpIncByTenantIdxKey,
				Map< CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj>();
			ICFSecTSecGrpIncObj obj;
			CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFSecTSecGrpIncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGrpIncObj arr[] = new ICFSecTSecGrpIncObj[len];
		Iterator<ICFSecTSecGrpIncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGrpIncObj> arrayList = new ArrayList<ICFSecTSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpIncObj> cmp = new Comparator<ICFSecTSecGrpIncObj>() {
			public int compare( ICFSecTSecGrpIncObj lhs, ICFSecTSecGrpIncObj rhs ) {
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
					CFSecTSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecTSecGrpIncObj> readTSecGrpIncByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		return( readTSecGrpIncByGroupIdx( TenantId,
			TSecGroupId,
			false ) );
	}

	public List<ICFSecTSecGrpIncObj> readTSecGrpIncByGroupIdx( long TenantId,
		int TSecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpIncByGroupIdx";
		CFSecTSecGrpIncByGroupIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecTSecGrpIncByGroupIdxKey,
				Map< CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj>();
			ICFSecTSecGrpIncObj obj;
			CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().readDerivedByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			CFSecTSecGrpIncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGrpIncObj arr[] = new ICFSecTSecGrpIncObj[len];
		Iterator<ICFSecTSecGrpIncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGrpIncObj> arrayList = new ArrayList<ICFSecTSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpIncObj> cmp = new Comparator<ICFSecTSecGrpIncObj>() {
			public int compare( ICFSecTSecGrpIncObj lhs, ICFSecTSecGrpIncObj rhs ) {
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
					CFSecTSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecTSecGrpIncObj> readTSecGrpIncByIncludeIdx( long TenantId,
		int IncludeGroupId )
	{
		return( readTSecGrpIncByIncludeIdx( TenantId,
			IncludeGroupId,
			false ) );
	}

	public List<ICFSecTSecGrpIncObj> readTSecGrpIncByIncludeIdx( long TenantId,
		int IncludeGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readTSecGrpIncByIncludeIdx";
		CFSecTSecGrpIncByIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> dict;
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFSecTSecGrpIncByIncludeIdxKey,
				Map< CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > >();
		}
		if( ( ! forceRead ) && indexByIncludeIdx.containsKey( key ) ) {
			dict = indexByIncludeIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj>();
			ICFSecTSecGrpIncObj obj;
			CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().readDerivedByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId );
			CFSecTSecGrpIncBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getTSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
				obj.setBuff( buff );
				ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIncludeIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecTSecGrpIncObj arr[] = new ICFSecTSecGrpIncObj[len];
		Iterator<ICFSecTSecGrpIncObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecTSecGrpIncObj> arrayList = new ArrayList<ICFSecTSecGrpIncObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecTSecGrpIncObj> cmp = new Comparator<ICFSecTSecGrpIncObj>() {
			public int compare( ICFSecTSecGrpIncObj lhs, ICFSecTSecGrpIncObj rhs ) {
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
					CFSecTSecGrpIncPKey lhsPKey = lhs.getPKey();
					CFSecTSecGrpIncPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecTSecGrpIncObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecTSecGrpIncObj readTSecGrpIncByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		return( readTSecGrpIncByUIncludeIdx( TenantId,
			TSecGroupId,
			IncludeGroupId,
			false ) );
	}

	public ICFSecTSecGrpIncObj readTSecGrpIncByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId, boolean forceRead )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFSecTSecGrpIncByUIncludeIdxKey,
				ICFSecTSecGrpIncObj >();
		}
		CFSecTSecGrpIncByUIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFSecTSecGrpIncObj obj = null;
		if( ( ! forceRead ) && indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
		}
		else {
			CFSecTSecGrpIncBuff buff = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().readDerivedByUIncludeIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				IncludeGroupId );
			if( buff != null ) {
				obj = schema.getTSecGrpIncTableObj().newInstance();
				obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecTSecGrpIncObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of TSecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TenantIdx key attributes.
	 *
	 *	@param	argTenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTSecGrpIncObj> pageTSecGrpIncByTenantIdx( long TenantId,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageTSecGrpIncByTenantIdx";
		CFSecTSecGrpIncByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		List<ICFSecTSecGrpIncObj> retList = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj obj;
		CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().pageBuffByTenantIdx( schema.getAuthorization(),
				TenantId,
			priorTenantId,
			priorTSecGrpIncId );
		CFSecTSecGrpIncBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpIncTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
			obj.setBuff( buff );
			ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of TSecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argTenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argTSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTSecGrpIncObj> pageTSecGrpIncByGroupIdx( long TenantId,
		int TSecGroupId,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageTSecGrpIncByGroupIdx";
		CFSecTSecGrpIncByGroupIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		List<ICFSecTSecGrpIncObj> retList = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj obj;
		CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().pageBuffByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
			priorTenantId,
			priorTSecGrpIncId );
		CFSecTSecGrpIncBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpIncTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
			obj.setBuff( buff );
			ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of TSecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate IncludeIdx key attributes.
	 *
	 *	@param	argTenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecTSecGrpIncObj> pageTSecGrpIncByIncludeIdx( long TenantId,
		int IncludeGroupId,
		Long priorTenantId,
		Long priorTSecGrpIncId )
	{
		final String S_ProcName = "pageTSecGrpIncByIncludeIdx";
		CFSecTSecGrpIncByIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		List<ICFSecTSecGrpIncObj> retList = new LinkedList<ICFSecTSecGrpIncObj>();
		ICFSecTSecGrpIncObj obj;
		CFSecTSecGrpIncBuff[] buffList = ((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().pageBuffByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId,
			priorTenantId,
			priorTSecGrpIncId );
		CFSecTSecGrpIncBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getTSecGrpIncTableObj().newInstance();
			obj.setPKey( ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey() );
			obj.setBuff( buff );
			ICFSecTSecGrpIncObj realised = (ICFSecTSecGrpIncObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecTSecGrpIncObj updateTSecGrpInc( ICFSecTSecGrpIncObj Obj ) {
		ICFSecTSecGrpIncObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().updateTSecGrpInc( schema.getAuthorization(),
			Obj.getTSecGrpIncBuff() );
		obj = (ICFSecTSecGrpIncObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteTSecGrpInc( ICFSecTSecGrpIncObj Obj ) {
		ICFSecTSecGrpIncObj obj = Obj;
		((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpInc( schema.getAuthorization(),
			obj.getTSecGrpIncBuff() );
		obj.forget( true );
	}

	public void deleteTSecGrpIncByIdIdx( long TenantId,
		long TSecGrpIncId )
	{
		CFSecTSecGrpIncPKey pkey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredTSecGrpIncId( TSecGrpIncId );
		ICFSecTSecGrpIncObj obj = readTSecGrpInc( pkey );
		if( obj != null ) {
			ICFSecTSecGrpIncEditObj editObj = (ICFSecTSecGrpIncEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecTSecGrpIncEditObj)obj.beginEdit();
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

	public void deleteTSecGrpIncByTenantIdx( long TenantId )
	{
		CFSecTSecGrpIncByTenantIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFSecTSecGrpIncByTenantIdxKey,
				Map< CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> dict = indexByTenantIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFSecTSecGrpIncObj> iter = dict.values().iterator();
			ICFSecTSecGrpIncObj obj;
			List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
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
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteTSecGrpIncByGroupIdx( long TenantId,
		int TSecGroupId )
	{
		CFSecTSecGrpIncByGroupIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newGroupIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecTSecGrpIncByGroupIdxKey,
				Map< CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> dict = indexByGroupIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
			Iterator<ICFSecTSecGrpIncObj> iter = dict.values().iterator();
			ICFSecTSecGrpIncObj obj;
			List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByGroupIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByGroupIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId );
		}
	}

	public void deleteTSecGrpIncByIncludeIdx( long TenantId,
		int IncludeGroupId )
	{
		CFSecTSecGrpIncByIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		if( indexByIncludeIdx == null ) {
			indexByIncludeIdx = new HashMap< CFSecTSecGrpIncByIncludeIdxKey,
				Map< CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj > >();
		}
		if( indexByIncludeIdx.containsKey( key ) ) {
			Map<CFSecTSecGrpIncPKey, ICFSecTSecGrpIncObj> dict = indexByIncludeIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId );
			Iterator<ICFSecTSecGrpIncObj> iter = dict.values().iterator();
			ICFSecTSecGrpIncObj obj;
			List<ICFSecTSecGrpIncObj> toForget = new LinkedList<ICFSecTSecGrpIncObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByIncludeIdx.remove( key );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByIncludeIdx( schema.getAuthorization(),
				TenantId,
				IncludeGroupId );
		}
	}

	public void deleteTSecGrpIncByUIncludeIdx( long TenantId,
		int TSecGroupId,
		int IncludeGroupId )
	{
		if( indexByUIncludeIdx == null ) {
			indexByUIncludeIdx = new HashMap< CFSecTSecGrpIncByUIncludeIdxKey,
				ICFSecTSecGrpIncObj >();
		}
		CFSecTSecGrpIncByUIncludeIdxKey key = ((ICFIntSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newUIncludeIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTSecGroupId( TSecGroupId );
		key.setRequiredIncludeGroupId( IncludeGroupId );
		ICFSecTSecGrpIncObj obj = null;
		if( indexByUIncludeIdx.containsKey( key ) ) {
			obj = indexByUIncludeIdx.get( key );
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByUIncludeIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				IncludeGroupId );
			obj.forget( true );
		}
		else {
			((ICFIntSchema)schema.getBackingStore()).getTableTSecGrpInc().deleteTSecGrpIncByUIncludeIdx( schema.getAuthorization(),
				TenantId,
				TSecGroupId,
				IncludeGroupId );
		}
	}
}
