// Description: Java 11 base object instance implementation for CFGenKb SecGroup.

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

public class CFGenKbSecGroupObj
	implements ICFGenKbSecGroupObj
{
	public final static String CLASS_CODE = "SGRP";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbSecGroupEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbSecGroupPKey pKey;
	protected CFGenKbSecGroupBuff buff;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbSecGroupObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFGenKbSecGroupObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerCluster = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbSecGroupObj retobj = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().realiseSecGroup(
			(ICFGenKbSecGroupObj)this );
		return( (ICFGenKbSecGroupObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getSecGroupTableObj().forgetSecGroup( (ICFGenKbSecGroupObj)this, forgetSubObjects );
	}

	public ICFGenKbSecGroupObj read() {
		ICFGenKbSecGroupObj retobj = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().readSecGroupByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecGroupId(), false );
		return( (ICFGenKbSecGroupObj)retobj );
	}

	public ICFGenKbSecGroupObj read( boolean forceRead ) {
		ICFGenKbSecGroupObj retobj = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().readSecGroupByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecGroupId(), forceRead );
		return( (ICFGenKbSecGroupObj)retobj );
	}

	public ICFGenKbSecGroupTableObj getSecGroupTable() {
		return( ((ICFGenKbSchemaObj)schema).getSecGroupTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbSecGroupBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecGroup().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredClusterId(),
						getPKey().getRequiredSecGroupId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecGroupBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbSecGroupBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbSecGroupBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFGenKbSecGroupBuff getSecGroupBuff() {
		return( (CFGenKbSecGroupBuff)getBuff() );
	}

	public CFGenKbSecGroupPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecGroup().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbSecGroupPKey value ) {
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

	public ICFGenKbSecGroupEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbSecGroupObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbSecGroupObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().lockSecGroup( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().newEditInstance( lockobj );
		return( (ICFGenKbSecGroupEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbSecGroupEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbSecGroupEditObj getEditAsSecGroup() {
		return( (ICFGenKbSecGroupEditObj)edit );
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

	public long getRequiredClusterId() {
		return( getPKey().getRequiredClusterId() );
	}

	public int getRequiredSecGroupId() {
		return( getPKey().getRequiredSecGroupId() );
	}

	public String getRequiredName() {
		return( getSecGroupBuff().getRequiredName() );
	}

	public boolean getRequiredIsVisible() {
		return( getSecGroupBuff().getRequiredIsVisible() );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = ((ICFGenKbSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredContainerCluster );
	}

	public List<ICFGenKbSecGrpIncObj> getOptionalComponentsInclude() {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpIncTableObj().readSecGrpIncByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpIncObj> getOptionalComponentsInclude( boolean forceRead ) {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpIncTableObj().readSecGrpIncByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalComponentsMember() {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpMembTableObj().readSecGrpMembByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpMembObj> getOptionalComponentsMember( boolean forceRead ) {
		List<ICFGenKbSecGrpMembObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpMembTableObj().readSecGrpMembByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGrpIncObj> getRequiredChildrenIncByGroup() {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpIncTableObj().readSecGrpIncByIncludeIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGrpIncObj> getRequiredChildrenIncByGroup( boolean forceRead ) {
		List<ICFGenKbSecGrpIncObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGrpIncTableObj().readSecGrpIncByIncludeIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGroupFormObj> getOptionalComponentsForm() {
		List<ICFGenKbSecGroupFormObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGroupFormTableObj().readSecGroupFormByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGroupFormObj> getOptionalComponentsForm( boolean forceRead ) {
		List<ICFGenKbSecGroupFormObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGroupFormTableObj().readSecGroupFormByGroupIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecGroupId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
			buff.setRequiredSecGroupId( getPKey().getRequiredSecGroupId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecGroupId( buff.getRequiredSecGroupId() );
	}
}
