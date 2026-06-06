// Description: Java 11 base object instance implementation for CFBam RelationCol.

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

public class CFBamRelationColObj
	implements ICFBamRelationColObj
{
	public final static String CLASS_CODE = "RELC";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamRelationColEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamRelationColPKey pKey;
	protected CFBamRelationColBuff buff;
	protected ICFBamRelationObj requiredContainerRelation;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamRelationColObj optionalLookupPrev;
	protected ICFBamRelationColObj optionalLookupNext;
	protected ICFBamIndexColObj requiredLookupFromCol;
	protected ICFBamIndexColObj requiredLookupToCol;

	public CFBamRelationColObj() {
		isNew = true;
		requiredContainerRelation = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	public CFBamRelationColObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerRelation = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFBamRelationColObj retobj = ((ICFBamSchemaObj)schema).getRelationColTableObj().realiseRelationCol(
			(ICFBamRelationColObj)this );
		return( (ICFBamRelationColObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getRelationColTableObj().forgetRelationCol( (ICFBamRelationColObj)this, forgetSubObjects );
	}

	public ICFBamRelationColObj read() {
		ICFBamRelationColObj retobj = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamRelationColObj)retobj );
	}

	public ICFBamRelationColObj read( boolean forceRead ) {
		ICFBamRelationColObj retobj = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamRelationColObj)retobj );
	}

	public ICFBamRelationColObj moveUp() {
		ICFBamRelationColObj retobj = ((ICFBamSchemaObj)schema).getRelationColTableObj().moveUpRelationCol( this );
		return( (ICFBamRelationColObj)retobj );
	}

	public ICFBamRelationColObj moveDown() {
		ICFBamRelationColObj retobj = ((ICFBamSchemaObj)schema).getRelationColTableObj().moveDownRelationCol( this );
		return( (ICFBamRelationColObj)retobj );
	}

	public ICFBamRelationColTableObj getRelationColTable() {
		return( ((ICFBamSchemaObj)schema).getRelationColTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamRelationColBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableRelationCol().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamRelationColBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamRelationColBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamRelationColBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerRelation = null;
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	public CFBamRelationColBuff getRelationColBuff() {
		return( (CFBamRelationColBuff)getBuff() );
	}

	public CFBamRelationColPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelationCol().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamRelationColPKey value ) {
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

	public ICFBamRelationColEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamRelationColObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamRelationColObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getRelationColTableObj().lockRelationCol( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getRelationColTableObj().newEditInstance( lockobj );
		return( (ICFBamRelationColEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamRelationColEditObj getEdit() {
		return( edit );
	}

	public ICFBamRelationColEditObj getEditAsRelationCol() {
		return( (ICFBamRelationColEditObj)edit );
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

	public String getOptionalShortName() {
		return( getRelationColBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getRelationColBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getRelationColBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getRelationColBuff().getOptionalDescription() );
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
		if( ( requiredContainerRelation == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerRelation = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByIdIdx( getPKey().getRequiredTenantId(),
					getRelationColBuff().getRequiredRelationId(), forceRead );
			}
		}
		return( requiredContainerRelation );
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
			if( getRelationColBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationColBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationColBuff().getOptionalDefSchemaTenantId(),
					getRelationColBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public ICFBamRelationColObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamRelationColObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationColBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationColBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByIdIdx( getRelationColBuff().getOptionalPrevTenantId(),
					getRelationColBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamRelationColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamRelationColObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationColBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationColBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByIdIdx( getRelationColBuff().getOptionalNextTenantId(),
					getRelationColBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	public ICFBamIndexColObj getRequiredLookupFromCol() {
		return( getRequiredLookupFromCol( false ) );
	}

	public ICFBamIndexColObj getRequiredLookupFromCol( boolean forceRead ) {
		if( ( requiredLookupFromCol == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupFromCol = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIdIdx( getPKey().getRequiredTenantId(),
					getRelationColBuff().getRequiredFromColId(), forceRead );
			}
		}
		return( requiredLookupFromCol );
	}

	public ICFBamIndexColObj getRequiredLookupToCol() {
		return( getRequiredLookupToCol( false ) );
	}

	public ICFBamIndexColObj getRequiredLookupToCol( boolean forceRead ) {
		if( ( requiredLookupToCol == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToCol = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIdIdx( getPKey().getRequiredTenantId(),
					getRelationColBuff().getRequiredToColId(), forceRead );
			}
		}
		return( requiredLookupToCol );
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
