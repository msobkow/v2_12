// Description: Java 11 edit object instance implementation for CFGenKb SecApp.

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

public class CFGenKbSecAppEditObj
	implements ICFGenKbSecAppEditObj
{
	protected ICFGenKbSecAppObj orig;
	protected CFGenKbSecAppBuff buff;
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbSecAppEditObj( ICFGenKbSecAppObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecAppBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerCluster = null;
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbSecAppBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbSecAppBuff buff = getBuff();
			updatedBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public void setCreatedBy( ICFGenKbSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getBuff().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setCreatedAt( Calendar value ) {
		getBuff().setCreatedAt( value );
	}

	public void setUpdatedBy( ICFGenKbSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getBuff().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setUpdatedAt( Calendar value ) {
		getBuff().setUpdatedAt( value );
	}

	public String getClassCode() {
		return( CFGenKbSecAppObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecApp" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredJEEMountName();
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
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getSecFormTableObj().readSecFormByUJEEServletIdx( getRequiredClusterId(),
				getRequiredSecAppId(),
				nextName, false );
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

	public ICFGenKbSecAppObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecAppObj retobj = getSchema().getSecAppTableObj().realiseSecApp( (ICFGenKbSecAppObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecApp().getSchema()).getSecAppTableObj().forgetSecApp( getOrigAsSecApp(), forgetSubObjects );
	}

	public ICFGenKbSecAppObj read() {
		ICFGenKbSecAppObj retval = getOrigAsSecApp().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecAppObj read( boolean forceRead ) {
		ICFGenKbSecAppObj retval = getOrigAsSecApp().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecAppObj create() {
		copyBuffToOrig();
		ICFGenKbSecAppObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecApp().getSchema()).getSecAppTableObj().createSecApp( getOrigAsSecApp() );
		if( retobj == getOrigAsSecApp() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecAppEditObj update() {
		getSchema().getSecAppTableObj().updateSecApp( (ICFGenKbSecAppObj)this );
		return( null );
	}

	public CFGenKbSecAppEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecAppTableObj().deleteSecApp( getOrigAsSecApp() );
		return( null );
	}

	public ICFGenKbSecAppTableObj getSecAppTable() {
		return( orig.getSchema().getSecAppTableObj() );
	}

	public ICFGenKbSecAppEditObj getEdit() {
		return( (ICFGenKbSecAppEditObj)this );
	}

	public ICFGenKbSecAppEditObj getEditAsSecApp() {
		return( (ICFGenKbSecAppEditObj)this );
	}

	public ICFGenKbSecAppEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecAppObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecAppObj getOrigAsSecApp() {
		return( (ICFGenKbSecAppObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecAppBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecApp().getSchema().getBackingStore()).getFactorySecApp().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecAppBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerCluster = null;
		}
	}

	public CFGenKbSecAppBuff getSecAppBuff() {
		return( (CFGenKbSecAppBuff)getBuff() );
	}

	public CFGenKbSecAppPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecAppPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public long getRequiredClusterId() {
		return( getPKey().getRequiredClusterId() );
	}

	public int getRequiredSecAppId() {
		return( getPKey().getRequiredSecAppId() );
	}

	public String getRequiredJEEMountName() {
		return( getSecAppBuff().getRequiredJEEMountName() );
	}

	public void setRequiredJEEMountName( String value ) {
		if( getSecAppBuff().getRequiredJEEMountName() != value ) {
			getSecAppBuff().setRequiredJEEMountName( value );
		}
	}

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( forceRead || ( requiredContainerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbClusterObj obj = ((ICFGenKbSchemaObj)getOrigAsSecApp().getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId() );
				requiredContainerCluster = obj;
				if( obj != null ) {
					getSecAppBuff().setRequiredClusterId( obj.getRequiredId() );
					requiredContainerCluster = obj;
				}
			}
		}
		return( requiredContainerCluster );
	}

	public void setRequiredContainerCluster( ICFGenKbClusterObj value ) {
			if( buff == null ) {
				getSecAppBuff();
			}
			if( value != null ) {
				getPKey().setRequiredClusterId( value.getRequiredId() );
				getSecAppBuff().setRequiredClusterId( value.getRequiredId() );
			}
			requiredContainerCluster = value;
	}

	public List<ICFGenKbSecFormObj> getOptionalComponentsForm() {
		List<ICFGenKbSecFormObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecApp().getSchema()).getSecFormTableObj().readSecFormBySecAppIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecAppId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecFormObj> getOptionalComponentsForm( boolean forceRead ) {
		List<ICFGenKbSecFormObj> retval;
		retval = ((ICFGenKbSchemaObj)getOrigAsSecApp().getSchema()).getSecFormTableObj().readSecFormBySecAppIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecAppId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
		buff.setRequiredSecAppId( getPKey().getRequiredSecAppId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecAppId( buff.getRequiredSecAppId() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecAppBuff origBuff = getOrigAsSecApp().getSecAppBuff();
		CFGenKbSecAppBuff myBuff = getSecAppBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecAppBuff origBuff = getOrigAsSecApp().getSecAppBuff();
		CFGenKbSecAppBuff myBuff = getSecAppBuff();
		myBuff.set( origBuff );
	}
}
