// Description: Java 11 base object instance implementation for CFGenKb TSecGroup.

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

public class CFGenKbTSecGroupObj
	implements ICFGenKbTSecGroupObj
{
	public final static String CLASS_CODE = "TGRP";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbTSecGroupEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbTSecGroupPKey pKey;
	protected CFGenKbTSecGroupBuff buff;
	protected ICFGenKbTenantObj requiredContainerTenant;

	public CFGenKbTSecGroupObj() {
		isNew = true;
		requiredContainerTenant = null;
	}

	public CFGenKbTSecGroupObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerTenant = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TSecGroup" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbTenantObj scope = getRequiredContainerTenant();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbTenantObj scope = getRequiredContainerTenant();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
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

	public ICFGenKbTSecGroupObj realise() {
		ICFGenKbTSecGroupObj retobj = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().realiseTSecGroup(
			(ICFGenKbTSecGroupObj)this );
		return( (ICFGenKbTSecGroupObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().forgetTSecGroup( (ICFGenKbTSecGroupObj)this, forgetSubObjects );
	}

	public ICFGenKbTSecGroupObj read() {
		ICFGenKbTSecGroupObj retobj = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredTSecGroupId(), false );
		return( (ICFGenKbTSecGroupObj)retobj );
	}

	public ICFGenKbTSecGroupObj read( boolean forceRead ) {
		ICFGenKbTSecGroupObj retobj = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredTSecGroupId(), forceRead );
		return( (ICFGenKbTSecGroupObj)retobj );
	}

	public ICFGenKbTSecGroupTableObj getTSecGroupTable() {
		return( ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbTSecGroupBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGroup().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTSecGroup().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredTSecGroupId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbTSecGroupBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbTSecGroupBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbTSecGroupBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerTenant = null;
	}

	public CFGenKbTSecGroupBuff getTSecGroupBuff() {
		return( (CFGenKbTSecGroupBuff)getBuff() );
	}

	public CFGenKbTSecGroupPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTSecGroup().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbTSecGroupPKey value ) {
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

	public ICFGenKbTSecGroupEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbTSecGroupObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbTSecGroupObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().lockTSecGroup( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getTSecGroupTableObj().newEditInstance( lockobj );
		return( (ICFGenKbTSecGroupEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbTSecGroupEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbTSecGroupEditObj getEditAsTSecGroup() {
		return( (ICFGenKbTSecGroupEditObj)edit );
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbTSecGroupBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbTSecGroupBuff buff = getBuff();
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

	public int getRequiredTSecGroupId() {
		return( getPKey().getRequiredTSecGroupId() );
	}

	public String getRequiredName() {
		return( getTSecGroupBuff().getRequiredName() );
	}

	public boolean getRequiredIsVisible() {
		return( getTSecGroupBuff().getRequiredIsVisible() );
	}

	public ICFGenKbTenantObj getRequiredContainerTenant() {
		return( getRequiredContainerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredContainerTenant( boolean forceRead ) {
		if( ( requiredContainerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTenant = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredContainerTenant );
	}

	public List<ICFGenKbTSecGrpIncObj> getOptionalComponentsInclude() {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpIncTableObj().readTSecGrpIncByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpIncObj> getOptionalComponentsInclude( boolean forceRead ) {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpIncTableObj().readTSecGrpIncByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalComponentsMember() {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().readTSecGrpMembByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalComponentsMember( boolean forceRead ) {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpMembTableObj().readTSecGrpMembByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTSecGrpIncObj> getRequiredChildrenIncByGroup() {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpIncTableObj().readTSecGrpIncByIncludeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpIncObj> getRequiredChildrenIncByGroup( boolean forceRead ) {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTSecGrpIncTableObj().readTSecGrpIncByIncludeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredTSecGroupId( getPKey().getRequiredTSecGroupId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredTSecGroupId( buff.getRequiredTSecGroupId() );
	}
}
