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

public class CFGenKbSecGroupFormTableObj
	implements ICFGenKbSecGroupFormTableObj
{
	protected ICFGenKbSchemaObj schema;
	private Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> members;
	private Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> allSecGroupForm;
	private Map< CFGenKbSecGroupFormByClusterIdxKey,
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > > indexByClusterIdx;
	private Map< CFGenKbSecGroupFormByGroupIdxKey,
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > > indexByGroupIdx;
	private Map< CFGenKbSecGroupFormByAppIdxKey,
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > > indexByAppIdx;
	private Map< CFGenKbSecGroupFormByFormIdxKey,
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > > indexByFormIdx;
	private Map< CFGenKbSecGroupFormByUFormIdxKey,
		ICFGenKbSecGroupFormObj > indexByUFormIdx;
	public static String TABLE_NAME = "SecGroupForm";
	public static String TABLE_DBNAME = "secgrpfrm";

	public CFGenKbSecGroupFormTableObj() {
		schema = null;
		members = new HashMap<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj>();
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
	}

	public CFGenKbSecGroupFormTableObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj>();
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
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
		allSecGroupForm = null;
		indexByClusterIdx = null;
		indexByGroupIdx = null;
		indexByAppIdx = null;
		indexByFormIdx = null;
		indexByUFormIdx = null;
		List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj cur = null;
		Iterator<ICFGenKbSecGroupFormObj> iter = members.values().iterator();
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
	 *	CFGenKbSecGroupFormObj.
	 */
	public ICFGenKbSecGroupFormObj newInstance() {
		ICFGenKbSecGroupFormObj inst = new CFGenKbSecGroupFormObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFGenKbSecGroupFormObj.
	 */
	public ICFGenKbSecGroupFormEditObj newEditInstance( ICFGenKbSecGroupFormObj orig ) {
		ICFGenKbSecGroupFormEditObj edit = new CFGenKbSecGroupFormEditObj( orig );
		return( edit );
	}

	public ICFGenKbSecGroupFormObj realiseSecGroupForm( ICFGenKbSecGroupFormObj Obj ) {
		ICFGenKbSecGroupFormObj obj = Obj;
		CFGenKbSecGroupFormPKey pkey = obj.getPKey();
		ICFGenKbSecGroupFormObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFGenKbSecGroupFormObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByAppIdx != null ) {
				CFGenKbSecGroupFormByAppIdxKey keyAppIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.remove( keepObj.getPKey() );
					if( mapAppIdx.size() <= 0 ) {
						indexByAppIdx.remove( keyAppIdx );
					}
				}
			}

			if( indexByFormIdx != null ) {
				CFGenKbSecGroupFormByFormIdxKey keyFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.remove( keepObj.getPKey() );
					if( mapFormIdx.size() <= 0 ) {
						indexByFormIdx.remove( keyFormIdx );
					}
				}
			}

			if( indexByUFormIdx != null ) {
				CFGenKbSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.remove( keyUFormIdx );
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAppIdx != null ) {
				CFGenKbSecGroupFormByAppIdxKey keyAppIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFormIdx != null ) {
				CFGenKbSecGroupFormByFormIdxKey keyFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUFormIdx != null ) {
				CFGenKbSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
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
				CFGenKbSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByAppIdx != null ) {
				CFGenKbSecGroupFormByAppIdxKey keyAppIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByFormIdx != null ) {
				CFGenKbSecGroupFormByFormIdxKey keyFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUFormIdx != null ) {
				CFGenKbSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
				keyUFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyUFormIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				keyUFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				indexByUFormIdx.put( keyUFormIdx, keepObj );
			}

		}
		return( keepObj );
	}

	public void forgetSecGroupForm( ICFGenKbSecGroupFormObj Obj ) {
		forgetSecGroupForm( Obj, false );
	}

	public void forgetSecGroupForm( ICFGenKbSecGroupFormObj Obj, boolean forgetSubObjects ) {
		ICFGenKbSecGroupFormObj obj = Obj;
		CFGenKbSecGroupFormPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFGenKbSecGroupFormObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByClusterIdx != null ) {
				CFGenKbSecGroupFormByClusterIdxKey keyClusterIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
				keyClusterIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( keyClusterIdx );
				if( mapClusterIdx != null ) {
					mapClusterIdx.remove( keepObj.getPKey() );
					if( mapClusterIdx.size() <= 0 ) {
						indexByClusterIdx.remove( keyClusterIdx );
					}
				}
			}

			if( indexByGroupIdx != null ) {
				CFGenKbSecGroupFormByGroupIdxKey keyGroupIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
				keyGroupIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyGroupIdx.setRequiredSecGroupId( keepObj.getRequiredSecGroupId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( keyGroupIdx );
				if( mapGroupIdx != null ) {
					mapGroupIdx.remove( keepObj.getPKey() );
					if( mapGroupIdx.size() <= 0 ) {
						indexByGroupIdx.remove( keyGroupIdx );
					}
				}
			}

			if( indexByAppIdx != null ) {
				CFGenKbSecGroupFormByAppIdxKey keyAppIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
				keyAppIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyAppIdx.setRequiredSecAppId( keepObj.getRequiredSecAppId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapAppIdx = indexByAppIdx.get( keyAppIdx );
				if( mapAppIdx != null ) {
					mapAppIdx.remove( keepObj.getPKey() );
					if( mapAppIdx.size() <= 0 ) {
						indexByAppIdx.remove( keyAppIdx );
					}
				}
			}

			if( indexByFormIdx != null ) {
				CFGenKbSecGroupFormByFormIdxKey keyFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
				keyFormIdx.setRequiredClusterId( keepObj.getRequiredClusterId() );
				keyFormIdx.setRequiredSecFormId( keepObj.getRequiredSecFormId() );
				Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapFormIdx = indexByFormIdx.get( keyFormIdx );
				if( mapFormIdx != null ) {
					mapFormIdx.remove( keepObj.getPKey() );
					if( mapFormIdx.size() <= 0 ) {
						indexByFormIdx.remove( keyFormIdx );
					}
				}
			}

			if( indexByUFormIdx != null ) {
				CFGenKbSecGroupFormByUFormIdxKey keyUFormIdx =
					((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
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
		CFGenKbSecGroupFormPKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupFormId( SecGroupFormId );
		if( members.containsKey( key ) ) {
			ICFGenKbSecGroupFormObj probed = members.get( key );
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
		List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj cur = null;
		CFGenKbSecGroupFormByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapClusterIdx = indexByClusterIdx.get( key );
			if( mapClusterIdx != null ) {
				Iterator<ICFGenKbSecGroupFormObj> iterDup = mapClusterIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByClusterIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGroupFormObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj cur = null;
		CFGenKbSecGroupFormByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapGroupIdx = indexByGroupIdx.get( key );
			if( mapGroupIdx != null ) {
				Iterator<ICFGenKbSecGroupFormObj> iterDup = mapGroupIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByGroupIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGroupFormObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj cur = null;
		CFGenKbSecGroupFormByAppIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexByAppIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapAppIdx = indexByAppIdx.get( key );
			if( mapAppIdx != null ) {
				Iterator<ICFGenKbSecGroupFormObj> iterDup = mapAppIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByAppIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGroupFormObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj cur = null;
		CFGenKbSecGroupFormByFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByFormIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > mapFormIdx = indexByFormIdx.get( key );
			if( mapFormIdx != null ) {
				Iterator<ICFGenKbSecGroupFormObj> iterDup = mapFormIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByFormIdx.remove( key );
			}

		}
		else {
			Iterator<ICFGenKbSecGroupFormObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFGenKbSecGroupFormObj> iter = toForget.iterator();
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
		List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj cur = null;
		CFGenKbSecGroupFormByUFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByUFormIdx.containsKey( key ) ) {
			cur = indexByUFormIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFGenKbSecGroupFormObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFGenKbSecGroupFormObj createSecGroupForm( ICFGenKbSecGroupFormObj Obj ) {
		ICFGenKbSecGroupFormObj obj = Obj;
		CFGenKbSecGroupFormBuff buff = obj.getSecGroupFormBuff();
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().createSecGroupForm(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	public ICFGenKbSecGroupFormObj readSecGroupForm( CFGenKbSecGroupFormPKey pkey ) {
		return( readSecGroupForm( pkey, false ) );
	}

	public ICFGenKbSecGroupFormObj readSecGroupForm( CFGenKbSecGroupFormPKey pkey, boolean forceRead ) {
		ICFGenKbSecGroupFormObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFGenKbSecGroupFormBuff readBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredClusterId(),
				pkey.getRequiredSecGroupFormId() );
			if( readBuff != null ) {
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFGenKbSecGroupFormObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFGenKbSecGroupFormObj lockSecGroupForm( CFGenKbSecGroupFormPKey pkey ) {
		ICFGenKbSecGroupFormObj locked = null;
		CFGenKbSecGroupFormBuff lockBuff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getSecGroupFormTableObj().newInstance();
			locked.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFGenKbSecGroupFormObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockSecGroupForm", pkey );
		}
		return( locked );
	}

	public List<ICFGenKbSecGroupFormObj> readAllSecGroupForm() {
		return( readAllSecGroupForm( false ) );
	}

	public List<ICFGenKbSecGroupFormObj> readAllSecGroupForm( boolean forceRead ) {
		final String S_ProcName = "readAllSecGroupForm";
		if( ( allSecGroupForm == null ) || forceRead ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> map = new HashMap<CFGenKbSecGroupFormPKey,ICFGenKbSecGroupFormObj>();
			allSecGroupForm = map;
			CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readAllDerived( schema.getAuthorization() );
			CFGenKbSecGroupFormBuff buff;
			ICFGenKbSecGroupFormObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
			}
		}
		int len = allSecGroupForm.size();
		ICFGenKbSecGroupFormObj arr[] = new ICFGenKbSecGroupFormObj[len];
		Iterator<ICFGenKbSecGroupFormObj> valIter = allSecGroupForm.values().iterator();
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
		ArrayList<ICFGenKbSecGroupFormObj> arrayList = new ArrayList<ICFGenKbSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupFormObj> cmp = new Comparator<ICFGenKbSecGroupFormObj>() {
			public int compare( ICFGenKbSecGroupFormObj lhs, ICFGenKbSecGroupFormObj rhs ) {
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
					CFGenKbSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	/**
	 *	Return a sorted map of a page of the SecGroupForm-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGroupFormObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	public List<ICFGenKbSecGroupFormObj> pageAllSecGroupForm(Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageAllSecGroupForm";
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> map = new HashMap<CFGenKbSecGroupFormPKey,ICFGenKbSecGroupFormObj>();
		CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().pageAllBuff( schema.getAuthorization(),
			priorClusterId,
			priorSecGroupFormId );
		CFGenKbSecGroupFormBuff buff;
		ICFGenKbSecGroupFormObj obj;
		ICFGenKbSecGroupFormObj realised;
		ArrayList<ICFGenKbSecGroupFormObj> arrayList = new ArrayList<ICFGenKbSecGroupFormObj>( buffList.length );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			realised = (ICFGenKbSecGroupFormObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	public ICFGenKbSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		return( readSecGroupFormByIdIdx( ClusterId,
			SecGroupFormId,
			false ) );
	}

	public ICFGenKbSecGroupFormObj readSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId, boolean forceRead )
	{
		CFGenKbSecGroupFormPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupFormId( SecGroupFormId );
		ICFGenKbSecGroupFormObj obj = readSecGroupForm( pkey, forceRead );
		return( obj );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId )
	{
		return( readSecGroupFormByClusterIdx( ClusterId,
			false ) );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByClusterIdx( long ClusterId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByClusterIdx";
		CFGenKbSecGroupFormByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict;
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGroupFormByClusterIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByClusterIdx.containsKey( key ) ) {
			dict = indexByClusterIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj>();
			ICFGenKbSecGroupFormObj obj;
			CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByClusterIdx( schema.getAuthorization(),
				ClusterId );
			CFGenKbSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByClusterIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGroupFormObj arr[] = new ICFGenKbSecGroupFormObj[len];
		Iterator<ICFGenKbSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGroupFormObj> arrayList = new ArrayList<ICFGenKbSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupFormObj> cmp = new Comparator<ICFGenKbSecGroupFormObj>() {
			public int compare( ICFGenKbSecGroupFormObj lhs, ICFGenKbSecGroupFormObj rhs ) {
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
					CFGenKbSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		return( readSecGroupFormByGroupIdx( ClusterId,
			SecGroupId,
			false ) );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByGroupIdx";
		CFGenKbSecGroupFormByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict;
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbSecGroupFormByGroupIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByGroupIdx.containsKey( key ) ) {
			dict = indexByGroupIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj>();
			ICFGenKbSecGroupFormObj obj;
			CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			CFGenKbSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByGroupIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGroupFormObj arr[] = new ICFGenKbSecGroupFormObj[len];
		Iterator<ICFGenKbSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGroupFormObj> arrayList = new ArrayList<ICFGenKbSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupFormObj> cmp = new Comparator<ICFGenKbSecGroupFormObj>() {
			public int compare( ICFGenKbSecGroupFormObj lhs, ICFGenKbSecGroupFormObj rhs ) {
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
					CFGenKbSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		return( readSecGroupFormByAppIdx( ClusterId,
			SecAppId,
			false ) );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByAppIdx( long ClusterId,
		int SecAppId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByAppIdx";
		CFGenKbSecGroupFormByAppIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict;
		if( indexByAppIdx == null ) {
			indexByAppIdx = new HashMap< CFGenKbSecGroupFormByAppIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByAppIdx.containsKey( key ) ) {
			dict = indexByAppIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj>();
			ICFGenKbSecGroupFormObj obj;
			CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			CFGenKbSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByAppIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGroupFormObj arr[] = new ICFGenKbSecGroupFormObj[len];
		Iterator<ICFGenKbSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGroupFormObj> arrayList = new ArrayList<ICFGenKbSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupFormObj> cmp = new Comparator<ICFGenKbSecGroupFormObj>() {
			public int compare( ICFGenKbSecGroupFormObj lhs, ICFGenKbSecGroupFormObj rhs ) {
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
					CFGenKbSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		return( readSecGroupFormByFormIdx( ClusterId,
			SecFormId,
			false ) );
	}

	public List<ICFGenKbSecGroupFormObj> readSecGroupFormByFormIdx( long ClusterId,
		int SecFormId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecGroupFormByFormIdx";
		CFGenKbSecGroupFormByFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict;
		if( indexByFormIdx == null ) {
			indexByFormIdx = new HashMap< CFGenKbSecGroupFormByFormIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( ( ! forceRead ) && indexByFormIdx.containsKey( key ) ) {
			dict = indexByFormIdx.get( key );
		}
		else {
			dict = new HashMap<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj>();
			ICFGenKbSecGroupFormObj obj;
			CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
			CFGenKbSecGroupFormBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFormIdx.put( key, dict );
		}
		int len = dict.size();
		ICFGenKbSecGroupFormObj arr[] = new ICFGenKbSecGroupFormObj[len];
		Iterator<ICFGenKbSecGroupFormObj> valIter = dict.values().iterator();
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
		ArrayList<ICFGenKbSecGroupFormObj> arrayList = new ArrayList<ICFGenKbSecGroupFormObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFGenKbSecGroupFormObj> cmp = new Comparator<ICFGenKbSecGroupFormObj>() {
			public int compare( ICFGenKbSecGroupFormObj lhs, ICFGenKbSecGroupFormObj rhs ) {
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
					CFGenKbSecGroupFormPKey lhsPKey = lhs.getPKey();
					CFGenKbSecGroupFormPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFGenKbSecGroupFormObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFGenKbSecGroupFormObj readSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		return( readSecGroupFormByUFormIdx( ClusterId,
			SecGroupId,
			SecFormId,
			false ) );
	}

	public ICFGenKbSecGroupFormObj readSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId, boolean forceRead )
	{
		if( indexByUFormIdx == null ) {
			indexByUFormIdx = new HashMap< CFGenKbSecGroupFormByUFormIdxKey,
				ICFGenKbSecGroupFormObj >();
		}
		CFGenKbSecGroupFormByUFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		ICFGenKbSecGroupFormObj obj = null;
		if( ( ! forceRead ) && indexByUFormIdx.containsKey( key ) ) {
			obj = indexByUFormIdx.get( key );
		}
		else {
			CFGenKbSecGroupFormBuff buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
			if( buff != null ) {
				obj = schema.getSecGroupFormTableObj().newInstance();
				obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
				obj.setBuff( buff );
				obj = (ICFGenKbSecGroupFormObj)obj.realise();
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
	public List<ICFGenKbSecGroupFormObj> pageSecGroupFormByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByClusterIdx";
		CFGenKbSecGroupFormByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		List<ICFGenKbSecGroupFormObj> retList = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj obj;
		CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByClusterIdx( schema.getAuthorization(),
				ClusterId,
			priorClusterId,
			priorSecGroupFormId );
		CFGenKbSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
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
	public List<ICFGenKbSecGroupFormObj> pageSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByGroupIdx";
		CFGenKbSecGroupFormByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		List<ICFGenKbSecGroupFormObj> retList = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj obj;
		CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
			priorClusterId,
			priorSecGroupFormId );
		CFGenKbSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
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
	public List<ICFGenKbSecGroupFormObj> pageSecGroupFormByAppIdx( long ClusterId,
		int SecAppId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByAppIdx";
		CFGenKbSecGroupFormByAppIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		List<ICFGenKbSecGroupFormObj> retList = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj obj;
		CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId,
			priorClusterId,
			priorSecGroupFormId );
		CFGenKbSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
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
	public List<ICFGenKbSecGroupFormObj> pageSecGroupFormByFormIdx( long ClusterId,
		int SecFormId,
		Long priorClusterId,
		Long priorSecGroupFormId )
	{
		final String S_ProcName = "pageSecGroupFormByFormIdx";
		CFGenKbSecGroupFormByFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		List<ICFGenKbSecGroupFormObj> retList = new LinkedList<ICFGenKbSecGroupFormObj>();
		ICFGenKbSecGroupFormObj obj;
		CFGenKbSecGroupFormBuff[] buffList = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().pageBuffByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId,
			priorClusterId,
			priorSecGroupFormId );
		CFGenKbSecGroupFormBuff buff;
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[ idx ];
				obj = schema.getSecGroupFormTableObj().newInstance();
			obj.setPKey( ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey() );
			obj.setBuff( buff );
			ICFGenKbSecGroupFormObj realised = (ICFGenKbSecGroupFormObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	public ICFGenKbSecGroupFormObj updateSecGroupForm( ICFGenKbSecGroupFormObj Obj ) {
		ICFGenKbSecGroupFormObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().updateSecGroupForm( schema.getAuthorization(),
			Obj.getSecGroupFormBuff() );
		obj = (ICFGenKbSecGroupFormObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteSecGroupForm( ICFGenKbSecGroupFormObj Obj ) {
		ICFGenKbSecGroupFormObj obj = Obj;
		((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupForm( schema.getAuthorization(),
			obj.getSecGroupFormBuff() );
		obj.forget( true );
	}

	public void deleteSecGroupFormByIdIdx( long ClusterId,
		long SecGroupFormId )
	{
		CFGenKbSecGroupFormPKey pkey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		pkey.setRequiredClusterId( ClusterId );
		pkey.setRequiredSecGroupFormId( SecGroupFormId );
		ICFGenKbSecGroupFormObj obj = readSecGroupForm( pkey );
		if( obj != null ) {
			ICFGenKbSecGroupFormEditObj editObj = (ICFGenKbSecGroupFormEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFGenKbSecGroupFormEditObj)obj.beginEdit();
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
		CFGenKbSecGroupFormByClusterIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newClusterIdxKey();
		key.setRequiredClusterId( ClusterId );
		if( indexByClusterIdx == null ) {
			indexByClusterIdx = new HashMap< CFGenKbSecGroupFormByClusterIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( indexByClusterIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict = indexByClusterIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
			Iterator<ICFGenKbSecGroupFormObj> iter = dict.values().iterator();
			ICFGenKbSecGroupFormObj obj;
			List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByClusterIdx( schema.getAuthorization(),
				ClusterId );
		}
	}

	public void deleteSecGroupFormByGroupIdx( long ClusterId,
		int SecGroupId )
	{
		CFGenKbSecGroupFormByGroupIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newGroupIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		if( indexByGroupIdx == null ) {
			indexByGroupIdx = new HashMap< CFGenKbSecGroupFormByGroupIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( indexByGroupIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict = indexByGroupIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
			Iterator<ICFGenKbSecGroupFormObj> iter = dict.values().iterator();
			ICFGenKbSecGroupFormObj obj;
			List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByGroupIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId );
		}
	}

	public void deleteSecGroupFormByAppIdx( long ClusterId,
		int SecAppId )
	{
		CFGenKbSecGroupFormByAppIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newAppIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecAppId( SecAppId );
		if( indexByAppIdx == null ) {
			indexByAppIdx = new HashMap< CFGenKbSecGroupFormByAppIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( indexByAppIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict = indexByAppIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
			Iterator<ICFGenKbSecGroupFormObj> iter = dict.values().iterator();
			ICFGenKbSecGroupFormObj obj;
			List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByAppIdx( schema.getAuthorization(),
				ClusterId,
				SecAppId );
		}
	}

	public void deleteSecGroupFormByFormIdx( long ClusterId,
		int SecFormId )
	{
		CFGenKbSecGroupFormByFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecFormId( SecFormId );
		if( indexByFormIdx == null ) {
			indexByFormIdx = new HashMap< CFGenKbSecGroupFormByFormIdxKey,
				Map< CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj > >();
		}
		if( indexByFormIdx.containsKey( key ) ) {
			Map<CFGenKbSecGroupFormPKey, ICFGenKbSecGroupFormObj> dict = indexByFormIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
			Iterator<ICFGenKbSecGroupFormObj> iter = dict.values().iterator();
			ICFGenKbSecGroupFormObj obj;
			List<ICFGenKbSecGroupFormObj> toForget = new LinkedList<ICFGenKbSecGroupFormObj>();
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
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByFormIdx( schema.getAuthorization(),
				ClusterId,
				SecFormId );
		}
	}

	public void deleteSecGroupFormByUFormIdx( long ClusterId,
		int SecGroupId,
		int SecFormId )
	{
		if( indexByUFormIdx == null ) {
			indexByUFormIdx = new HashMap< CFGenKbSecGroupFormByUFormIdxKey,
				ICFGenKbSecGroupFormObj >();
		}
		CFGenKbSecGroupFormByUFormIdxKey key = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroupForm().newUFormIdxKey();
		key.setRequiredClusterId( ClusterId );
		key.setRequiredSecGroupId( SecGroupId );
		key.setRequiredSecFormId( SecFormId );
		ICFGenKbSecGroupFormObj obj = null;
		if( indexByUFormIdx.containsKey( key ) ) {
			obj = indexByUFormIdx.get( key );
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
			obj.forget( true );
		}
		else {
			((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroupForm().deleteSecGroupFormByUFormIdx( schema.getAuthorization(),
				ClusterId,
				SecGroupId,
				SecFormId );
		}
	}
}
