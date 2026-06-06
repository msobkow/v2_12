// Description: Java 11 edit object instance implementation for CFGenKb GelModifier.

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

public class CFGenKbGelModifierEditObj
	extends CFGenKbGelInstructionEditObj

	implements ICFGenKbGelModifierEditObj
{
	protected ICFGenKbGelInstructionObj optionalLookupRemainder;

	public CFGenKbGelModifierEditObj( ICFGenKbGelModifierObj argOrig ) {
		super( argOrig );
		optionalLookupRemainder = null;
	}

	public String getClassCode() {
		return( CFGenKbGelModifierObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelModifier" );
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
		ICFGenKbGelModifierObj retobj = getSchema().getGelModifierTableObj().realiseGelModifier( (ICFGenKbGelModifierObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelModifier().getSchema()).getGelModifierTableObj().forgetGelModifier( getOrigAsGelModifier(), forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj create() {
		copyBuffToOrig();
		ICFGenKbGelModifierObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelModifier().getSchema()).getGelModifierTableObj().createGelModifier( getOrigAsGelModifier() );
		if( retobj == getOrigAsGelModifier() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelInstructionEditObj update() {
		getSchema().getGelModifierTableObj().updateGelModifier( (ICFGenKbGelModifierObj)this );
		return( null );
	}

	public CFGenKbGelInstructionEditObj deleteInstance() {
		super.forget();
		getSchema().getGelModifierTableObj().deleteGelModifier( getOrigAsGelModifier() );
		return( null );
	}

	public ICFGenKbGelModifierTableObj getGelModifierTable() {
		return( orig.getSchema().getGelModifierTableObj() );
	}

	public ICFGenKbGelModifierEditObj getEditAsGelModifier() {
		return( (ICFGenKbGelModifierEditObj)this );
	}

	public ICFGenKbGelModifierObj getOrigAsGelModifier() {
		return( (ICFGenKbGelModifierObj)orig );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelModifier().getSchema().getBackingStore()).getFactoryGelModifier().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			optionalLookupRemainder = null;
		}
	}

	public CFGenKbGelModifierBuff getGelModifierBuff() {
		return( (CFGenKbGelModifierBuff)getBuff() );
	}

	public Long getOptionalRemainderTenantId() {
		return( getGelModifierBuff().getOptionalRemainderTenantId() );
	}

	public long getRequiredRemainderGelCacheId() {
		return( getGelModifierBuff().getRequiredRemainderGelCacheId() );
	}

	public Long getOptionalRemainderInstId() {
		return( getGelModifierBuff().getOptionalRemainderInstId() );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupRemainder() {
		return( getOptionalLookupRemainder( false ) );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupRemainder( boolean forceRead ) {
		if( forceRead || ( optionalLookupRemainder == null ) ) {
			boolean anyMissing = false;
			if( getGelModifierBuff().getOptionalRemainderTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelModifierBuff().getOptionalRemainderInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelInstructionObj obj = ((ICFGenKbSchemaObj)getOrigAsGelModifier().getSchema()).getGelInstructionTableObj().readGelInstructionByPIdx( getGelModifierBuff().getOptionalRemainderTenantId(),
					getGelModifierBuff().getRequiredRemainderGelCacheId(),
					getGelModifierBuff().getOptionalRemainderInstId() );
				optionalLookupRemainder = obj;
			}
		}
		return( optionalLookupRemainder );
	}

	public void setOptionalLookupRemainder( ICFGenKbGelInstructionObj value ) {
			if( buff == null ) {
				getGelModifierBuff();
			}
			if( value != null ) {
				getGelModifierBuff().setOptionalRemainderTenantId( value.getRequiredTenantId() );
				getGelModifierBuff().setRequiredRemainderGelCacheId( value.getRequiredGelCacheId() );
				getGelModifierBuff().setOptionalRemainderInstId( value.getRequiredGelInstId() );
			}
			else {
				getGelModifierBuff().setOptionalRemainderTenantId( null );
				getGelModifierBuff().setOptionalRemainderInstId( null );
			}
			optionalLookupRemainder = value;
	}

	public void copyBuffToOrig() {
		CFGenKbGelModifierBuff origBuff = getOrigAsGelModifier().getGelModifierBuff();
		CFGenKbGelModifierBuff myBuff = getGelModifierBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelModifierBuff origBuff = getOrigAsGelModifier().getGelModifierBuff();
		CFGenKbGelModifierBuff myBuff = getGelModifierBuff();
		myBuff.set( origBuff );
	}
}
