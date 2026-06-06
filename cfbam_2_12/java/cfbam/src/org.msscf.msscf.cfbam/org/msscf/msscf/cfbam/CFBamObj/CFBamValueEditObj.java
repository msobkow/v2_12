// Description: Java 11 edit object instance implementation for CFBam Value.

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

public class CFBamValueEditObj
	implements ICFBamValueEditObj
{
	protected ICFBamValueObj orig;
	protected CFBamValueBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamScopeObj requiredContainerScope;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamValueObj optionalLookupPrev;
	protected ICFBamValueObj optionalLookupNext;

	public CFBamValueEditObj( ICFBamValueObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFBamValueBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamValueBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamValueBuff buff = getBuff();
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
		return( CFBamValueObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Value" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamScopeObj scope = getRequiredContainerScope();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamScopeObj scope = getRequiredContainerScope();
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

	public ICFBamValueObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamValueObj retobj = getSchema().getValueTableObj().realiseValue( (ICFBamValueObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsValue().getSchema()).getValueTableObj().forgetValue( getOrigAsValue(), forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamValueObj retval = getOrigAsValue().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamValueObj retval = getOrigAsValue().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFBamValueObj moveUp() {
		throw new CFLibUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj moveDown() {
		throw new CFLibUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj create() {
		copyBuffToOrig();
		ICFBamValueObj retobj = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getValueTableObj().createValue( getOrigAsValue() );
		if( retobj == getOrigAsValue() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getValueTableObj().updateValue( (ICFBamValueObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getValueTableObj().deleteValue( getOrigAsValue() );
		return( null );
	}

	public ICFBamValueTableObj getValueTable() {
		return( orig.getSchema().getValueTableObj() );
	}

	public ICFBamValueEditObj getEdit() {
		return( (ICFBamValueEditObj)this );
	}

	public ICFBamValueEditObj getEditAsValue() {
		return( (ICFBamValueEditObj)this );
	}

	public ICFBamValueEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFBamValueObj getOrig() {
		return( orig );
	}

	public ICFBamValueObj getOrigAsValue() {
		return( (ICFBamValueObj)orig );
	}

	public ICFBamSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsValue().getSchema().getBackingStore()).getFactoryValue().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerScope = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	public CFBamValueBuff getValueBuff() {
		return( (CFBamValueBuff)getBuff() );
	}

	public CFBamValuePKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFBamValuePKey value ) {
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

	public long getRequiredScopeId() {
		return( getValueBuff().getRequiredScopeId() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getValueBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getValueBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getValueBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getValueBuff().getRequiredName() != value ) {
			getValueBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getValueBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getValueBuff().getOptionalShortName() != value ) {
			getValueBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getValueBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getValueBuff().getOptionalLabel() != value ) {
			getValueBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getValueBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getValueBuff().getOptionalShortDescription() != value ) {
			getValueBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getValueBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getValueBuff().getOptionalDescription() != value ) {
			getValueBuff().setOptionalDescription( value );
		}
	}

	public String getOptionalDefaultXmlValue() {
		return( getValueBuff().getOptionalDefaultXmlValue() );
	}

	public void setOptionalDefaultXmlValue( String value ) {
		if( getValueBuff().getOptionalDefaultXmlValue() != value ) {
			getValueBuff().setOptionalDefaultXmlValue( value );
		}
	}

	public boolean getRequiredIsNullable() {
		return( getValueBuff().getRequiredIsNullable() );
	}

	public void setRequiredIsNullable( boolean value ) {
		if( getValueBuff().getRequiredIsNullable() != value ) {
			getValueBuff().setRequiredIsNullable( value );
		}
	}

	public Boolean getOptionalGenerateId() {
		return( getValueBuff().getOptionalGenerateId() );
	}

	public void setOptionalGenerateId( Boolean value ) {
		if( getValueBuff().getOptionalGenerateId() != value ) {
			getValueBuff().setOptionalGenerateId( value );
		}
	}

	public Long getOptionalPrevTenantId() {
		return( getValueBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getValueBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getValueBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getValueBuff().getOptionalNextId() );
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getValueBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFBamScopeObj getRequiredContainerScope() {
		return( getRequiredContainerScope( false ) );
	}

	public ICFBamScopeObj getRequiredContainerScope( boolean forceRead ) {
		if( forceRead || ( requiredContainerScope == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamScopeObj obj = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getScopeTableObj().readScopeByIdIdx( getPKey().getRequiredTenantId(),
					getValueBuff().getRequiredScopeId() );
				requiredContainerScope = obj;
				if( obj != null ) {
					getValueBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getValueBuff().setRequiredScopeId( obj.getRequiredId() );
					requiredContainerScope = obj;
				}
			}
		}
		return( requiredContainerScope );
	}

	public void setRequiredContainerScope( ICFBamScopeObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getValueBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getValueBuff().setRequiredScopeId( value.getRequiredId() );
			}
			requiredContainerScope = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getValueBuff().getOptionalDefSchemaTenantId(),
					getValueBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getValueBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalDefSchemaTenantId( null );
				getValueBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public List<ICFBamTableColObj> getOptionalChildrenRefTableCol() {
		List<ICFBamTableColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getTableColTableObj().readTableColByDataIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTableColObj> getOptionalChildrenRefTableCol( boolean forceRead ) {
		List<ICFBamTableColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getTableColTableObj().readTableColByDataIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalChildrenRefIndexCol() {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getIndexColTableObj().readIndexColByColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalChildrenRefIndexCol( boolean forceRead ) {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getIndexColTableObj().readIndexColByColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamValueObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamValueObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamValueObj obj = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalPrevTenantId(),
					getValueBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamValueObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getValueBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalPrevTenantId( null );
				getValueBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamValueObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamValueObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamValueObj obj = ((ICFBamSchemaObj)getOrigAsValue().getSchema()).getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalNextTenantId(),
					getValueBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamValueObj value ) {
			if( buff == null ) {
				getValueBuff();
			}
			if( value != null ) {
				getValueBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getValueBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getValueBuff().setOptionalNextTenantId( null );
				getValueBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFBamValueBuff origBuff = getOrigAsValue().getValueBuff();
		CFBamValueBuff myBuff = getValueBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamValueBuff origBuff = getOrigAsValue().getValueBuff();
		CFBamValueBuff myBuff = getValueBuff();
		myBuff.set( origBuff );
	}

	public List<ICFBamIndexObj> getAffectedIndexes() {
		List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
		ICFBamScopeObj container = getRequiredContainerScope();
		ICFBamTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getAffectedIndexes() RequiredContainerScope has no value");
		}
		else if( container instanceof ICFBamTableObj ) {
			tableDef = (ICFBamTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getAffectedIndexes() RequiredContainerScope is not an ICFBamTableObj");
		}
		Iterator<ICFBamIndexObj> cursorIndexDef = tableDef.getOptionalComponentsIndex().iterator();
		while (cursorIndexDef.hasNext())
		{
			ICFBamIndexObj indexDef = cursorIndexDef.next();

			Iterator<ICFBamIndexColObj> cursorIndexColDef = indexDef.getOptionalComponentsColumns().iterator();
			while (cursorIndexColDef.hasNext())
			{
				ICFBamIndexColObj indexColDef = cursorIndexColDef.next();
				if( indexColDef.getRequiredLookupColumn().equals(this))
				{
					list.add(indexDef);
				}
			}
		}
		return( list );
	}

	public List<ICFBamRelationObj> getAffectedRelations() {
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		ICFBamScopeObj container = getRequiredContainerScope();
		ICFBamTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getAffectedRelations() RequiredContainerScope has no value");
		}
		else if( container instanceof ICFBamTableObj ) {
			tableDef = (ICFBamTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getAffectedRelations() RequiredContainerScope is not an ICFBamTableObj");
		}
		Iterator<ICFBamRelationObj> cursorRelationDef = tableDef.getOptionalComponentsRelation().iterator();
		while (cursorRelationDef.hasNext())
		{
			ICFBamRelationObj relationDef = cursorRelationDef.next();
			Iterator<ICFBamRelationColObj> cursorRelationColDef = relationDef.getOptionalComponentsColumns().iterator();
			while (cursorRelationColDef.hasNext())
			{
				ICFBamRelationColObj relationColDef = cursorRelationColDef.next();
				if( relationColDef.getRequiredLookupFromCol().equals(this))
				{
					list.add(relationDef);
				}
			}
		}
		return( list );
	}

	public List<ICFBamIndexObj> getAffectedUniqueIndexes() {
		List<ICFBamIndexObj> affectedIndexes = getAffectedIndexes();
		List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
		ICFBamScopeObj container = getRequiredContainerScope();
		ICFBamTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getAffectedUniqueIndexes() RequiredContainerScope has no value");
		}
		else if( container instanceof ICFBamTableObj ) {
			tableDef = (ICFBamTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getAffectedUniqueIndexes() RequiredContainerScope is not an ICFBamTableObj");
		}
		Iterator<ICFBamIndexObj> cursorIndexDef = affectedIndexes.iterator();
		while (cursorIndexDef.hasNext())
		{
			ICFBamIndexObj indexDef = cursorIndexDef.next();
			if( indexDef.getRequiredIsUnique())
			{
				list.add(indexDef);
			}
		}
		return( list );
	}

	public List<ICFBamRelationObj> getColumnInMemberRelations() {
		final String S_ProcName = "ValueDefObj.getColumnInMemberRelations() ";

		ICFBamScopeObj scopeDef = (ICFBamScopeObj)getObjScope();
		if( scopeDef == null)
		{
			throw new RuntimeException(S_ProcName + "OptionalParentScope is required");
		}
		else if( scopeDef instanceof ICFBamTableObj)
		{
			List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
			Iterator<ICFBamRelationObj> relations = ((ICFBamTableObj)scopeDef).getOptionalComponentsRelation().iterator();
			ICFBamRelationColObj relationCol;
			Iterator<ICFBamRelationColObj> relationColumns;
			ICFBamRelationObj relation;
			ICFBamSchema.RelationTypeEnum relType;
			while (relations.hasNext())
			{
				relation = relations.next();
				relType = relation.getRequiredRelationType();
				if( ( relType == ICFBamSchema.RelationTypeEnum.Lookup )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Container )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Components )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Parent )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Children )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Owner ) )
				{
					relationColumns = relation.getOptionalComponentsColumns().iterator();
					while (relationColumns.hasNext())
					{
						relationCol = relationColumns.next();
						if( this == relationCol.getRequiredLookupFromCol().getRequiredLookupColumn() )
						{
							list.add(relation);
							break;
						}
					}
				}
			}
			return( list );
		}
		else
		{
			throw new RuntimeException(S_ProcName + "Expected scope definition to be an ICFBamTableObj");
		}
	}

	public List<ICFBamRelationObj> getColumnInComponentsRelations() {
		final String S_ProcName = "ValueDefObj.getColumnInComponentsRelations() ";

		ICFBamScopeObj container = getRequiredContainerScope();
		ICFBamTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getColumnInComponentsRelations() RequiredContainerScope has no value");
		}
		else if( container instanceof ICFBamTableObj ) {
			tableDef = (ICFBamTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getColumnInComponentsRelations() RequiredContainerScope is not an ICFBamTableObj");
		}

		ICFBamRelationColObj relationCol;
		ICFBamRelationObj relation;
		Iterator<ICFBamRelationColObj> relationColumns;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> relations = tableDef.getOptionalComponentsRelation().iterator();

		while( relations.hasNext() ) {
			relation = relations.next();
			if( relation.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Components ) {
				relationColumns = relation.getOptionalComponentsColumns().iterator();
				while (relationColumns.hasNext()) {
					relationCol = relationColumns.next();
					if( this == relationCol.getRequiredLookupFromCol().getRequiredLookupColumn() ) {
						list.add(relation);
						break;
					}
				}
			}
		}

		return( list );
	}

	public boolean getGenerateId() {
		boolean ret;
		if( getOptionalGenerateId() != null )		 {
			ret = getOptionalGenerateId().booleanValue();
		}
		else {
			ret = false;
		}
		return( ret );
	}
}
