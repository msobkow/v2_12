// Description: Java 11 edit object instance implementation for CFGenKb GelSwitchLimb.

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

public class CFGenKbGelSwitchLimbEditObj
	implements ICFGenKbGelSwitchLimbEditObj
{
	protected ICFGenKbGelSwitchLimbObj orig;
	protected CFGenKbGelSwitchLimbBuff buff;
	protected ICFGenKbGelSwitchObj requiredParentSwitch;
	protected ICFGenKbTenantObj requiredOwnerTenant;

	public CFGenKbGelSwitchLimbEditObj( ICFGenKbGelSwitchLimbObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbGelSwitchLimbBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredParentSwitch = null;
		requiredOwnerTenant = null;
	}

	public String getClassCode() {
		return( CFGenKbGelSwitchLimbObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelSwitchLimb" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredLimbName();
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

	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
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

	public String getObjFullName() {
		String fullName = getObjName();
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
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	public ICFGenKbGelSwitchLimbObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbGelSwitchLimbObj retobj = getSchema().getGelSwitchLimbTableObj().realiseGelSwitchLimb( (ICFGenKbGelSwitchLimbObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelSwitchLimb().getSchema()).getGelSwitchLimbTableObj().forgetGelSwitchLimb( getOrigAsGelSwitchLimb(), forgetSubObjects );
	}

	public ICFGenKbGelSwitchLimbObj read() {
		ICFGenKbGelSwitchLimbObj retval = getOrigAsGelSwitchLimb().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbGelSwitchLimbObj read( boolean forceRead ) {
		ICFGenKbGelSwitchLimbObj retval = getOrigAsGelSwitchLimb().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbGelSwitchLimbObj create() {
		copyBuffToOrig();
		ICFGenKbGelSwitchLimbObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelSwitchLimb().getSchema()).getGelSwitchLimbTableObj().createGelSwitchLimb( getOrigAsGelSwitchLimb() );
		if( retobj == getOrigAsGelSwitchLimb() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelSwitchLimbEditObj update() {
		getSchema().getGelSwitchLimbTableObj().updateGelSwitchLimb( (ICFGenKbGelSwitchLimbObj)this );
		return( null );
	}

	public CFGenKbGelSwitchLimbEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getGelSwitchLimbTableObj().deleteGelSwitchLimb( getOrigAsGelSwitchLimb() );
		return( null );
	}

	public ICFGenKbGelSwitchLimbTableObj getGelSwitchLimbTable() {
		return( orig.getSchema().getGelSwitchLimbTableObj() );
	}

	public ICFGenKbGelSwitchLimbEditObj getEdit() {
		return( (ICFGenKbGelSwitchLimbEditObj)this );
	}

	public ICFGenKbGelSwitchLimbEditObj getEditAsGelSwitchLimb() {
		return( (ICFGenKbGelSwitchLimbEditObj)this );
	}

	public ICFGenKbGelSwitchLimbEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbGelSwitchLimbObj getOrig() {
		return( orig );
	}

	public ICFGenKbGelSwitchLimbObj getOrigAsGelSwitchLimb() {
		return( (ICFGenKbGelSwitchLimbObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbGelSwitchLimbBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelSwitchLimb().getSchema().getBackingStore()).getFactoryGelSwitchLimb().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelSwitchLimbBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredParentSwitch = null;
			requiredOwnerTenant = null;
		}
	}

	public CFGenKbGelSwitchLimbBuff getGelSwitchLimbBuff() {
		return( (CFGenKbGelSwitchLimbBuff)getBuff() );
	}

	public CFGenKbGelSwitchLimbPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbGelSwitchLimbPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredGelCacheId() {
		return( getPKey().getRequiredGelCacheId() );
	}

	public long getRequiredGelInstId() {
		return( getPKey().getRequiredGelInstId() );
	}

	public String getRequiredLimbName() {
		return( getPKey().getRequiredLimbName() );
	}

	public void setRequiredLimbName( String value ) {
		if( getPKey().getRequiredLimbName() != value ) {
			getPKey().setRequiredLimbName( value );
		}
		if( getGelSwitchLimbBuff().getRequiredLimbName() != value ) {
			getGelSwitchLimbBuff().setRequiredLimbName( value );
		}
	}

	public String getRequiredLimbExpansion() {
		return( getGelSwitchLimbBuff().getRequiredLimbExpansion() );
	}

	public void setRequiredLimbExpansion( String value ) {
		if( getGelSwitchLimbBuff().getRequiredLimbExpansion() != value ) {
			getGelSwitchLimbBuff().setRequiredLimbExpansion( value );
		}
	}

	public ICFGenKbGelSwitchObj getRequiredParentSwitch() {
		return( getRequiredParentSwitch( false ) );
	}

	public ICFGenKbGelSwitchObj getRequiredParentSwitch( boolean forceRead ) {
		if( forceRead || ( requiredParentSwitch == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbGelSwitchObj obj = ((ICFGenKbSchemaObj)getOrigAsGelSwitchLimb().getSchema()).getGelSwitchTableObj().readGelSwitchByPIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId() );
				requiredParentSwitch = obj;
			}
		}
		return( requiredParentSwitch );
	}

	public void setRequiredParentSwitch( ICFGenKbGelSwitchObj value ) {
			if( buff == null ) {
				getGelSwitchLimbBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getGelSwitchLimbBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getPKey().setRequiredGelCacheId( value.getRequiredGelCacheId() );
				getGelSwitchLimbBuff().setRequiredGelCacheId( value.getRequiredGelCacheId() );
				getPKey().setRequiredGelInstId( value.getRequiredGelInstId() );
				getGelSwitchLimbBuff().setRequiredGelInstId( value.getRequiredGelInstId() );
			}
			else {
			}
			requiredParentSwitch = value;
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTenantObj obj = ((ICFGenKbSchemaObj)getOrigAsGelSwitchLimb().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFGenKbTenantObj value ) {
			if( buff == null ) {
				getGelSwitchLimbBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getGelSwitchLimbBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredGelCacheId( getPKey().getRequiredGelCacheId() );
		buff.setRequiredGelInstId( getPKey().getRequiredGelInstId() );
		buff.setRequiredLimbName( getPKey().getRequiredLimbName() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredGelCacheId( buff.getRequiredGelCacheId() );
		getPKey().setRequiredGelInstId( buff.getRequiredGelInstId() );
		getPKey().setRequiredLimbName( buff.getRequiredLimbName() );
	}

	public void copyBuffToOrig() {
		CFGenKbGelSwitchLimbBuff origBuff = getOrigAsGelSwitchLimb().getGelSwitchLimbBuff();
		CFGenKbGelSwitchLimbBuff myBuff = getGelSwitchLimbBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelSwitchLimbBuff origBuff = getOrigAsGelSwitchLimb().getGelSwitchLimbBuff();
		CFGenKbGelSwitchLimbBuff myBuff = getGelSwitchLimbBuff();
		myBuff.set( origBuff );
	}
}
