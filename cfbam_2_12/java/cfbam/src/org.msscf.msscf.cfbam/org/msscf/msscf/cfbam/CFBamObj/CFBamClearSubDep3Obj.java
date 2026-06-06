// Description: Java 11 base object instance implementation for CFBam ClearSubDep3.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamClearSubDep3Obj
	extends CFBamClearDepObj
	implements ICFBamClearSubDep3Obj
{
	public final static String CLASS_CODE = "CLR3";
	protected ICFBamClearSubDep2Obj requiredContainerClearSubDep2;

	public CFBamClearSubDep3Obj() {
		super();
		requiredContainerClearSubDep2 = null;
	}

	public CFBamClearSubDep3Obj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerClearSubDep2 = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ClearSubDep3" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamClearSubDep2Obj scope = getRequiredContainerClearSubDep2();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamClearSubDep2Obj scope = getRequiredContainerClearSubDep2();
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
		ICFBamClearSubDep3Obj retobj = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().realiseClearSubDep3(
			(ICFBamClearSubDep3Obj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getClearSubDep3TableObj().forgetClearSubDep3( (ICFBamClearSubDep3Obj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamClearSubDep3Obj retobj = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().readClearSubDep3ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamClearSubDep3Obj retobj = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().readClearSubDep3ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamClearSubDep3TableObj getClearSubDep3Table() {
		return( ((ICFBamSchemaObj)schema).getClearSubDep3TableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep3().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep3().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamClearSubDep3Buff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamClearSubDep3Buff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerClearSubDep2 = null;
	}

	public CFBamClearSubDep3Buff getClearSubDep3Buff() {
		return( (CFBamClearSubDep3Buff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamClearSubDep3Obj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamClearSubDep3Obj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().lockClearSubDep3( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamClearSubDep3EditObj getEditAsClearSubDep3() {
		return( (ICFBamClearSubDep3EditObj)edit );
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

	public long getRequiredClearSubDep2TenantId() {
		return( getClearSubDep3Buff().getRequiredClearSubDep2TenantId() );
	}

	public long getRequiredClearSubDep2Id() {
		return( getClearSubDep3Buff().getRequiredClearSubDep2Id() );
	}

	public String getRequiredName() {
		return( getClearSubDep3Buff().getRequiredName() );
	}

	public ICFBamClearSubDep2Obj getRequiredContainerClearSubDep2() {
		return( getRequiredContainerClearSubDep2( false ) );
	}

	public ICFBamClearSubDep2Obj getRequiredContainerClearSubDep2( boolean forceRead ) {
		if( ( requiredContainerClearSubDep2 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerClearSubDep2 = ((ICFBamSchemaObj)schema).getClearSubDep2TableObj().readClearSubDep2ByIdIdx( getClearSubDep3Buff().getRequiredClearSubDep2TenantId(),
					getClearSubDep3Buff().getRequiredClearSubDep2Id(), forceRead );
			}
		}
		return( requiredContainerClearSubDep2 );
	}
}
