// Description: Java 11 edit object instance implementation for CFGenKb TSecGrpInc.

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

public class CFGenKbTSecGrpIncEditObj
	implements ICFGenKbTSecGrpIncEditObj
{
	protected ICFGenKbTSecGrpIncObj orig;
	protected CFGenKbTSecGrpIncBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbTenantObj requiredOwnerTenant;
	protected ICFGenKbTSecGroupObj requiredContainerGroup;
	protected ICFGenKbTSecGroupObj requiredParentSubGroup;

	public CFGenKbTSecGrpIncEditObj( ICFGenKbTSecGrpIncObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbTSecGrpIncBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentSubGroup = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbTSecGrpIncBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbTSecGrpIncBuff buff = getBuff();
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
		return( CFGenKbTSecGrpIncObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TSecGrpInc" );
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
		long val = getRequiredTSecGrpIncId();
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

	public ICFGenKbTSecGrpIncObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbTSecGrpIncObj retobj = getSchema().getTSecGrpIncTableObj().realiseTSecGrpInc( (ICFGenKbTSecGrpIncObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsTSecGrpInc().getSchema()).getTSecGrpIncTableObj().forgetTSecGrpInc( getOrigAsTSecGrpInc(), forgetSubObjects );
	}

	public ICFGenKbTSecGrpIncObj read() {
		ICFGenKbTSecGrpIncObj retval = getOrigAsTSecGrpInc().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbTSecGrpIncObj read( boolean forceRead ) {
		ICFGenKbTSecGrpIncObj retval = getOrigAsTSecGrpInc().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbTSecGrpIncObj create() {
		copyBuffToOrig();
		ICFGenKbTSecGrpIncObj retobj = ((ICFGenKbSchemaObj)getOrigAsTSecGrpInc().getSchema()).getTSecGrpIncTableObj().createTSecGrpInc( getOrigAsTSecGrpInc() );
		if( retobj == getOrigAsTSecGrpInc() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbTSecGrpIncEditObj update() {
		getSchema().getTSecGrpIncTableObj().updateTSecGrpInc( (ICFGenKbTSecGrpIncObj)this );
		return( null );
	}

	public CFGenKbTSecGrpIncEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getTSecGrpIncTableObj().deleteTSecGrpInc( getOrigAsTSecGrpInc() );
		return( null );
	}

	public ICFGenKbTSecGrpIncTableObj getTSecGrpIncTable() {
		return( orig.getSchema().getTSecGrpIncTableObj() );
	}

	public ICFGenKbTSecGrpIncEditObj getEdit() {
		return( (ICFGenKbTSecGrpIncEditObj)this );
	}

	public ICFGenKbTSecGrpIncEditObj getEditAsTSecGrpInc() {
		return( (ICFGenKbTSecGrpIncEditObj)this );
	}

	public ICFGenKbTSecGrpIncEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbTSecGrpIncObj getOrig() {
		return( orig );
	}

	public ICFGenKbTSecGrpIncObj getOrigAsTSecGrpInc() {
		return( (ICFGenKbTSecGrpIncObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbTSecGrpIncBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsTSecGrpInc().getSchema().getBackingStore()).getFactoryTSecGrpInc().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbTSecGrpIncBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerGroup = null;
			requiredParentSubGroup = null;
		}
	}

	public CFGenKbTSecGrpIncBuff getTSecGrpIncBuff() {
		return( (CFGenKbTSecGrpIncBuff)getBuff() );
	}

	public CFGenKbTSecGrpIncPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbTSecGrpIncPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredTSecGrpIncId() {
		return( getPKey().getRequiredTSecGrpIncId() );
	}

	public int getRequiredTSecGroupId() {
		return( getTSecGrpIncBuff().getRequiredTSecGroupId() );
	}

	public int getRequiredIncludeGroupId() {
		return( getTSecGrpIncBuff().getRequiredIncludeGroupId() );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTenantObj obj = ((ICFGenKbSchemaObj)getOrigAsTSecGrpInc().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFGenKbTenantObj value ) {
			if( buff == null ) {
				getTSecGrpIncBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getTSecGrpIncBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFGenKbTSecGroupObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	public ICFGenKbTSecGroupObj getRequiredContainerGroup( boolean forceRead ) {
		if( forceRead || ( requiredContainerGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTSecGroupObj obj = ((ICFGenKbSchemaObj)getOrigAsTSecGrpInc().getSchema()).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
					getTSecGrpIncBuff().getRequiredTSecGroupId() );
				requiredContainerGroup = obj;
				if( obj != null ) {
					getTSecGrpIncBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getTSecGrpIncBuff().setRequiredTSecGroupId( obj.getRequiredTSecGroupId() );
					requiredContainerGroup = obj;
				}
			}
		}
		return( requiredContainerGroup );
	}

	public void setRequiredContainerGroup( ICFGenKbTSecGroupObj value ) {
			if( buff == null ) {
				getTSecGrpIncBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTSecGrpIncBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTSecGrpIncBuff().setRequiredTSecGroupId( value.getRequiredTSecGroupId() );
			}
			requiredContainerGroup = value;
	}

	public ICFGenKbTSecGroupObj getRequiredParentSubGroup() {
		return( getRequiredParentSubGroup( false ) );
	}

	public ICFGenKbTSecGroupObj getRequiredParentSubGroup( boolean forceRead ) {
		if( forceRead || ( requiredParentSubGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTSecGroupObj obj = ((ICFGenKbSchemaObj)getOrigAsTSecGrpInc().getSchema()).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
					getTSecGrpIncBuff().getRequiredIncludeGroupId() );
				requiredParentSubGroup = obj;
			}
		}
		return( requiredParentSubGroup );
	}

	public void setRequiredParentSubGroup( ICFGenKbTSecGroupObj value ) {
			if( buff == null ) {
				getTSecGrpIncBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTSecGrpIncBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTSecGrpIncBuff().setRequiredIncludeGroupId( value.getRequiredTSecGroupId() );
			}
			else {
			}
			requiredParentSubGroup = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredTSecGrpIncId( getPKey().getRequiredTSecGrpIncId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredTSecGrpIncId( buff.getRequiredTSecGrpIncId() );
	}

	public void copyBuffToOrig() {
		CFGenKbTSecGrpIncBuff origBuff = getOrigAsTSecGrpInc().getTSecGrpIncBuff();
		CFGenKbTSecGrpIncBuff myBuff = getTSecGrpIncBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbTSecGrpIncBuff origBuff = getOrigAsTSecGrpInc().getTSecGrpIncBuff();
		CFGenKbTSecGrpIncBuff myBuff = getTSecGrpIncBuff();
		myBuff.set( origBuff );
	}
}
