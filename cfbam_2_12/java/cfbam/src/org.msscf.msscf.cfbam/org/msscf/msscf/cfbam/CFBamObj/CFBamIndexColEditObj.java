// Description: Java 11 edit object instance implementation for CFBam IndexCol.

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

public class CFBamIndexColEditObj
	implements ICFBamIndexColEditObj
{
	protected ICFBamIndexColObj orig;
	protected CFBamIndexColBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamIndexObj requiredContainerIndex;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamIndexColObj optionalLookupPrev;
	protected ICFBamIndexColObj optionalLookupNext;
	protected ICFBamValueObj requiredLookupColumn;

	public CFBamIndexColEditObj( ICFBamIndexColObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamIndexColBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamIndexColBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamIndexColBuff buff = getBuff();
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
		return( CFBamIndexColObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "IndexCol" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamIndexObj scope = getRequiredContainerIndex();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamIndexObj scope = getRequiredContainerIndex();
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

	public ICFBamIndexColObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamIndexColObj retobj = getSchema().getIndexColTableObj().realiseIndexCol( (ICFBamIndexColObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().forgetIndexCol( getOrigAsIndexCol(), forgetSubObjects );
	}

	public ICFBamIndexColObj read() {
		ICFBamIndexColObj retval = getOrigAsIndexCol().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamIndexColObj read( boolean forceRead ) {
		ICFBamIndexColObj retval = getOrigAsIndexCol().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamIndexColObj moveUp() {
		throw new CFLibUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamIndexColObj moveDown() {
		throw new CFLibUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamIndexColObj create() {
		copyBuffToOrig();
		ICFBamIndexColObj retobj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().createIndexCol( getOrigAsIndexCol() );
		if( retobj == getOrigAsIndexCol() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamIndexColEditObj update() {
		getSchema().getIndexColTableObj().updateIndexCol( (ICFBamIndexColObj)this );
		return( null );
	}

	public CFBamIndexColEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getIndexColTableObj().deleteIndexCol( getOrigAsIndexCol() );
		return( null );
	}

	public ICFBamIndexColTableObj getIndexColTable() {
		return( orig.getSchema().getIndexColTableObj() );
	}

	public ICFBamIndexColEditObj getEdit() {
		return( (ICFBamIndexColEditObj)this );
	}

	public ICFBamIndexColEditObj getEditAsIndexCol() {
		return( (ICFBamIndexColEditObj)this );
	}

	public ICFBamIndexColEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamIndexColObj getOrig() {
		return( orig );
	}

	public ICFBamIndexColObj getOrigAsIndexCol() {
		return( (ICFBamIndexColObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamIndexColBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsIndexCol().getSchema().getBackingStore()).getFactoryIndexCol().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamIndexColBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerIndex = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
			requiredLookupColumn = null;
		}
	}

	public CFBamIndexColBuff getIndexColBuff() {
		return( (CFBamIndexColBuff)getBuff() );
	}

	public CFBamIndexColPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamIndexColPKey value ) {
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

	public long getRequiredIndexId() {
		return( getIndexColBuff().getRequiredIndexId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getIndexColBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getIndexColBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getIndexColBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getIndexColBuff().getRequiredName() != value ) {
			getIndexColBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getIndexColBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getIndexColBuff().getOptionalShortName() != value ) {
			getIndexColBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getIndexColBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getIndexColBuff().getOptionalLabel() != value ) {
			getIndexColBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getIndexColBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getIndexColBuff().getOptionalShortDescription() != value ) {
			getIndexColBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getIndexColBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getIndexColBuff().getOptionalDescription() != value ) {
			getIndexColBuff().setOptionalDescription( value );
		}
	}

	public long getRequiredColumnId() {
		return( getIndexColBuff().getRequiredColumnId() );
	}

	public boolean getRequiredIsAscending() {
		return( getIndexColBuff().getRequiredIsAscending() );
	}

	public void setRequiredIsAscending( boolean value ) {
		if( getIndexColBuff().getRequiredIsAscending() != value ) {
			getIndexColBuff().setRequiredIsAscending( value );
		}
	}

	public Long getOptionalPrevTenantId() {
		return( getIndexColBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getIndexColBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getIndexColBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getIndexColBuff().getOptionalNextId() );
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getIndexColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getIndexColBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamIndexObj getRequiredContainerIndex() {
		return( getRequiredContainerIndex( false ) );
	}

	public ICFBamIndexObj getRequiredContainerIndex( boolean forceRead ) {
		if( forceRead || ( requiredContainerIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexObj obj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getIndexColBuff().getRequiredIndexId() );
				requiredContainerIndex = obj;
				if( obj != null ) {
					getIndexColBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getIndexColBuff().setRequiredIndexId( obj.getRequiredId() );
					requiredContainerIndex = obj;
				}
			}
		}
		return( requiredContainerIndex );
	}

	public void setRequiredContainerIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getIndexColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setRequiredIndexId( value.getRequiredId() );
			}
			requiredContainerIndex = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getIndexColBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexColBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexColBuff().getOptionalDefSchemaTenantId(),
					getIndexColBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getIndexColBuff();
			}
			if( value != null ) {
				getIndexColBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getIndexColBuff().setOptionalDefSchemaTenantId( null );
				getIndexColBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelFromCol() {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getRelationColTableObj().readRelationColByFromColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelFromCol( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getRelationColTableObj().readRelationColByFromColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelToCol() {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getRelationColTableObj().readRelationColByToColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelToCol( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getRelationColTableObj().readRelationColByToColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexColObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamIndexColObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getIndexColBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexColBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexColObj obj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().readIndexColByIdIdx( getIndexColBuff().getOptionalPrevTenantId(),
					getIndexColBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamIndexColObj value ) {
			if( buff == null ) {
				getIndexColBuff();
			}
			if( value != null ) {
				getIndexColBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getIndexColBuff().setOptionalPrevTenantId( null );
				getIndexColBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamIndexColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamIndexColObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getIndexColBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexColBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexColObj obj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().readIndexColByIdIdx( getIndexColBuff().getOptionalNextTenantId(),
					getIndexColBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamIndexColObj value ) {
			if( buff == null ) {
				getIndexColBuff();
			}
			if( value != null ) {
				getIndexColBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getIndexColBuff().setOptionalNextTenantId( null );
				getIndexColBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
	}

	public ICFBamValueObj getRequiredLookupColumn() {
		return( getRequiredLookupColumn( false ) );
	}

	public ICFBamValueObj getRequiredLookupColumn( boolean forceRead ) {
		if( forceRead || ( requiredLookupColumn == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamValueObj obj = ((ICFBamSchemaObj)getOrigAsIndexCol().getSchema()).getValueTableObj().readValueByIdIdx( getPKey().getRequiredTenantId(),
					getIndexColBuff().getRequiredColumnId() );
				requiredLookupColumn = obj;
			}
		}
		return( requiredLookupColumn );
	}

	public void setRequiredLookupColumn( ICFBamValueObj value ) {
			if( buff == null ) {
				getIndexColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexColBuff().setRequiredColumnId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupColumn = value;
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
		CFBamIndexColBuff origBuff = getOrigAsIndexCol().getIndexColBuff();
		CFBamIndexColBuff myBuff = getIndexColBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamIndexColBuff origBuff = getOrigAsIndexCol().getIndexColBuff();
		CFBamIndexColBuff myBuff = getIndexColBuff();
		myBuff.set( origBuff );
	}
}
