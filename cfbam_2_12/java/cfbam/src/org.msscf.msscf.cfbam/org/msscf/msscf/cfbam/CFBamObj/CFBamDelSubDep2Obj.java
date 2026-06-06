// Description: Java 11 base object instance implementation for CFBam DelSubDep2.

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

public class CFBamDelSubDep2Obj
	extends CFBamDelDepObj
	implements ICFBamDelSubDep2Obj
{
	public final static String CLASS_CODE = "DEL2";
	protected ICFBamDelSubDep1Obj requiredContainerDelSubDep1;

	public CFBamDelSubDep2Obj() {
		super();
		requiredContainerDelSubDep1 = null;
	}

	public CFBamDelSubDep2Obj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerDelSubDep1 = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDelSubDep1Obj scope = getRequiredContainerDelSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDelSubDep1Obj scope = getRequiredContainerDelSubDep1();
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
		ICFBamDelSubDep2Obj retobj = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().realiseDelSubDep2(
			(ICFBamDelSubDep2Obj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getDelSubDep2TableObj().forgetDelSubDep2( (ICFBamDelSubDep2Obj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamDelSubDep2Obj retobj = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().readDelSubDep2ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamDelSubDep2Obj retobj = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().readDelSubDep2ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamDelSubDep2TableObj getDelSubDep2Table() {
		return( ((ICFBamSchemaObj)schema).getDelSubDep2TableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep2().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep2().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamDelSubDep2Buff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamDelSubDep2Buff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerDelSubDep1 = null;
	}

	public CFBamDelSubDep2Buff getDelSubDep2Buff() {
		return( (CFBamDelSubDep2Buff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamDelSubDep2Obj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamDelSubDep2Obj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().lockDelSubDep2( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamDelSubDep2EditObj getEditAsDelSubDep2() {
		return( (ICFBamDelSubDep2EditObj)edit );
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

	public long getRequiredDelSubDep1TenantId() {
		return( getDelSubDep2Buff().getRequiredDelSubDep1TenantId() );
	}

	public long getRequiredDelSubDep1Id() {
		return( getDelSubDep2Buff().getRequiredDelSubDep1Id() );
	}

	public String getRequiredName() {
		return( getDelSubDep2Buff().getRequiredName() );
	}

	public ICFBamDelSubDep1Obj getRequiredContainerDelSubDep1() {
		return( getRequiredContainerDelSubDep1( false ) );
	}

	public ICFBamDelSubDep1Obj getRequiredContainerDelSubDep1( boolean forceRead ) {
		if( ( requiredContainerDelSubDep1 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerDelSubDep1 = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().readDelSubDep1ByIdIdx( getDelSubDep2Buff().getRequiredDelSubDep1TenantId(),
					getDelSubDep2Buff().getRequiredDelSubDep1Id(), forceRead );
			}
		}
		return( requiredContainerDelSubDep1 );
	}

	public List<ICFBamDelSubDep3Obj> getOptionalComponentsDelDep() {
		List<ICFBamDelSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelSubDep3TableObj().readDelSubDep3ByDelSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelSubDep3Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelSubDep3TableObj().readDelSubDep3ByDelSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}
}
