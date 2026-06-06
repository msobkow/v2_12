// Description: Java 11 edit object instance implementation for CFInt TopProject.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntTopProjectEditObj
	implements ICFIntTopProjectEditObj
{
	protected ICFIntTopProjectObj orig;
	protected CFIntTopProjectBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFIntTopDomainObj requiredContainerParentSDom;

	public CFIntTopProjectEditObj( ICFIntTopProjectObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFIntTopProjectBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntTopProjectBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntTopProjectBuff buff = getBuff();
			updatedBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
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
		return( CFIntTopProjectObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TopProject" );
	}

	public ICFLibAnyObj getScope() {
		ICFIntTopDomainObj scope = getRequiredContainerParentSDom();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFIntTopDomainObj scope = getRequiredContainerParentSDom();
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
		if( subObj == null ) {
			subObj = ((ICFIntSchemaObj)getSchema()).getSubProjectTableObj().readSubProjectByNameIdx( getRequiredTenantId(),
				getRequiredId(),
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
			else if( container instanceof ICFIntTenantObj ) {
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

	public ICFIntTopProjectObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFIntTopProjectObj retobj = getSchema().getTopProjectTableObj().realiseTopProject( (ICFIntTopProjectObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFIntSchemaObj)getOrigAsTopProject().getSchema()).getTopProjectTableObj().forgetTopProject( getOrigAsTopProject(), forgetSubObjects );
	}

	public ICFIntTopProjectObj read() {
		ICFIntTopProjectObj retval = getOrigAsTopProject().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntTopProjectObj read( boolean forceRead ) {
		ICFIntTopProjectObj retval = getOrigAsTopProject().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntTopProjectObj create() {
		copyBuffToOrig();
		ICFIntTopProjectObj retobj = ((ICFIntSchemaObj)getOrigAsTopProject().getSchema()).getTopProjectTableObj().createTopProject( getOrigAsTopProject() );
		if( retobj == getOrigAsTopProject() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFIntTopProjectEditObj update() {
		getSchema().getTopProjectTableObj().updateTopProject( (ICFIntTopProjectObj)this );
		return( null );
	}

	public CFIntTopProjectEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getTopProjectTableObj().deleteTopProject( getOrigAsTopProject() );
		return( null );
	}

	public ICFIntTopProjectTableObj getTopProjectTable() {
		return( orig.getSchema().getTopProjectTableObj() );
	}

	public ICFIntTopProjectEditObj getEdit() {
		return( (ICFIntTopProjectEditObj)this );
	}

	public ICFIntTopProjectEditObj getEditAsTopProject() {
		return( (ICFIntTopProjectEditObj)this );
	}

	public ICFIntTopProjectEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFIntTopProjectObj getOrig() {
		return( orig );
	}

	public ICFIntTopProjectObj getOrigAsTopProject() {
		return( (ICFIntTopProjectObj)orig );
	}

	public ICFIntSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFIntTopProjectBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFIntSchema)getOrigAsTopProject().getSchema().getBackingStore()).getFactoryTopProject().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFIntTopProjectBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerParentSDom = null;
		}
	}

	public CFIntTopProjectBuff getTopProjectBuff() {
		return( (CFIntTopProjectBuff)getBuff() );
	}

	public CFIntTopProjectPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFIntTopProjectPKey value ) {
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

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public long getRequiredTopDomainId() {
		return( getTopProjectBuff().getRequiredTopDomainId() );
	}

	public String getRequiredName() {
		return( getTopProjectBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getTopProjectBuff().getRequiredName() != value ) {
			getTopProjectBuff().setRequiredName( value );
		}
	}

	public String getOptionalDescription() {
		return( getTopProjectBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getTopProjectBuff().getOptionalDescription() != value ) {
			getTopProjectBuff().setOptionalDescription( value );
		}
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFIntSchemaObj)getOrigAsTopProject().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getTopProjectBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getTopProjectBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFIntTopDomainObj getRequiredContainerParentSDom() {
		return( getRequiredContainerParentSDom( false ) );
	}

	public ICFIntTopDomainObj getRequiredContainerParentSDom( boolean forceRead ) {
		if( forceRead || ( requiredContainerParentSDom == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFIntTopDomainObj obj = ((ICFIntSchemaObj)getOrigAsTopProject().getSchema()).getTopDomainTableObj().readTopDomainByIdIdx( getPKey().getRequiredTenantId(),
					getTopProjectBuff().getRequiredTopDomainId() );
				requiredContainerParentSDom = obj;
				if( obj != null ) {
					getTopProjectBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getTopProjectBuff().setRequiredTopDomainId( obj.getRequiredId() );
					requiredContainerParentSDom = obj;
				}
			}
		}
		return( requiredContainerParentSDom );
	}

	public void setRequiredContainerParentSDom( ICFIntTopDomainObj value ) {
			if( buff == null ) {
				getTopProjectBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTopProjectBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTopProjectBuff().setRequiredTopDomainId( value.getRequiredId() );
			}
			requiredContainerParentSDom = value;
	}

	public List<ICFIntSubProjectObj> getOptionalComponentsSubProject() {
		List<ICFIntSubProjectObj> retval;
		retval = ((ICFIntSchemaObj)getOrigAsTopProject().getSchema()).getSubProjectTableObj().readSubProjectByTopProjectIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntSubProjectObj> getOptionalComponentsSubProject( boolean forceRead ) {
		List<ICFIntSubProjectObj> retval;
		retval = ((ICFIntSchemaObj)getOrigAsTopProject().getSchema()).getSubProjectTableObj().readSubProjectByTopProjectIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFIntTopProjectBuff origBuff = getOrigAsTopProject().getTopProjectBuff();
		CFIntTopProjectBuff myBuff = getTopProjectBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFIntTopProjectBuff origBuff = getOrigAsTopProject().getTopProjectBuff();
		CFIntTopProjectBuff myBuff = getTopProjectBuff();
		myBuff.set( origBuff );
	}
}
