// Description: Java 11 base object instance implementation for CFBam Value.

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

public class CFBamValueObj
	implements ICFBamValueObj
{
	public final static String CLASS_CODE = "VALU";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFBamValueEditObj edit;
	protected ICFBamSchemaObj schema;
	protected CFBamValuePKey pKey;
	protected CFBamValueBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFBamScopeObj requiredContainerScope;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamValueObj optionalLookupPrev;
	protected ICFBamValueObj optionalLookupNext;

	public CFBamValueObj() {
		getPKey().setClassCode( getClassCode() );
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamValueObj( ICFBamSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		getPKey().setClassCode( getClassCode() );
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFBamValueObj retobj = ((ICFBamSchemaObj)schema).getValueTableObj().realiseValue(
			(ICFBamValueObj)this );
		return( (ICFBamValueObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getValueTableObj().forgetValue( (ICFBamValueObj)this, forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamValueObj retobj = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamValueObj retobj = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveUp() {
		ICFBamValueObj retobj = ((ICFBamSchemaObj)schema).getValueTableObj().moveUpValue( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveDown() {
		ICFBamValueObj retobj = ((ICFBamSchemaObj)schema).getValueTableObj().moveDownValue( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueTableObj getValueTable() {
		return( ((ICFBamSchemaObj)schema).getValueTableObj() );
	}

	public ICFBamSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFBamSchemaObj value ) {
		schema = value;
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableValue().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamValueBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamValueBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamValueBuff getValueBuff() {
		return( (CFBamValueBuff)getBuff() );
	}

	public CFBamValuePKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryValue().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFBamValuePKey value ) {
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

	public ICFBamValueEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamValueObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamValueObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getValueTableObj().lockValue( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getValueTableObj().newEditInstance( lockobj );
		return( (ICFBamValueEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFBamValueEditObj getEdit() {
		return( edit );
	}

	public ICFBamValueEditObj getEditAsValue() {
		return( (ICFBamValueEditObj)edit );
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

	public String getOptionalShortName() {
		return( getValueBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getValueBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getValueBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getValueBuff().getOptionalDescription() );
	}

	public String getOptionalDefaultXmlValue() {
		return( getValueBuff().getOptionalDefaultXmlValue() );
	}

	public boolean getRequiredIsNullable() {
		return( getValueBuff().getRequiredIsNullable() );
	}

	public Boolean getOptionalGenerateId() {
		return( getValueBuff().getOptionalGenerateId() );
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
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFBamScopeObj getRequiredContainerScope() {
		return( getRequiredContainerScope( false ) );
	}

	public ICFBamScopeObj getRequiredContainerScope( boolean forceRead ) {
		if( ( requiredContainerScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerScope = ((ICFBamSchemaObj)schema).getScopeTableObj().readScopeByIdIdx( getPKey().getRequiredTenantId(),
					getValueBuff().getRequiredScopeId(), forceRead );
			}
		}
		return( requiredContainerScope );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getValueBuff().getOptionalDefSchemaTenantId(),
					getValueBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public List<ICFBamTableColObj> getOptionalChildrenRefTableCol() {
		List<ICFBamTableColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getTableColTableObj().readTableColByDataIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTableColObj> getOptionalChildrenRefTableCol( boolean forceRead ) {
		List<ICFBamTableColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getTableColTableObj().readTableColByDataIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalChildrenRefIndexCol() {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalChildrenRefIndexCol( boolean forceRead ) {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByColIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamValueObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamValueObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalPrevTenantId(),
					getValueBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamValueObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamValueObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getValueBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getValueBuff().getOptionalNextTenantId(),
					getValueBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
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
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
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
