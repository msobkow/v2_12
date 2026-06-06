// Description: Java 11 base object instance implementation for CFBam DelTopDep.

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

public class CFBamDelTopDepObj
	extends CFBamDelDepObj
	implements ICFBamDelTopDepObj
{
	public final static String CLASS_CODE = "DELT";
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamDelTopDepObj optionalLookupPrev;
	protected ICFBamDelTopDepObj optionalLookupNext;

	public CFBamDelTopDepObj() {
		super();
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamDelTopDepObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelTopDep" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else if( container instanceof ICFBamSchemaDefObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public ICFBamScopeObj realise() {
		ICFBamDelTopDepObj retobj = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().realiseDelTopDep(
			(ICFBamDelTopDepObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getDelTopDepTableObj().forgetDelTopDep( (ICFBamDelTopDepObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamDelTopDepObj retobj = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamDelTopDepObj retobj = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamDelTopDepObj moveUp() {
		ICFBamDelTopDepObj retobj = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().moveUpDelTopDep( this );
		return( (ICFBamDelTopDepObj)retobj );
	}

	public ICFBamDelTopDepObj moveDown() {
		ICFBamDelTopDepObj retobj = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().moveDownDelTopDep( this );
		return( (ICFBamDelTopDepObj)retobj );
	}

	public ICFBamDelTopDepTableObj getDelTopDepTable() {
		return( ((ICFBamSchemaObj)schema).getDelTopDepTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelTopDep().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelTopDep().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamDelTopDepBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamDelTopDepBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamDelTopDepBuff getDelTopDepBuff() {
		return( (CFBamDelTopDepBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamDelTopDepObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamDelTopDepObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().lockDelTopDep( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamDelTopDepEditObj getEditAsDelTopDep() {
		return( (ICFBamDelTopDepEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamScopeBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamScopeBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public String getRequiredName() {
		return( getDelTopDepBuff().getRequiredName() );
	}

	public long getRequiredTableTenantId() {
		return( getDelTopDepBuff().getRequiredTableTenantId() );
	}

	public long getRequiredTableId() {
		return( getDelTopDepBuff().getRequiredTableId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getDelTopDepBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getDelTopDepBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getDelTopDepBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getDelTopDepBuff().getOptionalNextId() );
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( ( requiredContainerTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getDelTopDepBuff().getRequiredTableTenantId(),
					getDelTopDepBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerTable );
	}

	public List<ICFBamDelSubDep1Obj> getOptionalComponentsDelDep() {
		List<ICFBamDelSubDep1Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().readDelSubDep1ByDelTopDepIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelSubDep1Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelSubDep1Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().readDelSubDep1ByDelTopDepIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamDelTopDepObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamDelTopDepObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getDelTopDepBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getDelTopDepBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByIdIdx( getDelTopDepBuff().getOptionalPrevTenantId(),
					getDelTopDepBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamDelTopDepObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamDelTopDepObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getDelTopDepBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getDelTopDepBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByIdIdx( getDelTopDepBuff().getOptionalNextTenantId(),
					getDelTopDepBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}
}
