// Description: Java 11 edit object instance implementation for CFBam NumberDef.

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

public class CFBamNumberDefEditObj
	extends CFBamAtomEditObj

	implements ICFBamNumberDefEditObj
{

	public CFBamNumberDefEditObj( ICFBamNumberDefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamNumberDefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "NumberDef" );
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
		ICFBamNumberDefObj retobj = getSchema().getNumberDefTableObj().realiseNumberDef( (ICFBamNumberDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsNumberDef().getSchema()).getNumberDefTableObj().forgetNumberDef( getOrigAsNumberDef(), forgetSubObjects );
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
		ICFBamNumberDefObj retobj = ((ICFBamSchemaObj)getOrigAsNumberDef().getSchema()).getNumberDefTableObj().createNumberDef( getOrigAsNumberDef() );
		if( retobj == getOrigAsNumberDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getNumberDefTableObj().updateNumberDef( (ICFBamNumberDefObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getNumberDefTableObj().deleteNumberDef( getOrigAsNumberDef() );
		return( null );
	}

	public ICFBamNumberDefTableObj getNumberDefTable() {
		return( orig.getSchema().getNumberDefTableObj() );
	}

	public ICFBamNumberDefEditObj getEditAsNumberDef() {
		return( (ICFBamNumberDefEditObj)this );
	}

	public ICFBamNumberDefObj getOrigAsNumberDef() {
		return( (ICFBamNumberDefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsNumberDef().getSchema().getBackingStore()).getFactoryNumberDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamNumberDefBuff getNumberDefBuff() {
		return( (CFBamNumberDefBuff)getBuff() );
	}

	public short getRequiredDigits() {
		return( getNumberDefBuff().getRequiredDigits() );
	}

	public void setRequiredDigits( short value ) {
		if( getNumberDefBuff().getRequiredDigits() != value ) {
			getNumberDefBuff().setRequiredDigits( value );
		}
	}

	public short getRequiredPrecis() {
		return( getNumberDefBuff().getRequiredPrecis() );
	}

	public void setRequiredPrecis( short value ) {
		if( getNumberDefBuff().getRequiredPrecis() != value ) {
			getNumberDefBuff().setRequiredPrecis( value );
		}
	}

	public BigDecimal getOptionalInitValue() {
		return( getNumberDefBuff().getOptionalInitValue() );
	}

	public void setOptionalInitValue( BigDecimal value ) {
		if( getNumberDefBuff().getOptionalInitValue() != value ) {
			getNumberDefBuff().setOptionalInitValue( value );
		}
	}

	public BigDecimal getOptionalMinValue() {
		return( getNumberDefBuff().getOptionalMinValue() );
	}

	public void setOptionalMinValue( BigDecimal value ) {
		if( getNumberDefBuff().getOptionalMinValue() != value ) {
			getNumberDefBuff().setOptionalMinValue( value );
		}
	}

	public BigDecimal getOptionalMaxValue() {
		return( getNumberDefBuff().getOptionalMaxValue() );
	}

	public void setOptionalMaxValue( BigDecimal value ) {
		if( getNumberDefBuff().getOptionalMaxValue() != value ) {
			getNumberDefBuff().setOptionalMaxValue( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamNumberDefBuff origBuff = getOrigAsNumberDef().getNumberDefBuff();
		CFBamNumberDefBuff myBuff = getNumberDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamNumberDefBuff origBuff = getOrigAsNumberDef().getNumberDefBuff();
		CFBamNumberDefBuff myBuff = getNumberDefBuff();
		myBuff.set( origBuff );
	}
}
