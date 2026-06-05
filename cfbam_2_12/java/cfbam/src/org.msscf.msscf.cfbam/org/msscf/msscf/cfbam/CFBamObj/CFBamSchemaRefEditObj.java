// Description: Java 11 edit object instance implementation for CFBam SchemaRef.

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

public class CFBamSchemaRefEditObj
	extends CFBamScopeEditObj

	implements ICFBamSchemaRefEditObj
{
	protected ICFBamSchemaDefObj requiredContainerSchema;
	protected ICFBamSchemaDefObj optionalLookupRefSchema;
	protected ICFBamSchemaRefObj optionalLookupPrev;
	protected ICFBamSchemaRefObj optionalLookupNext;

	public CFBamSchemaRefEditObj( ICFBamSchemaRefObj argOrig ) {
		super( argOrig );
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CFBamSchemaRefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SchemaRef" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchema();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchema();
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
		ICFBamSchemaRefObj retobj = getSchema().getSchemaRefTableObj().realiseSchemaRef( (ICFBamSchemaRefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().forgetSchemaRef( getOrigAsSchemaRef(), forgetSubObjects );
	}

	public ICFBamSchemaRefObj moveUp() {
		throw new CFLibUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamSchemaRefObj moveDown() {
		throw new CFLibUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamSchemaRefObj retobj = ((ICFBamSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().createSchemaRef( getOrigAsSchemaRef() );
		if( retobj == getOrigAsSchemaRef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getSchemaRefTableObj().updateSchemaRef( (ICFBamSchemaRefObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getSchemaRefTableObj().deleteSchemaRef( getOrigAsSchemaRef() );
		return( null );
	}

	public ICFBamSchemaRefTableObj getSchemaRefTable() {
		return( orig.getSchema().getSchemaRefTableObj() );
	}

	public ICFBamSchemaRefEditObj getEditAsSchemaRef() {
		return( (ICFBamSchemaRefEditObj)this );
	}

	public ICFBamSchemaRefObj getOrigAsSchemaRef() {
		return( (ICFBamSchemaRefObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsSchemaRef().getSchema().getBackingStore()).getFactorySchemaRef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerSchema = null;
			optionalLookupRefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	public CFBamSchemaRefBuff getSchemaRefBuff() {
		return( (CFBamSchemaRefBuff)getBuff() );
	}

	public long getRequiredSchemaId() {
		return( getSchemaRefBuff().getRequiredSchemaId() );
	}

	public String getRequiredName() {
		return( getSchemaRefBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getSchemaRefBuff().getRequiredName() != value ) {
			getSchemaRefBuff().setRequiredName( value );
		}
	}

	public String getRequiredRefModelName() {
		return( getSchemaRefBuff().getRequiredRefModelName() );
	}

	public void setRequiredRefModelName( String value ) {
		if( getSchemaRefBuff().getRequiredRefModelName() != value ) {
			getSchemaRefBuff().setRequiredRefModelName( value );
		}
	}

	public String getRequiredIncludeRoot() {
		return( getSchemaRefBuff().getRequiredIncludeRoot() );
	}

	public void setRequiredIncludeRoot( String value ) {
		if( getSchemaRefBuff().getRequiredIncludeRoot() != value ) {
			getSchemaRefBuff().setRequiredIncludeRoot( value );
		}
	}

	public Long getOptionalRefSchemaTenantId() {
		return( getSchemaRefBuff().getOptionalRefSchemaTenantId() );
	}

	public Long getOptionalRefSchemaId() {
		return( getSchemaRefBuff().getOptionalRefSchemaId() );
	}

	public Long getOptionalPrevTenantId() {
		return( getSchemaRefBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getSchemaRefBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getSchemaRefBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getSchemaRefBuff().getOptionalNextId() );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchema() {
		return( getRequiredContainerSchema( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchema( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchema == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaRefBuff().getRequiredSchemaId() );
				requiredContainerSchema = obj;
				if( obj != null ) {
					getSchemaRefBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getSchemaRefBuff().setRequiredSchemaId( obj.getRequiredId() );
					requiredContainerSchema = obj;
				}
			}
		}
		return( requiredContainerSchema );
	}

	public void setRequiredContainerSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getSchemaRefBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setRequiredSchemaId( value.getRequiredId() );
			}
			requiredContainerSchema = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupRefSchema() {
		return( getOptionalLookupRefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupRefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupRefSchema == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalRefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalRefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefBuff().getOptionalRefSchemaTenantId(),
					getSchemaRefBuff().getOptionalRefSchemaId() );
				optionalLookupRefSchema = obj;
			}
		}
		return( optionalLookupRefSchema );
	}

	public void setOptionalLookupRefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getSchemaRefBuff();
			}
			if( value != null ) {
				getSchemaRefBuff().setOptionalRefSchemaTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setOptionalRefSchemaId( value.getRequiredId() );
			}
			else {
				getSchemaRefBuff().setOptionalRefSchemaTenantId( null );
				getSchemaRefBuff().setOptionalRefSchemaId( null );
			}
			optionalLookupRefSchema = value;
	}

	public ICFBamSchemaRefObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamSchemaRefObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaRefObj obj = ((ICFBamSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefBuff().getOptionalPrevTenantId(),
					getSchemaRefBuff().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	public void setOptionalLookupPrev( ICFBamSchemaRefObj value ) {
			if( buff == null ) {
				getSchemaRefBuff();
			}
			if( value != null ) {
				getSchemaRefBuff().setOptionalPrevTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setOptionalPrevId( value.getRequiredId() );
			}
			else {
				getSchemaRefBuff().setOptionalPrevTenantId( null );
				getSchemaRefBuff().setOptionalPrevId( null );
			}
			optionalLookupPrev = value;
	}

	public ICFBamSchemaRefObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamSchemaRefObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaRefBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaRefObj obj = ((ICFBamSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefBuff().getOptionalNextTenantId(),
					getSchemaRefBuff().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	public void setOptionalLookupNext( ICFBamSchemaRefObj value ) {
			if( buff == null ) {
				getSchemaRefBuff();
			}
			if( value != null ) {
				getSchemaRefBuff().setOptionalNextTenantId( value.getRequiredTenantId() );
				getSchemaRefBuff().setOptionalNextId( value.getRequiredId() );
			}
			else {
				getSchemaRefBuff().setOptionalNextTenantId( null );
				getSchemaRefBuff().setOptionalNextId( null );
			}
			optionalLookupNext = value;
	}

	public void copyBuffToOrig() {
		CFBamSchemaRefBuff origBuff = getOrigAsSchemaRef().getSchemaRefBuff();
		CFBamSchemaRefBuff myBuff = getSchemaRefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamSchemaRefBuff origBuff = getOrigAsSchemaRef().getSchemaRefBuff();
		CFBamSchemaRefBuff myBuff = getSchemaRefBuff();
		myBuff.set( origBuff );
	}
}
