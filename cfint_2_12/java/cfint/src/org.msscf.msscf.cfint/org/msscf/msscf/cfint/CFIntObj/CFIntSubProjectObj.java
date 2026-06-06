// Description: Java 11 base object instance implementation for CFInt SubProject.

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

public class CFIntSubProjectObj
	implements ICFIntSubProjectObj
{
	public final static String CLASS_CODE = "SPRJ";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFIntSubProjectEditObj edit;
	protected ICFIntSchemaObj schema;
	protected CFIntSubProjectPKey pKey;
	protected CFIntSubProjectBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFIntTopProjectObj requiredContainerParentTPrj;

	public CFIntSubProjectObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	public CFIntSubProjectObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SubProject" );
	}

	public ICFLibAnyObj getScope() {
		ICFIntTopProjectObj scope = getRequiredContainerParentTPrj();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFIntTopProjectObj scope = getRequiredContainerParentTPrj();
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
			subObj = ((ICFIntSchemaObj)getSchema()).getMajorVersionTableObj().readMajorVersionByNameIdx( getRequiredTenantId(),
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

	public ICFIntSubProjectObj realise() {
		ICFIntSubProjectObj retobj = ((ICFIntSchemaObj)schema).getSubProjectTableObj().realiseSubProject(
			(ICFIntSubProjectObj)this );
		return( (ICFIntSubProjectObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getSubProjectTableObj().forgetSubProject( (ICFIntSubProjectObj)this, forgetSubObjects );
	}

	public ICFIntSubProjectObj read() {
		ICFIntSubProjectObj retobj = ((ICFIntSchemaObj)schema).getSubProjectTableObj().readSubProjectByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFIntSubProjectObj)retobj );
	}

	public ICFIntSubProjectObj read( boolean forceRead ) {
		ICFIntSubProjectObj retobj = ((ICFIntSchemaObj)schema).getSubProjectTableObj().readSubProjectByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFIntSubProjectObj)retobj );
	}

	public ICFIntSubProjectTableObj getSubProjectTable() {
		return( ((ICFIntSchemaObj)schema).getSubProjectTableObj() );
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public CFIntSubProjectBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactorySubProject().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableSubProject().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFIntSubProjectBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFIntSubProjectBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFIntSubProjectBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	public CFIntSubProjectBuff getSubProjectBuff() {
		return( (CFIntSubProjectBuff)getBuff() );
	}

	public CFIntSubProjectPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactorySubProject().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFIntSubProjectPKey value ) {
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

	public ICFIntSubProjectEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFIntSubProjectObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFIntSubProjectObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getSubProjectTableObj().lockSubProject( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getSubProjectTableObj().newEditInstance( lockobj );
		return( (ICFIntSubProjectEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFIntSubProjectEditObj getEdit() {
		return( edit );
	}

	public ICFIntSubProjectEditObj getEditAsSubProject() {
		return( (ICFIntSubProjectEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntSubProjectBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntSubProjectBuff buff = getBuff();
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

	public long getRequiredTopProjectId() {
		return( getSubProjectBuff().getRequiredTopProjectId() );
	}

	public String getRequiredName() {
		return( getSubProjectBuff().getRequiredName() );
	}

	public String getOptionalDescription() {
		return( getSubProjectBuff().getOptionalDescription() );
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

	public ICFIntTopProjectObj getRequiredContainerParentTPrj() {
		return( getRequiredContainerParentTPrj( false ) );
	}

	public ICFIntTopProjectObj getRequiredContainerParentTPrj( boolean forceRead ) {
		if( ( requiredContainerParentTPrj == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentTPrj = ((ICFIntSchemaObj)schema).getTopProjectTableObj().readTopProjectByIdIdx( getPKey().getRequiredTenantId(),
					getSubProjectBuff().getRequiredTopProjectId(), forceRead );
			}
		}
		return( requiredContainerParentTPrj );
	}

	public List<ICFIntMajorVersionObj> getOptionalComponentsMajorVer() {
		List<ICFIntMajorVersionObj> retval;
		retval = ((ICFIntSchemaObj)schema).getMajorVersionTableObj().readMajorVersionBySubProjectIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntMajorVersionObj> getOptionalComponentsMajorVer( boolean forceRead ) {
		List<ICFIntMajorVersionObj> retval;
		retval = ((ICFIntSchemaObj)schema).getMajorVersionTableObj().readMajorVersionBySubProjectIdx( getPKey().getRequiredTenantId(),
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
