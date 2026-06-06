// Description: Java 11 base object instance implementation for CFBam PopSubDep1.

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

public class CFBamPopSubDep1Obj
	extends CFBamPopDepObj
	implements ICFBamPopSubDep1Obj
{
	public final static String CLASS_CODE = "POP1";
	protected ICFBamPopTopDepObj requiredContainerContPopTopDep;

	public CFBamPopSubDep1Obj() {
		super();
		requiredContainerContPopTopDep = null;
	}

	public CFBamPopSubDep1Obj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerContPopTopDep = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopSubDep1" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamPopTopDepObj scope = getRequiredContainerContPopTopDep();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamPopTopDepObj scope = getRequiredContainerContPopTopDep();
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
		ICFBamPopSubDep1Obj retobj = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().realisePopSubDep1(
			(ICFBamPopSubDep1Obj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getPopSubDep1TableObj().forgetPopSubDep1( (ICFBamPopSubDep1Obj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamPopSubDep1Obj retobj = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().readPopSubDep1ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamPopSubDep1Obj retobj = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().readPopSubDep1ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamPopSubDep1TableObj getPopSubDep1Table() {
		return( ((ICFBamSchemaObj)schema).getPopSubDep1TableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopSubDep1().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTablePopSubDep1().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamPopSubDep1Buff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamPopSubDep1Buff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerContPopTopDep = null;
	}

	public CFBamPopSubDep1Buff getPopSubDep1Buff() {
		return( (CFBamPopSubDep1Buff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamPopSubDep1Obj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamPopSubDep1Obj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().lockPopSubDep1( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamPopSubDep1EditObj getEditAsPopSubDep1() {
		return( (ICFBamPopSubDep1EditObj)edit );
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

	public long getRequiredPopTopDepTenantId() {
		return( getPopSubDep1Buff().getRequiredPopTopDepTenantId() );
	}

	public long getRequiredPopTopDepId() {
		return( getPopSubDep1Buff().getRequiredPopTopDepId() );
	}

	public String getRequiredName() {
		return( getPopSubDep1Buff().getRequiredName() );
	}

	public ICFBamPopTopDepObj getRequiredContainerContPopTopDep() {
		return( getRequiredContainerContPopTopDep( false ) );
	}

	public ICFBamPopTopDepObj getRequiredContainerContPopTopDep( boolean forceRead ) {
		if( ( requiredContainerContPopTopDep == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerContPopTopDep = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().readPopTopDepByIdIdx( getPopSubDep1Buff().getRequiredPopTopDepTenantId(),
					getPopSubDep1Buff().getRequiredPopTopDepId(), forceRead );
			}
		}
		return( requiredContainerContPopTopDep );
	}

	public List<ICFBamPopSubDep2Obj> getOptionalComponentsPopDep() {
		List<ICFBamPopSubDep2Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getPopSubDep2TableObj().readPopSubDep2ByPopSubDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopSubDep2Obj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopSubDep2Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getPopSubDep2TableObj().readPopSubDep2ByPopSubDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}
}
