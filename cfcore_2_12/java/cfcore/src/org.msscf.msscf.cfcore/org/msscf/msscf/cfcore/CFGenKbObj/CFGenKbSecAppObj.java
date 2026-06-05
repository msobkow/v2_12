// Description: Java 11 base object instance implementation for CFGenKb SecApp.

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

public class CFGenKbSecAppObj
	implements ICFGenKbSecAppObj
{
	public final static String CLASS_CODE = "SAPP";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbSecAppEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbSecAppPKey pKey;
	protected CFGenKbSecAppBuff buff;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbSecAppObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFGenKbSecAppObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerCluster = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbSecAppObj retobj = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().realiseSecApp(
			(ICFGenKbSecAppObj)this );
		return( (ICFGenKbSecAppObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getSecAppTableObj().forgetSecApp( (ICFGenKbSecAppObj)this, forgetSubObjects );
	}

	public ICFGenKbSecAppObj read() {
		ICFGenKbSecAppObj retobj = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().readSecAppByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecAppId(), false );
		return( (ICFGenKbSecAppObj)retobj );
	}

	public ICFGenKbSecAppObj read( boolean forceRead ) {
		ICFGenKbSecAppObj retobj = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().readSecAppByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredSecAppId(), forceRead );
		return( (ICFGenKbSecAppObj)retobj );
	}

	public ICFGenKbSecAppTableObj getSecAppTable() {
		return( ((ICFGenKbSchemaObj)schema).getSecAppTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbSecAppBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecApp().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredClusterId(),
						getPKey().getRequiredSecAppId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecAppBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbSecAppBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbSecAppBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFGenKbSecAppBuff getSecAppBuff() {
		return( (CFGenKbSecAppBuff)getBuff() );
	}

	public CFGenKbSecAppPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecApp().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbSecAppPKey value ) {
		if( pKey != value ) {
			pKey = value;
			copyPKeyToBuff();
		}
	}

	public boolean getIsNew() {
		return( isNew );
	}

	public void setIsNew( boolean value ) {
		isNew = value;
	}

	public ICFGenKbSecAppEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbSecAppObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbSecAppObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().lockSecApp( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().newEditInstance( lockobj );
		return( (ICFGenKbSecAppEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbSecAppEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbSecAppEditObj getEditAsSecApp() {
		return( (ICFGenKbSecAppEditObj)edit );
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

	public long getRequiredClusterId() {
		return( getPKey().getRequiredClusterId() );
	}

	public int getRequiredSecAppId() {
		return( getPKey().getRequiredSecAppId() );
	}

	public String getRequiredJEEMountName() {
		return( getSecAppBuff().getRequiredJEEMountName() );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = ((ICFGenKbSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredContainerCluster );
	}

	public List<ICFGenKbSecFormObj> getOptionalComponentsForm() {
		List<ICFGenKbSecFormObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecFormTableObj().readSecFormBySecAppIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecAppId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecFormObj> getOptionalComponentsForm( boolean forceRead ) {
		List<ICFGenKbSecFormObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecFormTableObj().readSecFormBySecAppIdx( getPKey().getRequiredClusterId(),
					getPKey().getRequiredSecAppId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
			buff.setRequiredSecAppId( getPKey().getRequiredSecAppId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredSecAppId( buff.getRequiredSecAppId() );
	}
}
