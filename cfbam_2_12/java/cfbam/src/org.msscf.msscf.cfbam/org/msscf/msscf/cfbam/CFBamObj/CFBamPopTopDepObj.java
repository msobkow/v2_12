// Description: Java 11 base object instance implementation for CFBam PopTopDep.

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

public class CFBamPopTopDepObj
	extends CFBamPopDepObj
	implements ICFBamPopTopDepObj
{
	public final static String CLASS_CODE = "POPT";
	protected ICFBamRelationObj requiredContainerContRelation;

	public CFBamPopTopDepObj() {
		super();
		requiredContainerContRelation = null;
	}

	public CFBamPopTopDepObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerContRelation = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopTopDep" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamRelationObj scope = getRequiredContainerContRelation();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamRelationObj scope = getRequiredContainerContRelation();
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
		ICFBamPopTopDepObj retobj = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().realisePopTopDep(
			(ICFBamPopTopDepObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getPopTopDepTableObj().forgetPopTopDep( (ICFBamPopTopDepObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamPopTopDepObj retobj = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().readPopTopDepByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamPopTopDepObj retobj = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().readPopTopDepByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamPopTopDepTableObj getPopTopDepTable() {
		return( ((ICFBamSchemaObj)schema).getPopTopDepTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryPopTopDep().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTablePopTopDep().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamPopTopDepBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamPopTopDepBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerContRelation = null;
	}

	public CFBamPopTopDepBuff getPopTopDepBuff() {
		return( (CFBamPopTopDepBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamPopTopDepObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamPopTopDepObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().lockPopTopDep( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamPopTopDepEditObj getEditAsPopTopDep() {
		return( (ICFBamPopTopDepEditObj)edit );
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

	public long getRequiredContRelationTenantId() {
		return( getPopTopDepBuff().getRequiredContRelationTenantId() );
	}

	public long getRequiredContRelationId() {
		return( getPopTopDepBuff().getRequiredContRelationId() );
	}

	public String getRequiredName() {
		return( getPopTopDepBuff().getRequiredName() );
	}

	public ICFBamRelationObj getRequiredContainerContRelation() {
		return( getRequiredContainerContRelation( false ) );
	}

	public ICFBamRelationObj getRequiredContainerContRelation( boolean forceRead ) {
		if( ( requiredContainerContRelation == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerContRelation = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByIdIdx( getPopTopDepBuff().getRequiredContRelationTenantId(),
					getPopTopDepBuff().getRequiredContRelationId(), forceRead );
			}
		}
		return( requiredContainerContRelation );
	}

	public List<ICFBamPopSubDep1Obj> getOptionalComponentsPopDep() {
		List<ICFBamPopSubDep1Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().readPopSubDep1ByPopTopDepIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopSubDep1Obj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopSubDep1Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getPopSubDep1TableObj().readPopSubDep1ByPopTopDepIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}
}
