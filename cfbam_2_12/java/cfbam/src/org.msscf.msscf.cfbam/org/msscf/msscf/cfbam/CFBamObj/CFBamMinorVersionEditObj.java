// Description: Java 11 edit object instance implementation for CFBam MinorVersion.

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

public class CFBamMinorVersionEditObj
	implements ICFBamMinorVersionEditObj
{
	protected ICFIntMinorVersionObj orig;
	protected CFIntMinorVersionBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFIntMajorVersionObj requiredContainerParentMajVer;

	public CFBamMinorVersionEditObj( ICFIntMinorVersionObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFIntMinorVersionBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerParentMajVer = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntMinorVersionBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntMinorVersionBuff buff = getBuff();
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
		return( CFBamMinorVersionObj.CLASS_CODE );
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
			subObj = ((ICFBamSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByUNameIdx( getRequiredTenantId(),
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

	public ICFIntMinorVersionObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFIntMinorVersionObj retobj = getSchema().getMinorVersionTableObj().realiseMinorVersion( (ICFBamMinorVersionObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsMinorVersion().getSchema()).getMinorVersionTableObj().forgetMinorVersion( getOrigAsMinorVersion(), forgetSubObjects );
	}

	public ICFIntMinorVersionObj read() {
		ICFIntMinorVersionObj retval = getOrigAsMinorVersion().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntMinorVersionObj read( boolean forceRead ) {
		ICFIntMinorVersionObj retval = getOrigAsMinorVersion().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntMinorVersionObj create() {
		copyBuffToOrig();
		ICFIntMinorVersionObj retobj = ((ICFBamSchemaObj)getOrigAsMinorVersion().getSchema()).getMinorVersionTableObj().createMinorVersion( getOrigAsMinorVersion() );
		if( retobj == getOrigAsMinorVersion() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFIntMinorVersionEditObj update() {
		getSchema().getMinorVersionTableObj().updateMinorVersion( (ICFIntMinorVersionObj)this );
		return( null );
	}

	public CFIntMinorVersionEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getMinorVersionTableObj().deleteMinorVersion( getOrigAsMinorVersion() );
		return( null );
	}

	public ICFIntMinorVersionTableObj getMinorVersionTable() {
		return( orig.getSchema().getMinorVersionTableObj() );
	}

	public ICFIntMinorVersionEditObj getEdit() {
		return( (ICFIntMinorVersionEditObj)this );
	}

	public ICFIntMinorVersionEditObj getEditAsMinorVersion() {
		return( (ICFIntMinorVersionEditObj)this );
	}

	public ICFIntMinorVersionEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFIntMinorVersionObj getOrig() {
		return( orig );
	}

	public ICFIntMinorVersionObj getOrigAsMinorVersion() {
		return( (ICFIntMinorVersionObj)orig );
	}

	public ICFIntSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFIntMinorVersionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsMinorVersion().getSchema().getBackingStore()).getFactoryMinorVersion().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFIntMinorVersionBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerParentMajVer = null;
		}
	}

	public CFIntMinorVersionBuff getMinorVersionBuff() {
		return( (CFIntMinorVersionBuff)getBuff() );
	}

	public CFIntMinorVersionPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFIntMinorVersionPKey value ) {
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

	public long getRequiredMajorVersionId() {
		return( getMinorVersionBuff().getRequiredMajorVersionId() );
	}

	public String getRequiredName() {
		return( getMinorVersionBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getMinorVersionBuff().getRequiredName() != value ) {
			getMinorVersionBuff().setRequiredName( value );
		}
	}

	public String getOptionalDescription() {
		return( getMinorVersionBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getMinorVersionBuff().getOptionalDescription() != value ) {
			getMinorVersionBuff().setOptionalDescription( value );
		}
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsMinorVersion().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getMinorVersionBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getMinorVersionBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFIntMajorVersionObj getRequiredContainerParentMajVer() {
		return( getRequiredContainerParentMajVer( false ) );
	}

	public ICFIntMajorVersionObj getRequiredContainerParentMajVer( boolean forceRead ) {
		if( forceRead || ( requiredContainerParentMajVer == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFIntMajorVersionObj obj = ((ICFBamSchemaObj)getOrigAsMinorVersion().getSchema()).getMajorVersionTableObj().readMajorVersionByIdIdx( getPKey().getRequiredTenantId(),
					getMinorVersionBuff().getRequiredMajorVersionId() );
				requiredContainerParentMajVer = obj;
				if( obj != null ) {
					getMinorVersionBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getMinorVersionBuff().setRequiredMajorVersionId( obj.getRequiredId() );
					requiredContainerParentMajVer = obj;
				}
			}
		}
		return( requiredContainerParentMajVer );
	}

	public void setRequiredContainerParentMajVer( ICFIntMajorVersionObj value ) {
			if( buff == null ) {
				getMinorVersionBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getMinorVersionBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getMinorVersionBuff().setRequiredMajorVersionId( value.getRequiredId() );
			}
			requiredContainerParentMajVer = value;
	}

	public List<ICFBamSchemaDefObj> getOptionalComponentsSchemaDef() {
		List<ICFBamSchemaDefObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsMinorVersion().getSchema()).getSchemaDefTableObj().readSchemaDefByMinorVersionIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamSchemaDefObj> getOptionalComponentsSchemaDef( boolean forceRead ) {
		List<ICFBamSchemaDefObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsMinorVersion().getSchema()).getSchemaDefTableObj().readSchemaDefByMinorVersionIdx( getPKey().getRequiredTenantId(),
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
		CFIntMinorVersionBuff origBuff = getOrigAsMinorVersion().getMinorVersionBuff();
		CFIntMinorVersionBuff myBuff = getMinorVersionBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFIntMinorVersionBuff origBuff = getOrigAsMinorVersion().getMinorVersionBuff();
		CFIntMinorVersionBuff myBuff = getMinorVersionBuff();
		myBuff.set( origBuff );
	}
}
