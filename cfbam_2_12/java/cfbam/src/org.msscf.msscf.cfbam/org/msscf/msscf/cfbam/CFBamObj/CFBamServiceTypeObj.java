// Description: Java 11 base object instance implementation for CFBam ServiceType.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamServiceTypeObj
	implements ICFBamServiceTypeObj
{
	public final static String CLASS_CODE = "SVCT";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecServiceTypeEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecServiceTypePKey pKey;
	protected CFSecServiceTypeBuff buff;

	public CFBamServiceTypeObj() {
		isNew = true;
	}

	public CFBamServiceTypeObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ServiceType" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredDescription();
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

	public ICFSecServiceTypeObj realise() {
		ICFSecServiceTypeObj retobj = ((ICFBamSchemaObj)schema).getServiceTypeTableObj().realiseServiceType(
			(ICFSecServiceTypeObj)this );
		return( (ICFSecServiceTypeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getServiceTypeTableObj().forgetServiceType( (ICFSecServiceTypeObj)this, forgetSubObjects );
	}

	public ICFSecServiceTypeObj read() {
		ICFSecServiceTypeObj retobj = ((ICFBamSchemaObj)schema).getServiceTypeTableObj().readServiceTypeByIdIdx( getPKey().getRequiredServiceTypeId(), false );
		return( (ICFSecServiceTypeObj)retobj );
	}

	public ICFSecServiceTypeObj read( boolean forceRead ) {
		ICFSecServiceTypeObj retobj = ((ICFBamSchemaObj)schema).getServiceTypeTableObj().readServiceTypeByIdIdx( getPKey().getRequiredServiceTypeId(), forceRead );
		return( (ICFSecServiceTypeObj)retobj );
	}

	public ICFSecServiceTypeTableObj getServiceTypeTable() {
		return( ((ICFBamSchemaObj)schema).getServiceTypeTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecServiceTypeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryServiceType().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableServiceType().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredServiceTypeId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecServiceTypeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecServiceTypeBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecServiceTypeBuff" );
		}
		buff = value;
		copyBuffToPKey();
	}

	public CFSecServiceTypeBuff getServiceTypeBuff() {
		return( (CFSecServiceTypeBuff)getBuff() );
	}

	public CFSecServiceTypePKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryServiceType().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecServiceTypePKey value ) {
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

	public ICFSecServiceTypeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecServiceTypeObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecServiceTypeObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getServiceTypeTableObj().lockServiceType( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getServiceTypeTableObj().newEditInstance( lockobj );
		return( (ICFSecServiceTypeEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecServiceTypeEditObj getEdit() {
		return( edit );
	}

	public ICFSecServiceTypeEditObj getEditAsServiceType() {
		return( (ICFSecServiceTypeEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecServiceTypeBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecServiceTypeBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public int getRequiredServiceTypeId() {
		return( getPKey().getRequiredServiceTypeId() );
	}

	public String getRequiredDescription() {
		return( getServiceTypeBuff().getRequiredDescription() );
	}

	public List<ICFSecServiceObj> getOptionalChildrenDeployed() {
		List<ICFSecServiceObj> retval;
		retval = ((ICFBamSchemaObj)schema).getServiceTableObj().readServiceByTypeIdx( getPKey().getRequiredServiceTypeId(),
			false );
		return( retval );
	}

	public List<ICFSecServiceObj> getOptionalChildrenDeployed( boolean forceRead ) {
		List<ICFSecServiceObj> retval;
		retval = ((ICFBamSchemaObj)schema).getServiceTableObj().readServiceByTypeIdx( getPKey().getRequiredServiceTypeId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredServiceTypeId( getPKey().getRequiredServiceTypeId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredServiceTypeId( buff.getRequiredServiceTypeId() );
	}
}
