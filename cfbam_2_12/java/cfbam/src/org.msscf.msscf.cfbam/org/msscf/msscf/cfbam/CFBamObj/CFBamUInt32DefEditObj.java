// Description: Java 11 edit object instance implementation for CFBam UInt32Def.

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

public class CFBamUInt32DefEditObj
	extends CFBamAtomEditObj

	implements ICFBamUInt32DefEditObj
{

	public CFBamUInt32DefEditObj( ICFBamUInt32DefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamUInt32DefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "UInt32Def" );
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
		ICFBamUInt32DefObj retobj = getSchema().getUInt32DefTableObj().realiseUInt32Def( (ICFBamUInt32DefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsUInt32Def().getSchema()).getUInt32DefTableObj().forgetUInt32Def( getOrigAsUInt32Def(), forgetSubObjects );
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
		ICFBamUInt32DefObj retobj = ((ICFBamSchemaObj)getOrigAsUInt32Def().getSchema()).getUInt32DefTableObj().createUInt32Def( getOrigAsUInt32Def() );
		if( retobj == getOrigAsUInt32Def() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getUInt32DefTableObj().updateUInt32Def( (ICFBamUInt32DefObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getUInt32DefTableObj().deleteUInt32Def( getOrigAsUInt32Def() );
		return( null );
	}

	public ICFBamUInt32DefTableObj getUInt32DefTable() {
		return( orig.getSchema().getUInt32DefTableObj() );
	}

	public ICFBamUInt32DefEditObj getEditAsUInt32Def() {
		return( (ICFBamUInt32DefEditObj)this );
	}

	public ICFBamUInt32DefObj getOrigAsUInt32Def() {
		return( (ICFBamUInt32DefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsUInt32Def().getSchema().getBackingStore()).getFactoryUInt32Def().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamUInt32DefBuff getUInt32DefBuff() {
		return( (CFBamUInt32DefBuff)getBuff() );
	}

	public Long getOptionalInitValue() {
		return( getUInt32DefBuff().getOptionalInitValue() );
	}

	public void setOptionalInitValue( Long value ) {
		if( getUInt32DefBuff().getOptionalInitValue() != value ) {
			getUInt32DefBuff().setOptionalInitValue( value );
		}
	}

	public Long getOptionalMinValue() {
		return( getUInt32DefBuff().getOptionalMinValue() );
	}

	public void setOptionalMinValue( Long value ) {
		if( getUInt32DefBuff().getOptionalMinValue() != value ) {
			getUInt32DefBuff().setOptionalMinValue( value );
		}
	}

	public Long getOptionalMaxValue() {
		return( getUInt32DefBuff().getOptionalMaxValue() );
	}

	public void setOptionalMaxValue( Long value ) {
		if( getUInt32DefBuff().getOptionalMaxValue() != value ) {
			getUInt32DefBuff().setOptionalMaxValue( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamUInt32DefBuff origBuff = getOrigAsUInt32Def().getUInt32DefBuff();
		CFBamUInt32DefBuff myBuff = getUInt32DefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamUInt32DefBuff origBuff = getOrigAsUInt32Def().getUInt32DefBuff();
		CFBamUInt32DefBuff myBuff = getUInt32DefBuff();
		myBuff.set( origBuff );
	}
}
