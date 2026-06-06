// Description: Java 11 edit object instance implementation for CFBam TZTimestampDef.

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

public class CFBamTZTimestampDefEditObj
	extends CFBamAtomEditObj

	implements ICFBamTZTimestampDefEditObj
{

	public CFBamTZTimestampDefEditObj( ICFBamTZTimestampDefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamTZTimestampDefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TZTimestampDef" );
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
		ICFBamTZTimestampDefObj retobj = getSchema().getTZTimestampDefTableObj().realiseTZTimestampDef( (ICFBamTZTimestampDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsTZTimestampDef().getSchema()).getTZTimestampDefTableObj().forgetTZTimestampDef( getOrigAsTZTimestampDef(), forgetSubObjects );
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
		ICFBamTZTimestampDefObj retobj = ((ICFBamSchemaObj)getOrigAsTZTimestampDef().getSchema()).getTZTimestampDefTableObj().createTZTimestampDef( getOrigAsTZTimestampDef() );
		if( retobj == getOrigAsTZTimestampDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getTZTimestampDefTableObj().updateTZTimestampDef( (ICFBamTZTimestampDefObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getTZTimestampDefTableObj().deleteTZTimestampDef( getOrigAsTZTimestampDef() );
		return( null );
	}

	public ICFBamTZTimestampDefTableObj getTZTimestampDefTable() {
		return( orig.getSchema().getTZTimestampDefTableObj() );
	}

	public ICFBamTZTimestampDefEditObj getEditAsTZTimestampDef() {
		return( (ICFBamTZTimestampDefEditObj)this );
	}

	public ICFBamTZTimestampDefObj getOrigAsTZTimestampDef() {
		return( (ICFBamTZTimestampDefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsTZTimestampDef().getSchema().getBackingStore()).getFactoryTZTimestampDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamTZTimestampDefBuff getTZTimestampDefBuff() {
		return( (CFBamTZTimestampDefBuff)getBuff() );
	}

	public String getOptionalDummy() {
		return( getTZTimestampDefBuff().getOptionalDummy() );
	}

	public void setOptionalDummy( String value ) {
		if( getTZTimestampDefBuff().getOptionalDummy() != value ) {
			getTZTimestampDefBuff().setOptionalDummy( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamTZTimestampDefBuff origBuff = getOrigAsTZTimestampDef().getTZTimestampDefBuff();
		CFBamTZTimestampDefBuff myBuff = getTZTimestampDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamTZTimestampDefBuff origBuff = getOrigAsTZTimestampDef().getTZTimestampDefBuff();
		CFBamTZTimestampDefBuff myBuff = getTZTimestampDefBuff();
		myBuff.set( origBuff );
	}
}
