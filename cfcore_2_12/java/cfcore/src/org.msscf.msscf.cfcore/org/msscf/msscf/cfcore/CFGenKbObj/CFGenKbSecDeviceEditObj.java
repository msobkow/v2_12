// Description: Java 11 edit object instance implementation for CFGenKb SecDevice.

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

public class CFGenKbSecDeviceEditObj
	implements ICFGenKbSecDeviceEditObj
{
	protected ICFGenKbSecDeviceObj orig;
	protected CFGenKbSecDeviceBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbSecUserObj requiredContainerSecUser;

	public CFGenKbSecDeviceEditObj( ICFGenKbSecDeviceObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecDeviceBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerSecUser = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbSecDeviceBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbSecDeviceBuff buff = getBuff();
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
		return( CFGenKbSecDeviceObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecDevice" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredDevName();
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

	public ICFGenKbSecDeviceObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecDeviceObj retobj = getSchema().getSecDeviceTableObj().realiseSecDevice( (ICFGenKbSecDeviceObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecDevice().getSchema()).getSecDeviceTableObj().forgetSecDevice( getOrigAsSecDevice(), forgetSubObjects );
	}

	public ICFGenKbSecDeviceObj read() {
		ICFGenKbSecDeviceObj retval = getOrigAsSecDevice().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecDeviceObj read( boolean forceRead ) {
		ICFGenKbSecDeviceObj retval = getOrigAsSecDevice().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecDeviceObj create() {
		copyBuffToOrig();
		ICFGenKbSecDeviceObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecDevice().getSchema()).getSecDeviceTableObj().createSecDevice( getOrigAsSecDevice() );
		if( retobj == getOrigAsSecDevice() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecDeviceEditObj update() {
		getSchema().getSecDeviceTableObj().updateSecDevice( (ICFGenKbSecDeviceObj)this );
		return( null );
	}

	public CFGenKbSecDeviceEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecDeviceTableObj().deleteSecDevice( getOrigAsSecDevice() );
		return( null );
	}

	public ICFGenKbSecDeviceTableObj getSecDeviceTable() {
		return( orig.getSchema().getSecDeviceTableObj() );
	}

	public ICFGenKbSecDeviceEditObj getEdit() {
		return( (ICFGenKbSecDeviceEditObj)this );
	}

	public ICFGenKbSecDeviceEditObj getEditAsSecDevice() {
		return( (ICFGenKbSecDeviceEditObj)this );
	}

	public ICFGenKbSecDeviceEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecDeviceObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecDeviceObj getOrigAsSecDevice() {
		return( (ICFGenKbSecDeviceObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecDeviceBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecDevice().getSchema().getBackingStore()).getFactorySecDevice().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecDeviceBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerSecUser = null;
		}
	}

	public CFGenKbSecDeviceBuff getSecDeviceBuff() {
		return( (CFGenKbSecDeviceBuff)getBuff() );
	}

	public CFGenKbSecDevicePKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecDevicePKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public UUID getRequiredSecUserId() {
		return( getPKey().getRequiredSecUserId() );
	}

	public String getRequiredDevName() {
		return( getPKey().getRequiredDevName() );
	}

	public void setRequiredDevName( String value ) {
		if( getPKey().getRequiredDevName() != value ) {
			getPKey().setRequiredDevName( value );
		}
		if( getSecDeviceBuff().getRequiredDevName() != value ) {
			getSecDeviceBuff().setRequiredDevName( value );
		}
	}

	public String getOptionalPubKey() {
		return( getSecDeviceBuff().getOptionalPubKey() );
	}

	public void setOptionalPubKey( String value ) {
		if( getSecDeviceBuff().getOptionalPubKey() != value ) {
			getSecDeviceBuff().setOptionalPubKey( value );
		}
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser() {
		return( getRequiredContainerSecUser( false ) );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser( boolean forceRead ) {
		if( forceRead || ( requiredContainerSecUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbSecUserObj obj = ((ICFGenKbSchemaObj)getOrigAsSecDevice().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey().getRequiredSecUserId() );
				requiredContainerSecUser = obj;
				if( obj != null ) {
					getSecDeviceBuff().setRequiredSecUserId( obj.getRequiredSecUserId() );
					requiredContainerSecUser = obj;
				}
			}
		}
		return( requiredContainerSecUser );
	}

	public void setRequiredContainerSecUser( ICFGenKbSecUserObj value ) {
			if( buff == null ) {
				getSecDeviceBuff();
			}
			if( value != null ) {
				getPKey().setRequiredSecUserId( value.getRequiredSecUserId() );
				getSecDeviceBuff().setRequiredSecUserId( value.getRequiredSecUserId() );
			}
			requiredContainerSecUser = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredSecUserId( getPKey().getRequiredSecUserId() );
		buff.setRequiredDevName( getPKey().getRequiredDevName() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSecUserId( buff.getRequiredSecUserId() );
		getPKey().setRequiredDevName( buff.getRequiredDevName() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecDeviceBuff origBuff = getOrigAsSecDevice().getSecDeviceBuff();
		CFGenKbSecDeviceBuff myBuff = getSecDeviceBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecDeviceBuff origBuff = getOrigAsSecDevice().getSecDeviceBuff();
		CFGenKbSecDeviceBuff myBuff = getSecDeviceBuff();
		myBuff.set( origBuff );
	}
}
