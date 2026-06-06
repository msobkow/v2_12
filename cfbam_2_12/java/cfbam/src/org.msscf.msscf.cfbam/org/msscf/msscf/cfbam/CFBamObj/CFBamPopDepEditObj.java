// Description: Java 11 edit object instance implementation for CFBam PopDep.

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

public class CFBamPopDepEditObj
	extends CFBamScopeEditObj

	implements ICFBamPopDepEditObj
{
	protected ICFBamRelationObj requiredLookupRelation;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;

	public CFBamPopDepEditObj( ICFBamPopDepObj argOrig ) {
		super( argOrig );
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
	}

	public String getClassCode() {
		return( CFBamPopDepObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopDep" );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredId();
		objName = Long.toString( val );
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
		ICFBamPopDepObj retobj = getSchema().getPopDepTableObj().realisePopDep( (ICFBamPopDepObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsPopDep().getSchema()).getPopDepTableObj().forgetPopDep( getOrigAsPopDep(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamPopDepObj retobj = ((ICFBamSchemaObj)getOrigAsPopDep().getSchema()).getPopDepTableObj().createPopDep( getOrigAsPopDep() );
		if( retobj == getOrigAsPopDep() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getPopDepTableObj().updatePopDep( (ICFBamPopDepObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getPopDepTableObj().deletePopDep( getOrigAsPopDep() );
		return( null );
	}

	public ICFBamPopDepTableObj getPopDepTable() {
		return( orig.getSchema().getPopDepTableObj() );
	}

	public ICFBamPopDepEditObj getEditAsPopDep() {
		return( (ICFBamPopDepEditObj)this );
	}

	public ICFBamPopDepObj getOrigAsPopDep() {
		return( (ICFBamPopDepObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsPopDep().getSchema().getBackingStore()).getFactoryPopDep().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredLookupRelation = null;
			optionalLookupDefSchema = null;
		}
	}

	public CFBamPopDepBuff getPopDepBuff() {
		return( (CFBamPopDepBuff)getBuff() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getPopDepBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getPopDepBuff().getOptionalDefSchemaId() );
	}

	public long getRequiredRelationTenantId() {
		return( getPopDepBuff().getRequiredRelationTenantId() );
	}

	public long getRequiredRelationId() {
		return( getPopDepBuff().getRequiredRelationId() );
	}

	public ICFBamRelationObj getRequiredLookupRelation() {
		return( getRequiredLookupRelation( false ) );
	}

	public ICFBamRelationObj getRequiredLookupRelation( boolean forceRead ) {
		if( forceRead || ( requiredLookupRelation == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamRelationObj obj = ((ICFBamSchemaObj)getOrigAsPopDep().getSchema()).getRelationTableObj().readRelationByIdIdx( getPopDepBuff().getRequiredRelationTenantId(),
					getPopDepBuff().getRequiredRelationId() );
				requiredLookupRelation = obj;
			}
		}
		return( requiredLookupRelation );
	}

	public void setRequiredLookupRelation( ICFBamRelationObj value ) {
			if( buff == null ) {
				getPopDepBuff();
			}
			if( value != null ) {
				getPopDepBuff().setRequiredRelationTenantId( value.getRequiredTenantId() );
				getPopDepBuff().setRequiredRelationId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupRelation = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getPopDepBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getPopDepBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsPopDep().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getPopDepBuff().getOptionalDefSchemaTenantId(),
					getPopDepBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getPopDepBuff();
			}
			if( value != null ) {
				getPopDepBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getPopDepBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getPopDepBuff().setOptionalDefSchemaTenantId( null );
				getPopDepBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public void copyBuffToOrig() {
		CFBamPopDepBuff origBuff = getOrigAsPopDep().getPopDepBuff();
		CFBamPopDepBuff myBuff = getPopDepBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamPopDepBuff origBuff = getOrigAsPopDep().getPopDepBuff();
		CFBamPopDepBuff myBuff = getPopDepBuff();
		myBuff.set( origBuff );
	}
}
