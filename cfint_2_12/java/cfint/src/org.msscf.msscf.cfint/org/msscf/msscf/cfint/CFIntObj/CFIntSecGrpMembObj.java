// Description: Java 11 base object instance implementation for CFInt SecGrpMemb.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntSecGrpMembObj
	implements ICFIntSecGrpMembObj
{
	public final static String CLASS_CODE = "SGMB";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecGrpMembEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecSecGrpMembPKey pKey;
	protected CFSecSecGrpMembBuff buff;
	protected ICFSecClusterObj requiredOwnerCluster;
	protected ICFSecSecGroupObj requiredContainerGroup;
	protected ICFSecSecUserObj requiredParentUser;

	public CFIntSecGrpMembObj() {
		isNew = true;
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	public CFIntSecGrpMembObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecGrpMemb" );
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
		long val = getRequiredSecGrpMembId();
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

	public ICFSecSecGrpMembObj realise() {
		ICFSecSecGrpMembObj retobj = ((ICFIntSchemaObj)schema).getSecGrpMembTableObj().realiseSecGrpMemb(
			(ICFSecSecGrpMembObj)this );
		return( (ICFSecSecGrpMembObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getSecGrpMembTableObj().forgetSecGrpMemb( (ICFSecSecGrpMembObj)this, forgetSubObjects );
	}

	public ICFSecSecGrpMembObj read() {
		ICFSecSecGrpMembObj retobj = ((ICFIntSchemaObj)schema).getSecGrpMembTableObj().readSecGrpMembByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecGrpMembId(), false );
		return( (ICFSecSecGrpMembObj)retobj );
	}

	public ICFSecSecGrpMembObj read( boolean forceRead ) {
		ICFSecSecGrpMembObj retobj = ((ICFIntSchemaObj)schema).getSecGrpMembTableObj().readSecGrpMembByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecGrpMembId(), forceRead );
		return( (ICFSecSecGrpMembObj)retobj );
	}

	public ICFSecSecGrpMembTableObj getSecGrpMembTable() {
		return( ((ICFIntSchemaObj)schema).getSecGrpMembTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecSecGrpMembBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactorySecGrpMemb().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableSecGrpMemb().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredClusterId(),
						getPKey().getRequiredSecGrpMembId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecSecGrpMembBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecSecGrpMembBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecSecGrpMembBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerCluster = null;
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	public CFSecSecGrpMembBuff getSecGrpMembBuff() {
		return( (CFSecSecGrpMembBuff)getBuff() );
	}

	public CFSecSecGrpMembPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactorySecGrpMemb().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecSecGrpMembPKey value ) {
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

	public ICFSecSecGrpMembEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecSecGrpMembObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecGrpMembObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getSecGrpMembTableObj().lockSecGrpMemb( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getSecGrpMembTableObj().newEditInstance( lockobj );
		return( (ICFSecSecGrpMembEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecSecGrpMembEditObj getEdit() {
		return( edit );
	}

	public ICFSecSecGrpMembEditObj getEditAsSecGrpMemb() {
		return( (ICFSecSecGrpMembEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecSecGrpMembBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecSecGrpMembBuff buff = getBuff();
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

	public long getRequiredSecGrpMembId() {
		return( getPKey().getRequiredSecGrpMembId() );
	}

	public int getRequiredSecGroupId() {
		return( getSecGrpMembBuff().getRequiredSecGroupId() );
	}

	public UUID getRequiredSecUserId() {
		return( getSecGrpMembBuff().getRequiredSecUserId() );
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
					getSecGrpMembBuff().getRequiredSecGroupId(), forceRead );
			}
		}
		return( requiredContainerGroup );
	}

	public ICFSecSecUserObj getRequiredParentUser() {
		return( getRequiredParentUser( false ) );
	}

	public ICFSecSecUserObj getRequiredParentUser( boolean forceRead ) {
		if( ( requiredParentUser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentUser = ((ICFIntSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getSecGrpMembBuff().getRequiredSecUserId(), forceRead );
			}
		}
		return( requiredParentUser );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
			buff.setRequiredSecGrpMembId( getPKey().getRequiredSecGrpMembId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecGrpMembId( buff.getRequiredSecGrpMembId() );
	}
}
