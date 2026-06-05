// Description: Java 11 base object instance implementation for CFGenKb SecDevice.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbSecDeviceObj
	implements ICFGenKbSecDeviceObj
{
	public final static String CLASS_CODE = "SDEV";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbSecDeviceEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbSecDevicePKey pKey;
	protected CFGenKbSecDeviceBuff buff;
	protected ICFGenKbSecUserObj requiredContainerSecUser;

	public CFGenKbSecDeviceObj() {
		isNew = true;
		requiredContainerSecUser = null;
	}

	public CFGenKbSecDeviceObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerSecUser = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbSecDeviceObj retobj = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().realiseSecDevice(
			(ICFGenKbSecDeviceObj)this );
		return( (ICFGenKbSecDeviceObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().forgetSecDevice( (ICFGenKbSecDeviceObj)this, forgetSubObjects );
	}

	public ICFGenKbSecDeviceObj read() {
		ICFGenKbSecDeviceObj retobj = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().readSecDeviceByIdIdx( getPKey().getRequiredSecUserId(),
			getPKey().getRequiredDevName(), false );
		return( (ICFGenKbSecDeviceObj)retobj );
	}

	public ICFGenKbSecDeviceObj read( boolean forceRead ) {
		ICFGenKbSecDeviceObj retobj = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().readSecDeviceByIdIdx( getPKey().getRequiredSecUserId(),
			getPKey().getRequiredDevName(), forceRead );
		return( (ICFGenKbSecDeviceObj)retobj );
	}

	public ICFGenKbSecDeviceTableObj getSecDeviceTable() {
		return( ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbSecDeviceBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecDevice().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecDevice().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredSecUserId(),
						getPKey().getRequiredDevName() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecDeviceBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbSecDeviceBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbSecDeviceBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerSecUser = null;
	}

	public CFGenKbSecDeviceBuff getSecDeviceBuff() {
		return( (CFGenKbSecDeviceBuff)getBuff() );
	}

	public CFGenKbSecDevicePKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecDevice().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbSecDevicePKey value ) {
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

	public ICFGenKbSecDeviceEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbSecDeviceObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbSecDeviceObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().lockSecDevice( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().newEditInstance( lockobj );
		return( (ICFGenKbSecDeviceEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbSecDeviceEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbSecDeviceEditObj getEditAsSecDevice() {
		return( (ICFGenKbSecDeviceEditObj)edit );
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

	public UUID getRequiredSecUserId() {
		return( getPKey().getRequiredSecUserId() );
	}

	public String getRequiredDevName() {
		return( getPKey().getRequiredDevName() );
	}

	public String getOptionalPubKey() {
		return( getSecDeviceBuff().getOptionalPubKey() );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser() {
		return( getRequiredContainerSecUser( false ) );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser( boolean forceRead ) {
		if( ( requiredContainerSecUser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSecUser = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getPKey().getRequiredSecUserId(), forceRead );
			}
		}
		return( requiredContainerSecUser );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredSecUserId( getPKey().getRequiredSecUserId() );
			buff.setRequiredDevName( getPKey().getRequiredDevName() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSecUserId( buff.getRequiredSecUserId() );
		getPKey().setRequiredDevName( buff.getRequiredDevName() );
	}
}
