// Description: Java 11 base object instance implementation for CFInt MinorVersion.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntMinorVersionObj
	implements ICFIntMinorVersionObj
{
	public final static String CLASS_CODE = "MNVR";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFIntMinorVersionEditObj edit;
	protected ICFIntSchemaObj schema;
	protected CFIntMinorVersionPKey pKey;
	protected CFIntMinorVersionBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFIntMajorVersionObj requiredContainerParentMajVer;

	public CFIntMinorVersionObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentMajVer = null;
	}

	public CFIntMinorVersionObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentMajVer = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "MinorVersion" );
	}

	public ICFLibAnyObj getScope() {
		ICFIntMajorVersionObj scope = getRequiredContainerParentMajVer();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFIntMajorVersionObj scope = getRequiredContainerParentMajVer();
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

	public ICFIntMinorVersionObj realise() {
		ICFIntMinorVersionObj retobj = ((ICFIntSchemaObj)schema).getMinorVersionTableObj().realiseMinorVersion(
			(ICFIntMinorVersionObj)this );
		return( (ICFIntMinorVersionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getMinorVersionTableObj().forgetMinorVersion( (ICFIntMinorVersionObj)this, forgetSubObjects );
	}

	public ICFIntMinorVersionObj read() {
		ICFIntMinorVersionObj retobj = ((ICFIntSchemaObj)schema).getMinorVersionTableObj().readMinorVersionByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFIntMinorVersionObj)retobj );
	}

	public ICFIntMinorVersionObj read( boolean forceRead ) {
		ICFIntMinorVersionObj retobj = ((ICFIntSchemaObj)schema).getMinorVersionTableObj().readMinorVersionByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFIntMinorVersionObj)retobj );
	}

	public ICFIntMinorVersionTableObj getMinorVersionTable() {
		return( ((ICFIntSchemaObj)schema).getMinorVersionTableObj() );
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public CFIntMinorVersionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactoryMinorVersion().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableMinorVersion().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFIntMinorVersionBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFIntMinorVersionBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFIntMinorVersionBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentMajVer = null;
	}

	public CFIntMinorVersionBuff getMinorVersionBuff() {
		return( (CFIntMinorVersionBuff)getBuff() );
	}

	public CFIntMinorVersionPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactoryMinorVersion().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFIntMinorVersionPKey value ) {
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

	public ICFIntMinorVersionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFIntMinorVersionObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFIntMinorVersionObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getMinorVersionTableObj().lockMinorVersion( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getMinorVersionTableObj().newEditInstance( lockobj );
		return( (ICFIntMinorVersionEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFIntMinorVersionEditObj getEdit() {
		return( edit );
	}

	public ICFIntMinorVersionEditObj getEditAsMinorVersion() {
		return( (ICFIntMinorVersionEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntMinorVersionBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntMinorVersionBuff buff = getBuff();
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

	public long getRequiredMajorVersionId() {
		return( getMinorVersionBuff().getRequiredMajorVersionId() );
	}

	public String getRequiredName() {
		return( getMinorVersionBuff().getRequiredName() );
	}

	public String getOptionalDescription() {
		return( getMinorVersionBuff().getOptionalDescription() );
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

	public ICFIntMajorVersionObj getRequiredContainerParentMajVer() {
		return( getRequiredContainerParentMajVer( false ) );
	}

	public ICFIntMajorVersionObj getRequiredContainerParentMajVer( boolean forceRead ) {
		if( ( requiredContainerParentMajVer == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentMajVer = ((ICFIntSchemaObj)schema).getMajorVersionTableObj().readMajorVersionByIdIdx( getPKey().getRequiredTenantId(),
					getMinorVersionBuff().getRequiredMajorVersionId(), forceRead );
			}
		}
		return( requiredContainerParentMajVer );
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
