// Description: Java 11 base object instance implementation for CFBam DelSubDep1.

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

public class CFBamDelSubDep1Obj
	extends CFBamDelDepObj
	implements ICFBamDelSubDep1Obj
{
	public final static String CLASS_CODE = "DEL1";
	protected ICFBamDelTopDepObj requiredContainerDelTopDep;

	public CFBamDelSubDep1Obj() {
		super();
		requiredContainerDelTopDep = null;
	}

	public CFBamDelSubDep1Obj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerDelTopDep = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelSubDep1" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDelTopDepObj scope = getRequiredContainerDelTopDep();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDelTopDepObj scope = getRequiredContainerDelTopDep();
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
		ICFBamDelSubDep1Obj retobj = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().realiseDelSubDep1(
			(ICFBamDelSubDep1Obj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getDelSubDep1TableObj().forgetDelSubDep1( (ICFBamDelSubDep1Obj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamDelSubDep1Obj retobj = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().readDelSubDep1ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamDelSubDep1Obj retobj = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().readDelSubDep1ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamDelSubDep1TableObj getDelSubDep1Table() {
		return( ((ICFBamSchemaObj)schema).getDelSubDep1TableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryDelSubDep1().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableDelSubDep1().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamDelSubDep1Buff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamDelSubDep1Buff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerDelTopDep = null;
	}

	public CFBamDelSubDep1Buff getDelSubDep1Buff() {
		return( (CFBamDelSubDep1Buff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamDelSubDep1Obj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamDelSubDep1Obj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().lockDelSubDep1( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getDelSubDep1TableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamDelSubDep1EditObj getEditAsDelSubDep1() {
		return( (ICFBamDelSubDep1EditObj)edit );
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

	public long getRequiredDelTopDepTenantId() {
		return( getDelSubDep1Buff().getRequiredDelTopDepTenantId() );
	}

	public long getRequiredDelTopDepId() {
		return( getDelSubDep1Buff().getRequiredDelTopDepId() );
	}

	public String getRequiredName() {
		return( getDelSubDep1Buff().getRequiredName() );
	}

	public ICFBamDelTopDepObj getRequiredContainerDelTopDep() {
		return( getRequiredContainerDelTopDep( false ) );
	}

	public ICFBamDelTopDepObj getRequiredContainerDelTopDep( boolean forceRead ) {
		if( ( requiredContainerDelTopDep == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerDelTopDep = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByIdIdx( getDelSubDep1Buff().getRequiredDelTopDepTenantId(),
					getDelSubDep1Buff().getRequiredDelTopDepId(), forceRead );
			}
		}
		return( requiredContainerDelTopDep );
	}

	public List<ICFBamDelSubDep2Obj> getOptionalComponentsDelDep() {
		List<ICFBamDelSubDep2Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelSubDep2Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelSubDep2Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}
}
