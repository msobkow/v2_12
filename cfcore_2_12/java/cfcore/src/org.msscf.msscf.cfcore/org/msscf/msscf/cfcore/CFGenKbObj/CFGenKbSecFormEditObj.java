// Description: Java 11 edit object instance implementation for CFGenKb SecForm.

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

public class CFGenKbSecFormEditObj
	implements ICFGenKbSecFormEditObj
{
	protected ICFGenKbSecFormObj orig;
	protected CFGenKbSecFormBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbClusterObj requiredOwnerCluster;
	protected ICFGenKbSecAppObj requiredContainerApplication;

	public CFGenKbSecFormEditObj( ICFGenKbSecFormObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecFormBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerCluster = null;
		requiredContainerApplication = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbSecFormBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbSecFormBuff buff = getBuff();
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
		return( CFGenKbSecFormObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecForm" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbSecAppObj scope = getRequiredContainerApplication();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbSecAppObj scope = getRequiredContainerApplication();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredJEEServletMapName();
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

	public ICFGenKbSecFormObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecFormObj retobj = getSchema().getSecFormTableObj().realiseSecForm( (ICFGenKbSecFormObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecForm().getSchema()).getSecFormTableObj().forgetSecForm( getOrigAsSecForm(), forgetSubObjects );
	}

	public ICFGenKbSecFormObj read() {
		ICFGenKbSecFormObj retval = getOrigAsSecForm().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecFormObj read( boolean forceRead ) {
		ICFGenKbSecFormObj retval = getOrigAsSecForm().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecFormObj create() {
		copyBuffToOrig();
		ICFGenKbSecFormObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecForm().getSchema()).getSecFormTableObj().createSecForm( getOrigAsSecForm() );
		if( retobj == getOrigAsSecForm() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecFormEditObj update() {
		getSchema().getSecFormTableObj().updateSecForm( (ICFGenKbSecFormObj)this );
		return( null );
	}

	public CFGenKbSecFormEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecFormTableObj().deleteSecForm( getOrigAsSecForm() );
		return( null );
	}

	public ICFGenKbSecFormTableObj getSecFormTable() {
		return( orig.getSchema().getSecFormTableObj() );
	}

	public ICFGenKbSecFormEditObj getEdit() {
		return( (ICFGenKbSecFormEditObj)this );
	}

	public ICFGenKbSecFormEditObj getEditAsSecForm() {
		return( (ICFGenKbSecFormEditObj)this );
	}

	public ICFGenKbSecFormEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecFormObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecFormObj getOrigAsSecForm() {
		return( (ICFGenKbSecFormObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecFormBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecForm().getSchema().getBackingStore()).getFactorySecForm().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecFormBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerCluster = null;
			requiredContainerApplication = null;
		}
	}

	public CFGenKbSecFormBuff getSecFormBuff() {
		return( (CFGenKbSecFormBuff)getBuff() );
	}

	public CFGenKbSecFormPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecFormPKey value ) {
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

	public int getRequiredSecFormId() {
		return( getPKey().getRequiredSecFormId() );
	}

	public int getRequiredSecAppId() {
		return( getSecFormBuff().getRequiredSecAppId() );
	}

	public String getRequiredJEEServletMapName() {
		return( getSecFormBuff().getRequiredJEEServletMapName() );
	}

	public void setRequiredJEEServletMapName( String value ) {
		if( getSecFormBuff().getRequiredJEEServletMapName() != value ) {
			getSecFormBuff().setRequiredJEEServletMapName( value );
		}
	}

	public ICFGenKbClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbClusterObj obj = ((ICFGenKbSchemaObj)getOrigAsSecForm().getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId() );
				requiredOwnerCluster = obj;
			}
		}
		return( requiredOwnerCluster );
	}

	public void setRequiredOwnerCluster( ICFGenKbClusterObj value ) {
			if( buff == null ) {
				getSecFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredId() );
				getSecFormBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredOwnerCluster = value;
	}

	public ICFGenKbSecAppObj getRequiredContainerApplication() {
		return( getRequiredContainerApplication( false ) );
	}

	public ICFGenKbSecAppObj getRequiredContainerApplication( boolean forceRead ) {
		if( forceRead || ( requiredContainerApplication == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbSecAppObj obj = ((ICFGenKbSchemaObj)getOrigAsSecForm().getSchema()).getSecAppTableObj().readSecAppByIdIdx( getPKey().getRequiredClusterId(),
					getSecFormBuff().getRequiredSecAppId() );
				requiredContainerApplication = obj;
				if( obj != null ) {
					getSecFormBuff().setRequiredClusterId( obj.getRequiredClusterId() );
					getSecFormBuff().setRequiredSecAppId( obj.getRequiredSecAppId() );
					requiredContainerApplication = obj;
				}
			}
		}
		return( requiredContainerApplication );
	}

	public void setRequiredContainerApplication( ICFGenKbSecAppObj value ) {
			if( buff == null ) {
				getSecFormBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredClusterId() );
				getSecFormBuff().setRequiredClusterId( value.getRequiredClusterId() );
				getSecFormBuff().setRequiredSecAppId( value.getRequiredSecAppId() );
			}
			requiredContainerApplication = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
		buff.setRequiredSecFormId( getPKey().getRequiredSecFormId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecFormId( buff.getRequiredSecFormId() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecFormBuff origBuff = getOrigAsSecForm().getSecFormBuff();
		CFGenKbSecFormBuff myBuff = getSecFormBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecFormBuff origBuff = getOrigAsSecForm().getSecFormBuff();
		CFGenKbSecFormBuff myBuff = getSecFormBuff();
		myBuff.set( origBuff );
	}
}
