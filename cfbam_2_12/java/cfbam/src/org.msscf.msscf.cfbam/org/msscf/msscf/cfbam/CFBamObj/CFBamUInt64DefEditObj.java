// Description: Java 11 edit object instance implementation for CFBam UInt64Def.

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

public class CFBamUInt64DefEditObj
	extends CFBamAtomEditObj

	implements ICFBamUInt64DefEditObj
{

	public CFBamUInt64DefEditObj( ICFBamUInt64DefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamUInt64DefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "UInt64Def" );
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
		ICFBamUInt64DefObj retobj = getSchema().getUInt64DefTableObj().realiseUInt64Def( (ICFBamUInt64DefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsUInt64Def().getSchema()).getUInt64DefTableObj().forgetUInt64Def( getOrigAsUInt64Def(), forgetSubObjects );
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
		ICFBamUInt64DefObj retobj = ((ICFBamSchemaObj)getOrigAsUInt64Def().getSchema()).getUInt64DefTableObj().createUInt64Def( getOrigAsUInt64Def() );
		if( retobj == getOrigAsUInt64Def() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getUInt64DefTableObj().updateUInt64Def( (ICFBamUInt64DefObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getUInt64DefTableObj().deleteUInt64Def( getOrigAsUInt64Def() );
		return( null );
	}

	public ICFBamUInt64DefTableObj getUInt64DefTable() {
		return( orig.getSchema().getUInt64DefTableObj() );
	}

	public ICFBamUInt64DefEditObj getEditAsUInt64Def() {
		return( (ICFBamUInt64DefEditObj)this );
	}

	public ICFBamUInt64DefObj getOrigAsUInt64Def() {
		return( (ICFBamUInt64DefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsUInt64Def().getSchema().getBackingStore()).getFactoryUInt64Def().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamUInt64DefBuff getUInt64DefBuff() {
		return( (CFBamUInt64DefBuff)getBuff() );
	}

	public BigDecimal getOptionalInitValue() {
		return( getUInt64DefBuff().getOptionalInitValue() );
	}

	public void setOptionalInitValue( BigDecimal value ) {
		if( getUInt64DefBuff().getOptionalInitValue() != value ) {
			getUInt64DefBuff().setOptionalInitValue( value );
		}
	}

	public BigDecimal getOptionalMinValue() {
		return( getUInt64DefBuff().getOptionalMinValue() );
	}

	public void setOptionalMinValue( BigDecimal value ) {
		if( getUInt64DefBuff().getOptionalMinValue() != value ) {
			getUInt64DefBuff().setOptionalMinValue( value );
		}
	}

	public BigDecimal getOptionalMaxValue() {
		return( getUInt64DefBuff().getOptionalMaxValue() );
	}

	public void setOptionalMaxValue( BigDecimal value ) {
		if( getUInt64DefBuff().getOptionalMaxValue() != value ) {
			getUInt64DefBuff().setOptionalMaxValue( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamUInt64DefBuff origBuff = getOrigAsUInt64Def().getUInt64DefBuff();
		CFBamUInt64DefBuff myBuff = getUInt64DefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamUInt64DefBuff origBuff = getOrigAsUInt64Def().getUInt64DefBuff();
		CFBamUInt64DefBuff myBuff = getUInt64DefBuff();
		myBuff.set( origBuff );
	}
}
