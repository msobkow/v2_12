// Description: Java 11 edit object instance implementation for CFGenKb RuleCart.

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

public class CFGenKbRuleCartEditObj
	implements ICFGenKbRuleCartEditObj
{
	protected ICFGenKbRuleCartObj orig;
	protected CFGenKbRuleCartBuff buff;
	protected ICFGenKbTenantObj requiredContainerTenant;

	public CFGenKbRuleCartEditObj( ICFGenKbRuleCartObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbRuleCartBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerTenant = null;
	}

	public String getClassCode() {
		return( CFGenKbRuleCartObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "RuleCart" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbTenantObj scope = getRequiredContainerTenant();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbTenantObj scope = getRequiredContainerTenant();
		return( scope );
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

	public ICFGenKbRuleCartObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbRuleCartObj retobj = getSchema().getRuleCartTableObj().realiseRuleCart( (ICFGenKbRuleCartObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsRuleCart().getSchema()).getRuleCartTableObj().forgetRuleCart( getOrigAsRuleCart(), forgetSubObjects );
	}

	public ICFGenKbRuleCartObj read() {
		ICFGenKbRuleCartObj retval = getOrigAsRuleCart().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbRuleCartObj read( boolean forceRead ) {
		ICFGenKbRuleCartObj retval = getOrigAsRuleCart().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbRuleCartObj create() {
		copyBuffToOrig();
		ICFGenKbRuleCartObj retobj = ((ICFGenKbSchemaObj)getOrigAsRuleCart().getSchema()).getRuleCartTableObj().createRuleCart( getOrigAsRuleCart() );
		if( retobj == getOrigAsRuleCart() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbRuleCartEditObj update() {
		getSchema().getRuleCartTableObj().updateRuleCart( (ICFGenKbRuleCartObj)this );
		return( null );
	}

	public CFGenKbRuleCartEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getRuleCartTableObj().deleteRuleCart( getOrigAsRuleCart() );
		return( null );
	}

	public ICFGenKbRuleCartTableObj getRuleCartTable() {
		return( orig.getSchema().getRuleCartTableObj() );
	}

	public ICFGenKbRuleCartEditObj getEdit() {
		return( (ICFGenKbRuleCartEditObj)this );
	}

	public ICFGenKbRuleCartEditObj getEditAsRuleCart() {
		return( (ICFGenKbRuleCartEditObj)this );
	}

	public ICFGenKbRuleCartEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbRuleCartObj getOrig() {
		return( orig );
	}

	public ICFGenKbRuleCartObj getOrigAsRuleCart() {
		return( (ICFGenKbRuleCartObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbRuleCartBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsRuleCart().getSchema().getBackingStore()).getFactoryRuleCart().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbRuleCartBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerTenant = null;
		}
	}

	public CFGenKbRuleCartBuff getRuleCartBuff() {
		return( (CFGenKbRuleCartBuff)getBuff() );
	}

	public CFGenKbRuleCartPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbRuleCartPKey value ) {
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

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredName() {
		return( getRuleCartBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getRuleCartBuff().getRequiredName() != value ) {
			getRuleCartBuff().setRequiredName( value );
		}
	}

	public String getOptionalDescr() {
		return( getRuleCartBuff().getOptionalDescr() );
	}

	public void setOptionalDescr( String value ) {
		if( getRuleCartBuff().getOptionalDescr() != value ) {
			getRuleCartBuff().setOptionalDescr( value );
		}
	}

	public String getOptionalRevisionString() {
		return( getRuleCartBuff().getOptionalRevisionString() );
	}

	public void setOptionalRevisionString( String value ) {
		if( getRuleCartBuff().getOptionalRevisionString() != value ) {
			getRuleCartBuff().setOptionalRevisionString( value );
		}
	}

	public ICFGenKbTenantObj getRequiredContainerTenant() {
		return( getRequiredContainerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredContainerTenant( boolean forceRead ) {
		if( forceRead || ( requiredContainerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTenantObj obj = ((ICFGenKbSchemaObj)getOrigAsRuleCart().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredContainerTenant = obj;
				if( obj != null ) {
					getRuleCartBuff().setRequiredTenantId( obj.getRequiredId() );
					requiredContainerTenant = obj;
				}
			}
		}
		return( requiredContainerTenant );
	}

	public void setRequiredContainerTenant( ICFGenKbTenantObj value ) {
			if( buff == null ) {
				getRuleCartBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getRuleCartBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredContainerTenant = value;
	}

	public List<ICFGenKbGenItemObj> getOptionalComponentsRule() {
		List<ICFGenKbGenItemObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsRuleCart().getSchema()).getGenItemTableObj().readGenItemByCartIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbGenItemObj> getOptionalComponentsRule( boolean forceRead ) {
		List<ICFGenKbGenItemObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsRuleCart().getSchema()).getGenItemTableObj().readGenItemByCartIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFGenKbRuleCartBuff origBuff = getOrigAsRuleCart().getRuleCartBuff();
		CFGenKbRuleCartBuff myBuff = getRuleCartBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbRuleCartBuff origBuff = getOrigAsRuleCart().getRuleCartBuff();
		CFGenKbRuleCartBuff myBuff = getRuleCartBuff();
		myBuff.set( origBuff );
	}
}
