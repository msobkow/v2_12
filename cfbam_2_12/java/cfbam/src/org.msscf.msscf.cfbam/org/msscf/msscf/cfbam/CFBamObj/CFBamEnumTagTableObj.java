// Description: Java 11 Table Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamEnumTagTableObj
	implements ICFBamEnumTagTableObj
{
	protected ICFBamSchemaObj schema;
	private Map<CFBamEnumTagPKey, ICFBamEnumTagObj> members;
	private Map<CFBamEnumTagPKey, ICFBamEnumTagObj> allEnumTag;
	private Map< CFBamEnumTagByEnumTagTenantIdxKey,
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj > > indexByEnumTagTenantIdx;
	private Map< CFBamEnumTagByEnumIdxKey,
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj > > indexByEnumIdx;
	private Map< CFBamEnumTagByDefSchemaIdxKey,
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj > > indexByDefSchemaIdx;
	private Map< CFBamEnumTagByEnumNameIdxKey,
		ICFBamEnumTagObj > indexByEnumNameIdx;
	private Map< CFBamEnumTagByPrevIdxKey,
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj > > indexByPrevIdx;
	private Map< CFBamEnumTagByNextIdxKey,
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj > > indexByNextIdx;
	public static String TABLE_NAME = "EnumTag";
	public static String TABLE_DBNAME = "enum_tag";

	public CFBamEnumTagTableObj() {
		schema = null;
		members = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
		allEnumTag = null;
		indexByEnumTagTenantIdx = null;
		indexByEnumIdx = null;
		indexByDefSchemaIdx = null;
		indexByEnumNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public CFBamEnumTagTableObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		members = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
		allEnumTag = null;
		indexByEnumTagTenantIdx = null;
		indexByEnumIdx = null;
		indexByDefSchemaIdx = null;
		indexByEnumNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
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
		allEnumTag = null;
		indexByEnumTagTenantIdx = null;
		indexByEnumIdx = null;
		indexByDefSchemaIdx = null;
		indexByEnumNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		Iterator<ICFBamEnumTagObj> iter = members.values().iterator();
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
	 *	CFBamEnumTagObj.
	 */
	public ICFBamEnumTagObj newInstance() {
		ICFBamEnumTagObj inst = new CFBamEnumTagObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	CFBamEnumTagObj.
	 */
	public ICFBamEnumTagEditObj newEditInstance( ICFBamEnumTagObj orig ) {
		ICFBamEnumTagEditObj edit = new CFBamEnumTagEditObj( orig );
		return( edit );
	}

	public ICFBamEnumTagObj realiseEnumTag( ICFBamEnumTagObj Obj ) {
		ICFBamEnumTagObj obj = Obj;
		CFBamEnumTagPKey pkey = obj.getPKey();
		ICFBamEnumTagObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ICFBamEnumTagObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByEnumTagTenantIdx != null ) {
				CFBamEnumTagByEnumTagTenantIdxKey keyEnumTagTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
				keyEnumTagTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumTagTenantIdx = indexByEnumTagTenantIdx.get( keyEnumTagTenantIdx );
				if( mapEnumTagTenantIdx != null ) {
					mapEnumTagTenantIdx.remove( keepObj.getPKey() );
					if( mapEnumTagTenantIdx.size() <= 0 ) {
						indexByEnumTagTenantIdx.remove( keyEnumTagTenantIdx );
					}
				}
			}

			if( indexByEnumIdx != null ) {
				CFBamEnumTagByEnumIdxKey keyEnumIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
				keyEnumIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.remove( keepObj.getPKey() );
					if( mapEnumIdx.size() <= 0 ) {
						indexByEnumIdx.remove( keyEnumIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByEnumNameIdx != null ) {
				CFBamEnumTagByEnumNameIdxKey keyEnumNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
				keyEnumNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.remove( keyEnumNameIdx );
			}

			if( indexByPrevIdx != null ) {
				CFBamEnumTagByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamEnumTagByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			keepObj.setBuff( Obj.getBuff() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByEnumTagTenantIdx != null ) {
				CFBamEnumTagByEnumTagTenantIdxKey keyEnumTagTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
				keyEnumTagTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumTagTenantIdx = indexByEnumTagTenantIdx.get( keyEnumTagTenantIdx );
				if( mapEnumTagTenantIdx != null ) {
					mapEnumTagTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEnumIdx != null ) {
				CFBamEnumTagByEnumIdxKey keyEnumIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
				keyEnumIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEnumNameIdx != null ) {
				CFBamEnumTagByEnumNameIdxKey keyEnumNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
				keyEnumNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.put( keyEnumNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				CFBamEnumTagByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamEnumTagByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allEnumTag != null ) {
				allEnumTag.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allEnumTag != null ) {
				allEnumTag.put( keepObj.getPKey(), keepObj );
			}

			if( indexByEnumTagTenantIdx != null ) {
				CFBamEnumTagByEnumTagTenantIdxKey keyEnumTagTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
				keyEnumTagTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumTagTenantIdx = indexByEnumTagTenantIdx.get( keyEnumTagTenantIdx );
				if( mapEnumTagTenantIdx != null ) {
					mapEnumTagTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEnumIdx != null ) {
				CFBamEnumTagByEnumIdxKey keyEnumIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
				keyEnumIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEnumNameIdx != null ) {
				CFBamEnumTagByEnumNameIdxKey keyEnumNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
				keyEnumNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.put( keyEnumNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				CFBamEnumTagByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				CFBamEnumTagByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	public void forgetEnumTag( ICFBamEnumTagObj Obj ) {
		forgetEnumTag( Obj, false );
	}

	public void forgetEnumTag( ICFBamEnumTagObj Obj, boolean forgetSubObjects ) {
		ICFBamEnumTagObj obj = Obj;
		CFBamEnumTagPKey pkey = obj.getPKey();
		if( members.containsKey( pkey ) ) {
			ICFBamEnumTagObj keepObj = members.get( pkey );
			// Detach object from alternate, duplicate, all and PKey indexes

			if( indexByEnumTagTenantIdx != null ) {
				CFBamEnumTagByEnumTagTenantIdxKey keyEnumTagTenantIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
				keyEnumTagTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumTagTenantIdx = indexByEnumTagTenantIdx.get( keyEnumTagTenantIdx );
				if( mapEnumTagTenantIdx != null ) {
					mapEnumTagTenantIdx.remove( keepObj.getPKey() );
					if( mapEnumTagTenantIdx.size() <= 0 ) {
						indexByEnumTagTenantIdx.remove( keyEnumTagTenantIdx );
					}
				}
			}

			if( indexByEnumIdx != null ) {
				CFBamEnumTagByEnumIdxKey keyEnumIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
				keyEnumIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.remove( keepObj.getPKey() );
					if( mapEnumIdx.size() <= 0 ) {
						indexByEnumIdx.remove( keyEnumIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				CFBamEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByEnumNameIdx != null ) {
				CFBamEnumTagByEnumNameIdxKey keyEnumNameIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
				keyEnumNameIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.remove( keyEnumNameIdx );
			}

			if( indexByPrevIdx != null ) {
				CFBamEnumTagByPrevIdxKey keyPrevIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
				keyPrevIdx.setOptionalPrevTenantId( keepObj.getOptionalPrevTenantId() );
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				CFBamEnumTagByNextIdxKey keyNextIdx =
					((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
				keyNextIdx.setOptionalNextTenantId( keepObj.getOptionalNextTenantId() );
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( allEnumTag != null ) {
				allEnumTag.remove( keepObj.getPKey() );
			}
			members.remove( pkey );
			if( forgetSubObjects ) {
			}
		}
	}

	public void forgetEnumTagByIdIdx( long TenantId,
		long Id )
	{
		if( members == null ) {
			return;
		}
		CFBamEnumTagPKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );
		if( members.containsKey( key ) ) {
			ICFBamEnumTagObj probed = members.get( key );
			if( probed != null ) {
				probed.forget( true );
			}
		}
	}

	public void forgetEnumTagByEnumTagTenantIdx( long TenantId )
	{
		if( indexByEnumTagTenantIdx == null ) {
			return;
		}
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		CFBamEnumTagByEnumTagTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByEnumTagTenantIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumTagTenantIdx = indexByEnumTagTenantIdx.get( key );
			if( mapEnumTagTenantIdx != null ) {
				Iterator<ICFBamEnumTagObj> iterDup = mapEnumTagTenantIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByEnumTagTenantIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamEnumTagObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamEnumTagObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetEnumTagByEnumIdx( long TenantId,
		long EnumId )
	{
		if( indexByEnumIdx == null ) {
			return;
		}
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		CFBamEnumTagByEnumIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		if( indexByEnumIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapEnumIdx = indexByEnumIdx.get( key );
			if( mapEnumIdx != null ) {
				Iterator<ICFBamEnumTagObj> iterDup = mapEnumIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByEnumIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamEnumTagObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamEnumTagObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		if( indexByDefSchemaIdx == null ) {
			return;
		}
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		CFBamEnumTagByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( key );
			if( mapDefSchemaIdx != null ) {
				Iterator<ICFBamEnumTagObj> iterDup = mapDefSchemaIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByDefSchemaIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamEnumTagObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamEnumTagObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetEnumTagByEnumNameIdx( long TenantId,
		long EnumId,
		String Name )
	{
		if( indexByEnumNameIdx == null ) {
			return;
		}
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		CFBamEnumTagByEnumNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		if( indexByEnumNameIdx.containsKey( key ) ) {
			cur = indexByEnumNameIdx.get( key );
			if( cur != null ) {
				toForget.add( cur );
			}

		}
		Iterator<ICFBamEnumTagObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		if( indexByPrevIdx == null ) {
			return;
		}
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		CFBamEnumTagByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapPrevIdx = indexByPrevIdx.get( key );
			if( mapPrevIdx != null ) {
				Iterator<ICFBamEnumTagObj> iterDup = mapPrevIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByPrevIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamEnumTagObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamEnumTagObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public void forgetEnumTagByNextIdx( Long NextTenantId,
		Long NextId )
	{
		if( indexByNextIdx == null ) {
			return;
		}
		List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
		ICFBamEnumTagObj cur = null;
		CFBamEnumTagByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj > mapNextIdx = indexByNextIdx.get( key );
			if( mapNextIdx != null ) {
				Iterator<ICFBamEnumTagObj> iterDup = mapNextIdx.values().iterator();
				while( iterDup.hasNext() ) {
					cur = iterDup.next();
					toForget.add( cur );
				}
				indexByNextIdx.remove( key );
			}

		}
		else {
			Iterator<ICFBamEnumTagObj> memberIter = members.values().iterator();
			while( memberIter.hasNext() ) {
				cur = memberIter.next();
				if( cur != null ) {
					if( key.equals( cur.getBuff() ) ) {
						toForget.add( cur );
					}
				}
			}
		}
		Iterator<ICFBamEnumTagObj> iter = toForget.iterator();
		while( iter.hasNext() ) {
			cur = iter.next();
			cur.forget( true );
		}
	}

	public ICFBamEnumTagObj createEnumTag( ICFBamEnumTagObj Obj ) {
		ICFBamEnumTagObj obj = Obj;
		CFBamEnumTagBuff buff = obj.getEnumTagBuff();
		((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().createEnumTag(
			schema.getAuthorization(),
			buff );
		obj.copyBuffToPKey();
		obj = obj.realise();
		ICFBamEnumTagObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	public ICFBamEnumTagObj readEnumTag( CFBamEnumTagPKey pkey ) {
		return( readEnumTag( pkey, false ) );
	}

	public ICFBamEnumTagObj readEnumTag( CFBamEnumTagPKey pkey, boolean forceRead ) {
		ICFBamEnumTagObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			CFBamEnumTagBuff readBuff = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByIdIdx( schema.getAuthorization(),
				pkey.getRequiredTenantId(),
				pkey.getRequiredId() );
			if( readBuff != null ) {
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( readBuff );
				obj = (ICFBamEnumTagObj)obj.realise();
			}
		}
		return( obj );
	}

	public ICFBamEnumTagObj lockEnumTag( CFBamEnumTagPKey pkey ) {
		ICFBamEnumTagObj locked = null;
		CFBamEnumTagBuff lockBuff = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().lockDerived( schema.getAuthorization(), pkey );
		if( lockBuff != null ) {
				locked = schema.getEnumTagTableObj().newInstance();
			locked.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
			locked.setBuff( lockBuff );
			locked = (ICFBamEnumTagObj)locked.realise();
		}
		else {
			throw new CFLibCollisionDetectedException( getClass(), "lockEnumTag", pkey );
		}
		return( locked );
	}

	public List<ICFBamEnumTagObj> readAllEnumTag() {
		return( readAllEnumTag( false ) );
	}

	public List<ICFBamEnumTagObj> readAllEnumTag( boolean forceRead ) {
		final String S_ProcName = "readAllEnumTag";
		if( ( allEnumTag == null ) || forceRead ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj> map = new HashMap<CFBamEnumTagPKey,ICFBamEnumTagObj>();
			allEnumTag = map;
			CFBamEnumTagBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readAllDerived( schema.getAuthorization() );
			CFBamEnumTagBuff buff;
			ICFBamEnumTagObj obj;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				ICFBamEnumTagObj realised = (ICFBamEnumTagObj)obj.realise();
			}
		}
		int len = allEnumTag.size();
		ICFBamEnumTagObj arr[] = new ICFBamEnumTagObj[len];
		Iterator<ICFBamEnumTagObj> valIter = allEnumTag.values().iterator();
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
		ArrayList<ICFBamEnumTagObj> arrayList = new ArrayList<ICFBamEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamEnumTagObj> cmp = new Comparator<ICFBamEnumTagObj>() {
			public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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
					CFBamEnumTagPKey lhsPKey = lhs.getPKey();
					CFBamEnumTagPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamEnumTagObj readEnumTagByIdIdx( long TenantId,
		long Id )
	{
		return( readEnumTagByIdIdx( TenantId,
			Id,
			false ) );
	}

	public ICFBamEnumTagObj readEnumTagByIdIdx( long TenantId,
		long Id, boolean forceRead )
	{
		CFBamEnumTagPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamEnumTagObj obj = readEnumTag( pkey, forceRead );
		return( obj );
	}

	public List<ICFBamEnumTagObj> readEnumTagByEnumTagTenantIdx( long TenantId )
	{
		return( readEnumTagByEnumTagTenantIdx( TenantId,
			false ) );
	}

	public List<ICFBamEnumTagObj> readEnumTagByEnumTagTenantIdx( long TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByEnumTagTenantIdx";
		CFBamEnumTagByEnumTagTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict;
		if( indexByEnumTagTenantIdx == null ) {
			indexByEnumTagTenantIdx = new HashMap< CFBamEnumTagByEnumTagTenantIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByEnumTagTenantIdx.containsKey( key ) ) {
			dict = indexByEnumTagTenantIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
			ICFBamEnumTagObj obj;
			CFBamEnumTagBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByEnumTagTenantIdx( schema.getAuthorization(),
				TenantId );
			CFBamEnumTagBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				ICFBamEnumTagObj realised = (ICFBamEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByEnumTagTenantIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamEnumTagObj arr[] = new ICFBamEnumTagObj[len];
		Iterator<ICFBamEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamEnumTagObj> arrayList = new ArrayList<ICFBamEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamEnumTagObj> cmp = new Comparator<ICFBamEnumTagObj>() {
			public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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
					CFBamEnumTagPKey lhsPKey = lhs.getPKey();
					CFBamEnumTagPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamEnumTagObj> readEnumTagByEnumIdx( long TenantId,
		long EnumId )
	{
		return( readEnumTagByEnumIdx( TenantId,
			EnumId,
			false ) );
	}

	public List<ICFBamEnumTagObj> readEnumTagByEnumIdx( long TenantId,
		long EnumId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByEnumIdx";
		CFBamEnumTagByEnumIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict;
		if( indexByEnumIdx == null ) {
			indexByEnumIdx = new HashMap< CFBamEnumTagByEnumIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByEnumIdx.containsKey( key ) ) {
			dict = indexByEnumIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
			ICFBamEnumTagObj obj;
			CFBamEnumTagBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByEnumIdx( schema.getAuthorization(),
				TenantId,
				EnumId );
			CFBamEnumTagBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				ICFBamEnumTagObj realised = (ICFBamEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByEnumIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamEnumTagObj arr[] = new ICFBamEnumTagObj[len];
		Iterator<ICFBamEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamEnumTagObj> arrayList = new ArrayList<ICFBamEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamEnumTagObj> cmp = new Comparator<ICFBamEnumTagObj>() {
			public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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
					CFBamEnumTagPKey lhsPKey = lhs.getPKey();
					CFBamEnumTagPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamEnumTagObj> readEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		return( readEnumTagByDefSchemaIdx( DefSchemaTenantId,
			DefSchemaId,
			false ) );
	}

	public List<ICFBamEnumTagObj> readEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByDefSchemaIdx";
		CFBamEnumTagByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamEnumTagByDefSchemaIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
			ICFBamEnumTagObj obj;
			CFBamEnumTagBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			CFBamEnumTagBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				ICFBamEnumTagObj realised = (ICFBamEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamEnumTagObj arr[] = new ICFBamEnumTagObj[len];
		Iterator<ICFBamEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamEnumTagObj> arrayList = new ArrayList<ICFBamEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamEnumTagObj> cmp = new Comparator<ICFBamEnumTagObj>() {
			public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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
					CFBamEnumTagPKey lhsPKey = lhs.getPKey();
					CFBamEnumTagPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamEnumTagObj readEnumTagByEnumNameIdx( long TenantId,
		long EnumId,
		String Name )
	{
		return( readEnumTagByEnumNameIdx( TenantId,
			EnumId,
			Name,
			false ) );
	}

	public ICFBamEnumTagObj readEnumTagByEnumNameIdx( long TenantId,
		long EnumId,
		String Name, boolean forceRead )
	{
		if( indexByEnumNameIdx == null ) {
			indexByEnumNameIdx = new HashMap< CFBamEnumTagByEnumNameIdxKey,
				ICFBamEnumTagObj >();
		}
		CFBamEnumTagByEnumNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		ICFBamEnumTagObj obj = null;
		if( ( ! forceRead ) && indexByEnumNameIdx.containsKey( key ) ) {
			obj = indexByEnumNameIdx.get( key );
		}
		else {
			CFBamEnumTagBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByEnumNameIdx( schema.getAuthorization(),
				TenantId,
				EnumId,
				Name );
			if( buff != null ) {
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				obj = (ICFBamEnumTagObj)obj.realise();
			}
		}
		return( obj );
	}

	public List<ICFBamEnumTagObj> readEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		return( readEnumTagByPrevIdx( PrevTenantId,
			PrevId,
			false ) );
	}

	public List<ICFBamEnumTagObj> readEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByPrevIdx";
		CFBamEnumTagByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamEnumTagByPrevIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
			ICFBamEnumTagObj obj;
			CFBamEnumTagBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			CFBamEnumTagBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				ICFBamEnumTagObj realised = (ICFBamEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamEnumTagObj arr[] = new ICFBamEnumTagObj[len];
		Iterator<ICFBamEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamEnumTagObj> arrayList = new ArrayList<ICFBamEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamEnumTagObj> cmp = new Comparator<ICFBamEnumTagObj>() {
			public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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
					CFBamEnumTagPKey lhsPKey = lhs.getPKey();
					CFBamEnumTagPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	public List<ICFBamEnumTagObj> readEnumTagByNextIdx( Long NextTenantId,
		Long NextId )
	{
		return( readEnumTagByNextIdx( NextTenantId,
			NextId,
			false ) );
	}

	public List<ICFBamEnumTagObj> readEnumTagByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByNextIdx";
		CFBamEnumTagByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamEnumTagByNextIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<CFBamEnumTagPKey, ICFBamEnumTagObj>();
			ICFBamEnumTagObj obj;
			CFBamEnumTagBuff[] buffList = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().readDerivedByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			CFBamEnumTagBuff buff;
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
				obj.setBuff( buff );
				ICFBamEnumTagObj realised = (ICFBamEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		ICFBamEnumTagObj arr[] = new ICFBamEnumTagObj[len];
		Iterator<ICFBamEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<ICFBamEnumTagObj> arrayList = new ArrayList<ICFBamEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ICFBamEnumTagObj> cmp = new Comparator<ICFBamEnumTagObj>() {
			public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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
					CFBamEnumTagPKey lhsPKey = lhs.getPKey();
					CFBamEnumTagPKey rhsPKey = rhs.getPKey();
					int ret = lhsPKey.compareTo( rhsPKey );
					return( ret );
				}
			}
		};
		Collections.sort( arrayList, cmp );
		List<ICFBamEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	public ICFBamEnumTagObj updateEnumTag( ICFBamEnumTagObj Obj ) {
		ICFBamEnumTagObj obj = Obj;
		((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().updateEnumTag( schema.getAuthorization(),
			Obj.getEnumTagBuff() );
		obj = (ICFBamEnumTagObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	public void deleteEnumTag( ICFBamEnumTagObj Obj ) {
		ICFBamEnumTagObj obj = Obj;
		ICFBamEnumTagObj prev = obj.getOptionalLookupPrev();
		ICFBamEnumTagObj next = obj.getOptionalLookupNext();
		((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTag( schema.getAuthorization(),
			obj.getEnumTagBuff() );
		obj.forget( true );
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	public void deleteEnumTagByIdIdx( long TenantId,
		long Id )
	{
		CFBamEnumTagPKey pkey = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey();
		pkey.setRequiredTenantId( TenantId );
		pkey.setRequiredId( Id );
		ICFBamEnumTagObj obj = readEnumTag( pkey );
		if( obj != null ) {
			ICFBamEnumTagEditObj editObj = (ICFBamEnumTagEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ICFBamEnumTagEditObj)obj.beginEdit();
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

	public void deleteEnumTagByEnumTagTenantIdx( long TenantId )
	{
		CFBamEnumTagByEnumTagTenantIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumTagTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByEnumTagTenantIdx == null ) {
			indexByEnumTagTenantIdx = new HashMap< CFBamEnumTagByEnumTagTenantIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( indexByEnumTagTenantIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict = indexByEnumTagTenantIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByEnumTagTenantIdx( schema.getAuthorization(),
				TenantId );
			Iterator<ICFBamEnumTagObj> iter = dict.values().iterator();
			ICFBamEnumTagObj obj;
			List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByEnumTagTenantIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByEnumTagTenantIdx( schema.getAuthorization(),
				TenantId );
		}
	}

	public void deleteEnumTagByEnumIdx( long TenantId,
		long EnumId )
	{
		CFBamEnumTagByEnumIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		if( indexByEnumIdx == null ) {
			indexByEnumIdx = new HashMap< CFBamEnumTagByEnumIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( indexByEnumIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict = indexByEnumIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByEnumIdx( schema.getAuthorization(),
				TenantId,
				EnumId );
			Iterator<ICFBamEnumTagObj> iter = dict.values().iterator();
			ICFBamEnumTagObj obj;
			List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByEnumIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByEnumIdx( schema.getAuthorization(),
				TenantId,
				EnumId );
		}
	}

	public void deleteEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		CFBamEnumTagByDefSchemaIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< CFBamEnumTagByDefSchemaIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict = indexByDefSchemaIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
			Iterator<ICFBamEnumTagObj> iter = dict.values().iterator();
			ICFBamEnumTagObj obj;
			List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
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
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByDefSchemaIdx( schema.getAuthorization(),
				DefSchemaTenantId,
				DefSchemaId );
		}
	}

	public void deleteEnumTagByEnumNameIdx( long TenantId,
		long EnumId,
		String Name )
	{
		if( indexByEnumNameIdx == null ) {
			indexByEnumNameIdx = new HashMap< CFBamEnumTagByEnumNameIdxKey,
				ICFBamEnumTagObj >();
		}
		CFBamEnumTagByEnumNameIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newEnumNameIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		ICFBamEnumTagObj obj = null;
		if( indexByEnumNameIdx.containsKey( key ) ) {
			obj = indexByEnumNameIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByEnumNameIdx( schema.getAuthorization(),
				TenantId,
				EnumId,
				Name );
			obj.forget( true );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByEnumNameIdx( schema.getAuthorization(),
				TenantId,
				EnumId,
				Name );
		}
	}

	public void deleteEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId )
	{
		CFBamEnumTagByPrevIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPrevIdxKey();
		key.setOptionalPrevTenantId( PrevTenantId );
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< CFBamEnumTagByPrevIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict = indexByPrevIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
			Iterator<ICFBamEnumTagObj> iter = dict.values().iterator();
			ICFBamEnumTagObj obj;
			List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByPrevIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByPrevIdx( schema.getAuthorization(),
				PrevTenantId,
				PrevId );
		}
	}

	public void deleteEnumTagByNextIdx( Long NextTenantId,
		Long NextId )
	{
		CFBamEnumTagByNextIdxKey key = ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newNextIdxKey();
		key.setOptionalNextTenantId( NextTenantId );
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< CFBamEnumTagByNextIdxKey,
				Map< CFBamEnumTagPKey, ICFBamEnumTagObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<CFBamEnumTagPKey, ICFBamEnumTagObj> dict = indexByNextIdx.get( key );
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
			Iterator<ICFBamEnumTagObj> iter = dict.values().iterator();
			ICFBamEnumTagObj obj;
			List<ICFBamEnumTagObj> toForget = new LinkedList<ICFBamEnumTagObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget( true );
			}
			indexByNextIdx.remove( key );
		}
		else {
			((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().deleteEnumTagByNextIdx( schema.getAuthorization(),
				NextTenantId,
				NextId );
		}
	}

	/**
	 *	Move the CFBamEnumTagObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumTagObj refreshed cache instance.
	 */
	public ICFBamEnumTagObj moveUpEnumTag( ICFBamEnumTagObj Obj ) {
		ICFBamEnumTagObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveUpEnumTag",
				"You cannot move an object that is being edited" );
		}
		CFBamEnumTagBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().moveBuffUp( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getEnumTagTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamEnumTagObj)obj.realise();
			ICFBamEnumTagObj prev = obj.getOptionalLookupPrev( true );
			ICFBamEnumTagObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				ICFBamEnumTagObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the CFBamEnumTagObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumTagObj refreshed cache instance.
	 */
	public ICFBamEnumTagObj moveDownEnumTag( ICFBamEnumTagObj Obj ) {
		ICFBamEnumTagObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new CFLibUsageException( getClass(),
				"moveDownEnumTag",
				"You cannot move an object that is being edited" );
		}
		CFBamEnumTagBuff buff = ((ICFBamSchema)schema.getBackingStore()).getTableEnumTag().moveBuffDown( schema.getAuthorization(),
			Obj.getRequiredTenantId(),
			Obj.getRequiredId(),
			Obj.getBuff().getRequiredRevision() );
		if( buff != null ) {
			obj = schema.getEnumTagTableObj().newInstance();
			obj.setPKey( ((ICFBamSchema)schema.getBackingStore()).getFactoryEnumTag().newPKey() );
			obj.setBuff( buff );
			obj = (ICFBamEnumTagObj)obj.realise();
			ICFBamEnumTagObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				ICFBamEnumTagObj gprev = prev.getOptionalLookupPrev( true );
			}
			ICFBamEnumTagObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}
