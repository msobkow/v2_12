// Description: Java 11 base object instance implementation for CFBam Index.

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

public class CFBamIndexObj
	extends CFBamScopeObj
	implements ICFBamIndexObj
{
	public final static String CLASS_CODE = "IDXD";
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFSecTenantObj requiredOwnerIdxTenant;

	public CFBamIndexObj() {
		super();
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
		requiredOwnerIdxTenant = null;
	}

	public CFBamIndexObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
		requiredOwnerIdxTenant = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Index" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
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
			subObj = ((ICFBamSchemaObj)getSchema()).getIndexColTableObj().readIndexColByUNameIdx( getRequiredTenantId(),
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
		ICFBamIndexObj retobj = ((ICFBamSchemaObj)schema).getIndexTableObj().realiseIndex(
			(ICFBamIndexObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getIndexTableObj().forgetIndex( (ICFBamIndexObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamIndexObj retobj = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamIndexObj retobj = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamIndexTableObj getIndexTable() {
		return( ((ICFBamSchemaObj)schema).getIndexTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryIndex().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableIndex().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamIndexBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamIndexBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
		requiredOwnerIdxTenant = null;
	}

	public CFBamIndexBuff getIndexBuff() {
		return( (CFBamIndexBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamIndexObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamIndexObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getIndexTableObj().lockIndex( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getIndexTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamIndexEditObj getEditAsIndex() {
		return( (ICFBamIndexEditObj)edit );
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
		return( getIndexBuff().getRequiredTableId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getIndexBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getIndexBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getIndexBuff().getRequiredName() );
	}

	public String getOptionalShortName() {
		return( getIndexBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getIndexBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getIndexBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getIndexBuff().getOptionalDescription() );
	}

	public String getOptionalDbName() {
		return( getIndexBuff().getOptionalDbName() );
	}

	public String getOptionalSuffix() {
		return( getIndexBuff().getOptionalSuffix() );
	}

	public boolean getRequiredIsUnique() {
		return( getIndexBuff().getRequiredIsUnique() );
	}

	public boolean getRequiredIsDbMapped() {
		return( getIndexBuff().getRequiredIsDbMapped() );
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( ( requiredContainerTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getIndexBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerTable );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexBuff().getOptionalDefSchemaTenantId(),
					getIndexBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public List<ICFBamIndexColObj> getOptionalComponentsColumns() {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIndexIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)schema).getIndexColTableObj().readIndexColByIndexIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFSecTenantObj getRequiredOwnerIdxTenant() {
		return( getRequiredOwnerIdxTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerIdxTenant( boolean forceRead ) {
		if( ( requiredOwnerIdxTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerIdxTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerIdxTenant );
	}
}
