// Description: Java 11 edit object instance implementation for CFBam Int32Type.

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

public class CFBamInt32TypeEditObj
	extends CFBamInt32DefEditObj

	implements ICFBamInt32TypeEditObj
{
	protected ICFBamSchemaDefObj requiredContainerSchemaDef;

	public CFBamInt32TypeEditObj( ICFBamInt32TypeObj argOrig ) {
		super( argOrig );
		requiredContainerSchemaDef = null;
	}

	public String getClassCode() {
		return( CFBamInt32TypeObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Int32Type" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
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

	public ICFBamValueObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamInt32TypeObj retobj = getSchema().getInt32TypeTableObj().realiseInt32Type( (ICFBamInt32TypeObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsInt32Type().getSchema()).getInt32TypeTableObj().forgetInt32Type( getOrigAsInt32Type(), forgetSubObjects );
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
		ICFBamInt32TypeObj retobj = ((ICFBamSchemaObj)getOrigAsInt32Type().getSchema()).getInt32TypeTableObj().createInt32Type( getOrigAsInt32Type() );
		if( retobj == getOrigAsInt32Type() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getInt32TypeTableObj().updateInt32Type( (ICFBamInt32TypeObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getInt32TypeTableObj().deleteInt32Type( getOrigAsInt32Type() );
		return( null );
	}

	public ICFBamInt32TypeTableObj getInt32TypeTable() {
		return( orig.getSchema().getInt32TypeTableObj() );
	}

	public ICFBamInt32TypeEditObj getEditAsInt32Type() {
		return( (ICFBamInt32TypeEditObj)this );
	}

	public ICFBamInt32TypeObj getOrigAsInt32Type() {
		return( (ICFBamInt32TypeObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsInt32Type().getSchema().getBackingStore()).getFactoryInt32Type().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerSchemaDef = null;
		}
	}

	public CFBamInt32TypeBuff getInt32TypeBuff() {
		return( (CFBamInt32TypeBuff)getBuff() );
	}

	public long getRequiredSchemaDefId() {
		return( getInt32TypeBuff().getRequiredSchemaDefId() );
	}

	public void setRequiredContainerScope( ICFBamScopeObj value ) {
		final String S_ProcName = "CFBamInt32TypeEditObj.setRequiredContainerScope() ";
		if( value == null ) {
			setRequiredContainerSchemaDef( null );
		}
		else if( ! ( value instanceof ICFBamSchemaDefObj ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRequiredContainerScope",
				"value",
				value,
				"ICFBamSchemaDefObj" );
		}
		else {
			setRequiredContainerSchemaDef( (ICFBamSchemaDefObj)value );
		}
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchemaDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsInt32Type().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getInt32TypeBuff().getRequiredSchemaDefId() );
				requiredContainerSchemaDef = obj;
				if( obj != null ) {
					getInt32TypeBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getInt32TypeBuff().setRequiredSchemaDefId( obj.getRequiredId() );
					requiredContainerSchemaDef = obj;
				}
			}
		}
		return( requiredContainerSchemaDef );
	}

	public void setRequiredContainerSchemaDef( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getInt32TypeBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getInt32TypeBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getInt32TypeBuff().setRequiredSchemaDefId( value.getRequiredId() );
			}
			requiredContainerSchemaDef = value;
			super.setRequiredContainerScope( value );
	}

	public void copyBuffToOrig() {
		CFBamInt32TypeBuff origBuff = getOrigAsInt32Type().getInt32TypeBuff();
		CFBamInt32TypeBuff myBuff = getInt32TypeBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamInt32TypeBuff origBuff = getOrigAsInt32Type().getInt32TypeBuff();
		CFBamInt32TypeBuff myBuff = getInt32TypeBuff();
		myBuff.set( origBuff );
	}
}
