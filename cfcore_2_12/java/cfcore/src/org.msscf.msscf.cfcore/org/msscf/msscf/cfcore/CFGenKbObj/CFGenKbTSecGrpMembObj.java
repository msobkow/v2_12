// Description: Java 11 base object instance implementation for CFGenKb TSecGrpMemb.

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

public class CFGenKbTSecGrpMembObj
	implements ICFGenKbTSecGrpMembObj
{
	public final static String CLASS_CODE = "TGMB";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbTSecGrpMembEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbTSecGrpMembPKey pKey;
	protected CFGenKbTSecGrpMembBuff buff;
	protected ICFGenKbTenantObj requiredOwnerTenant;
	protected ICFGenKbTSecGroupObj requiredContainerGroup;
	protected ICFGenKbSecUserObj requiredParentUser;

	public CFGenKbTSecGrpMembObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	public CFGenKbTSecGrpMembObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TSecGrpMemb" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbTSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbTSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredTSecGrpMembId();
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

	public ICFGenKbTSecGrpMembObj realise() {
		ICFGenKbTSecGrpMembObj retobj = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().realiseTSecGrpMemb(
			(ICFGenKbTSecGrpMembObj)this );
		return( (ICFGenKbTSecGrpMembObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().forgetTSecGrpMemb( (ICFGenKbTSecGrpMembObj)this, forgetSubObjects );
	}

	public ICFGenKbTSecGrpMembObj read() {
		ICFGenKbTSecGrpMembObj retobj = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().readTSecGrpMembByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredTSecGrpMembId(), false );
		return( (ICFGenKbTSecGrpMembObj)retobj );
	}

	public ICFGenKbTSecGrpMembObj read( boolean forceRead ) {
		ICFGenKbTSecGrpMembObj retobj = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().readTSecGrpMembByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredTSecGrpMembId(), forceRead );
		return( (ICFGenKbTSecGrpMembObj)retobj );
	}

	public ICFGenKbTSecGrpMembTableObj getTSecGrpMembTable() {
		return( ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbTSecGrpMembBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGrpMemb().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredTSecGrpMembId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbTSecGrpMembBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbTSecGrpMembBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbTSecGrpMembBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	public CFGenKbTSecGrpMembBuff getTSecGrpMembBuff() {
		return( (CFGenKbTSecGrpMembBuff)getBuff() );
	}

	public CFGenKbTSecGrpMembPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGrpMemb().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbTSecGrpMembPKey value ) {
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

	public ICFGenKbTSecGrpMembEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbTSecGrpMembObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbTSecGrpMembObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().lockTSecGrpMemb( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().newEditInstance( lockobj );
		return( (ICFGenKbTSecGrpMembEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbTSecGrpMembEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbTSecGrpMembEditObj getEditAsTSecGrpMemb() {
		return( (ICFGenKbTSecGrpMembEditObj)edit );
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbTSecGrpMembBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbTSecGrpMembBuff buff = getBuff();
			updatedBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredTSecGrpMembId() {
		return( getPKey().getRequiredTSecGrpMembId() );
	}

	public int getRequiredTSecGroupId() {
		return( getTSecGrpMembBuff().getRequiredTSecGroupId() );
	}

	public UUID getRequiredSecUserId() {
		return( getTSecGrpMembBuff().getRequiredSecUserId() );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFGenKbTSecGroupObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	public ICFGenKbTSecGroupObj getRequiredContainerGroup( boolean forceRead ) {
		if( ( requiredContainerGroup == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerGroup = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
					getTSecGrpMembBuff().getRequiredTSecGroupId(), forceRead );
			}
		}
		return( requiredContainerGroup );
	}

	public ICFGenKbSecUserObj getRequiredParentUser() {
		return( getRequiredParentUser( false ) );
	}

	public ICFGenKbSecUserObj getRequiredParentUser( boolean forceRead ) {
		if( ( requiredParentUser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentUser = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getTSecGrpMembBuff().getRequiredSecUserId(), forceRead );
			}
		}
		return( requiredParentUser );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredTSecGrpMembId( getPKey().getRequiredTSecGrpMembId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredTSecGrpMembId( buff.getRequiredTSecGrpMembId() );
	}
}
