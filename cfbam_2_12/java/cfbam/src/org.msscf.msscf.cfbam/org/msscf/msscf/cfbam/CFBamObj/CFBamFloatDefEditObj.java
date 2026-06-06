// Description: Java 11 edit object instance implementation for CFBam FloatDef.

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

public class CFBamFloatDefEditObj
	extends CFBamAtomEditObj

	implements ICFBamFloatDefEditObj
{

	public CFBamFloatDefEditObj( ICFBamFloatDefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamFloatDefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "FloatDef" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
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
		ICFBamFloatDefObj retobj = getSchema().getFloatDefTableObj().realiseFloatDef( (ICFBamFloatDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsFloatDef().getSchema()).getFloatDefTableObj().forgetFloatDef( getOrigAsFloatDef(), forgetSubObjects );
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
		ICFBamFloatDefObj retobj = ((ICFBamSchemaObj)getOrigAsFloatDef().getSchema()).getFloatDefTableObj().createFloatDef( getOrigAsFloatDef() );
		if( retobj == getOrigAsFloatDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getFloatDefTableObj().updateFloatDef( (ICFBamFloatDefObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getFloatDefTableObj().deleteFloatDef( getOrigAsFloatDef() );
		return( null );
	}

	public ICFBamFloatDefTableObj getFloatDefTable() {
		return( orig.getSchema().getFloatDefTableObj() );
	}

	public ICFBamFloatDefEditObj getEditAsFloatDef() {
		return( (ICFBamFloatDefEditObj)this );
	}

	public ICFBamFloatDefObj getOrigAsFloatDef() {
		return( (ICFBamFloatDefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsFloatDef().getSchema().getBackingStore()).getFactoryFloatDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamFloatDefBuff getFloatDefBuff() {
		return( (CFBamFloatDefBuff)getBuff() );
	}

	public Float getOptionalInitValue() {
		return( getFloatDefBuff().getOptionalInitValue() );
	}

	public void setOptionalInitValue( Float value ) {
		if( getFloatDefBuff().getOptionalInitValue() != value ) {
			getFloatDefBuff().setOptionalInitValue( value );
		}
	}

	public Float getOptionalMinValue() {
		return( getFloatDefBuff().getOptionalMinValue() );
	}

	public void setOptionalMinValue( Float value ) {
		if( getFloatDefBuff().getOptionalMinValue() != value ) {
			getFloatDefBuff().setOptionalMinValue( value );
		}
	}

	public Float getOptionalMaxValue() {
		return( getFloatDefBuff().getOptionalMaxValue() );
	}

	public void setOptionalMaxValue( Float value ) {
		if( getFloatDefBuff().getOptionalMaxValue() != value ) {
			getFloatDefBuff().setOptionalMaxValue( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamFloatDefBuff origBuff = getOrigAsFloatDef().getFloatDefBuff();
		CFBamFloatDefBuff myBuff = getFloatDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamFloatDefBuff origBuff = getOrigAsFloatDef().getFloatDefBuff();
		CFBamFloatDefBuff myBuff = getFloatDefBuff();
		myBuff.set( origBuff );
	}
}
