// Description: Java 11 edit object instance implementation for CFGenKb GelExpansion.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGelExpansionEditObj
	extends CFGenKbGelInstructionEditObj

	implements ICFGenKbGelExpansionEditObj
{

	public CFGenKbGelExpansionEditObj( ICFGenKbGelExpansionObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFGenKbGelExpansionObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelExpansion" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredGelInstId();
		objName = Long.toString( val );
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
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

	public ICFGenKbGelInstructionObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbGelExpansionObj retobj = getSchema().getGelExpansionTableObj().realiseGelExpansion( (ICFGenKbGelExpansionObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelExpansion().getSchema()).getGelExpansionTableObj().forgetGelExpansion( getOrigAsGelExpansion(), forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj create() {
		copyBuffToOrig();
		ICFGenKbGelExpansionObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelExpansion().getSchema()).getGelExpansionTableObj().createGelExpansion( getOrigAsGelExpansion() );
		if( retobj == getOrigAsGelExpansion() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelInstructionEditObj update() {
		getSchema().getGelExpansionTableObj().updateGelExpansion( (ICFGenKbGelExpansionObj)this );
		return( null );
	}

	public CFGenKbGelInstructionEditObj deleteInstance() {
		super.forget();
		getSchema().getGelExpansionTableObj().deleteGelExpansion( getOrigAsGelExpansion() );
		return( null );
	}

	public ICFGenKbGelExpansionTableObj getGelExpansionTable() {
		return( orig.getSchema().getGelExpansionTableObj() );
	}

	public ICFGenKbGelExpansionEditObj getEditAsGelExpansion() {
		return( (ICFGenKbGelExpansionEditObj)this );
	}

	public ICFGenKbGelExpansionObj getOrigAsGelExpansion() {
		return( (ICFGenKbGelExpansionObj)orig );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelExpansion().getSchema().getBackingStore()).getFactoryGelExpansion().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFGenKbGelExpansionBuff getGelExpansionBuff() {
		return( (CFGenKbGelExpansionBuff)getBuff() );
	}

	public String getRequiredMacroName() {
		return( getGelExpansionBuff().getRequiredMacroName() );
	}

	public void setRequiredMacroName( String value ) {
		if( getGelExpansionBuff().getRequiredMacroName() != value ) {
			getGelExpansionBuff().setRequiredMacroName( value );
		}
	}

	public void copyBuffToOrig() {
		CFGenKbGelExpansionBuff origBuff = getOrigAsGelExpansion().getGelExpansionBuff();
		CFGenKbGelExpansionBuff myBuff = getGelExpansionBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelExpansionBuff origBuff = getOrigAsGelExpansion().getGelExpansionBuff();
		CFGenKbGelExpansionBuff myBuff = getGelExpansionBuff();
		myBuff.set( origBuff );
	}
}
