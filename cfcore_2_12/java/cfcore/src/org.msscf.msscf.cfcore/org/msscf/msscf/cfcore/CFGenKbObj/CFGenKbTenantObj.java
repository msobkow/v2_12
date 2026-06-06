// Description: Java 11 base object instance implementation for CFGenKb Tenant.

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

public class CFGenKbTenantObj
	implements ICFGenKbTenantObj
{
	public final static String CLASS_CODE = "TENT";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbTenantEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbTenantPKey pKey;
	protected CFGenKbTenantBuff buff;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbTenantObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFGenKbTenantObj( ICFGenKbSchemaObj argSchema ) {
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
		ICFGenKbClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbClusterObj scope = getRequiredContainerCluster();
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
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
			subObj = ((ICFGenKbSchemaObj)getSchema()).getTSecGroupTableObj().readTSecGroupByUNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getRuleCartTableObj().readRuleCartByNameIdx( getRequiredId(),
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
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
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
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
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

	public ICFGenKbTenantObj realise() {
		ICFGenKbTenantObj retobj = ((ICFGenKbSchemaObj)schema).getTenantTableObj().realiseTenant(
			(ICFGenKbTenantObj)this );
		return( (ICFGenKbTenantObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getTenantTableObj().forgetTenant( (ICFGenKbTenantObj)this, forgetSubObjects );
	}

	public ICFGenKbTenantObj read() {
		ICFGenKbTenantObj retobj = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredId(), false );
		return( (ICFGenKbTenantObj)retobj );
	}

	public ICFGenKbTenantObj read( boolean forceRead ) {
		ICFGenKbTenantObj retobj = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredId(), forceRead );
		return( (ICFGenKbTenantObj)retobj );
	}

	public ICFGenKbTenantTableObj getTenantTable() {
		return( ((ICFGenKbSchemaObj)schema).getTenantTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbTenantBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTenant().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbTenantBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbTenantBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbTenantBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFGenKbTenantBuff getTenantBuff() {
		return( (CFGenKbTenantBuff)getBuff() );
	}

	public CFGenKbTenantPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTenant().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbTenantPKey value ) {
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

	public ICFGenKbTenantEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbTenantObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbTenantObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getTenantTableObj().lockTenant( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getTenantTableObj().newEditInstance( lockobj );
		return( (ICFGenKbTenantEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbTenantEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbTenantEditObj getEditAsTenant() {
		return( (ICFGenKbTenantEditObj)edit );
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbTenantBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbTenantBuff buff = getBuff();
			updatedBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
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

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = ((ICFGenKbSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getTenantBuff().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredContainerCluster );
	}

	public List<ICFGenKbTSecGroupObj> getOptionalComponentsTSecGroup() {
		List<ICFGenKbTSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByTenantIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGroupObj> getOptionalComponentsTSecGroup( boolean forceRead ) {
		List<ICFGenKbTSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByTenantIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbRuleCartObj> getOptionalComponentsRuleCart() {
		List<ICFGenKbRuleCartObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getRuleCartTableObj().readRuleCartByTenantIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbRuleCartObj> getOptionalComponentsRuleCart( boolean forceRead ) {
		List<ICFGenKbRuleCartObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getRuleCartTableObj().readRuleCartByTenantIdx( getPKey().getRequiredId(),
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
