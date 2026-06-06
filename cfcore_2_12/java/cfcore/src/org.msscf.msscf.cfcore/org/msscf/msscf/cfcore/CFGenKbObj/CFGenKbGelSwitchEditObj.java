// Description: Java 11 edit object instance implementation for CFGenKb GelSwitch.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbGelSwitchEditObj
	extends CFGenKbGelInstructionEditObj

	implements ICFGenKbGelSwitchEditObj
{

	public CFGenKbGelSwitchEditObj( ICFGenKbGelSwitchObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFGenKbGelSwitchObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelSwitch" );
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
		ICFGenKbGelSwitchObj retobj = getSchema().getGelSwitchTableObj().realiseGelSwitch( (ICFGenKbGelSwitchObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelSwitch().getSchema()).getGelSwitchTableObj().forgetGelSwitch( getOrigAsGelSwitch(), forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj create() {
		copyBuffToOrig();
		ICFGenKbGelSwitchObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelSwitch().getSchema()).getGelSwitchTableObj().createGelSwitch( getOrigAsGelSwitch() );
		if( retobj == getOrigAsGelSwitch() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelInstructionEditObj update() {
		getSchema().getGelSwitchTableObj().updateGelSwitch( (ICFGenKbGelSwitchObj)this );
		return( null );
	}

	public CFGenKbGelInstructionEditObj deleteInstance() {
		super.forget();
		getSchema().getGelSwitchTableObj().deleteGelSwitch( getOrigAsGelSwitch() );
		return( null );
	}

	public ICFGenKbGelSwitchTableObj getGelSwitchTable() {
		return( orig.getSchema().getGelSwitchTableObj() );
	}

	public ICFGenKbGelSwitchEditObj getEditAsGelSwitch() {
		return( (ICFGenKbGelSwitchEditObj)this );
	}

	public ICFGenKbGelSwitchObj getOrigAsGelSwitch() {
		return( (ICFGenKbGelSwitchObj)orig );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelSwitch().getSchema().getBackingStore()).getFactoryGelSwitch().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFGenKbGelSwitchBuff getGelSwitchBuff() {
		return( (CFGenKbGelSwitchBuff)getBuff() );
	}

	public String getRequiredValueExpansion() {
		return( getGelSwitchBuff().getRequiredValueExpansion() );
	}

	public void setRequiredValueExpansion( String value ) {
		if( getGelSwitchBuff().getRequiredValueExpansion() != value ) {
			getGelSwitchBuff().setRequiredValueExpansion( value );
		}
	}

	public String getOptionalNilExpansion() {
		return( getGelSwitchBuff().getOptionalNilExpansion() );
	}

	public void setOptionalNilExpansion( String value ) {
		if( getGelSwitchBuff().getOptionalNilExpansion() != value ) {
			getGelSwitchBuff().setOptionalNilExpansion( value );
		}
	}

	public String getOptionalEmptyExpansion() {
		return( getGelSwitchBuff().getOptionalEmptyExpansion() );
	}

	public void setOptionalEmptyExpansion( String value ) {
		if( getGelSwitchBuff().getOptionalEmptyExpansion() != value ) {
			getGelSwitchBuff().setOptionalEmptyExpansion( value );
		}
	}

	public String getRequiredDefaultExpansion() {
		return( getGelSwitchBuff().getRequiredDefaultExpansion() );
	}

	public void setRequiredDefaultExpansion( String value ) {
		if( getGelSwitchBuff().getRequiredDefaultExpansion() != value ) {
			getGelSwitchBuff().setRequiredDefaultExpansion( value );
		}
	}

	public List<ICFGenKbGelSwitchLimbObj> getOptionalChildrenSwitchLimb() {
		List<ICFGenKbGelSwitchLimbObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsGelSwitch().getSchema()).getGelSwitchLimbTableObj().readGelSwitchLimbBySwitchIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId(),
			false );
		return( retval );
	}

	public List<ICFGenKbGelSwitchLimbObj> getOptionalChildrenSwitchLimb( boolean forceRead ) {
		List<ICFGenKbGelSwitchLimbObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsGelSwitch().getSchema()).getGelSwitchLimbTableObj().readGelSwitchLimbBySwitchIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFGenKbGelSwitchBuff origBuff = getOrigAsGelSwitch().getGelSwitchBuff();
		CFGenKbGelSwitchBuff myBuff = getGelSwitchBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelSwitchBuff origBuff = getOrigAsGelSwitch().getGelSwitchBuff();
		CFGenKbGelSwitchBuff myBuff = getGelSwitchBuff();
		myBuff.set( origBuff );
	}
}
