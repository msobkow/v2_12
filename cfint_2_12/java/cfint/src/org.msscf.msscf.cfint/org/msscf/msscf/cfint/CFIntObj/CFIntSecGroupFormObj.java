// Description: Java 11 base object instance implementation for CFInt SecGroupForm.

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

public class CFIntSecGroupFormObj
	implements ICFIntSecGroupFormObj
{
	public final static String CLASS_CODE = "SGFM";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecGroupFormEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecSecGroupFormPKey pKey;
	protected CFSecSecGroupFormBuff buff;
	protected ICFSecClusterObj requiredOwnerCluster;
	protected ICFSecSecGroupObj requiredContainerGroup;
	protected ICFSecSecAppObj requiredParentApp;
	protected ICFSecSecFormObj requiredParentForm;

	public CFIntSecGroupFormObj() {
		isNew = true;
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentApp = null;
		requiredParentForm = null;
	}

	public CFIntSecGroupFormObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentApp = null;
		requiredParentForm = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecGroupForm" );
	}

	public ICFLibAnyObj getScope() {
		ICFSecSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFSecSecGroupObj scope = getRequiredContainerGroup();
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

	public ICFSecSecGroupFormObj realise() {
		ICFSecSecGroupFormObj retobj = ((ICFIntSchemaObj)schema).getSecGroupFormTableObj().realiseSecGroupForm(
			(ICFSecSecGroupFormObj)this );
		return( (ICFSecSecGroupFormObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getSecGroupFormTableObj().forgetSecGroupForm( (ICFSecSecGroupFormObj)this, forgetSubObjects );
	}

	public ICFSecSecGroupFormObj read() {
		ICFSecSecGroupFormObj retobj = ((ICFIntSchemaObj)schema).getSecGroupFormTableObj().readSecGroupFormByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecGroupFormId(), false );
		return( (ICFSecSecGroupFormObj)retobj );
	}

	public ICFSecSecGroupFormObj read( boolean forceRead ) {
		ICFSecSecGroupFormObj retobj = ((ICFIntSchemaObj)schema).getSecGroupFormTableObj().readSecGroupFormByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecGroupFormId(), forceRead );
		return( (ICFSecSecGroupFormObj)retobj );
	}

	public ICFSecSecGroupFormTableObj getSecGroupFormTable() {
		return( ((ICFIntSchemaObj)schema).getSecGroupFormTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecSecGroupFormBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactorySecGroupForm().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableSecGroupForm().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredClusterId(),
						getPKey().getRequiredSecGroupFormId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecSecGroupFormBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecSecGroupFormBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecSecGroupFormBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentApp = null;
		requiredParentForm = null;
	}

	public CFSecSecGroupFormBuff getSecGroupFormBuff() {
		return( (CFSecSecGroupFormBuff)getBuff() );
	}

	public CFSecSecGroupFormPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactorySecGroupForm().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecSecGroupFormPKey value ) {
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

	public ICFSecSecGroupFormEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecSecGroupFormObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecGroupFormObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getSecGroupFormTableObj().lockSecGroupForm( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getSecGroupFormTableObj().newEditInstance( lockobj );
		return( (ICFSecSecGroupFormEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecSecGroupFormEditObj getEdit() {
		return( edit );
	}

	public ICFSecSecGroupFormEditObj getEditAsSecGroupForm() {
		return( (ICFSecSecGroupFormEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecSecGroupFormBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecSecGroupFormBuff buff = getBuff();
			updatedBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
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

	public ICFSecClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	public ICFSecClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( ( requiredOwnerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerCluster = ((ICFIntSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredOwnerCluster );
	}

	public ICFSecSecGroupObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	public ICFSecSecGroupObj getRequiredContainerGroup( boolean forceRead ) {
		if( ( requiredContainerGroup == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerGroup = ((ICFIntSchemaObj)schema).getSecGroupTableObj().readSecGroupByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecGroupId(), forceRead );
			}
		}
		return( requiredContainerGroup );
	}

	public ICFSecSecAppObj getRequiredParentApp() {
		return( getRequiredParentApp( false ) );
	}

	public ICFSecSecAppObj getRequiredParentApp( boolean forceRead ) {
		if( ( requiredParentApp == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentApp = ((ICFIntSchemaObj)schema).getSecAppTableObj().readSecAppByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecAppId(), forceRead );
			}
		}
		return( requiredParentApp );
	}

	public ICFSecSecFormObj getRequiredParentForm() {
		return( getRequiredParentForm( false ) );
	}

	public ICFSecSecFormObj getRequiredParentForm( boolean forceRead ) {
		if( ( requiredParentForm == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentForm = ((ICFIntSchemaObj)schema).getSecFormTableObj().readSecFormByIdIdx( getPKey().getRequiredClusterId(),
					getSecGroupFormBuff().getRequiredSecFormId(), forceRead );
			}
		}
		return( requiredParentForm );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
			buff.setRequiredSecGroupFormId( getPKey().getRequiredSecGroupFormId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecGroupFormId( buff.getRequiredSecGroupFormId() );
	}
}
