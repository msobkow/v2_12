// Description: Java 11 edit object instance implementation for CFBam RelationCol.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamRelationColEditObj
	implements ICFBamRelationColEditObj
{
	protected ICFBamRelationColObj orig;
	protected CFBamRelationColBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFBamRelationObj requiredContainerRelation;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamRelationColObj optionalLookupPrev;
	protected ICFBamRelationColObj optionalLookupNext;
	protected ICFBamIndexColObj requiredLookupFromCol;
	protected ICFBamIndexColObj requiredLookupToCol;

	public CFBamRelationColEditObj( ICFBamRelationColObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamRelationColBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerRelation = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamRelationColBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamRelationColBuff buff = getBuff();
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
		return( CFBamRelationColObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "RelationCol" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamRelationObj scope = getRequiredContainerRelation();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamRelationObj scope = getRequiredContainerRelation();
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

	public ICFBamRelationColObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamRelationColObj retobj = getSchema().getRelationColTableObj().realiseRelationCol( (ICFBamRelationColObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getRelationColTableObj().forgetRelationCol( getOrigAsRelationCol(), forgetSubObjects );
	}

	public ICFBamRelationColObj read() {
		ICFBamRelationColObj retval = getOrigAsRelationCol().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamRelationColObj read( boolean forceRead ) {
		ICFBamRelationColObj retval = getOrigAsRelationCol().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamRelationColObj moveUp() {
		throw new CFLibUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamRelationColObj moveDown() {
		throw new CFLibUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamRelationColObj create() {
		copyBuffToOrig();
		ICFBamRelationColObj retobj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getRelationColTableObj().createRelationCol( getOrigAsRelationCol() );
		if( retobj == getOrigAsRelationCol() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamRelationColEditObj update() {
		getSchema().getRelationColTableObj().updateRelationCol( (ICFBamRelationColObj)this );
		return( null );
	}

	public CFBamRelationColEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getRelationColTableObj().deleteRelationCol( getOrigAsRelationCol() );
		return( null );
	}

	public ICFBamRelationColTableObj getRelationColTable() {
		return( orig.getSchema().getRelationColTableObj() );
	}

	public ICFBamRelationColEditObj getEdit() {
		return( (ICFBamRelationColEditObj)this );
	}

	public ICFBamRelationColEditObj getEditAsRelationCol() {
		return( (ICFBamRelationColEditObj)this );
	}

	public ICFBamRelationColEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamRelationColObj getOrig() {
		return( orig );
	}

	public ICFBamRelationColObj getOrigAsRelationCol() {
		return( (ICFBamRelationColObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamRelationColBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsRelationCol().getSchema().getBackingStore()).getFactoryRelationCol().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamRelationColBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerRelation = null;
			requiredOwnerTenant = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
			requiredLookupFromCol = null;
			requiredLookupToCol = null;
		}
	}

	public CFBamRelationColBuff getRelationColBuff() {
		return( (CFBamRelationColBuff)getBuff() );
	}

	public CFBamRelationColPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamRelationColPKey value ) {
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

	public long getRequiredRelationId() {
		return( getRelationColBuff().getRequiredRelationId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getRelationColBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getRelationColBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getRelationColBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getRelationColBuff().getRequiredName() != value ) {
			getRelationColBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getRelationColBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getRelationColBuff().getOptionalShortName() != value ) {
			getRelationColBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getRelationColBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getRelationColBuff().getOptionalLabel() != value ) {
			getRelationColBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getRelationColBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getRelationColBuff().getOptionalShortDescription() != value ) {
			getRelationColBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getRelationColBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getRelationColBuff().getOptionalDescription() != value ) {
			getRelationColBuff().setOptionalDescription( value );
		}
	}

	public long getRequiredFromColId() {
		return( getRelationColBuff().getRequiredFromColId() );
	}

	public long getRequiredToColId() {
		return( getRelationColBuff().getRequiredToColId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getRelationColBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getRelationColBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getRelationColBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getRelationColBuff().getOptionalNextId() );
	}

	public ICFBamRelationObj getRequiredContainerRelation() {
		return( getRequiredContainerRelation( false ) );
	}

	public ICFBamRelationObj getRequiredContainerRelation( boolean forceRead ) {
		if( forceRead || ( requiredContainerRelation == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamRelationObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getRelationTableObj().readRelationByIdIdx( getPKey().getRequiredTenantId(),
					getRelationColBuff().getRequiredRelationId() );
				requiredContainerRelation = obj;
				if( obj != null ) {
					getRelationColBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getRelationColBuff().setRequiredRelationId( obj.getRequiredId() );
					requiredContainerRelation = obj;
				}
			}
		}
		return( requiredContainerRelation );
	}

	public void setRequiredContainerRelation( ICFBamRelationObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setRequiredRelationId( value.getRequiredId() );
			}
			requiredContainerRelation = value;
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getRelationColBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getRelationColBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationColBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationColBuff().getOptionalDefSchemaTenantId(),
					getRelationColBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getRelationColBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getRelationColBuff().setOptionalDefSchemaTenantId( null );
				getRelationColBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamRelationColObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamRelationColObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getRelationColBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationColBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamRelationColObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getRelationColTableObj().readRelationColByIdIdx( getRelationColBuff().getOptionalPrevTenantId(),
					getRelationColBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamRelationColObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getRelationColBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getRelationColBuff().setOptionalPrevTenantId( null );
				getRelationColBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamRelationColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamRelationColObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getRelationColBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationColBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamRelationColObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getRelationColTableObj().readRelationColByIdIdx( getRelationColBuff().getOptionalNextTenantId(),
					getRelationColBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamRelationColObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getRelationColBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getRelationColBuff().setOptionalNextTenantId( null );
				getRelationColBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
	}

	public ICFBamIndexColObj getRequiredLookupFromCol() {
		return( getRequiredLookupFromCol( false ) );
	}

	public ICFBamIndexColObj getRequiredLookupFromCol( boolean forceRead ) {
		if( forceRead || ( requiredLookupFromCol == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexColObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getIndexColTableObj().readIndexColByIdIdx( getPKey().getRequiredTenantId(),
					getRelationColBuff().getRequiredFromColId() );
				requiredLookupFromCol = obj;
			}
		}
		return( requiredLookupFromCol );
	}

	public void setRequiredLookupFromCol( ICFBamIndexColObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setRequiredFromColId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupFromCol = value;
	}

	public ICFBamIndexColObj getRequiredLookupToCol() {
		return( getRequiredLookupToCol( false ) );
	}

	public ICFBamIndexColObj getRequiredLookupToCol( boolean forceRead ) {
		if( forceRead || ( requiredLookupToCol == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexColObj obj = ((ICFBamSchemaObj)getOrigAsRelationCol().getSchema()).getIndexColTableObj().readIndexColByIdIdx( getPKey().getRequiredTenantId(),
					getRelationColBuff().getRequiredToColId() );
				requiredLookupToCol = obj;
			}
		}
		return( requiredLookupToCol );
	}

	public void setRequiredLookupToCol( ICFBamIndexColObj value ) {
			if( buff == null ) {
				getRelationColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationColBuff().setRequiredToColId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupToCol = value;
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
		CFBamRelationColBuff origBuff = getOrigAsRelationCol().getRelationColBuff();
		CFBamRelationColBuff myBuff = getRelationColBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamRelationColBuff origBuff = getOrigAsRelationCol().getRelationColBuff();
		CFBamRelationColBuff myBuff = getRelationColBuff();
		myBuff.set( origBuff );
	}

	public ICFBamSubProjectObj getProject() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof ICFBamSubProjectObj ) {
				return ((ICFBamSubProjectObj)curDef);
			}
			else if( curDef instanceof ICFBamTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	public ICFBamTopDomainObj getCompany() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof ICFBamTopDomainObj ) {
				return ((ICFBamTopDomainObj)curDef);
			}
			else if( curDef instanceof ICFBamTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	public ICFBamSchemaDefObj getSchemaDef() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof ICFBamSchemaDefObj ) {
				return ((ICFBamSchemaDefObj)curDef);
			}
			else if( curDef instanceof ICFBamTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	public ICFBamMinorVersionObj getVersion() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof ICFBamMinorVersionObj ) {
				return ((ICFBamMinorVersionObj)curDef);
			}
			else if( curDef instanceof ICFBamMajorVersionObj ) {
				return( null );
			}
			else if( curDef instanceof ICFBamSubProjectObj ) {
				return( null );
			}
			else if( curDef instanceof ICFBamTopProjectObj ) {
				return( null );
			}
			else if( curDef instanceof ICFBamTopDomainObj ) {
				return( null );
			}
			else if( curDef instanceof ICFBamTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	protected String getVersionStringForVersion( ICFLibAnyObj value ) {
		String ret;
		if( value instanceof ICFBamMinorVersionObj ) {
			ret = ((ICFBamMinorVersionObj)value).getRequiredName();
		}
		else if( value instanceof ICFBamMajorVersionObj ) {
			ret = ((ICFBamMajorVersionObj)value).getRequiredName();
		}
		else {
			ret = null;
		}
		return( ret );
	}

	public String getVersionString() {
		ICFLibAnyObj scopeDef;
		ICFLibAnyObj curDef = getVersion();
		List<String> invertedNodeNames = new ArrayList<String>();
		while (curDef != null) {
			if( curDef instanceof ICFBamMinorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMinorVersionObj)( curDef ) ) );
			}
			else if( curDef instanceof ICFBamMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMajorVersionObj)( curDef ) ) );
			}
			scopeDef = curDef.getObjScope();
			if( scopeDef == null) {
				curDef = null;
			}
			else if( scopeDef instanceof ICFBamMinorVersionObj ) {
				curDef = scopeDef;
			}
			else if( scopeDef instanceof ICFBamMajorVersionObj ) {
				curDef = scopeDef;
			}
			else {
				curDef = null;
			}
		}
		String ret = "";
		for( int idx = invertedNodeNames.size() - 1; idx >= 0; idx-- )
		{
			if( ret.length() == 0) {
				ret = invertedNodeNames.get(idx);
			}
			else {
				ret = ret + "-" + invertedNodeNames.get(idx);
			}
		}
		return( ret );
	}

	public String getPackedVersionString() {
		ICFLibAnyObj scopeDef;
		ICFLibAnyObj curDef = getVersion();
		List<String> invertedNodeNames = new ArrayList<String>();
		while (curDef != null) {
			if( curDef instanceof ICFBamMinorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMinorVersionObj)( curDef ) ) );
			}
			else if( curDef instanceof ICFBamMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMajorVersionObj)( curDef ) ) );
			}
			scopeDef = curDef.getObjScope();
			if( scopeDef == null) {
				curDef = null;
			}
			else if( scopeDef instanceof ICFBamMinorVersionObj ) {
				curDef = scopeDef;
			}
			else if( scopeDef instanceof ICFBamMajorVersionObj ) {
				curDef = scopeDef;
			}
			else {
				curDef = null;
			}
		}
		String ret = "";
		for( int idx = invertedNodeNames.size() - 1; idx >= 0; idx-- )
		{
			if( ret.length() == 0) {
				ret = invertedNodeNames.get(idx);
			}
			else {
				ret = ret + invertedNodeNames.get(idx);
			}
		}
		return( ret );
	}

	public Boolean isColumnInOwnerRelation() {

		ICFLibAnyObj		focusDef;
		ICFBamTableObj		tableDef;
		final String S_ProcName = "isColumnInOwnerRelation() ";

		if( this instanceof ICFBamAtomObj ) {
			ICFBamAtomObj atomDef = (ICFBamAtomObj)this;
			ICFLibAnyObj atomScopeDef = atomDef.getObjScope();
			tableDef = (ICFBamTableObj)atomScopeDef;
			focusDef = this;
		}
		else if( this instanceof ICFBamTableColObj ) {
			ICFBamTableColObj tableColDef = (ICFBamTableColObj)this;
			ICFLibAnyObj tableColScopeDef = tableColDef.getObjScope();
			tableDef = (ICFBamTableObj)tableColScopeDef;
			focusDef = this;
		}
		else if( this instanceof ICFBamIndexColObj ) {
			ICFBamIndexColObj indexColDef = (ICFBamIndexColObj)this;
			focusDef = indexColDef.getRequiredLookupColumn();
			if( focusDef instanceof ICFBamAtomObj ) {
				tableDef = (ICFBamTableObj)((ICFBamAtomObj)focusDef).getObjScope();
			}
			else if( focusDef instanceof ICFBamTableColObj ) {
				tableDef = (ICFBamTableObj)((ICFBamTableColObj)focusDef).getObjScope();
			}
			else {
				throw new RuntimeException(
					S_ProcName + "genContext.getGenDef().getColumnDef() for a ICFBamIndexColObj did not return a ICFBamAtomObj"
						+	" nor a ICFBamTableColObj" );
			}
		}
		else if( this instanceof ICFBamRelationColObj ) {
			ICFBamRelationColObj relColDef = (ICFBamRelationColObj)this;
			ICFLibAnyObj columnDef = relColDef.getRequiredLookupFromCol();
			if( columnDef instanceof ICFBamAtomObj ) {
				focusDef = columnDef;
				tableDef = (ICFBamTableObj)columnDef.getObjScope();
			}
			else if( columnDef instanceof ICFBamTableColObj ) {
				focusDef = columnDef;
				tableDef = (ICFBamTableObj)columnDef.getObjScope();
			}
			else {
				throw new RuntimeException(
					S_ProcName + "genContext.getGenDef().getFromColumnDef() for a ICFBamIndexColObj did not return a ICFBamAtomObj"
						+	" nor a ICFBamTableColObj" );
			}
		}
		else {
			throw new RuntimeException(
				S_ProcName + "genContext.getGenDef() did not return a ICFBamAtomObj, ICFBamTableColObj, nor ICFBamIndexColObj instance" );
		}

		List<ICFBamRelationObj> ownerRelations = tableDef.getContainerOwnerRelations();
		if( ( ownerRelations == null )
		 || ( ( ownerRelations != null ) && ( ownerRelations.size() == 0 ) ) )
		{
			return( false );
		}

		ListIterator<ICFBamRelationObj> ownerEnumerator = ownerRelations.listIterator();

		ICFBamRelationObj ownerRelation;
		ICFBamRelationColObj ownerRelationCol;
		Iterator<ICFBamRelationColObj> ownerRelationCols;

		while( ownerEnumerator.hasNext() ) {

			ownerRelation = ownerEnumerator.next();
			ownerRelationCols = ownerRelation.getOptionalComponentsColumns().iterator();

			while( ownerRelationCols.hasNext() ) {
				ownerRelationCol = ownerRelationCols.next();
				if( ownerRelationCol.getRequiredLookupFromCol() == focusDef ) {
					return( true );
				}
			}
		}

		return( false );
	}
}
