// Description: Java 11 base object instance implementation for CFInt TopDomain.

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

public class CFIntTopDomainObj
	implements ICFIntTopDomainObj
{
	public final static String CLASS_CODE = "TDOM";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFIntTopDomainEditObj edit;
	protected ICFIntSchemaObj schema;
	protected CFIntTopDomainPKey pKey;
	protected CFIntTopDomainBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFIntTldObj requiredContainerParentTld;

	public CFIntTopDomainObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	public CFIntTopDomainObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TopDomain" );
	}

	public ICFLibAnyObj getScope() {
		ICFIntTldObj scope = getRequiredContainerParentTld();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFIntTldObj scope = getRequiredContainerParentTld();
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
			subObj = ((ICFIntSchemaObj)getSchema()).getLicenseTableObj().readLicenseByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFIntSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByNameIdx( getRequiredTenantId(),
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

	public ICFIntTopDomainObj realise() {
		ICFIntTopDomainObj retobj = ((ICFIntSchemaObj)schema).getTopDomainTableObj().realiseTopDomain(
			(ICFIntTopDomainObj)this );
		return( (ICFIntTopDomainObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getTopDomainTableObj().forgetTopDomain( (ICFIntTopDomainObj)this, forgetSubObjects );
	}

	public ICFIntTopDomainObj read() {
		ICFIntTopDomainObj retobj = ((ICFIntSchemaObj)schema).getTopDomainTableObj().readTopDomainByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFIntTopDomainObj)retobj );
	}

	public ICFIntTopDomainObj read( boolean forceRead ) {
		ICFIntTopDomainObj retobj = ((ICFIntSchemaObj)schema).getTopDomainTableObj().readTopDomainByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFIntTopDomainObj)retobj );
	}

	public ICFIntTopDomainTableObj getTopDomainTable() {
		return( ((ICFIntSchemaObj)schema).getTopDomainTableObj() );
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public CFIntTopDomainBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopDomain().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableTopDomain().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFIntTopDomainBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFIntTopDomainBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFIntTopDomainBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	public CFIntTopDomainBuff getTopDomainBuff() {
		return( (CFIntTopDomainBuff)getBuff() );
	}

	public CFIntTopDomainPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactoryTopDomain().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFIntTopDomainPKey value ) {
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

	public ICFIntTopDomainEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFIntTopDomainObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFIntTopDomainObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getTopDomainTableObj().lockTopDomain( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getTopDomainTableObj().newEditInstance( lockobj );
		return( (ICFIntTopDomainEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFIntTopDomainEditObj getEdit() {
		return( edit );
	}

	public ICFIntTopDomainEditObj getEditAsTopDomain() {
		return( (ICFIntTopDomainEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntTopDomainBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntTopDomainBuff buff = getBuff();
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

	public long getRequiredTldId() {
		return( getTopDomainBuff().getRequiredTldId() );
	}

	public String getRequiredName() {
		return( getTopDomainBuff().getRequiredName() );
	}

	public String getOptionalDescription() {
		return( getTopDomainBuff().getOptionalDescription() );
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

	public ICFIntTldObj getRequiredContainerParentTld() {
		return( getRequiredContainerParentTld( false ) );
	}

	public ICFIntTldObj getRequiredContainerParentTld( boolean forceRead ) {
		if( ( requiredContainerParentTld == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentTld = ((ICFIntSchemaObj)schema).getTldTableObj().readTldByIdIdx( getPKey().getRequiredTenantId(),
					getTopDomainBuff().getRequiredTldId(), forceRead );
			}
		}
		return( requiredContainerParentTld );
	}

	public List<ICFIntLicenseObj> getOptionalComponentsLicense() {
		List<ICFIntLicenseObj> retval;
		retval = ((ICFIntSchemaObj)schema).getLicenseTableObj().readLicenseByDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntLicenseObj> getOptionalComponentsLicense( boolean forceRead ) {
		List<ICFIntLicenseObj> retval;
		retval = ((ICFIntSchemaObj)schema).getLicenseTableObj().readLicenseByDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFIntTopProjectObj> getOptionalComponentsTopProject() {
		List<ICFIntTopProjectObj> retval;
		retval = ((ICFIntSchemaObj)schema).getTopProjectTableObj().readTopProjectByTopDomainIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntTopProjectObj> getOptionalComponentsTopProject( boolean forceRead ) {
		List<ICFIntTopProjectObj> retval;
		retval = ((ICFIntSchemaObj)schema).getTopProjectTableObj().readTopProjectByTopDomainIdx( getPKey().getRequiredTenantId(),
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
