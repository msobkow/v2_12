// Description: Java 11 edit object instance implementation for CFGenKb TSecGroup.

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

public class CFGenKbTSecGroupEditObj
	implements ICFGenKbTSecGroupEditObj
{
	protected ICFGenKbTSecGroupObj orig;
	protected CFGenKbTSecGroupBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbTenantObj requiredContainerTenant;

	public CFGenKbTSecGroupEditObj( ICFGenKbTSecGroupObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbTSecGroupBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerTenant = null;
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
		return( CFGenKbTSecGroupObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbTSecGroupObj retobj = getSchema().getTSecGroupTableObj().realiseTSecGroup( (ICFGenKbTSecGroupObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGroupTableObj().forgetTSecGroup( getOrigAsTSecGroup(), forgetSubObjects );
	}

	public ICFGenKbTSecGroupObj read() {
		ICFGenKbTSecGroupObj retval = getOrigAsTSecGroup().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbTSecGroupObj read( boolean forceRead ) {
		ICFGenKbTSecGroupObj retval = getOrigAsTSecGroup().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbTSecGroupObj create() {
		copyBuffToOrig();
		ICFGenKbTSecGroupObj retobj = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGroupTableObj().createTSecGroup( getOrigAsTSecGroup() );
		if( retobj == getOrigAsTSecGroup() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbTSecGroupEditObj update() {
		getSchema().getTSecGroupTableObj().updateTSecGroup( (ICFGenKbTSecGroupObj)this );
		return( null );
	}

	public CFGenKbTSecGroupEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getTSecGroupTableObj().deleteTSecGroup( getOrigAsTSecGroup() );
		return( null );
	}

	public ICFGenKbTSecGroupTableObj getTSecGroupTable() {
		return( orig.getSchema().getTSecGroupTableObj() );
	}

	public ICFGenKbTSecGroupEditObj getEdit() {
		return( (ICFGenKbTSecGroupEditObj)this );
	}

	public ICFGenKbTSecGroupEditObj getEditAsTSecGroup() {
		return( (ICFGenKbTSecGroupEditObj)this );
	}

	public ICFGenKbTSecGroupEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbTSecGroupObj getOrig() {
		return( orig );
	}

	public ICFGenKbTSecGroupObj getOrigAsTSecGroup() {
		return( (ICFGenKbTSecGroupObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbTSecGroupBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsTSecGroup().getSchema().getBackingStore()).getFactoryTSecGroup().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbTSecGroupBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerTenant = null;
		}
	}

	public CFGenKbTSecGroupBuff getTSecGroupBuff() {
		return( (CFGenKbTSecGroupBuff)getBuff() );
	}

	public CFGenKbTSecGroupPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbTSecGroupPKey value ) {
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

	public int getRequiredTSecGroupId() {
		return( getPKey().getRequiredTSecGroupId() );
	}

	public String getRequiredName() {
		return( getTSecGroupBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getTSecGroupBuff().getRequiredName() != value ) {
			getTSecGroupBuff().setRequiredName( value );
		}
	}

	public boolean getRequiredIsVisible() {
		return( getTSecGroupBuff().getRequiredIsVisible() );
	}

	public void setRequiredIsVisible( boolean value ) {
		if( getTSecGroupBuff().getRequiredIsVisible() != value ) {
			getTSecGroupBuff().setRequiredIsVisible( value );
		}
	}

	public ICFGenKbTenantObj getRequiredContainerTenant() {
		return( getRequiredContainerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredContainerTenant( boolean forceRead ) {
		if( forceRead || ( requiredContainerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTenantObj obj = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredContainerTenant = obj;
				if( obj != null ) {
					getTSecGroupBuff().setRequiredTenantId( obj.getRequiredId() );
					requiredContainerTenant = obj;
				}
			}
		}
		return( requiredContainerTenant );
	}

	public void setRequiredContainerTenant( ICFGenKbTenantObj value ) {
			if( buff == null ) {
				getTSecGroupBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getTSecGroupBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredContainerTenant = value;
	}

	public List<ICFGenKbTSecGrpIncObj> getOptionalComponentsInclude() {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGrpIncTableObj().readTSecGrpIncByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpIncObj> getOptionalComponentsInclude( boolean forceRead ) {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGrpIncTableObj().readTSecGrpIncByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalComponentsMember() {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGrpMembTableObj().readTSecGrpMembByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpMembObj> getOptionalComponentsMember( boolean forceRead ) {
		List<ICFGenKbTSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGrpMembTableObj().readTSecGrpMembByGroupIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTSecGrpIncObj> getRequiredChildrenIncByGroup() {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGrpIncTableObj().readTSecGrpIncByIncludeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTSecGrpIncObj> getRequiredChildrenIncByGroup( boolean forceRead ) {
		List<ICFGenKbTSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsTSecGroup().getSchema()).getTSecGrpIncTableObj().readTSecGrpIncByIncludeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredTSecGroupId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredTSecGroupId( getPKey().getRequiredTSecGroupId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredTSecGroupId( buff.getRequiredTSecGroupId() );
	}

	public void copyBuffToOrig() {
		CFGenKbTSecGroupBuff origBuff = getOrigAsTSecGroup().getTSecGroupBuff();
		CFGenKbTSecGroupBuff myBuff = getTSecGroupBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbTSecGroupBuff origBuff = getOrigAsTSecGroup().getTSecGroupBuff();
		CFGenKbTSecGroupBuff myBuff = getTSecGroupBuff();
		myBuff.set( origBuff );
	}
}
