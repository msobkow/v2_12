// Description: Java 11 edit object instance implementation for CFBam EnumTag.

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

public class CFBamEnumTagEditObj
	implements ICFBamEnumTagEditObj
{
	protected ICFBamEnumTagObj orig;
	protected CFBamEnumTagBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamEnumDefObj requiredContainerEnumDef;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamEnumTagObj optionalLookupPrev;
	protected ICFBamEnumTagObj optionalLookupNext;

	public CFBamEnumTagEditObj( ICFBamEnumTagObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamEnumTagBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerEnumDef = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamEnumTagBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamEnumTagBuff buff = getBuff();
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
		return( CFBamEnumTagObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "EnumTag" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamEnumDefObj scope = getRequiredContainerEnumDef();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamEnumDefObj scope = getRequiredContainerEnumDef();
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

	public ICFBamEnumTagObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamEnumTagObj retobj = getSchema().getEnumTagTableObj().realiseEnumTag( (ICFBamEnumTagObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().forgetEnumTag( getOrigAsEnumTag(), forgetSubObjects );
	}

	public ICFBamEnumTagObj read() {
		ICFBamEnumTagObj retval = getOrigAsEnumTag().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamEnumTagObj read( boolean forceRead ) {
		ICFBamEnumTagObj retval = getOrigAsEnumTag().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamEnumTagObj moveUp() {
		throw new CFLibUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamEnumTagObj moveDown() {
		throw new CFLibUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamEnumTagObj create() {
		copyBuffToOrig();
		ICFBamEnumTagObj retobj = ((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().createEnumTag( getOrigAsEnumTag() );
		if( retobj == getOrigAsEnumTag() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamEnumTagEditObj update() {
		getSchema().getEnumTagTableObj().updateEnumTag( (ICFBamEnumTagObj)this );
		return( null );
	}

	public CFBamEnumTagEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getEnumTagTableObj().deleteEnumTag( getOrigAsEnumTag() );
		return( null );
	}

	public ICFBamEnumTagTableObj getEnumTagTable() {
		return( orig.getSchema().getEnumTagTableObj() );
	}

	public ICFBamEnumTagEditObj getEdit() {
		return( (ICFBamEnumTagEditObj)this );
	}

	public ICFBamEnumTagEditObj getEditAsEnumTag() {
		return( (ICFBamEnumTagEditObj)this );
	}

	public ICFBamEnumTagEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamEnumTagObj getOrig() {
		return( orig );
	}

	public ICFBamEnumTagObj getOrigAsEnumTag() {
		return( (ICFBamEnumTagObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamEnumTagBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsEnumTag().getSchema().getBackingStore()).getFactoryEnumTag().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamEnumTagBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerEnumDef = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	public CFBamEnumTagBuff getEnumTagBuff() {
		return( (CFBamEnumTagBuff)getBuff() );
	}

	public CFBamEnumTagPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamEnumTagPKey value ) {
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

	public Long getOptionalDefSchemaTenantId() {
		return( getEnumTagBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getEnumTagBuff().getOptionalDefSchemaId() );
	}

	public long getRequiredEnumId() {
		return( getEnumTagBuff().getRequiredEnumId() );
	}

	public Short getOptionalEnumCode() {
		return( getEnumTagBuff().getOptionalEnumCode() );
	}

	public void setOptionalEnumCode( Short value ) {
		if( getEnumTagBuff().getOptionalEnumCode() != value ) {
			getEnumTagBuff().setOptionalEnumCode( value );
		}
	}

	public String getRequiredName() {
		return( getEnumTagBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getEnumTagBuff().getRequiredName() != value ) {
			getEnumTagBuff().setRequiredName( value );
		}
	}

	public Long getOptionalPrevTenantId() {
		return( getEnumTagBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getEnumTagBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getEnumTagBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getEnumTagBuff().getOptionalNextId() );
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getEnumTagBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getEnumTagBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamEnumDefObj getRequiredContainerEnumDef() {
		return( getRequiredContainerEnumDef( false ) );
	}

	public ICFBamEnumDefObj getRequiredContainerEnumDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerEnumDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamEnumDefObj obj = ((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getEnumDefTableObj().readEnumDefByIdIdx( getPKey().getRequiredTenantId(),
					getEnumTagBuff().getRequiredEnumId() );
				requiredContainerEnumDef = obj;
				if( obj != null ) {
					getEnumTagBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getEnumTagBuff().setRequiredEnumId( obj.getRequiredId() );
					requiredContainerEnumDef = obj;
				}
			}
		}
		return( requiredContainerEnumDef );
	}

	public void setRequiredContainerEnumDef( ICFBamEnumDefObj value ) {
			if( buff == null ) {
				getEnumTagBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getEnumTagBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getEnumTagBuff().setRequiredEnumId( value.getRequiredId() );
			}
			requiredContainerEnumDef = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getEnumTagBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getEnumTagBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getEnumTagBuff().getOptionalDefSchemaTenantId(),
					getEnumTagBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getEnumTagBuff();
			}
			if( value != null ) {
				getEnumTagBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getEnumTagBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getEnumTagBuff().setOptionalDefSchemaTenantId( null );
				getEnumTagBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamEnumTagObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamEnumTagObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getEnumTagBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getEnumTagBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamEnumTagObj obj = ((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().readEnumTagByIdIdx( getEnumTagBuff().getOptionalPrevTenantId(),
					getEnumTagBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamEnumTagObj value ) {
			if( buff == null ) {
				getEnumTagBuff();
			}
			if( value != null ) {
				getEnumTagBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getEnumTagBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getEnumTagBuff().setOptionalPrevTenantId( null );
				getEnumTagBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamEnumTagObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamEnumTagObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getEnumTagBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getEnumTagBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamEnumTagObj obj = ((ICFBamSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().readEnumTagByIdIdx( getEnumTagBuff().getOptionalNextTenantId(),
					getEnumTagBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamEnumTagObj value ) {
			if( buff == null ) {
				getEnumTagBuff();
			}
			if( value != null ) {
				getEnumTagBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getEnumTagBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getEnumTagBuff().setOptionalNextTenantId( null );
				getEnumTagBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
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
		CFBamEnumTagBuff origBuff = getOrigAsEnumTag().getEnumTagBuff();
		CFBamEnumTagBuff myBuff = getEnumTagBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamEnumTagBuff origBuff = getOrigAsEnumTag().getEnumTagBuff();
		CFBamEnumTagBuff myBuff = getEnumTagBuff();
		myBuff.set( origBuff );
	}
}
