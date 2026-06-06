// Description: Java 11 edit object instance implementation for CFGenKb SecGroup.

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

public class CFGenKbSecGroupEditObj
	implements ICFGenKbSecGroupEditObj
{
	protected ICFGenKbSecGroupObj orig;
	protected CFGenKbSecGroupBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbSecGroupEditObj( ICFGenKbSecGroupObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecGroupBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerCluster = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbSecGroupBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbSecGroupBuff buff = getBuff();
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
		return( CFGenKbSecGroupObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecGroup" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbClusterObj scope = getRequiredContainerCluster();
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

	public ICFGenKbSecGroupObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecGroupObj retobj = getSchema().getSecGroupTableObj().realiseSecGroup( (ICFGenKbSecGroupObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGroupTableObj().forgetSecGroup( getOrigAsSecGroup(), forgetSubObjects );
	}

	public ICFGenKbSecGroupObj read() {
		ICFGenKbSecGroupObj retval = getOrigAsSecGroup().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecGroupObj read( boolean forceRead ) {
		ICFGenKbSecGroupObj retval = getOrigAsSecGroup().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecGroupObj create() {
		copyBuffToOrig();
		ICFGenKbSecGroupObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGroupTableObj().createSecGroup( getOrigAsSecGroup() );
		if( retobj == getOrigAsSecGroup() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecGroupEditObj update() {
		getSchema().getSecGroupTableObj().updateSecGroup( (ICFGenKbSecGroupObj)this );
		return( null );
	}

	public CFGenKbSecGroupEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecGroupTableObj().deleteSecGroup( getOrigAsSecGroup() );
		return( null );
	}

	public ICFGenKbSecGroupTableObj getSecGroupTable() {
		return( orig.getSchema().getSecGroupTableObj() );
	}

	public ICFGenKbSecGroupEditObj getEdit() {
		return( (ICFGenKbSecGroupEditObj)this );
	}

	public ICFGenKbSecGroupEditObj getEditAsSecGroup() {
		return( (ICFGenKbSecGroupEditObj)this );
	}

	public ICFGenKbSecGroupEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecGroupObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecGroupObj getOrigAsSecGroup() {
		return( (ICFGenKbSecGroupObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecGroupBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecGroup().getSchema().getBackingStore()).getFactorySecGroup().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecGroupBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerCluster = null;
		}
	}

	public CFGenKbSecGroupBuff getSecGroupBuff() {
		return( (CFGenKbSecGroupBuff)getBuff() );
	}

	public CFGenKbSecGroupPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecGroupPKey value ) {
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

	public int getRequiredSecGroupId() {
		return( getPKey().getRequiredSecGroupId() );
	}

	public String getRequiredName() {
		return( getSecGroupBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getSecGroupBuff().getRequiredName() != value ) {
			getSecGroupBuff().setRequiredName( value );
		}
	}

	public boolean getRequiredIsVisible() {
		return( getSecGroupBuff().getRequiredIsVisible() );
	}

	public void setRequiredIsVisible( boolean value ) {
		if( getSecGroupBuff().getRequiredIsVisible() != value ) {
			getSecGroupBuff().setRequiredIsVisible( value );
		}
	}

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( forceRead || ( requiredContainerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbClusterObj obj = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId() );
				requiredContainerCluster = obj;
				if( obj != null ) {
					getSecGroupBuff().setRequiredClusterId( obj.getRequiredId() );
					requiredContainerCluster = obj;
				}
			}
		}
		return( requiredContainerCluster );
	}

	public void setRequiredContainerCluster( ICFGenKbClusterObj value ) {
			if( buff == null ) {
				getSecGroupBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredId() );
				getSecGroupBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredContainerCluster = value;
	}

	public List<ICFGenKbSecGrpIncObj> getOptionalComponentsInclude() {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGrpIncTableObj().readSecGrpIncByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpIncObj> getOptionalComponentsInclude( boolean forceRead ) {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGrpIncTableObj().readSecGrpIncByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalComponentsMember() {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGrpMembTableObj().readSecGrpMembByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalComponentsMember( boolean forceRead ) {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGrpMembTableObj().readSecGrpMembByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGrpIncObj> getRequiredChildrenIncByGroup() {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGrpIncTableObj().readSecGrpIncByIncludeIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpIncObj> getRequiredChildrenIncByGroup( boolean forceRead ) {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGrpIncTableObj().readSecGrpIncByIncludeIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGroupFormObj> getOptionalComponentsForm() {
		List<ICFGenKbSecGroupFormObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGroupFormTableObj().readSecGroupFormByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGroupFormObj> getOptionalComponentsForm( boolean forceRead ) {
		List<ICFGenKbSecGroupFormObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecGroup().getSchema()).getSecGroupFormTableObj().readSecGroupFormByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
		buff.setRequiredSecGroupId( getPKey().getRequiredSecGroupId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecGroupId( buff.getRequiredSecGroupId() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecGroupBuff origBuff = getOrigAsSecGroup().getSecGroupBuff();
		CFGenKbSecGroupBuff myBuff = getSecGroupBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecGroupBuff origBuff = getOrigAsSecGroup().getSecGroupBuff();
		CFGenKbSecGroupBuff myBuff = getSecGroupBuff();
		myBuff.set( origBuff );
	}
}
