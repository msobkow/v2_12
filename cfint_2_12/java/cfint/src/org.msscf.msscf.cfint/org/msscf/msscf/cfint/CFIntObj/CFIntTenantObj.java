// Description: Java 11 base object instance implementation for CFInt Tenant.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntTenantObj
	implements ICFIntTenantObj
{
	public final static String CLASS_CODE = "TENT";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecTenantEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecTenantPKey pKey;
	protected CFSecTenantBuff buff;
	protected ICFSecClusterObj requiredContainerCluster;

	public CFIntTenantObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFIntTenantObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerCluster = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Tenant" );
	}

	public ICFLibAnyObj getScope() {
		ICFSecClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFSecClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredTenantName();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
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
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
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
		if( subObj == null ) {
			subObj = ((ICFIntSchemaObj)getSchema()).getTSecGroupTableObj().readTSecGroupByUNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFIntSchemaObj)getSchema()).getTldTableObj().readTldByNameIdx( getRequiredId(),
				nextName, false );
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

	public String getObjFullName() {
		String fullName = getObjName();
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
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	public ICFSecTenantObj realise() {
		ICFSecTenantObj retobj = ((ICFIntSchemaObj)schema).getTenantTableObj().realiseTenant(
			(ICFSecTenantObj)this );
		return( (ICFSecTenantObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getTenantTableObj().forgetTenant( (ICFSecTenantObj)this, forgetSubObjects );
	}

	public ICFSecTenantObj read() {
		ICFSecTenantObj retobj = ((ICFIntSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredId(), false );
		return( (ICFSecTenantObj)retobj );
	}

	public ICFSecTenantObj read( boolean forceRead ) {
		ICFSecTenantObj retobj = ((ICFIntSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredId(), forceRead );
		return( (ICFSecTenantObj)retobj );
	}

	public ICFSecTenantTableObj getTenantTable() {
		return( ((ICFIntSchemaObj)schema).getTenantTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecTenantBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactoryTenant().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableTenant().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecTenantBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecTenantBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecTenantBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFSecTenantBuff getTenantBuff() {
		return( (CFSecTenantBuff)getBuff() );
	}

	public CFSecTenantPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecTenantPKey value ) {
		if( pKey != value ) {
			pKey = value;
			copyPKeyToBuff();
		}
	}

	public boolean getIsNew() {
		return( isNew );
	}

	public void setIsNew( boolean value ) {
		isNew = value;
	}

	public ICFSecTenantEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecTenantObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecTenantObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getTenantTableObj().lockTenant( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getTenantTableObj().newEditInstance( lockobj );
		return( (ICFSecTenantEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecTenantEditObj getEdit() {
		return( edit );
	}

	public ICFSecTenantEditObj getEditAsTenant() {
		return( (ICFSecTenantEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecTenantBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecTenantBuff buff = getBuff();
			updatedBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredClusterId() {
		return( getTenantBuff().getRequiredClusterId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredTenantName() {
		return( getTenantBuff().getRequiredTenantName() );
	}

	public ICFSecClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFSecClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = ((ICFIntSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getTenantBuff().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredContainerCluster );
	}

	public List<ICFSecTSecGroupObj> getOptionalComponentsTSecGroup() {
		List<ICFSecTSecGroupObj> retval;
		retval = ((ICFIntSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByTenantIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFSecTSecGroupObj> getOptionalComponentsTSecGroup( boolean forceRead ) {
		List<ICFSecTSecGroupObj> retval;
		retval = ((ICFIntSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByTenantIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFIntTldObj> getOptionalComponentsTld() {
		List<ICFIntTldObj> retval;
		retval = ((ICFIntSchemaObj)schema).getTldTableObj().readTldByTenantIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntTldObj> getOptionalComponentsTld( boolean forceRead ) {
		List<ICFIntTldObj> retval;
		retval = ((ICFIntSchemaObj)schema).getTldTableObj().readTldByTenantIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredId( getPKey().getRequiredId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}
}
