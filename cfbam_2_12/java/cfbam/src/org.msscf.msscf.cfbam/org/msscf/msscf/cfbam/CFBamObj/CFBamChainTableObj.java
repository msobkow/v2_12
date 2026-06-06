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

public class CFBamChainTableObj
	implements ICFBamChainTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamChainPKey, ICFBamChainObj> members;
	private Map<CFBamChainPKey, ICFBamChainObj> allChain;
	private Map< CFBamChainByTenantIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByTenantIdx;
	private Map< CFBamChainByChainTableIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByChainTableIdx;
	private Map< CFBamChainByDefSchemaIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByDefSchemaIdx;
	private Map< CFBamChainByUNameIdxKey,
		ICFBamChainObj > indexByUNameIdx;
	private Map< CFBamChainByPrevRelIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByPrevRelIdx;
	private Map< CFBamChainByNextRelIdxKey,
		Map<CFBamChainPKey, ICFBamChainObj > > indexByNextRelIdx;
	public static String TABLE_NAME = "Chain";
	public static String TABLE_DBNAME = "chain_def";

	public CFBamChainTableObj() {
		schema = null;
		members = new HashMap<CFBamChainPKey, ICFBamChainObj>();
		allChain = null;
		indexByTenantIdx = null;
		indexByChainTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
	}

	public CFBamChainTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamChainPKey, ICFBamChainObj>();
		allChain = null;
		indexByTenantIdx = null;
		indexByChainTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public String getTableName() {
		return( TABLE_NAME );
	}

	public String getTableDbName() {
		return( TABLE_DBNAME );
	}

	public Class getObjQualifyingClass() {
		return( ICFBamSchemaDefObj.class );
	}


	public void minimizeMemory() {
		allChain = null;
		indexByTenantIdx = null;
		indexByChainTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		Iterator<ICFBamChainObj> iter = members.values().iterator();
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
	 *	CFBamChainObj.
	 */
	public ICFBamChainObj newInstance() {
		ICFBamChainObj inst = new CFBamChainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamChainObj.
	 */
	public ICFBamChainEditObj newEditInstance( ICFBamChainObj orig ) {
		ICFBamChainEditObj edit = new CFBamChainEditObj( orig );
		return( edit );
	}

	public ICFBamChainObj realiseChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		CFBamChainPKey pkey = obj.getPKey();
		ICFBamChainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamChainObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByChainTableIdx != null ) {
				CFBamChainByChainTableIdxKey keyChainTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
				keyChainTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.remove( keepObj.getPKey() );
					if( mapChainTableIdx.size() <= 0 ) {
						indexByChainTableIdx.remove( keyChainTableIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.remove( keepObj.getPKey() );
					if( mapPrevRelIdx.size() <= 0 ) {
						indexByPrevRelIdx.remove( keyPrevRelIdx );
					}
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.remove( keepObj.getPKey() );
					if( mapNextRelIdx.size() <= 0 ) {
						indexByNextRelIdx.remove( keyNextRelIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByChainTableIdx != null ) {
				CFBamChainByChainTableIdxKey keyChainTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
				keyChainTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allChain != null ) {
				allChain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allChain != null ) {
				allChain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByChainTableIdx != null ) {
				CFBamChainByChainTableIdxKey keyChainTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
				keyChainTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetChain( ICFBamChainObj Obj ) {
		forgetChain( Obj, false );
	}

	public void forgetChain( ICFBamChainObj Obj, boolean forgetSubObjects ) {
		ICFBamChainObj obj = Obj;
		CFBamChainPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamChainObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByTenantIdx != null ) {
				CFBamChainByTenantIdxKey keyTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByChainTableIdx != null ) {
				CFBamChainByChainTableIdxKey keyChainTableIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
				keyChainTableIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.remove( keepObj.getPKey() );
					if( mapChainTableIdx.size() <= 0 ) {
						indexByChainTableIdx.remove( keyChainTableIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamChainByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				CFBamChainByUNameIdxKey keyUNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
				keyUNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevRelIdx != null ) {
				CFBamChainByPrevRelIdxKey keyPrevRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationTenantId( keepObj.getRequiredPrevRelationTenantId() );
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.remove( keepObj.getPKey() );
					if( mapPrevRelIdx.size() <= 0 ) {
						indexByPrevRelIdx.remove( keyPrevRelIdx );
					}
				}
			}

			if( indexByNextRelIdx != null ) {
				CFBamChainByNextRelIdxKey keyNextRelIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationTenantId( keepObj.getRequiredNextRelationTenantId() );
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.remove( keepObj.getPKey() );
					if( mapNextRelIdx.size() <= 0 ) {
						indexByNextRelIdx.remove( keyNextRelIdx );
					}
				}
			}

			if( allChain != null ) {
				allChain.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetChainByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamChainPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamChainObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetChainByTenantIdx( long TenantId )
	{
		if( indexByTenantIdx == null ) {
			return;
		}
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		CFBamChainByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapTenantIdx = indexByTenantIdx.get( key );
			if( mapTenantIdx != null ) {
				Iterator<ICFBamChainObj> iterDup = mapTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamChainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamChainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetChainByChainTableIdx( long TenantId,
		long TableId )
	{
		if( indexByChainTableIdx == null ) {
			return;
		}
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		CFBamChainByChainTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByChainTableIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapChainTableIdx = indexByChainTableIdx.get( key );
			if( mapChainTableIdx != null ) {
				Iterator<ICFBamChainObj> iterDup = mapChainTableIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByChainTableIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamChainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamChainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		CFBamChainByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamChainObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamChainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamChainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetChainByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			return;
		}
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		CFBamChainByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx.containsKey( key ) ) {
			cur = indexByUNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamChainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId )
	{
		if( indexByPrevRelIdx == null ) {
			return;
		}
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		CFBamChainByPrevRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );
		if( indexByPrevRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( key );
			if( mapPrevRelIdx != null ) {
				Iterator<ICFBamChainObj> iterDup = mapPrevRelIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevRelIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamChainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamChainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId )
	{
		if( indexByNextRelIdx == null ) {
			return;
		}
		List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
		ICFBamChainObj cur = null;
		CFBamChainByNextRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );
		if( indexByNextRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj > mapNextRelIdx = indexByNextRelIdx.get( key );
			if( mapNextRelIdx != null ) {
				Iterator<ICFBamChainObj> iterDup = mapNextRelIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextRelIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamChainObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamChainObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamChainObj createChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		CFBamChainBuff buff = obj.getChainBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableChain().createChain(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFBamChainObj readChain( CFBamChainPKey pkey ) {
		return( readChain( pkey, false ) );
	}

	public ICFBamChainObj readChain( CFBamChainPKey pkey, boolean forceRead ) {
		ICFBamChainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamChainBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamChainObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamChainObj lockChain( CFBamChainPKey pkey ) {
		ICFBamChainObj locked = null;
		CFBamChainBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableChain().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getChainTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamChainObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockChain", pkey );
		}
		return( locked );
	}

	public List<ICFBamChainObj> readAllChain() {
		return( readAllChain( false ) );
	}

	public List<ICFBamChainObj> readAllChain( boolean forceRead ) {
		final String S_ProcName = "readAllChain";
		if( ( allChain == null ) || forceRead ) {
			Map<CFBamChainPKey, ICFBamChainObj> map = new HashMap<CFBamChainPKey,ICFBamChainObj>();
			allChain = map;
			CFBamChainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readAllDerived( schema.getAuthorization() );
			CFBamChainBuff buff;
			ICFBamChainObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realised = (ICFBamChainObj)obj.realise();
			}
		}
		int len = allChain.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = allChain.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamChainObj readChainByIdIdx( long TenantId,
		long Id )
	{
		return( readChainByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamChainObj readChainByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamChainPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamChainObj obj = readChain( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamChainObj> readChainByTenantIdx( long TenantId )
	{
		return( readChainByTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByTenantIdx";
		CFBamChainByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamChainByTenantIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realised = (ICFBamChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamChainObj> readChainByChainTableIdx( long TenantId,
		long TableId )
	{
		return( readChainByChainTableIdx( TenantId,
			TableId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByChainTableIdx( long TenantId,
		long TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByChainTableIdx";
		CFBamChainByChainTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByChainTableIdx == null ) {
			indexByChainTableIdx = new HashMap< CFBamChainByChainTableIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByChainTableIdx.containsKey( key ) ) {
			dict = indexByChainTableIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByChainTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realised = (ICFBamChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainTableIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamChainObj> readChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readChainByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByDefSchemaIdx";
		CFBamChainByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamChainByDefSchemaIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realised = (ICFBamChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamChainObj readChainByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		return( readChainByUNameIdx( TenantId,
			TableId,
			Name,
			false ) );
	}

	public ICFBamChainObj readChainByUNameIdx( long TenantId,
		long TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamChainByUNameIdxKey,
				ICFBamChainObj >();
		}
		CFBamChainByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamChainObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			CFBamChainBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			if( buff != null ) {
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamChainObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamChainObj> readChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId )
	{
		return( readChainByPrevRelIdx( PrevRelationTenantId,
			PrevRelationId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByPrevRelIdx";
		CFBamChainByPrevRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByPrevRelIdx == null ) {
			indexByPrevRelIdx = new HashMap< CFBamChainByPrevRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByPrevRelIdx.containsKey( key ) ) {
			dict = indexByPrevRelIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByPrevRelIdx( schema.getAuthorization(),
				PrevRelationTenantId,
				PrevRelationId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realised = (ICFBamChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevRelIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamChainObj> readChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId )
	{
		return( readChainByNextRelIdx( NextRelationTenantId,
			NextRelationId,
			false ) );
	}

	public List<ICFBamChainObj> readChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByNextRelIdx";
		CFBamChainByNextRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );
		Map<CFBamChainPKey, ICFBamChainObj> dict;
		if( indexByNextRelIdx == null ) {
			indexByNextRelIdx = new HashMap< CFBamChainByNextRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( ( ! forceRead ) && indexByNextRelIdx.containsKey( key ) ) {
			dict = indexByNextRelIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamChainPKey, ICFBamChainObj>();
			ICFBamChainObj obj;
			CFBamChainBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableChain().readDerivedByNextRelIdx( schema.getAuthorization(),
				NextRelationTenantId,
				NextRelationId );
			CFBamChainBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey() );
				obj.setBuff( buff );
				ICFBamChainObj realised = (ICFBamChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextRelIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamChainObj arr[] = new ICFBamChainObj[len];
		Iterator<ICFBamChainObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamChainObj> arrayList = new ArrayList<ICFBamChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamChainObj> cmp = new Comparator<ICFBamChainObj>() {
			public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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
					CFBamChainPKey lhsPKey = lhs.getPKey();
					CFBamChainPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamChainObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamChainObj updateChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableChain().updateChain( schema.getAuthorization(),
			Obj.getChainBuff() );
		obj = (ICFBamChainObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteChain( ICFBamChainObj Obj ) {
		ICFBamChainObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChain( schema.getAuthorization(),
			obj.getChainBuff() );
		obj.forget( true );
	}

	public void deleteChainByIdIdx( long TenantId,
		long Id )
	{
		CFBamChainPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamChainObj obj = readChain( pkey );
		if( obj != null ) {
			ICFBamChainEditObj editObj = (ICFBamChainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamChainEditObj)obj.beginEdit();
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

	public void deleteChainByTenantIdx( long TenantId )
	{
		CFBamChainByTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< CFBamChainByTenantIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteChainByChainTableIdx( long TenantId,
		long TableId )
	{
		CFBamChainByChainTableIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newChainTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		if( indexByChainTableIdx == null ) {
			indexByChainTableIdx = new HashMap< CFBamChainByChainTableIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByChainTableIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByChainTableIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByChainTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByChainTableIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByChainTableIdx( schema.getAuthorization(),
				TenantId,
				TableId );
		}
	}

	public void deleteChainByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamChainByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamChainByDefSchemaIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByDefSchemaIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteChainByUNameIdx( long TenantId,
		long TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< CFBamChainByUNameIdxKey,
				ICFBamChainObj >();
		}
		CFBamChainByUNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newUNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		ICFBamChainObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByUNameIdx( schema.getAuthorization(),
				TenantId,
				TableId,
				Name );
		}
	}

	public void deleteChainByPrevRelIdx( long PrevRelationTenantId,
		long PrevRelationId )
	{
		CFBamChainByPrevRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newPrevRelIdxKey();
		key.setRequiredPrevRelationTenantId( PrevRelationTenantId );
		key.setRequiredPrevRelationId( PrevRelationId );
		if( indexByPrevRelIdx == null ) {
			indexByPrevRelIdx = new HashMap< CFBamChainByPrevRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByPrevRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByPrevRelIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByPrevRelIdx( schema.getAuthorization(),
				PrevRelationTenantId,
				PrevRelationId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrevRelIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByPrevRelIdx( schema.getAuthorization(),
				PrevRelationTenantId,
				PrevRelationId );
		}
	}

	public void deleteChainByNextRelIdx( long NextRelationTenantId,
		long NextRelationId )
	{
		CFBamChainByNextRelIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryChain().newNextRelIdxKey();
		key.setRequiredNextRelationTenantId( NextRelationTenantId );
		key.setRequiredNextRelationId( NextRelationId );
		if( indexByNextRelIdx == null ) {
			indexByNextRelIdx = new HashMap< CFBamChainByNextRelIdxKey,
				Map< CFBamChainPKey, ICFBamChainObj > >();
		}
		if( indexByNextRelIdx.containsKey( key ) ) {
			Map<CFBamChainPKey, ICFBamChainObj> dict = indexByNextRelIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByNextRelIdx( schema.getAuthorization(),
				NextRelationTenantId,
				NextRelationId );
			Iterator<ICFBamChainObj> iter = dict.values().iterator();
			ICFBamChainObj obj;
			List<ICFBamChainObj> toForget = new LinkedList<ICFBamChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNextRelIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableChain().deleteChainByNextRelIdx( schema.getAuthorization(),
				NextRelationTenantId,
				NextRelationId );
		}
	}
}
