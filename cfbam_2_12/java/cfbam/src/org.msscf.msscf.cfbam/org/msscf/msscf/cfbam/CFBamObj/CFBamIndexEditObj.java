// Description: Java 11 edit object instance implementation for CFBam Index.

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

public class CFBamIndexEditObj
	extends CFBamScopeEditObj

	implements ICFBamIndexEditObj
{
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFSecTenantObj requiredOwnerIdxTenant;

	public CFBamIndexEditObj( ICFBamIndexObj argOrig ) {
		super( argOrig );
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
		requiredOwnerIdxTenant = null;
	}

	public String getClassCode() {
		return( CFBamIndexObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamIndexObj retobj = getSchema().getIndexTableObj().realiseIndex( (ICFBamIndexObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getIndexTableObj().forgetIndex( getOrigAsIndex(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamIndexObj retobj = ((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getIndexTableObj().createIndex( getOrigAsIndex() );
		if( retobj == getOrigAsIndex() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getIndexTableObj().updateIndex( (ICFBamIndexObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getIndexTableObj().deleteIndex( getOrigAsIndex() );
		return( null );
	}

	public ICFBamIndexTableObj getIndexTable() {
		return( orig.getSchema().getIndexTableObj() );
	}

	public ICFBamIndexEditObj getEditAsIndex() {
		return( (ICFBamIndexEditObj)this );
	}

	public ICFBamIndexObj getOrigAsIndex() {
		return( (ICFBamIndexObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsIndex().getSchema().getBackingStore()).getFactoryIndex().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerTable = null;
			optionalLookupDefSchema = null;
			requiredOwnerIdxTenant = null;
		}
	}

	public CFBamIndexBuff getIndexBuff() {
		return( (CFBamIndexBuff)getBuff() );
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

	public void setRequiredName( String value ) {
		if( getIndexBuff().getRequiredName() != value ) {
			getIndexBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getIndexBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getIndexBuff().getOptionalShortName() != value ) {
			getIndexBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getIndexBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getIndexBuff().getOptionalLabel() != value ) {
			getIndexBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getIndexBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getIndexBuff().getOptionalShortDescription() != value ) {
			getIndexBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getIndexBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getIndexBuff().getOptionalDescription() != value ) {
			getIndexBuff().setOptionalDescription( value );
		}
	}

	public String getOptionalDbName() {
		return( getIndexBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getIndexBuff().getOptionalDbName() != value ) {
			getIndexBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalSuffix() {
		return( getIndexBuff().getOptionalSuffix() );
	}

	public void setOptionalSuffix( String value ) {
		if( getIndexBuff().getOptionalSuffix() != value ) {
			getIndexBuff().setOptionalSuffix( value );
		}
	}

	public boolean getRequiredIsUnique() {
		return( getIndexBuff().getRequiredIsUnique() );
	}

	public void setRequiredIsUnique( boolean value ) {
		if( getIndexBuff().getRequiredIsUnique() != value ) {
			getIndexBuff().setRequiredIsUnique( value );
		}
	}

	public boolean getRequiredIsDbMapped() {
		return( getIndexBuff().getRequiredIsDbMapped() );
	}

	public void setRequiredIsDbMapped( boolean value ) {
		if( getIndexBuff().getRequiredIsDbMapped() != value ) {
			getIndexBuff().setRequiredIsDbMapped( value );
		}
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getIndexBuff().getRequiredTableId() );
				requiredContainerTable = obj;
				if( obj != null ) {
					getIndexBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getIndexBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerTable = obj;
				}
			}
		}
		return( requiredContainerTable );
	}

	public void setRequiredContainerTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getIndexBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getIndexBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerTable = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getIndexBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getIndexBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexBuff().getOptionalDefSchemaTenantId(),
					getIndexBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getIndexBuff();
			}
			if( value != null ) {
				getIndexBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getIndexBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getIndexBuff().setOptionalDefSchemaTenantId( null );
				getIndexBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public List<ICFBamIndexColObj> getOptionalComponentsColumns() {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getIndexColTableObj().readIndexColByIndexIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamIndexColObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getIndexColTableObj().readIndexColByIndexIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFSecTenantObj getRequiredOwnerIdxTenant() {
		return( getRequiredOwnerIdxTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerIdxTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerIdxTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsIndex().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerIdxTenant = obj;
			}
		}
		return( requiredOwnerIdxTenant );
	}

	public void setRequiredOwnerIdxTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getIndexBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getIndexBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerIdxTenant = value;
			super.setRequiredOwnerTenant( value );
	}

	public void copyBuffToOrig() {
		CFBamIndexBuff origBuff = getOrigAsIndex().getIndexBuff();
		CFBamIndexBuff myBuff = getIndexBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamIndexBuff origBuff = getOrigAsIndex().getIndexBuff();
		CFBamIndexBuff myBuff = getIndexBuff();
		myBuff.set( origBuff );
	}
}
