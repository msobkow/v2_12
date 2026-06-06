// Description: Java 11 edit object instance implementation for CFGenKb Tenant.

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

public class CFGenKbTenantEditObj
	implements ICFGenKbTenantEditObj
{
	protected ICFGenKbTenantObj orig;
	protected CFGenKbTenantBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbTenantEditObj( ICFGenKbTenantObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbTenantBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerCluster = null;
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

	public void setCreatedBy( ICFGenKbSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getBuff().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setCreatedAt( Calendar value ) {
		getBuff().setCreatedAt( value );
	}

	public void setUpdatedBy( ICFGenKbSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getBuff().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setUpdatedAt( Calendar value ) {
		getBuff().setUpdatedAt( value );
	}

	public String getClassCode() {
		return( CFGenKbTenantObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbTenantObj retobj = getSchema().getTenantTableObj().realiseTenant( (ICFGenKbTenantObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getTenantTableObj().forgetTenant( getOrigAsTenant(), forgetSubObjects );
	}

	public ICFGenKbTenantObj read() {
		ICFGenKbTenantObj retval = getOrigAsTenant().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbTenantObj read( boolean forceRead ) {
		ICFGenKbTenantObj retval = getOrigAsTenant().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbTenantObj create() {
		copyBuffToOrig();
		ICFGenKbTenantObj retobj = ((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getTenantTableObj().createTenant( getOrigAsTenant() );
		if( retobj == getOrigAsTenant() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbTenantEditObj update() {
		getSchema().getTenantTableObj().updateTenant( (ICFGenKbTenantObj)this );
		return( null );
	}

	public CFGenKbTenantEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getTenantTableObj().deleteTenant( getOrigAsTenant() );
		return( null );
	}

	public ICFGenKbTenantTableObj getTenantTable() {
		return( orig.getSchema().getTenantTableObj() );
	}

	public ICFGenKbTenantEditObj getEdit() {
		return( (ICFGenKbTenantEditObj)this );
	}

	public ICFGenKbTenantEditObj getEditAsTenant() {
		return( (ICFGenKbTenantEditObj)this );
	}

	public ICFGenKbTenantEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbTenantObj getOrig() {
		return( orig );
	}

	public ICFGenKbTenantObj getOrigAsTenant() {
		return( (ICFGenKbTenantObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbTenantBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsTenant().getSchema().getBackingStore()).getFactoryTenant().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbTenantBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerCluster = null;
		}
	}

	public CFGenKbTenantBuff getTenantBuff() {
		return( (CFGenKbTenantBuff)getBuff() );
	}

	public CFGenKbTenantPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbTenantPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
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

	public void setRequiredTenantName( String value ) {
		if( getTenantBuff().getRequiredTenantName() != value ) {
			getTenantBuff().setRequiredTenantName( value );
		}
	}

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( forceRead || ( requiredContainerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbClusterObj obj = ((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getClusterTableObj().readClusterByIdIdx( getTenantBuff().getRequiredClusterId() );
				requiredContainerCluster = obj;
				if( obj != null ) {
					getTenantBuff().setRequiredClusterId( obj.getRequiredId() );
					requiredContainerCluster = obj;
				}
			}
		}
		return( requiredContainerCluster );
	}

	public void setRequiredContainerCluster( ICFGenKbClusterObj value ) {
			if( buff == null ) {
				getTenantBuff();
			}
			if( value != null ) {
				getTenantBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredContainerCluster = value;
	}

	public List<ICFGenKbTSecGroupObj> getOptionalComponentsTSecGroup() {
		List<ICFGenKbTSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getTSecGroupTableObj().readTSecGroupByTenantIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGroupObj> getOptionalComponentsTSecGroup( boolean forceRead ) {
		List<ICFGenKbTSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getTSecGroupTableObj().readTSecGroupByTenantIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbRuleCartObj> getOptionalComponentsRuleCart() {
		List<ICFGenKbRuleCartObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getRuleCartTableObj().readRuleCartByTenantIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbRuleCartObj> getOptionalComponentsRuleCart( boolean forceRead ) {
		List<ICFGenKbRuleCartObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTenant().getSchema()).getRuleCartTableObj().readRuleCartByTenantIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFGenKbTenantBuff origBuff = getOrigAsTenant().getTenantBuff();
		CFGenKbTenantBuff myBuff = getTenantBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbTenantBuff origBuff = getOrigAsTenant().getTenantBuff();
		CFGenKbTenantBuff myBuff = getTenantBuff();
		myBuff.set( origBuff );
	}
}
