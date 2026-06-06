// Description: Java 11 edit object instance implementation for CFGenKb SecGroupForm.

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

public class CFGenKbSecGroupFormEditObj
	implements ICFGenKbSecGroupFormEditObj
{
	protected ICFGenKbSecGroupFormObj orig;
	protected CFGenKbSecGroupFormBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbClusterObj requiredOwnerCluster;
	protected ICFGenKbSecGroupObj requiredContainerGroup;
	protected ICFGenKbSecAppObj requiredParentApp;
	protected ICFGenKbSecFormObj requiredParentForm;

	public CFGenKbSecGroupFormEditObj( ICFGenKbSecGroupFormObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecGroupFormBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentApp = null;
		requiredParentForm = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbSecGroupFormBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbSecGroupFormBuff buff = getBuff();
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
		return( CFGenKbSecGroupFormObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecGroupForm" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredSecGroupFormId();
		objName = Long.toString( val );
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

	public ICFGenKbSecGroupFormObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecGroupFormObj retobj = getSchema().getSecGroupFormTableObj().realiseSecGroupForm( (ICFGenKbSecGroupFormObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecGroupForm().getSchema()).getSecGroupFormTableObj().forgetSecGroupForm( getOrigAsSecGroupForm(), forgetSubObjects );
	}

	public ICFGenKbSecGroupFormObj read() {
		ICFGenKbSecGroupFormObj retval = getOrigAsSecGroupForm().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecGroupFormObj read( boolean forceRead ) {
		ICFGenKbSecGroupFormObj retval = getOrigAsSecGroupForm().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecGroupFormObj create() {
		copyBuffToOrig();
		ICFGenKbSecGroupFormObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecGroupForm().getSchema()).getSecGroupFormTableObj().createSecGroupForm( getOrigAsSecGroupForm() );
		if( retobj == getOrigAsSecGroupForm() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecGroupFormEditObj update() {
		getSchema().getSecGroupFormTableObj().updateSecGroupForm( (ICFGenKbSecGroupFormObj)this );
		return( null );
	}

	public CFGenKbSecGroupFormEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecGroupFormTableObj().deleteSecGroupForm( getOrigAsSecGroupForm() );
		return( null );
	}

	public ICFGenKbSecGroupFormTableObj getSecGroupFormTable() {
		return( orig.getSchema().getSecGroupFormTableObj() );
	}

	public ICFGenKbSecGroupFormEditObj getEdit() {
		return( (ICFGenKbSecGroupFormEditObj)this );
	}

	public ICFGenKbSecGroupFormEditObj getEditAsSecGroupForm() {
		return( (ICFGenKbSecGroupFormEditObj)this );
	}

	public ICFGenKbSecGroupFormEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecGroupFormObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecGroupFormObj getOrigAsSecGroupForm() {
		return( (ICFGenKbSecGroupFormObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecGroupFormBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecGroupForm().getSchema().getBackingStore()).getFactorySecGroupForm().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecGroupFormBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerCluster = null;
			requiredContainerGroup = null;
			requiredParentApp = null;
			requiredParentForm = null;
		}
	}

	public CFGenKbSecGroupFormBuff getSecGroupFormBuff() {
		return( (CFGenKbSecGroupFormBuff)getBuff() );
	}

	public CFGenKbSecGroupFormPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecGroupFormPKey value ) {
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
		return( getPKey().getRequiredClusterId() );
	}

	public long getRequiredSecGroupFormId() {
		return( getPKey().getRequiredSecGroupFormId() );
	}

	public int getRequiredSecGroupId() {
		return( getSecGroupFormBuff().getRequiredSecGroupId() );
	}

	public int getRequiredSecAppId() {
		return( getSecGroupFormBuff().getRequiredSecAppId() );
	}

	public int getRequiredSecFormId() {
		return( getSecGroupFormBuff().getRequiredSecFormId() );
	}

	public ICFGenKbClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbClusterObj obj = ((ICFGenKbSchemaObj)getOrigAsSecGroupForm().getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId() );
				requiredOwnerCluster = obj;
			}
		}
		return( requiredOwnerCluster );
	}

	public void setRequiredOwnerCluster( ICFGenKbClusterObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredOwnerCluster = value;
	}

	public ICFGenKbSecGroupObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	public ICFGenKbSecGroupObj getRequiredContainerGroup( boolean forceRead ) {
		if( forceRead || ( requiredContainerGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbSecGroupObj obj = ((ICFGenKbSchemaObj)getOrigAsSecGroupForm().getSchema()).getSecGroupTableObj().readSecGroupByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecGroupId() );
				requiredContainerGroup = obj;
				if( obj != null ) {
					getSecGroupFormBuff().setRequiredClusterId( obj.getRequiredClusterId() );
					getSecGroupFormBuff().setRequiredSecGroupId( obj.getRequiredSecGroupId() );
					requiredContainerGroup = obj;
				}
			}
		}
		return( requiredContainerGroup );
	}

	public void setRequiredContainerGroup( ICFGenKbSecGroupObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredSecGroupId( value.getRequiredSecGroupId() );
			}
			requiredContainerGroup = value;
	}

	public ICFGenKbSecAppObj getRequiredParentApp() {
		return( getRequiredParentApp( false ) );
	}

	public ICFGenKbSecAppObj getRequiredParentApp( boolean forceRead ) {
		if( forceRead || ( requiredParentApp == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbSecAppObj obj = ((ICFGenKbSchemaObj)getOrigAsSecGroupForm().getSchema()).getSecAppTableObj().readSecAppByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecAppId() );
				requiredParentApp = obj;
			}
		}
		return( requiredParentApp );
	}

	public void setRequiredParentApp( ICFGenKbSecAppObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredSecAppId( value.getRequiredSecAppId() );
			}
			else {
			}
			requiredParentApp = value;
	}

	public ICFGenKbSecFormObj getRequiredParentForm() {
		return( getRequiredParentForm( false ) );
	}

	public ICFGenKbSecFormObj getRequiredParentForm( boolean forceRead ) {
		if( forceRead || ( requiredParentForm == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbSecFormObj obj = ((ICFGenKbSchemaObj)getOrigAsSecGroupForm().getSchema()).getSecFormTableObj().readSecFormByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecFormId() );
				requiredParentForm = obj;
			}
		}
		return( requiredParentForm );
	}

	public void setRequiredParentForm( ICFGenKbSecFormObj value ) {
			if( buff == null ) {
				getSecGroupFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecGroupFormBuff().setRequiredSecFormId( value.getRequiredSecFormId() );
			}
			else {
			}
			requiredParentForm = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
		buff.setRequiredSecGroupFormId( getPKey().getRequiredSecGroupFormId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecGroupFormId( buff.getRequiredSecGroupFormId() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecGroupFormBuff origBuff = getOrigAsSecGroupForm().getSecGroupFormBuff();
		CFGenKbSecGroupFormBuff myBuff = getSecGroupFormBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecGroupFormBuff origBuff = getOrigAsSecGroupForm().getSecGroupFormBuff();
		CFGenKbSecGroupFormBuff myBuff = getSecGroupFormBuff();
		myBuff.set( origBuff );
	}
}
