// Description: Java 11 base object instance implementation for CFBam Relation.

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

public class CFBamRelationObj
	extends CFBamScopeObj
	implements ICFBamRelationObj
{
	public final static String CLASS_CODE = "RELD";
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamTableObj requiredContainerFromTable;
	protected ICFSecTenantObj requiredOwnerRelTenant;
	protected ICFBamIndexObj requiredLookupFromIndex;
	protected ICFBamTableObj requiredLookupToTable;
	protected ICFBamIndexObj requiredLookupToIndex;
	protected ICFBamRelationObj optionalLookupNarrowed;

	public CFBamRelationObj() {
		super();
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredOwnerRelTenant = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public CFBamRelationObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredOwnerRelTenant = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Relation" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerFromTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerFromTable();
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
			subObj = ((ICFBamSchemaObj)getSchema()).getRelationColTableObj().readRelationColByUNameIdx( getRequiredTenantId(),
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

	public ICFBamScopeObj realise() {
		ICFBamRelationObj retobj = ((ICFBamSchemaObj)schema).getRelationTableObj().realiseRelation(
			(ICFBamRelationObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getRelationTableObj().forgetRelation( (ICFBamRelationObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamRelationObj retobj = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamRelationObj retobj = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamRelationTableObj getRelationTable() {
		return( ((ICFBamSchemaObj)schema).getRelationTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryRelation().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableRelation().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamRelationBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamRelationBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredOwnerRelTenant = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public CFBamRelationBuff getRelationBuff() {
		return( (CFBamRelationBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamRelationObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamRelationObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getRelationTableObj().lockRelation( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getRelationTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamRelationEditObj getEditAsRelation() {
		return( (ICFBamRelationEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamScopeBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamScopeBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredTableId() {
		return( getRelationBuff().getRequiredTableId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getRelationBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getRelationBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getRelationBuff().getRequiredName() );
	}

	public String getOptionalShortName() {
		return( getRelationBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getRelationBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getRelationBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getRelationBuff().getOptionalDescription() );
	}

	public ICFBamSchema.RelationTypeEnum getRequiredRelationType() {
		return( getRelationBuff().getRequiredRelationType() );
	}

	public String getOptionalDbName() {
		return( getRelationBuff().getOptionalDbName() );
	}

	public String getOptionalSuffix() {
		return( getRelationBuff().getOptionalSuffix() );
	}

	public long getRequiredFromIndexId() {
		return( getRelationBuff().getRequiredFromIndexId() );
	}

	public long getRequiredToTableId() {
		return( getRelationBuff().getRequiredToTableId() );
	}

	public long getRequiredToIndexId() {
		return( getRelationBuff().getRequiredToIndexId() );
	}

	public boolean getRequiredIsRequired() {
		return( getRelationBuff().getRequiredIsRequired() );
	}

	public boolean getRequiredAllowAddendum() {
		return( getRelationBuff().getRequiredAllowAddendum() );
	}

	public boolean getRequiredIsXsdContainer() {
		return( getRelationBuff().getRequiredIsXsdContainer() );
	}

	public boolean getRequiredIsLateResolver() {
		return( getRelationBuff().getRequiredIsLateResolver() );
	}

	public Long getOptionalNarrowedTenantId() {
		return( getRelationBuff().getOptionalNarrowedTenantId() );
	}

	public Long getOptionalNarrowedId() {
		return( getRelationBuff().getOptionalNarrowedId() );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationBuff().getOptionalDefSchemaTenantId(),
					getRelationBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public ICFBamTableObj getRequiredContainerFromTable() {
		return( getRequiredContainerFromTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerFromTable( boolean forceRead ) {
		if( ( requiredContainerFromTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerFromTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerFromTable );
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns() {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep() {
		List<ICFBamPopTopDepObj> retval;
		retval = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopTopDepObj> retval;
		retval = ((ICFBamSchemaObj)schema).getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFSecTenantObj getRequiredOwnerRelTenant() {
		return( getRequiredOwnerRelTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerRelTenant( boolean forceRead ) {
		if( ( requiredOwnerRelTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerRelTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerRelTenant );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex() {
		return( getRequiredLookupFromIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex( boolean forceRead ) {
		if( ( requiredLookupFromIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupFromIndex = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredFromIndexId(), forceRead );
			}
		}
		return( requiredLookupFromIndex );
	}

	public ICFBamTableObj getRequiredLookupToTable() {
		return( getRequiredLookupToTable( false ) );
	}

	public ICFBamTableObj getRequiredLookupToTable( boolean forceRead ) {
		if( ( requiredLookupToTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToTableId(), forceRead );
			}
		}
		return( requiredLookupToTable );
	}

	public ICFBamIndexObj getRequiredLookupToIndex() {
		return( getRequiredLookupToIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupToIndex( boolean forceRead ) {
		if( ( requiredLookupToIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToIndex = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToIndexId(), forceRead );
			}
		}
		return( requiredLookupToIndex );
	}

	public ICFBamRelationObj getOptionalLookupNarrowed() {
		return( getOptionalLookupNarrowed( false ) );
	}

	public ICFBamRelationObj getOptionalLookupNarrowed( boolean forceRead ) {
		if( ( optionalLookupNarrowed == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalNarrowedTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalNarrowedId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNarrowed = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByIdIdx( getRelationBuff().getOptionalNarrowedTenantId(),
					getRelationBuff().getOptionalNarrowedId(), forceRead );
			}
		}
		return( optionalLookupNarrowed );
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
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMinorVersionObj) curDef ) );
			}
			else if( curDef instanceof ICFBamMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMajorVersionObj) curDef ) );
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
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMinorVersionObj) curDef ) );
			}
			else if( curDef instanceof ICFBamMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (ICFBamMajorVersionObj) curDef ) );
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
