// Description: Java 11 base object instance implementation for CFBam Param.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamParamObj
	implements ICFBamParamObj
{
	public final static String CLASS_CODE = "SPRM";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamParamEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamParamPKey pKey;
	protected CFBamParamBuff buff;
	protected ICFBamServerMethodObj requiredContainerServerMeth;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamParamObj optionalLookupPrev;
	protected ICFBamParamObj optionalLookupNext;
	protected ICFBamValueObj requiredLookupType;

	public CFBamParamObj() {
		isNew = true;
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
	}

	public CFBamParamObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Param" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamServerMethodObj scope = getRequiredContainerServerMeth();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamServerMethodObj scope = getRequiredContainerServerMeth();
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
			else if( container instanceof ICFBamSchemaDefObj ) {
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

	public ICFBamParamObj realise() {
		ICFBamParamObj retobj = ((ICFBamSchemaObj)schema).getParamTableObj().realiseParam(
			(ICFBamParamObj)this );
		return( (ICFBamParamObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getParamTableObj().forgetParam( (ICFBamParamObj)this, forgetSubObjects );
	}

	public ICFBamParamObj read() {
		ICFBamParamObj retobj = ((ICFBamSchemaObj)schema).getParamTableObj().readParamByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamObj read( boolean forceRead ) {
		ICFBamParamObj retobj = ((ICFBamSchemaObj)schema).getParamTableObj().readParamByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamObj moveUp() {
		ICFBamParamObj retobj = ((ICFBamSchemaObj)schema).getParamTableObj().moveUpParam( this );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamObj moveDown() {
		ICFBamParamObj retobj = ((ICFBamSchemaObj)schema).getParamTableObj().moveDownParam( this );
		return( (ICFBamParamObj)retobj );
	}

	public ICFBamParamTableObj getParamTable() {
		return( ((ICFBamSchemaObj)schema).getParamTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamParamBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableParam().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamParamBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamParamBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamParamBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerServerMeth = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
	}

	public CFBamParamBuff getParamBuff() {
		return( (CFBamParamBuff)getBuff() );
	}

	public CFBamParamPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryParam().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamParamPKey value ) {
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

	public ICFBamParamEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamParamObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamParamObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getParamTableObj().lockParam( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getParamTableObj().newEditInstance( lockobj );
		return( (ICFBamParamEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamParamEditObj getEdit() {
		return( edit );
	}

	public ICFBamParamEditObj getEditAsParam() {
		return( (ICFBamParamEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamParamBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamParamBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredServerMethodId() {
		return( getParamBuff().getRequiredServerMethodId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getParamBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getParamBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getParamBuff().getRequiredName() );
	}

	public String getOptionalShortDescription() {
		return( getParamBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getParamBuff().getOptionalDescription() );
	}

	public boolean getRequiredIsNullable() {
		return( getParamBuff().getRequiredIsNullable() );
	}

	public Long getOptionalTypeTenantId() {
		return( getParamBuff().getOptionalTypeTenantId() );
	}

	public Long getOptionalTypeId() {
		return( getParamBuff().getOptionalTypeId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getParamBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getParamBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getParamBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getParamBuff().getOptionalNextId() );
	}

	public ICFBamServerMethodObj getRequiredContainerServerMeth() {
		return( getRequiredContainerServerMeth( false ) );
	}

	public ICFBamServerMethodObj getRequiredContainerServerMeth( boolean forceRead ) {
		if( ( requiredContainerServerMeth == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerServerMeth = ((ICFBamSchemaObj)schema).getServerMethodTableObj().readServerMethodByIdIdx( getPKey().getRequiredTenantId(),
					getParamBuff().getRequiredServerMethodId(), forceRead );
			}
		}
		return( requiredContainerServerMeth );
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getParamBuff().getOptionalDefSchemaTenantId(),
					getParamBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public ICFBamParamObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamParamObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getParamTableObj().readParamByIdIdx( getParamBuff().getOptionalPrevTenantId(),
					getParamBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamParamObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamParamObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getParamTableObj().readParamByIdIdx( getParamBuff().getOptionalNextTenantId(),
					getParamBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	public ICFBamValueObj getRequiredLookupType() {
		return( getRequiredLookupType( false ) );
	}

	public ICFBamValueObj getRequiredLookupType( boolean forceRead ) {
		if( ( requiredLookupType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamBuff().getOptionalTypeTenantId() == null ) {
				anyMissing = true;
			}
			if( getParamBuff().getOptionalTypeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				requiredLookupType = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getParamBuff().getOptionalTypeTenantId(),
					getParamBuff().getOptionalTypeId(), forceRead );
			}
		}
		return( requiredLookupType );
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
