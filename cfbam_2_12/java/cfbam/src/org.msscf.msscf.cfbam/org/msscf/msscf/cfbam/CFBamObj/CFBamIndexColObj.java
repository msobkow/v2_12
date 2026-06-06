// Description: Java 11 base object instance implementation for CFBam IndexCol.

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

public class CFBamIndexColObj
	implements ICFBamIndexColObj
{
	public final static String CLASS_CODE = "IDXC";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamIndexColEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamIndexColPKey pKey;
	protected CFBamIndexColBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamIndexObj requiredContainerIndex;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamIndexColObj optionalLookupPrev;
	protected ICFBamIndexColObj optionalLookupNext;
	protected ICFBamValueObj requiredLookupColumn;

	public CFBamIndexColObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	public CFBamIndexColObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFBamIndexColObj retobj = ((ICFBamSchemaObj)schema).getIndexColTableObj().realiseIndexCol(
			(ICFBamIndexColObj)this );
		return( (ICFBamIndexColObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getIndexColTableObj().forgetIndexCol( (ICFBamIndexColObj)this, forgetSubObjects );
	}

	public ICFBamIndexColObj read() {
		ICFBamIndexColObj retobj = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamIndexColObj)retobj );
	}

	public ICFBamIndexColObj read( boolean forceRead ) {
		ICFBamIndexColObj retobj = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamIndexColObj)retobj );
	}

	public ICFBamIndexColObj moveUp() {
		ICFBamIndexColObj retobj = ((ICFBamSchemaObj)schema).getIndexColTableObj().moveUpIndexCol( this );
		return( (ICFBamIndexColObj)retobj );
	}

	public ICFBamIndexColObj moveDown() {
		ICFBamIndexColObj retobj = ((ICFBamSchemaObj)schema).getIndexColTableObj().moveDownIndexCol( this );
		return( (ICFBamIndexColObj)retobj );
	}

	public ICFBamIndexColTableObj getIndexColTable() {
		return( ((ICFBamSchemaObj)schema).getIndexColTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamIndexColBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryIndexCol().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableIndexCol().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamIndexColBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamIndexColBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamIndexColBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	public CFBamIndexColBuff getIndexColBuff() {
		return( (CFBamIndexColBuff)getBuff() );
	}

	public CFBamIndexColPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryIndexCol().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamIndexColPKey value ) {
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

	public ICFBamIndexColEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamIndexColObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamIndexColObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getIndexColTableObj().lockIndexCol( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getIndexColTableObj().newEditInstance( lockobj );
		return( (ICFBamIndexColEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamIndexColEditObj getEdit() {
		return( edit );
	}

	public ICFBamIndexColEditObj getEditAsIndexCol() {
		return( (ICFBamIndexColEditObj)edit );
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

	public String getOptionalShortName() {
		return( getIndexColBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getIndexColBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getIndexColBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getIndexColBuff().getOptionalDescription() );
	}

	public long getRequiredColumnId() {
		return( getIndexColBuff().getRequiredColumnId() );
	}

	public boolean getRequiredIsAscending() {
		return( getIndexColBuff().getRequiredIsAscending() );
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
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFBamIndexObj getRequiredContainerIndex() {
		return( getRequiredContainerIndex( false ) );
	}

	public ICFBamIndexObj getRequiredContainerIndex( boolean forceRead ) {
		if( ( requiredContainerIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerIndex = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getIndexColBuff().getRequiredIndexId(), forceRead );
			}
		}
		return( requiredContainerIndex );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexColBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexColBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexColBuff().getOptionalDefSchemaTenantId(),
					getIndexColBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelFromCol() {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByFromColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelFromCol( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByFromColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelToCol() {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByToColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalChildrenRefRelToCol( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByToColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexColObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamIndexColObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexColBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexColBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIdIdx( getIndexColBuff().getOptionalPrevTenantId(),
					getIndexColBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamIndexColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamIndexColObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexColBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexColBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIdIdx( getIndexColBuff().getOptionalNextTenantId(),
					getIndexColBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	public ICFBamValueObj getRequiredLookupColumn() {
		return( getRequiredLookupColumn( false ) );
	}

	public ICFBamValueObj getRequiredLookupColumn( boolean forceRead ) {
		if( ( requiredLookupColumn == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupColumn = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getPKey().getRequiredTenantId(),
					getIndexColBuff().getRequiredColumnId(), forceRead );
			}
		}
		return( requiredLookupColumn );
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
