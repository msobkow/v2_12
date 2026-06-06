// Description: Java 11 edit object instance implementation for CFGenKb Cluster.

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

public class CFGenKbClusterEditObj
	implements ICFGenKbClusterEditObj
{
	protected ICFGenKbClusterObj orig;
	protected CFGenKbClusterBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;

	public CFGenKbClusterEditObj( ICFGenKbClusterObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbClusterBuff origBuff = orig.getBuff();
		buff.set( origBuff );
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbClusterBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbClusterBuff buff = getBuff();
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
		return( CFGenKbClusterObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Cluster" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredFullDomName();
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
			subObj = ((ICFGenKbSchemaObj)getSchema()).getHostNodeTableObj().readHostNodeByHostNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getTenantTableObj().readTenantByUNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getSecAppTableObj().readSecAppByUJEEMountIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getSecGroupTableObj().readSecGroupByUNameIdx( getRequiredId(),
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

	public ICFGenKbClusterObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbClusterObj retobj = getSchema().getClusterTableObj().realiseCluster( (ICFGenKbClusterObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getClusterTableObj().forgetCluster( getOrigAsCluster(), forgetSubObjects );
	}

	public ICFGenKbClusterObj read() {
		ICFGenKbClusterObj retval = getOrigAsCluster().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbClusterObj read( boolean forceRead ) {
		ICFGenKbClusterObj retval = getOrigAsCluster().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbClusterObj create() {
		copyBuffToOrig();
		ICFGenKbClusterObj retobj = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getClusterTableObj().createCluster( getOrigAsCluster() );
		if( retobj == getOrigAsCluster() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbClusterEditObj update() {
		getSchema().getClusterTableObj().updateCluster( (ICFGenKbClusterObj)this );
		return( null );
	}

	public CFGenKbClusterEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getClusterTableObj().deleteCluster( getOrigAsCluster() );
		return( null );
	}

	public ICFGenKbClusterTableObj getClusterTable() {
		return( orig.getSchema().getClusterTableObj() );
	}

	public ICFGenKbClusterEditObj getEdit() {
		return( (ICFGenKbClusterEditObj)this );
	}

	public ICFGenKbClusterEditObj getEditAsCluster() {
		return( (ICFGenKbClusterEditObj)this );
	}

	public ICFGenKbClusterEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbClusterObj getOrig() {
		return( orig );
	}

	public ICFGenKbClusterObj getOrigAsCluster() {
		return( (ICFGenKbClusterObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbClusterBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsCluster().getSchema().getBackingStore()).getFactoryCluster().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbClusterBuff value ) {
		if( buff != value ) {
			buff = value;
		}
	}

	public CFGenKbClusterBuff getClusterBuff() {
		return( (CFGenKbClusterBuff)getBuff() );
	}

	public CFGenKbClusterPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbClusterPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredFullDomName() {
		return( getClusterBuff().getRequiredFullDomName() );
	}

	public void setRequiredFullDomName( String value ) {
		if( getClusterBuff().getRequiredFullDomName() != value ) {
			getClusterBuff().setRequiredFullDomName( value );
		}
	}

	public String getRequiredDescription() {
		return( getClusterBuff().getRequiredDescription() );
	}

	public void setRequiredDescription( String value ) {
		if( getClusterBuff().getRequiredDescription() != value ) {
			getClusterBuff().setRequiredDescription( value );
		}
	}

	public List<ICFGenKbHostNodeObj> getOptionalComponentsHostNode() {
		List<ICFGenKbHostNodeObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbHostNodeObj> getOptionalComponentsHostNode( boolean forceRead ) {
		List<ICFGenKbHostNodeObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTenantObj> getOptionalComponentsTenant() {
		List<ICFGenKbTenantObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTenantObj> getOptionalComponentsTenant( boolean forceRead ) {
		List<ICFGenKbTenantObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecAppObj> getOptionalComponentsSecApp() {
		List<ICFGenKbSecAppObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getSecAppTableObj().readSecAppByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecAppObj> getOptionalComponentsSecApp( boolean forceRead ) {
		List<ICFGenKbSecAppObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getSecAppTableObj().readSecAppByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGroupObj> getOptionalComponentsSecGroup() {
		List<ICFGenKbSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGroupObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ICFGenKbSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSysClusterObj> getOptionalComponentsSysCluster() {
		List<ICFGenKbSysClusterObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead ) {
		List<ICFGenKbSysClusterObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsCluster().getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFGenKbClusterBuff origBuff = getOrigAsCluster().getClusterBuff();
		CFGenKbClusterBuff myBuff = getClusterBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbClusterBuff origBuff = getOrigAsCluster().getClusterBuff();
		CFGenKbClusterBuff myBuff = getClusterBuff();
		myBuff.set( origBuff );
	}
}
