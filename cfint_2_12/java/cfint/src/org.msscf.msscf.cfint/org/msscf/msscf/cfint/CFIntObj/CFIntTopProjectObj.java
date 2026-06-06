// Description: Java 11 base object instance implementation for CFInt TopProject.

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

public class CFIntTopProjectObj
	implements ICFIntTopProjectObj
{
	public final static String CLASS_CODE = "TPRJ";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFIntTopProjectEditObj edit;
	protected ICFIntSchemaObj schema;
	protected CFIntTopProjectPKey pKey;
	protected CFIntTopProjectBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFIntTopDomainObj requiredContainerParentSDom;

	public CFIntTopProjectObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	public CFIntTopProjectObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFIntTopProjectObj retobj = ((ICFIntSchemaObj)schema).getTopProjectTableObj().realiseTopProject(
			(ICFIntTopProjectObj)this );
		return( (ICFIntTopProjectObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getTopProjectTableObj().forgetTopProject( (ICFIntTopProjectObj)this, forgetSubObjects );
	}

	public ICFIntTopProjectObj read() {
		ICFIntTopProjectObj retobj = ((ICFIntSchemaObj)schema).getTopProjectTableObj().readTopProjectByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFIntTopProjectObj)retobj );
	}

	public ICFIntTopProjectObj read( boolean forceRead ) {
		ICFIntTopProjectObj retobj = ((ICFIntSchemaObj)schema).getTopProjectTableObj().readTopProjectByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFIntTopProjectObj)retobj );
	}

	public ICFIntTopProjectTableObj getTopProjectTable() {
		return( ((ICFIntSchemaObj)schema).getTopProjectTableObj() );
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public CFIntTopProjectBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableTopProject().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFIntTopProjectBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFIntTopProjectBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFIntTopProjectBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	public CFIntTopProjectBuff getTopProjectBuff() {
		return( (CFIntTopProjectBuff)getBuff() );
	}

	public CFIntTopProjectPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopProject().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFIntTopProjectPKey value ) {
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

	public ICFIntTopProjectEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFIntTopProjectObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFIntTopProjectObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getTopProjectTableObj().lockTopProject( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getTopProjectTableObj().newEditInstance( lockobj );
		return( (ICFIntTopProjectEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFIntTopProjectEditObj getEdit() {
		return( edit );
	}

	public ICFIntTopProjectEditObj getEditAsTopProject() {
		return( (ICFIntTopProjectEditObj)edit );
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

	public String getOptionalDescription() {
		return( getTopProjectBuff().getOptionalDescription() );
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFIntSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFIntTopDomainObj getRequiredContainerParentSDom() {
		return( getRequiredContainerParentSDom( false ) );
	}

	public ICFIntTopDomainObj getRequiredContainerParentSDom( boolean forceRead ) {
		if( ( requiredContainerParentSDom == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentSDom = ((ICFIntSchemaObj)schema).getTopDomainTableObj().readTopDomainByIdIdx( getPKey().getRequiredTenantId(),
					getTopProjectBuff().getRequiredTopDomainId(), forceRead );
			}
		}
		return( requiredContainerParentSDom );
	}

	public List<ICFIntSubProjectObj> getOptionalComponentsSubProject() {
		List<ICFIntSubProjectObj> retval;
		retval = ((ICFIntSchemaObj)schema).getSubProjectTableObj().readSubProjectByTopProjectIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntSubProjectObj> getOptionalComponentsSubProject( boolean forceRead ) {
		List<ICFIntSubProjectObj> retval;
		retval = ((ICFIntSchemaObj)schema).getSubProjectTableObj().readSubProjectByTopProjectIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredId( getPKey().getRequiredId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}
}
