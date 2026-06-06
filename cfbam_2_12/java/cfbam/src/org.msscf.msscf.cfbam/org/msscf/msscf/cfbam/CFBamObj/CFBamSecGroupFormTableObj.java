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

public class CFBamSecGroupFormTableObj
	implements ICFBamSecGroupFormTableObj
{
	protected ICFSecSchemaObj schema;
	private Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> members;
	private Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> allSecGroupForm;
	private Map< CFSecSecGroupFormByClusterIdxKey,
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > > indexByClusterIdx;
	private Map< CFSecSecGroupFormByGroupIdxKey,
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > > indexByGroupIdx;
	private Map< CFSecSecGroupFormByAppIdxKey,
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > > indexByAppIdx;
	private Map< CFSecSecGroupFormByFormIdxKey,
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > > indexByFormIdx;
	private Map< CFSecSecGroupFormByUFormIdxKey,
		ICFSecSecGroupFormObj > indexByUFormIdx;
	public static String TABLE_NAME = "SecGroupForm";
	public static String TABLE_DBNAME = "secgrpfrm";

	public CFBamSecGroupFormTableObj() {
		schema = null;
		members = new HashMap<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj>();
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
	}

	public CFBamSecGroupFormTableObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj>();
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
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
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
		List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj cur = null;
		Iterator<ICFSecSecGroupFormObj> iter = members.values().iterator();
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
	 *	CFBamSecGroupFormObj.
	 */
	public ICFSecSecGroupFormObj newInstance() {
		ICFSecSecGroupFormObj inst = new CFBamSecGroupFormObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamSecGroupFormObj.
	 */
	public ICFSecSecGroupFormEditObj newEditInstance( ICFSecSecGroupFormObj orig ) {
		ICFSecSecGroupFormEditObj edit = new CFBamSecGroupFormEditObj( orig );
		return( edit );
	}

	public ICFSecSecGroupFormObj realiseSecGroupForm( ICFSecSecGroupFormObj Obj ) {
		ICFSecSecGroupFormObj obj = Obj;
		CFSecSecGroupFormPKey pkey = obj.getPKey();
		ICFSecSecGroupFormObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFSecSecGroupFormObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFSecSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByAppIdx != null ) {
				CFSecSecGroupFormByAppIdxKey keyAppIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.remove( keepObj.getPKey() );
					if( mapAppIdx.size() <= 0 ) {
						indexByAppIdx.remove( keyAppIdx );
					}
				}
			}

			if( indexByFormIdx != null ) {
				CFSecSecGroupFormByFormIdxKey keyFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.remove( keepObj.getPKey() );
					if( mapFormIdx.size() <= 0 ) {
						indexByFormIdx.remove( keyFormIdx );
					}
				}
			}

			if( indexByUFormIdx != null ) {
				CFSecSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.remove( keyUFormIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFSecSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAppIdx != null ) {
				CFSecSecGroupFormByAppIdxKey keyAppIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFormIdx != null ) {
				CFSecSecGroupFormByFormIdxKey keyFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUFormIdx != null ) {
				CFSecSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.put( keyUFormIdx, keepObj );
			}

			if( allSecGroupForm != null ) {
				allSecGroupForm.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecGroupForm != null ) {
				allSecGroupForm.put( keepObj.getPKey(), keepObj );
			}

			if( indexByClusterIdx != null ) {
				CFSecSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAppIdx != null ) {
				CFSecSecGroupFormByAppIdxKey keyAppIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFormIdx != null ) {
				CFSecSecGroupFormByFormIdxKey keyFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUFormIdx != null ) {
				CFSecSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.put( keyUFormIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGroupForm( ICFSecSecGroupFormObj Obj ) {
		forgetSecGroupForm( Obj, false );
	}

	public void forgetSecGroupForm( ICFSecSecGroupFormObj Obj, boolean forgetSubObjects ) {
		ICFSecSecGroupFormObj obj = Obj;
		CFSecSecGroupFormPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFSecSecGroupFormObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFSecSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFSecSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByAppIdx != null ) {
				CFSecSecGroupFormByAppIdxKey keyAppIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.remove( keepObj.getPKey() );
					if( mapAppIdx.size() <= 0 ) {
						indexByAppIdx.remove( keyAppIdx );
					}
				}
			}

			if( indexByFormIdx != null ) {
				CFSecSecGroupFormByFormIdxKey keyFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.remove( keepObj.getPKey() );
					if( mapFormIdx.size() <= 0 ) {
						indexByFormIdx.remove( keyFormIdx );
					}
				}
			}

			if( indexByUFormIdx != null ) {
				CFSecSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.remove( keyUFormIdx );
			}

			if( allSecGroupForm != null ) {
				allSecGroupForm.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		if( members == null ) {
			return;
		}
		CFSecSecGroupFormPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupFormId( SecGroupFormId );
		if( members.containsKey( key ) ) {
			ICFSecSecGroupFormObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetSecGroupFormByClusterIdx( long ClusterId )
	{
		if( indexByClusterIdx == null ) {
			return;
		}
		List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj cur = null;
		CFSecSecGroupFormByClusterIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFSecSecGroupFormObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGroupFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		if( indexByGroupIdx == null ) {
			return;
		}
		List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj cur = null;
		CFSecSecGroupFormByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFSecSecGroupFormObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGroupFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		if( indexByAppIdx == null ) {
			return;
		}
		List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj cur = null;
		CFSecSecGroupFormByAppIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexByAppIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapAppIdx = indexByAppIdx.get( key );
			if( mapAppIdx != null ) {
				Iterator<ICFSecSecGroupFormObj> iterDup = mapAppIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByAppIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGroupFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		if( indexByFormIdx == null ) {
			return;
		}
		List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj cur = null;
		CFSecSecGroupFormByFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByFormIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > mapFormIdx = indexByFormIdx.get( key );
			if( mapFormIdx != null ) {
				Iterator<ICFSecSecGroupFormObj> iterDup = mapFormIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByFormIdx.remove( key );
			}

		}
		else {
			Iterator<ICFSecSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFSecSecGroupFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		if( indexByUFormIdx == null ) {
			return;
		}
		List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj cur = null;
		CFSecSecGroupFormByUFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByUFormIdx.containsKey( key ) ) {
			cur = indexByUFormIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFSecSecGroupFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFSecSecGroupFormObj createSecGroupForm( ICFSecSecGroupFormObj Obj ) {
		ICFSecSecGroupFormObj obj = Obj;
		CFSecSecGroupFormBuff buff = obj.getSecGroupFormBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().createSecGroupForm(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFSecSecGroupFormObj readSecGroupForm( CFSecSecGroupFormPKey pkey ) {
		return( readSecGroupForm( pkey, false ) );
	}

	public ICFSecSecGroupFormObj readSecGroupForm( CFSecSecGroupFormPKey pkey, boolean forceRead ) {
		ICFSecSecGroupFormObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFSecSecGroupFormBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupFormId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFSecSecGroupFormObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFSecSecGroupFormObj lockSecGroupForm( CFSecSecGroupFormPKey pkey ) {
		ICFSecSecGroupFormObj locked = null;
		CFSecSecGroupFormBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupFormTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFSecSecGroupFormObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGroupForm", pkey );
		}
		return( locked );
	}

	public List<ICFSecSecGroupFormObj> readAllSecGroupForm() {
		return( readAllSecGroupForm( false ) );
	}

	public List<ICFSecSecGroupFormObj> readAllSecGroupForm( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroupForm";
		if( ( allSecGroupForm == null ) || forceRead ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> map = new HashMap<CFSecSecGroupFormPKey,ICFSecSecGroupFormObj>();
			allSecGroupForm = map;
			CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readAllDerived( schema.getAuthorization() );
			CFSecSecGroupFormBuff buff;
			ICFSecSecGroupFormObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
			}
		}
		int len = allSecGroupForm.size();
		ICFSecSecGroupFormObj arr[] = new ICFSecSecGroupFormObj[len];
		Iterator<ICFSecSecGroupFormObj> valIter = allSecGroupForm.values().iterator();
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
		ArrayList<ICFSecSecGroupFormObj> arrayList = new ArrayList<ICFSecSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupFormObj> cmp = new Comparator<ICFSecSecGroupFormObj>() {
			public int compare( ICFSecSecGroupFormObj lhs, ICFSecSecGroupFormObj rhs ) {
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
					CFSecSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecGroupForm-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGroupFormObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFSecSecGroupFormObj> pageAllSecGroupForm(Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageAllSecGroupForm";
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> map = new HashMap<CFSecSecGroupFormPKey,ICFSecSecGroupFormObj>();
		CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecGroupFormId );
		CFSecSecGroupFormBuff buff;
		ICFSecSecGroupFormObj obj;
		ICFSecSecGroupFormObj realised;
		ArrayList<ICFSecSecGroupFormObj> arrayList = new ArrayList<ICFSecSecGroupFormObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			realised = (ICFSecSecGroupFormObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFSecSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		return( readSecGroupFormByIdIdx( ClusterId,
			SecGroupFormId,
			false ) );
	}

	public ICFSecSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId, boolean forceRead )
	{
		CFSecSecGroupFormPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupFormId( SecGroupFormId );
		ICFSecSecGroupFormObj obj = readSecGroupForm( pkey, forceRead );
		return( obj );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId )
	{
		return( readSecGroupFormByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByClusterIdx";
		CFSecSecGroupFormByClusterIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecGroupFormByClusterIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj>();
			ICFSecSecGroupFormObj obj;
			CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFSecSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGroupFormObj arr[] = new ICFSecSecGroupFormObj[len];
		Iterator<ICFSecSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGroupFormObj> arrayList = new ArrayList<ICFSecSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupFormObj> cmp = new Comparator<ICFSecSecGroupFormObj>() {
			public int compare( ICFSecSecGroupFormObj lhs, ICFSecSecGroupFormObj rhs ) {
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
					CFSecSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupFormByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByGroupIdx";
		CFSecSecGroupFormByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecSecGroupFormByGroupIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj>();
			ICFSecSecGroupFormObj obj;
			CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFSecSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGroupFormObj arr[] = new ICFSecSecGroupFormObj[len];
		Iterator<ICFSecSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGroupFormObj> arrayList = new ArrayList<ICFSecSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupFormObj> cmp = new Comparator<ICFSecSecGroupFormObj>() {
			public int compare( ICFSecSecGroupFormObj lhs, ICFSecSecGroupFormObj rhs ) {
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
					CFSecSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecGroupFormByAppIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByAppIdx";
		CFSecSecGroupFormByAppIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict;
		if( indexByAppIdx == null ) {
			indexByAppIdx = new HashMap< CFSecSecGroupFormByAppIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByAppIdx.containsKey( key ) ) {
			dict = indexByAppIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj>();
			ICFSecSecGroupFormObj obj;
			CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			CFSecSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByAppIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGroupFormObj arr[] = new ICFSecSecGroupFormObj[len];
		Iterator<ICFSecSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGroupFormObj> arrayList = new ArrayList<ICFSecSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupFormObj> cmp = new Comparator<ICFSecSecGroupFormObj>() {
			public int compare( ICFSecSecGroupFormObj lhs, ICFSecSecGroupFormObj rhs ) {
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
					CFSecSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		return( readSecGroupFormByFormIdx( ClusterId,
			SecFormId,
			false ) );
	}

	public List<ICFSecSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByFormIdx";
		CFSecSecGroupFormByFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict;
		if( indexByFormIdx == null ) {
			indexByFormIdx = new HashMap< CFSecSecGroupFormByFormIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByFormIdx.containsKey( key ) ) {
			dict = indexByFormIdx.get( key );
		}
		else {
			dict = new HashMap<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj>();
			ICFSecSecGroupFormObj obj;
			CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
			CFSecSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFormIdx.put( key, dict );
		}
		int len = dict.size();
		ICFSecSecGroupFormObj arr[] = new ICFSecSecGroupFormObj[len];
		Iterator<ICFSecSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFSecSecGroupFormObj> arrayList = new ArrayList<ICFSecSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFSecSecGroupFormObj> cmp = new Comparator<ICFSecSecGroupFormObj>() {
			public int compare( ICFSecSecGroupFormObj lhs, ICFSecSecGroupFormObj rhs ) {
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
					CFSecSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFSecSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFSecSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFSecSecGroupFormObj readSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		return( readSecGroupFormByUFormIdx( ClusterId,
			SecGroupId,
			SecFormId,
			false ) );
	}

	public ICFSecSecGroupFormObj readSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId, boolean forceRead )
	{
		if( indexByUFormIdx == null ) {
			indexByUFormIdx = new HashMap< CFSecSecGroupFormByUFormIdxKey,
				ICFSecSecGroupFormObj >();
		}
		CFSecSecGroupFormByUFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		ICFSecSecGroupFormObj obj = null;
		if( ( ! forceRead ) && indexByUFormIdx.containsKey( key ) ) {
			obj = indexByUFormIdx.get( key );
		}
		else {
			CFSecSecGroupFormBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
			if( buff != null ) {
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				obj = (ICFSecSecGroupFormObj)obj.realise();
			}
		}
		return( obj );
	}

	/**
	 *	Read a page of data as a List of SecGroupForm-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGroupForm-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGroupFormObj> pageSecGroupFormByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByClusterIdx";
		CFSecSecGroupFormByClusterIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFSecSecGroupFormObj> retList = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj obj;
		CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecGroupFormId );
		CFSecSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGroupForm-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGroupForm-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGroupFormObj> pageSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByGroupIdx";
		CFSecSecGroupFormByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		List<ICFSecSecGroupFormObj> retList = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj obj;
		CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
			priorClusterId,
			priorSecGroupFormId );
		CFSecSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGroupForm-derived instances sorted by their primary keys,
	 *	as identified by the duplicate AppIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecAppId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGroupForm-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGroupFormObj> pageSecGroupFormByAppIdx( long ClusterId,
		int SecAppId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByAppIdx";
		CFSecSecGroupFormByAppIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		List<ICFSecSecGroupFormObj> retList = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj obj;
		CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
			priorClusterId,
			priorSecGroupFormId );
		CFSecSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecGroupForm-derived instances sorted by their primary keys,
	 *	as identified by the duplicate FormIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@param	argSecFormId	The SecGroupForm key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGroupForm-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	public List<ICFSecSecGroupFormObj> pageSecGroupFormByFormIdx( long ClusterId,
		int SecFormId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByFormIdx";
		CFSecSecGroupFormByFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		List<ICFSecSecGroupFormObj> retList = new LinkedList<ICFSecSecGroupFormObj>();
		ICFSecSecGroupFormObj obj;
		CFSecSecGroupFormBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId,
			priorClusterId,
			priorSecGroupFormId );
		CFSecSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFSecSecGroupFormObj realised = (ICFSecSecGroupFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFSecSecGroupFormObj updateSecGroupForm( ICFSecSecGroupFormObj Obj ) {
		ICFSecSecGroupFormObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().updateSecGroupForm( schema.getAuthorization(),
			Obj.getSecGroupFormBuff() );
		obj = (ICFSecSecGroupFormObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGroupForm( ICFSecSecGroupFormObj Obj ) {
		ICFSecSecGroupFormObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupForm( schema.getAuthorization(),
			obj.getSecGroupFormBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		CFSecSecGroupFormPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupFormId( SecGroupFormId );
		ICFSecSecGroupFormObj obj = readSecGroupForm( pkey );
		if( obj != null ) {
			ICFSecSecGroupFormEditObj editObj = (ICFSecSecGroupFormEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFSecSecGroupFormEditObj)obj.beginEdit();
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

	public void deleteSecGroupFormByClusterIdx( long ClusterId )
	{
		CFSecSecGroupFormByClusterIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFSecSecGroupFormByClusterIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict = indexByClusterIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFSecSecGroupFormObj> iter = dict.values().iterator();
			ICFSecSecGroupFormObj obj;
			List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFSecSecGroupFormByGroupIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFSecSecGroupFormByGroupIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict = indexByGroupIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFSecSecGroupFormObj> iter = dict.values().iterator();
			ICFSecSecGroupFormObj obj;
			List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		CFSecSecGroupFormByAppIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexByAppIdx == null ) {
			indexByAppIdx = new HashMap< CFSecSecGroupFormByAppIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( indexByAppIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict = indexByAppIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			Iterator<ICFSecSecGroupFormObj> iter = dict.values().iterator();
			ICFSecSecGroupFormObj obj;
			List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByAppIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
		}
	}

	public void deleteSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		CFSecSecGroupFormByFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByFormIdx == null ) {
			indexByFormIdx = new HashMap< CFSecSecGroupFormByFormIdxKey,
				Map< CFSecSecGroupFormPKey, ICFSecSecGroupFormObj > >();
		}
		if( indexByFormIdx.containsKey( key ) ) {
			Map<CFSecSecGroupFormPKey, ICFSecSecGroupFormObj> dict = indexByFormIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
			Iterator<ICFSecSecGroupFormObj> iter = dict.values().iterator();
			ICFSecSecGroupFormObj obj;
			List<ICFSecSecGroupFormObj> toForget = new LinkedList<ICFSecSecGroupFormObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByFormIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
		}
	}

	public void deleteSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		if( indexByUFormIdx == null ) {
			indexByUFormIdx = new HashMap< CFSecSecGroupFormByUFormIdxKey,
				ICFSecSecGroupFormObj >();
		}
		CFSecSecGroupFormByUFormIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		ICFSecSecGroupFormObj obj = null;
		if( indexByUFormIdx.containsKey( key ) ) {
			obj = indexByUFormIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
		}
	}
}
