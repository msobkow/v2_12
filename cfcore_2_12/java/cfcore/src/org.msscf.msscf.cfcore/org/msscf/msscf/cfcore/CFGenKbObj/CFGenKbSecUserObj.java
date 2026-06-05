// Description: Java 11 base object instance implementation for CFGenKb SecUser.

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

public class CFGenKbSecUserObj
	implements ICFGenKbSecUserObj
{
	public final static String CLASS_CODE = "SUSR";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbSecUserEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbSecUserPKey pKey;
	protected CFGenKbSecUserBuff buff;
	protected ICFGenKbSecDeviceObj optionalLookupDefDev;

	public CFGenKbSecUserObj() {
		isNew = true;
		optionalLookupDefDev = null;
	}

	public CFGenKbSecUserObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		optionalLookupDefDev = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbSecUserObj retobj = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().realiseSecUser(
			(ICFGenKbSecUserObj)this );
		return( (ICFGenKbSecUserObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getSecUserTableObj().forgetSecUser( (ICFGenKbSecUserObj)this, forgetSubObjects );
	}

	public ICFGenKbSecUserObj read() {
		ICFGenKbSecUserObj retobj = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getPKey().getRequiredSecUserId(), false );
		return( (ICFGenKbSecUserObj)retobj );
	}

	public ICFGenKbSecUserObj read( boolean forceRead ) {
		ICFGenKbSecUserObj retobj = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getPKey().getRequiredSecUserId(), forceRead );
		return( (ICFGenKbSecUserObj)retobj );
	}

	public ICFGenKbSecUserTableObj getSecUserTable() {
		return( ((ICFGenKbSchemaObj)schema).getSecUserTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbSecUserBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecUser().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecUser().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredSecUserId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecUserBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbSecUserBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbSecUserBuff" );
		}
		buff = value;
		copyBuffToPKey();
		optionalLookupDefDev = null;
	}

	public CFGenKbSecUserBuff getSecUserBuff() {
		return( (CFGenKbSecUserBuff)getBuff() );
	}

	public CFGenKbSecUserPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecUser().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbSecUserPKey value ) {
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

	public ICFGenKbSecUserEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbSecUserObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbSecUserObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().lockSecUser( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().newEditInstance( lockobj );
		return( (ICFGenKbSecUserEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbSecUserEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbSecUserEditObj getEditAsSecUser() {
		return( (ICFGenKbSecUserEditObj)edit );
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

	public UUID getRequiredSecUserId() {
		return( getPKey().getRequiredSecUserId() );
	}

	public String getRequiredLoginId() {
		return( getSecUserBuff().getRequiredLoginId() );
	}

	public String getRequiredEMailAddress() {
		return( getSecUserBuff().getRequiredEMailAddress() );
	}

	public UUID getOptionalEMailConfirmUuid() {
		return( getSecUserBuff().getOptionalEMailConfirmUuid() );
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

	public UUID getOptionalPasswordResetUuid() {
		return( getSecUserBuff().getOptionalPasswordResetUuid() );
	}

	public List<ICFGenKbSecDeviceObj> getOptionalComponentsSecDev() {
		List<ICFGenKbSecDeviceObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().readSecDeviceByUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecDeviceObj> getOptionalComponentsSecDev( boolean forceRead ) {
		List<ICFGenKbSecDeviceObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().readSecDeviceByUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public ICFGenKbSecDeviceObj getOptionalLookupDefDev() {
		return( getOptionalLookupDefDev( false ) );
	}

	public ICFGenKbSecDeviceObj getOptionalLookupDefDev( boolean forceRead ) {
		if( ( optionalLookupDefDev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSecUserBuff().getOptionalDfltDevUserId() == null ) {
				anyMissing = true;
			}
			if( getSecUserBuff().getOptionalDfltDevName() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefDev = ((ICFGenKbSchemaObj)schema).getSecDeviceTableObj().readSecDeviceByIdIdx( getSecUserBuff().getOptionalDfltDevUserId(),
					getSecUserBuff().getOptionalDfltDevName(), forceRead );
			}
		}
		return( optionalLookupDefDev );
	}

	public List<ICFGenKbSecSessionObj> getOptionalComponentsSecSess() {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecSessionObj> getOptionalComponentsSecSess( boolean forceRead ) {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecSessionObj> getOptionalChildrenSecProxy() {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecSessionObj> getOptionalChildrenSecProxy( boolean forceRead ) {
		List<ICFGenKbSecSessionObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalChildrenSecGrpMemb() {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpMembTableObj().readSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalChildrenSecGrpMemb( boolean forceRead ) {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpMembTableObj().readSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalChildrenTSecGrpMemb() {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().readTSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalChildrenTSecGrpMemb( boolean forceRead ) {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().readTSecGrpMembByUserIdx( getPKey().getRequiredSecUserId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredSecUserId( getPKey().getRequiredSecUserId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSecUserId( buff.getRequiredSecUserId() );
	}
}
