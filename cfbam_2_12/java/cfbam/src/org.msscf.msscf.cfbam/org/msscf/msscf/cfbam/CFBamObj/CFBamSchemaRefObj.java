// Description: Java 11 base object instance implementation for CFBam SchemaRef.

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

public class CFBamSchemaRefObj
	extends CFBamScopeObj
	implements ICFBamSchemaRefObj
{
	public final static String CLASS_CODE = "SCRF";
	protected ICFBamSchemaDefObj requiredContainerSchema;
	protected ICFBamSchemaDefObj optionalLookupRefSchema;
	protected ICFBamSchemaRefObj optionalLookupPrev;
	protected ICFBamSchemaRefObj optionalLookupNext;

	public CFBamSchemaRefObj() {
		super();
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamSchemaRefObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SchemaRef" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchema();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchema();
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
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public ICFBamScopeObj realise() {
		ICFBamSchemaRefObj retobj = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().realiseSchemaRef(
			(ICFBamSchemaRefObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getSchemaRefTableObj().forgetSchemaRef( (ICFBamSchemaRefObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamSchemaRefObj retobj = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().readSchemaRefByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamSchemaRefObj retobj = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().readSchemaRefByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamSchemaRefObj moveUp() {
		ICFBamSchemaRefObj retobj = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().moveUpSchemaRef( this );
		return( (ICFBamSchemaRefObj)retobj );
	}

	public ICFBamSchemaRefObj moveDown() {
		ICFBamSchemaRefObj retobj = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().moveDownSchemaRef( this );
		return( (ICFBamSchemaRefObj)retobj );
	}

	public ICFBamSchemaRefTableObj getSchemaRefTable() {
		return( ((ICFBamSchemaObj)schema).getSchemaRefTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaRef().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaRef().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamSchemaRefBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamSchemaRefBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamSchemaRefBuff getSchemaRefBuff() {
		return( (CFBamSchemaRefBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamSchemaRefObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamSchemaRefObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().lockSchemaRef( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamSchemaRefEditObj getEditAsSchemaRef() {
		return( (ICFBamSchemaRefEditObj)edit );
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

	public long getRequiredSchemaId() {
		return( getSchemaRefBuff().getRequiredSchemaId() );
	}

	public String getRequiredName() {
		return( getSchemaRefBuff().getRequiredName() );
	}

	public String getRequiredRefModelName() {
		return( getSchemaRefBuff().getRequiredRefModelName() );
	}

	public String getRequiredIncludeRoot() {
		return( getSchemaRefBuff().getRequiredIncludeRoot() );
	}

	public Long getOptionalRefSchemaTenantId() {
		return( getSchemaRefBuff().getOptionalRefSchemaTenantId() );
	}

	public Long getOptionalRefSchemaId() {
		return( getSchemaRefBuff().getOptionalRefSchemaId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getSchemaRefBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getSchemaRefBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getSchemaRefBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getSchemaRefBuff().getOptionalNextId() );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchema() {
		return( getRequiredContainerSchema( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchema( boolean forceRead ) {
		if( ( requiredContainerSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaRefBuff().getRequiredSchemaId(), forceRead );
			}
		}
		return( requiredContainerSchema );
	}

	public ICFBamSchemaDefObj getOptionalLookupRefSchema() {
		return( getOptionalLookupRefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupRefSchema( boolean forceRead ) {
		if( ( optionalLookupRefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalRefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalRefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupRefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefBuff().getOptionalRefSchemaTenantId(),
					getSchemaRefBuff().getOptionalRefSchemaId(), forceRead );
			}
		}
		return( optionalLookupRefSchema );
	}

	public ICFBamSchemaRefObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamSchemaRefObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefBuff().getOptionalPrevTenantId(),
					getSchemaRefBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamSchemaRefObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamSchemaRefObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefBuff().getOptionalNextTenantId(),
					getSchemaRefBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}
}
