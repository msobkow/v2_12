// Description: Java 11 edit object instance implementation for CFBam Tld.

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

public class CFBamTldEditObj
	implements ICFBamTldEditObj
{
	protected ICFIntTldObj orig;
	protected CFIntTldBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecTenantObj requiredContainerTenant;

	public CFBamTldEditObj( ICFIntTldObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFIntTldBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerTenant = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntTldBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntTldBuff buff = getBuff();
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
		return( CFBamTldObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Tld" );
	}

	public ICFLibAnyObj getScope() {
		return( getRequiredContainerTenant() );
	}

	public ICFLibAnyObj getObjScope() {
		return( getRequiredContainerTenant() );
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
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByNameIdx( getRequiredTenantId(),
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

	public ICFIntTldObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFIntTldObj retobj = getSchema().getTldTableObj().realiseTld( (ICFBamTldObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsTld().getSchema()).getTldTableObj().forgetTld( getOrigAsTld(), forgetSubObjects );
	}

	public ICFIntTldObj read() {
		ICFIntTldObj retval = getOrigAsTld().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntTldObj read( boolean forceRead ) {
		ICFIntTldObj retval = getOrigAsTld().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntTldObj create() {
		copyBuffToOrig();
		ICFIntTldObj retobj = ((ICFBamSchemaObj)getOrigAsTld().getSchema()).getTldTableObj().createTld( getOrigAsTld() );
		if( retobj == getOrigAsTld() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFIntTldEditObj update() {
		getSchema().getTldTableObj().updateTld( (ICFIntTldObj)this );
		return( null );
	}

	public CFIntTldEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getTldTableObj().deleteTld( getOrigAsTld() );
		return( null );
	}

	public ICFIntTldTableObj getTldTable() {
		return( orig.getSchema().getTldTableObj() );
	}

	public ICFIntTldEditObj getEdit() {
		return( (ICFIntTldEditObj)this );
	}

	public ICFIntTldEditObj getEditAsTld() {
		return( (ICFIntTldEditObj)this );
	}

	public ICFIntTldEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFIntTldObj getOrig() {
		return( orig );
	}

	public ICFIntTldObj getOrigAsTld() {
		return( (ICFIntTldObj)orig );
	}

	public ICFIntSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFIntTldBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsTld().getSchema().getBackingStore()).getFactoryTld().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFIntTldBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerTenant = null;
		}
	}

	public CFIntTldBuff getTldBuff() {
		return( (CFIntTldBuff)getBuff() );
	}

	public CFIntTldPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFIntTldPKey value ) {
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

	public String getRequiredName() {
		return( getTldBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getTldBuff().getRequiredName() != value ) {
			getTldBuff().setRequiredName( value );
		}
	}

	public String getOptionalDescription() {
		return( getTldBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getTldBuff().getOptionalDescription() != value ) {
			getTldBuff().setOptionalDescription( value );
		}
	}

	public ICFSecTenantObj getRequiredContainerTenant() {
		return( getRequiredContainerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredContainerTenant( boolean forceRead ) {
		if( forceRead || ( requiredContainerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsTld().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredContainerTenant = obj;
				if( obj != null ) {
					getTldBuff().setRequiredTenantId( obj.getRequiredId() );
					requiredContainerTenant = obj;
				}
			}
		}
		return( requiredContainerTenant );
	}

	public void setRequiredContainerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getTldBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getTldBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredContainerTenant = value;
	}

	public List<ICFIntTopDomainObj> getOptionalComponentsTopDomain() {
		List<ICFIntTopDomainObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTld().getSchema()).getTopDomainTableObj().readTopDomainByTldIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFIntTopDomainObj> getOptionalComponentsTopDomain( boolean forceRead ) {
		List<ICFIntTopDomainObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTld().getSchema()).getTopDomainTableObj().readTopDomainByTldIdx( getPKey().getRequiredTenantId(),
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
		CFIntTldBuff origBuff = getOrigAsTld().getTldBuff();
		CFIntTldBuff myBuff = getTldBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFIntTldBuff origBuff = getOrigAsTld().getTldBuff();
		CFIntTldBuff myBuff = getTldBuff();
		myBuff.set( origBuff );
	}
}
