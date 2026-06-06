// Description: Java 11 edit object instance implementation for CFBam Cluster.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public class CFBamClusterEditObj
	implements ICFBamClusterEditObj
{
	protected ICFSecClusterObj orig;
	protected CFSecClusterBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;

	public CFBamClusterEditObj( ICFSecClusterObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFSecClusterBuff origBuff = orig.getBuff();
		buff.set( origBuff );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecClusterBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecClusterBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public void setCreatedBy( ICFSecSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getBuff().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setCreatedAt( Calendar value ) {
		getBuff().setCreatedAt( value );
	}

	public void setUpdatedBy( ICFSecSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getBuff().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setUpdatedAt( Calendar value ) {
		getBuff().setUpdatedAt( value );
	}

	public String getClassCode() {
		return( CFBamClusterObj.CLASS_CODE );
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
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
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
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
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
			subObj = ((ICFBamSchemaObj)getSchema()).getHostNodeTableObj().readHostNodeByHostNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getTenantTableObj().readTenantByUNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getSecAppTableObj().readSecAppByUJEEMountIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getSecGroupTableObj().readSecGroupByUNameIdx( getRequiredId(),
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

	public ICFSecClusterObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFSecClusterObj retobj = getSchema().getClusterTableObj().realiseCluster( (ICFBamClusterObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getClusterTableObj().forgetCluster( getOrigAsCluster(), forgetSubObjects );
	}

	public ICFSecClusterObj read() {
		ICFSecClusterObj retval = getOrigAsCluster().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFSecClusterObj read( boolean forceRead ) {
		ICFSecClusterObj retval = getOrigAsCluster().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFSecClusterObj create() {
		copyBuffToOrig();
		ICFSecClusterObj retobj = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getClusterTableObj().createCluster( getOrigAsCluster() );
		if( retobj == getOrigAsCluster() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFSecClusterEditObj update() {
		getSchema().getClusterTableObj().updateCluster( (ICFSecClusterObj)this );
		return( null );
	}

	public CFSecClusterEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getClusterTableObj().deleteCluster( getOrigAsCluster() );
		return( null );
	}

	public ICFSecClusterTableObj getClusterTable() {
		return( orig.getSchema().getClusterTableObj() );
	}

	public ICFSecClusterEditObj getEdit() {
		return( (ICFSecClusterEditObj)this );
	}

	public ICFSecClusterEditObj getEditAsCluster() {
		return( (ICFSecClusterEditObj)this );
	}

	public ICFSecClusterEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFSecClusterObj getOrig() {
		return( orig );
	}

	public ICFSecClusterObj getOrigAsCluster() {
		return( (ICFSecClusterObj)orig );
	}

	public ICFSecSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFSecClusterBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsCluster().getSchema().getBackingStore()).getFactoryCluster().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFSecClusterBuff value ) {
		if( buff != value ) {
			buff = value;
		}
	}

	public CFSecClusterBuff getClusterBuff() {
		return( (CFSecClusterBuff)getBuff() );
	}

	public CFSecClusterPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFSecClusterPKey value ) {
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

	public List<ICFSecHostNodeObj> getOptionalComponentsHostNode() {
		List<ICFSecHostNodeObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFSecHostNodeObj> getOptionalComponentsHostNode( boolean forceRead ) {
		List<ICFSecHostNodeObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFSecTenantObj> getOptionalComponentsTenant() {
		List<ICFSecTenantObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFSecTenantObj> getOptionalComponentsTenant( boolean forceRead ) {
		List<ICFSecTenantObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFSecSecAppObj> getOptionalComponentsSecApp() {
		List<ICFSecSecAppObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getSecAppTableObj().readSecAppByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFSecSecAppObj> getOptionalComponentsSecApp( boolean forceRead ) {
		List<ICFSecSecAppObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getSecAppTableObj().readSecAppByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFSecSecGroupObj> getOptionalComponentsSecGroup() {
		List<ICFSecSecGroupObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFSecSecGroupObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ICFSecSecGroupObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFSecSysClusterObj> getOptionalComponentsSysCluster() {
		List<ICFSecSysClusterObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFSecSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead ) {
		List<ICFSecSysClusterObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsCluster().getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey().getRequiredId(),
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
		CFSecClusterBuff origBuff = getOrigAsCluster().getClusterBuff();
		CFSecClusterBuff myBuff = getClusterBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFSecClusterBuff origBuff = getOrigAsCluster().getClusterBuff();
		CFSecClusterBuff myBuff = getClusterBuff();
		myBuff.set( origBuff );
	}
}
