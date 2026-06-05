// Description: Java 11 edit object instance implementation for CFBam TokenDef.

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

public class CFBamTokenDefEditObj
	extends CFBamAtomEditObj

	implements ICFBamTokenDefEditObj
{

	public CFBamTokenDefEditObj( ICFBamTokenDefObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFBamTokenDefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TokenDef" );
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
		ICFBamTokenDefObj retobj = getSchema().getTokenDefTableObj().realiseTokenDef( (ICFBamTokenDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsTokenDef().getSchema()).getTokenDefTableObj().forgetTokenDef( getOrigAsTokenDef(), forgetSubObjects );
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
		ICFBamTokenDefObj retobj = ((ICFBamSchemaObj)getOrigAsTokenDef().getSchema()).getTokenDefTableObj().createTokenDef( getOrigAsTokenDef() );
		if( retobj == getOrigAsTokenDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getTokenDefTableObj().updateTokenDef( (ICFBamTokenDefObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getTokenDefTableObj().deleteTokenDef( getOrigAsTokenDef() );
		return( null );
	}

	public ICFBamTokenDefTableObj getTokenDefTable() {
		return( orig.getSchema().getTokenDefTableObj() );
	}

	public ICFBamTokenDefEditObj getEditAsTokenDef() {
		return( (ICFBamTokenDefEditObj)this );
	}

	public ICFBamTokenDefObj getOrigAsTokenDef() {
		return( (ICFBamTokenDefObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsTokenDef().getSchema().getBackingStore()).getFactoryTokenDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFBamTokenDefBuff getTokenDefBuff() {
		return( (CFBamTokenDefBuff)getBuff() );
	}

	public int getRequiredMaxLen() {
		return( getTokenDefBuff().getRequiredMaxLen() );
	}

	public void setRequiredMaxLen( int value ) {
		if( getTokenDefBuff().getRequiredMaxLen() != value ) {
			getTokenDefBuff().setRequiredMaxLen( value );
		}
	}

	public String getOptionalInitValue() {
		return( getTokenDefBuff().getOptionalInitValue() );
	}

	public void setOptionalInitValue( String value ) {
		if( getTokenDefBuff().getOptionalInitValue() != value ) {
			getTokenDefBuff().setOptionalInitValue( value );
		}
	}

	public void copyBuffToOrig() {
		CFBamTokenDefBuff origBuff = getOrigAsTokenDef().getTokenDefBuff();
		CFBamTokenDefBuff myBuff = getTokenDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamTokenDefBuff origBuff = getOrigAsTokenDef().getTokenDefBuff();
		CFBamTokenDefBuff myBuff = getTokenDefBuff();
		myBuff.set( origBuff );
	}
}
