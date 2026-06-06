// Description: Java 11 edit object instance implementation for CFGenKb SecUser.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbSecUserEditObj
	implements ICFGenKbSecUserEditObj
{
	protected ICFGenKbSecUserObj orig;
	protected CFGenKbSecUserBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbSecDeviceObj optionalLookupDefDev;

	public CFGenKbSecUserEditObj( ICFGenKbSecUserObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecUserBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		optionalLookupDefDev = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbSecUserBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbSecUserBuff buff = getBuff();
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
		return( CFGenKbSecUserObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecUser" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredLoginId();
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
			subObj = ((ICFGenKbSchemaObj)getSchema()).getSecDeviceTableObj().readSecDeviceByNameIdx( getRequiredSecUserId(),
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

	public ICFGenKbSecUserObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecUserObj retobj = getSchema().getSecUserTableObj().realiseSecUser( (ICFGenKbSecUserObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecUserTableObj().forgetSecUser( getOrigAsSecUser(), forgetSubObjects );
	}

	public ICFGenKbSecUserObj read() {
		ICFGenKbSecUserObj retval = getOrigAsSecUser().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecUserObj read( boolean forceRead ) {
		ICFGenKbSecUserObj retval = getOrigAsSecUser().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecUserObj create() {
		copyBuffToOrig();
		ICFGenKbSecUserObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecUserTableObj().createSecUser( getOrigAsSecUser() );
		if( retobj == getOrigAsSecUser() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecUserEditObj update() {
		getSchema().getSecUserTableObj().updateSecUser( (ICFGenKbSecUserObj)this );
		return( null );
	}

	public CFGenKbSecUserEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecUserTableObj().deleteSecUser( getOrigAsSecUser() );
		return( null );
	}

	public ICFGenKbSecUserTableObj getSecUserTable() {
		return( orig.getSchema().getSecUserTableObj() );
	}

	public ICFGenKbSecUserEditObj getEdit() {
		return( (ICFGenKbSecUserEditObj)this );
	}

	public ICFGenKbSecUserEditObj getEditAsSecUser() {
		return( (ICFGenKbSecUserEditObj)this );
	}

	public ICFGenKbSecUserEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecUserObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecUserObj getOrigAsSecUser() {
		return( (ICFGenKbSecUserObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecUserBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecUser().getSchema().getBackingStore()).getFactorySecUser().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecUserBuff value ) {
		if( buff != value ) {
			buff = value;
			optionalLookupDefDev = null;
		}
	}

	public CFGenKbSecUserBuff getSecUserBuff() {
		return( (CFGenKbSecUserBuff)getBuff() );
	}

	public CFGenKbSecUserPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecUserPKey value ) {
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

	public String getRequiredLoginId() {
		return( getSecUserBuff().getRequiredLoginId() );
	}

	public void setRequiredLoginId( String value ) {
		if( getSecUserBuff().getRequiredLoginId() != value ) {
			getSecUserBuff().setRequiredLoginId( value );
		}
	}

	public String getRequiredEMailAddress() {
		return( getSecUserBuff().getRequiredEMailAddress() );
	}

	public void setRequiredEMailAddress( String value ) {
		if( getSecUserBuff().getRequiredEMailAddress() != value ) {
			getSecUserBuff().setRequiredEMailAddress( value );
		}
	}

	public UUID getOptionalEMailConfirmUuid() {
		return( getSecUserBuff().getOptionalEMailConfirmUuid() );
	}

	public void setOptionalEMailConfirmUuid( UUID value ) {
		if( getSecUserBuff().getOptionalEMailConfirmUuid() != value ) {
			getSecUserBuff().setOptionalEMailConfirmUuid( value );
		}
	}

	public UUID getOptionalDfltDevUserId() {
		return( getSecUserBuff().getOptionalDfltDevUserId() );
	}

	public String getOptionalDfltDevName() {
		return( getSecUserBuff().getOptionalDfltDevName() );
	}

	public String getRequiredPasswordHash() {
		return( getSecUserBuff().getRequiredPasswordHash() );
	}

	public void setRequiredPasswordHash( String value ) {
		if( getSecUserBuff().getRequiredPasswordHash() != value ) {
			getSecUserBuff().setRequiredPasswordHash( value );
		}
	}

	public UUID getOptionalPasswordResetUuid() {
		return( getSecUserBuff().getOptionalPasswordResetUuid() );
	}

	public void setOptionalPasswordResetUuid( UUID value ) {
		if( getSecUserBuff().getOptionalPasswordResetUuid() != value ) {
			getSecUserBuff().setOptionalPasswordResetUuid( value );
		}
	}

	public List<ICFGenKbSecDeviceObj> getOptionalComponentsSecDev() {
		List<ICFGenKbSecDeviceObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecDeviceTableObj().readSecDeviceByUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecDeviceObj> getOptionalComponentsSecDev( boolean forceRead ) {
		List<ICFGenKbSecDeviceObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecDeviceTableObj().readSecDeviceByUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public ICFGenKbSecDeviceObj getOptionalLookupDefDev() {
		return( getOptionalLookupDefDev( false ) );
	}

	public ICFGenKbSecDeviceObj getOptionalLookupDefDev( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefDev == null ) ) {
			boolean anyMissing = false;
			if( getSecUserBuff().getOptionalDfltDevUserId() == null ) {
				anyMissing = true;
			}
			if( getSecUserBuff().getOptionalDfltDevName() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbSecDeviceObj obj = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecDeviceTableObj().readSecDeviceByIdIdx( getSecUserBuff().getOptionalDfltDevUserId(),
					getSecUserBuff().getOptionalDfltDevName() );
				optionalLookupDefDev = obj;
			}
		}
		return( optionalLookupDefDev );
	}

	public void setOptionalLookupDefDev( ICFGenKbSecDeviceObj value ) {
			if( buff == null ) {
				getSecUserBuff();
			}
			if( value != null ) {
				getSecUserBuff().setOptionalDfltDevUserId( value.getRequiredSecUserId() );
				getSecUserBuff().setOptionalDfltDevName( value.getRequiredDevName() );
			}
			else {
				getSecUserBuff().setOptionalDfltDevUserId( null );
				getSecUserBuff().setOptionalDfltDevName( null );
			}
			optionalLookupDefDev = value;
	}

	public List<ICFGenKbSecSessionObj> getOptionalComponentsSecSess() {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecSessionObj> getOptionalComponentsSecSess( boolean forceRead ) {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecSessionObj> getOptionalChildrenSecProxy() {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecSessionObj> getOptionalChildrenSecProxy( boolean forceRead ) {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalChildrenSecGrpMemb() {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecGrpMembTableObj().readSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalChildrenSecGrpMemb( boolean forceRead ) {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getSecGrpMembTableObj().readSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalChildrenTSecGrpMemb() {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getTSecGrpMembTableObj().readTSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalChildrenTSecGrpMemb( boolean forceRead ) {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecUser().getSchema()).getTSecGrpMembTableObj().readTSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredSecUserId( getPKey().getRequiredSecUserId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSecUserId( buff.getRequiredSecUserId() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecUserBuff origBuff = getOrigAsSecUser().getSecUserBuff();
		CFGenKbSecUserBuff myBuff = getSecUserBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecUserBuff origBuff = getOrigAsSecUser().getSecUserBuff();
		CFGenKbSecUserBuff myBuff = getSecUserBuff();
		myBuff.set( origBuff );
	}
}
