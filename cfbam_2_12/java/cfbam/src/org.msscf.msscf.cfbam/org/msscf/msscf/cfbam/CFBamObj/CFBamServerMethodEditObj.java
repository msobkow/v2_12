// Description: Java 11 edit object instance implementation for CFBam ServerMethod.

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

public class CFBamServerMethodEditObj
	extends CFBamScopeEditObj

	implements ICFBamServerMethodEditObj
{
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamTableObj requiredContainerForTable;

	public CFBamServerMethodEditObj( ICFBamServerMethodObj argOrig ) {
		super( argOrig );
		optionalLookupDefSchema = null;
		requiredContainerForTable = null;
	}

	public String getClassCode() {
		return( CFBamServerMethodObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ServerMethod" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerForTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerForTable();
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
		ICFBamServerMethodObj retobj = getSchema().getServerMethodTableObj().realiseServerMethod( (ICFBamServerMethodObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsServerMethod().getSchema()).getServerMethodTableObj().forgetServerMethod( getOrigAsServerMethod(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamServerMethodObj retobj = ((ICFBamSchemaObj)getOrigAsServerMethod().getSchema()).getServerMethodTableObj().createServerMethod( getOrigAsServerMethod() );
		if( retobj == getOrigAsServerMethod() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getServerMethodTableObj().updateServerMethod( (ICFBamServerMethodObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getServerMethodTableObj().deleteServerMethod( getOrigAsServerMethod() );
		return( null );
	}

	public ICFBamServerMethodTableObj getServerMethodTable() {
		return( orig.getSchema().getServerMethodTableObj() );
	}

	public ICFBamServerMethodEditObj getEditAsServerMethod() {
		return( (ICFBamServerMethodEditObj)this );
	}

	public ICFBamServerMethodObj getOrigAsServerMethod() {
		return( (ICFBamServerMethodObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsServerMethod().getSchema().getBackingStore()).getFactoryServerMethod().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			optionalLookupDefSchema = null;
			requiredContainerForTable = null;
		}
	}

	public CFBamServerMethodBuff getServerMethodBuff() {
		return( (CFBamServerMethodBuff)getBuff() );
	}

	public long getRequiredTableId() {
		return( getServerMethodBuff().getRequiredTableId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getServerMethodBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getServerMethodBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getServerMethodBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getServerMethodBuff().getRequiredName() != value ) {
			getServerMethodBuff().setRequiredName( value );
		}
	}

	public String getOptionalShortName() {
		return( getServerMethodBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getServerMethodBuff().getOptionalShortName() != value ) {
			getServerMethodBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getServerMethodBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getServerMethodBuff().getOptionalLabel() != value ) {
			getServerMethodBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getServerMethodBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getServerMethodBuff().getOptionalShortDescription() != value ) {
			getServerMethodBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getServerMethodBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getServerMethodBuff().getOptionalDescription() != value ) {
			getServerMethodBuff().setOptionalDescription( value );
		}
	}

	public String getOptionalSuffix() {
		return( getServerMethodBuff().getOptionalSuffix() );
	}

	public void setOptionalSuffix( String value ) {
		if( getServerMethodBuff().getOptionalSuffix() != value ) {
			getServerMethodBuff().setOptionalSuffix( value );
		}
	}

	public boolean getRequiredIsInstanceMethod() {
		return( getServerMethodBuff().getRequiredIsInstanceMethod() );
	}

	public void setRequiredIsInstanceMethod( boolean value ) {
		if( getServerMethodBuff().getRequiredIsInstanceMethod() != value ) {
			getServerMethodBuff().setRequiredIsInstanceMethod( value );
		}
	}

	public boolean getRequiredIsClientMethod() {
		return( getServerMethodBuff().getRequiredIsClientMethod() );
	}

	public void setRequiredIsClientMethod( boolean value ) {
		if( getServerMethodBuff().getRequiredIsClientMethod() != value ) {
			getServerMethodBuff().setRequiredIsClientMethod( value );
		}
	}

	public String getRequiredJMethodBody() {
		return( getServerMethodBuff().getRequiredJMethodBody() );
	}

	public void setRequiredJMethodBody( String value ) {
		if( getServerMethodBuff().getRequiredJMethodBody() != value ) {
			getServerMethodBuff().setRequiredJMethodBody( value );
		}
	}

	public String getRequiredCppMethodBody() {
		return( getServerMethodBuff().getRequiredCppMethodBody() );
	}

	public void setRequiredCppMethodBody( String value ) {
		if( getServerMethodBuff().getRequiredCppMethodBody() != value ) {
			getServerMethodBuff().setRequiredCppMethodBody( value );
		}
	}

	public String getRequiredCsMethodBody() {
		return( getServerMethodBuff().getRequiredCsMethodBody() );
	}

	public void setRequiredCsMethodBody( String value ) {
		if( getServerMethodBuff().getRequiredCsMethodBody() != value ) {
			getServerMethodBuff().setRequiredCsMethodBody( value );
		}
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getServerMethodBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getServerMethodBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsServerMethod().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getServerMethodBuff().getOptionalDefSchemaTenantId(),
					getServerMethodBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getServerMethodBuff();
			}
			if( value != null ) {
				getServerMethodBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getServerMethodBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getServerMethodBuff().setOptionalDefSchemaTenantId( null );
				getServerMethodBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public ICFBamTableObj getRequiredContainerForTable() {
		return( getRequiredContainerForTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerForTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerForTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsServerMethod().getSchema()).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getServerMethodBuff().getRequiredTableId() );
				requiredContainerForTable = obj;
				if( obj != null ) {
					getServerMethodBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getServerMethodBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerForTable = obj;
				}
			}
		}
		return( requiredContainerForTable );
	}

	public void setRequiredContainerForTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getServerMethodBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getServerMethodBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getServerMethodBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerForTable = value;
	}

	public List<ICFBamParamObj> getOptionalComponentsParams() {
		List<ICFBamParamObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsServerMethod().getSchema()).getParamTableObj().readParamByServerMethodIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamParamObj> getOptionalComponentsParams( boolean forceRead ) {
		List<ICFBamParamObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsServerMethod().getSchema()).getParamTableObj().readParamByServerMethodIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamServerMethodBuff origBuff = getOrigAsServerMethod().getServerMethodBuff();
		CFBamServerMethodBuff myBuff = getServerMethodBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamServerMethodBuff origBuff = getOrigAsServerMethod().getServerMethodBuff();
		CFBamServerMethodBuff myBuff = getServerMethodBuff();
		myBuff.set( origBuff );
	}
}
