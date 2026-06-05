// Description: Java 11 edit object instance implementation for CFBam Relation.

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

public class CFBamRelationEditObj
	extends CFBamScopeEditObj

	implements ICFBamRelationEditObj
{
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamTableObj requiredContainerFromTable;
	protected ICFSecTenantObj requiredOwnerRelTenant;
	protected ICFBamIndexObj requiredLookupFromIndex;
	protected ICFBamTableObj requiredLookupToTable;
	protected ICFBamIndexObj requiredLookupToIndex;
	protected ICFBamRelationObj optionalLookupNarrowed;

	public CFBamRelationEditObj( ICFBamRelationObj argOrig ) {
		super( argOrig );
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredOwnerRelTenant = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	public String getClassCode() {
		return( CFBamRelationObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamRelationObj retobj = getSchema().getRelationTableObj().realiseRelation( (ICFBamRelationObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getRelationTableObj().forgetRelation( getOrigAsRelation(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamRelationObj retobj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getRelationTableObj().createRelation( getOrigAsRelation() );
		if( retobj == getOrigAsRelation() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getRelationTableObj().updateRelation( (ICFBamRelationObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getRelationTableObj().deleteRelation( getOrigAsRelation() );
		return( null );
	}

	public ICFBamRelationTableObj getRelationTable() {
		return( orig.getSchema().getRelationTableObj() );
	}

	public ICFBamRelationEditObj getEditAsRelation() {
		return( (ICFBamRelationEditObj)this );
	}

	public ICFBamRelationObj getOrigAsRelation() {
		return( (ICFBamRelationObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsRelation().getSchema().getBackingStore()).getFactoryRelation().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			optionalLookupDefSchema = null;
			requiredContainerFromTable = null;
			requiredOwnerRelTenant = null;
			requiredLookupFromIndex = null;
			requiredLookupToTable = null;
			requiredLookupToIndex = null;
			optionalLookupNarrowed = null;
		}
	}

	public CFBamRelationBuff getRelationBuff() {
		return( (CFBamRelationBuff)getBuff() );
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

	public void setRequiredName( String value ) {
		if( getRelationBuff().getRequiredName() != value ) {
			getRelationBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getRelationBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getRelationBuff().getOptionalShortName() != value ) {
			getRelationBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getRelationBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getRelationBuff().getOptionalLabel() != value ) {
			getRelationBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getRelationBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getRelationBuff().getOptionalShortDescription() != value ) {
			getRelationBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getRelationBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getRelationBuff().getOptionalDescription() != value ) {
			getRelationBuff().setOptionalDescription( value );
		}
	}

	public ICFBamSchema.RelationTypeEnum getRequiredRelationType() {
		return( getRelationBuff().getRequiredRelationType() );
	}

	public void setRequiredRelationType( ICFBamSchema.RelationTypeEnum value ) {
		if( getRelationBuff().getRequiredRelationType() != value ) {
			getRelationBuff().setRequiredRelationType( value );
		}
	}

	public String getOptionalDbName() {
		return( getRelationBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getRelationBuff().getOptionalDbName() != value ) {
			getRelationBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalSuffix() {
		return( getRelationBuff().getOptionalSuffix() );
	}

	public void setOptionalSuffix( String value ) {
		if( getRelationBuff().getOptionalSuffix() != value ) {
			getRelationBuff().setOptionalSuffix( value );
		}
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

	public void setRequiredIsRequired( boolean value ) {
		if( getRelationBuff().getRequiredIsRequired() != value ) {
			getRelationBuff().setRequiredIsRequired( value );
		}
	}

	public boolean getRequiredAllowAddendum() {
		return( getRelationBuff().getRequiredAllowAddendum() );
	}

	public void setRequiredAllowAddendum( boolean value ) {
		if( getRelationBuff().getRequiredAllowAddendum() != value ) {
			getRelationBuff().setRequiredAllowAddendum( value );
		}
	}

	public boolean getRequiredIsXsdContainer() {
		return( getRelationBuff().getRequiredIsXsdContainer() );
	}

	public void setRequiredIsXsdContainer( boolean value ) {
		if( getRelationBuff().getRequiredIsXsdContainer() != value ) {
			getRelationBuff().setRequiredIsXsdContainer( value );
		}
	}

	public boolean getRequiredIsLateResolver() {
		return( getRelationBuff().getRequiredIsLateResolver() );
	}

	public void setRequiredIsLateResolver( boolean value ) {
		if( getRelationBuff().getRequiredIsLateResolver() != value ) {
			getRelationBuff().setRequiredIsLateResolver( value );
		}
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
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationBuff().getOptionalDefSchemaTenantId(),
					getRelationBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getRelationBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getRelationBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getRelationBuff().setOptionalDefSchemaTenantId( null );
				getRelationBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamTableObj getRequiredContainerFromTable() {
		return( getRequiredContainerFromTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerFromTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerFromTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredTableId() );
				requiredContainerFromTable = obj;
				if( obj != null ) {
					getRelationBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getRelationBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerFromTable = obj;
				}
			}
		}
		return( requiredContainerFromTable );
	}

	public void setRequiredContainerFromTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerFromTable = value;
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns() {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamRelationColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getRelationColTableObj().readRelationColByRelationIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep() {
		List<ICFBamPopTopDepObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopTopDepObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFSecTenantObj getRequiredOwnerRelTenant() {
		return( getRequiredOwnerRelTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerRelTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerRelTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerRelTenant = obj;
			}
		}
		return( requiredOwnerRelTenant );
	}

	public void setRequiredOwnerRelTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerRelTenant = value;
			super.setRequiredOwnerTenant( value );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex() {
		return( getRequiredLookupFromIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupFromIndex( boolean forceRead ) {
		if( forceRead || ( requiredLookupFromIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredFromIndexId() );
				requiredLookupFromIndex = obj;
			}
		}
		return( requiredLookupFromIndex );
	}

	public void setRequiredLookupFromIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredFromIndexId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupFromIndex = value;
	}

	public ICFBamTableObj getRequiredLookupToTable() {
		return( getRequiredLookupToTable( false ) );
	}

	public ICFBamTableObj getRequiredLookupToTable( boolean forceRead ) {
		if( forceRead || ( requiredLookupToTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToTableId() );
				requiredLookupToTable = obj;
			}
		}
		return( requiredLookupToTable );
	}

	public void setRequiredLookupToTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredToTableId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupToTable = value;
	}

	public ICFBamIndexObj getRequiredLookupToIndex() {
		return( getRequiredLookupToIndex( false ) );
	}

	public ICFBamIndexObj getRequiredLookupToIndex( boolean forceRead ) {
		if( forceRead || ( requiredLookupToIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamIndexObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
					getRelationBuff().getRequiredToIndexId() );
				requiredLookupToIndex = obj;
			}
		}
		return( requiredLookupToIndex );
	}

	public void setRequiredLookupToIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getRelationBuff().setRequiredToIndexId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupToIndex = value;
	}

	public ICFBamRelationObj getOptionalLookupNarrowed() {
		return( getOptionalLookupNarrowed( false ) );
	}

	public ICFBamRelationObj getOptionalLookupNarrowed( boolean forceRead ) {
		if( forceRead || ( optionalLookupNarrowed == null ) ) {
			boolean anyMissing = false;
			if( getRelationBuff().getOptionalNarrowedTenantId() == null ) {
				anyMissing = true;
			}
			if( getRelationBuff().getOptionalNarrowedId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamRelationObj obj = ((ICFBamSchemaObj)getOrigAsRelation().getSchema()).getRelationTableObj().readRelationByIdIdx( getRelationBuff().getOptionalNarrowedTenantId(),
					getRelationBuff().getOptionalNarrowedId() );
				optionalLookupNarrowed = obj;
			}
		}
		return( optionalLookupNarrowed );
	}

	public void setOptionalLookupNarrowed( ICFBamRelationObj value ) {
			if( buff == null ) {
				getRelationBuff();
			}
			if( value != null ) {
				getRelationBuff().setOptionalNarrowedTenantId( value.getRequiredTenantId() );
				getRelationBuff().setOptionalNarrowedId( value.getRequiredId() );
			}
			else {
				getRelationBuff().setOptionalNarrowedTenantId( null );
				getRelationBuff().setOptionalNarrowedId( null );
			}
			optionalLookupNarrowed = value;
	}

	public void copyBuffToOrig() {
		CFBamRelationBuff origBuff = getOrigAsRelation().getRelationBuff();
		CFBamRelationBuff myBuff = getRelationBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamRelationBuff origBuff = getOrigAsRelation().getRelationBuff();
		CFBamRelationBuff myBuff = getRelationBuff();
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
