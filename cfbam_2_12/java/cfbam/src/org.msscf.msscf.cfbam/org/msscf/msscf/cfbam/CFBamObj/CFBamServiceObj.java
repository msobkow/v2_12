// Description: Java 11 base object instance implementation for CFBam Service.

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

public class CFBamServiceObj
	implements ICFBamServiceObj
{
	public final static String CLASS_CODE = "HSVC";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecServiceEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecServicePKey pKey;
	protected CFSecServiceBuff buff;
	protected ICFSecClusterObj requiredOwnerCluster;
	protected ICFSecHostNodeObj optionalContainerHost;
	protected ICFSecServiceTypeObj optionalParentServiceType;

	public CFBamServiceObj() {
		isNew = true;
		requiredOwnerCluster = null;
		optionalContainerHost = null;
		optionalParentServiceType = null;
	}

	public CFBamServiceObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerCluster = null;
		optionalContainerHost = null;
		optionalParentServiceType = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Service" );
	}

	public ICFLibAnyObj getScope() {
		ICFSecHostNodeObj scope = getOptionalContainerHost();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFSecHostNodeObj scope = getOptionalContainerHost();
		return( scope );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredServiceId();
		objName = Long.toString( val );
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
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
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
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
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

	public ICFSecServiceObj realise() {
		ICFSecServiceObj retobj = ((ICFBamSchemaObj)schema).getServiceTableObj().realiseService(
			(ICFSecServiceObj)this );
		return( (ICFSecServiceObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getServiceTableObj().forgetService( (ICFSecServiceObj)this, forgetSubObjects );
	}

	public ICFSecServiceObj read() {
		ICFSecServiceObj retobj = ((ICFBamSchemaObj)schema).getServiceTableObj().readServiceByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredServiceId(), false );
		return( (ICFSecServiceObj)retobj );
	}

	public ICFSecServiceObj read( boolean forceRead ) {
		ICFSecServiceObj retobj = ((ICFBamSchemaObj)schema).getServiceTableObj().readServiceByIdIdx( getPKey().getRequiredClusterId(),
			getPKey().getRequiredServiceId(), forceRead );
		return( (ICFSecServiceObj)retobj );
	}

	public ICFSecServiceTableObj getServiceTable() {
		return( ((ICFBamSchemaObj)schema).getServiceTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecServiceBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryService().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableService().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredClusterId(),
						getPKey().getRequiredServiceId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecServiceBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecServiceBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecServiceBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerCluster = null;
		optionalContainerHost = null;
		optionalParentServiceType = null;
	}

	public CFSecServiceBuff getServiceBuff() {
		return( (CFSecServiceBuff)getBuff() );
	}

	public CFSecServicePKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryService().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecServicePKey value ) {
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

	public ICFSecServiceEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecServiceObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecServiceObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getServiceTableObj().lockService( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getServiceTableObj().newEditInstance( lockobj );
		return( (ICFSecServiceEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecServiceEditObj getEdit() {
		return( edit );
	}

	public ICFSecServiceEditObj getEditAsService() {
		return( (ICFSecServiceEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecServiceBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecServiceBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredClusterId() {
		return( getPKey().getRequiredClusterId() );
	}

	public long getRequiredServiceId() {
		return( getPKey().getRequiredServiceId() );
	}

	public long getRequiredHostNodeId() {
		return( getServiceBuff().getRequiredHostNodeId() );
	}

	public int getRequiredServiceTypeId() {
		return( getServiceBuff().getRequiredServiceTypeId() );
	}

	public short getRequiredHostPort() {
		return( getServiceBuff().getRequiredHostPort() );
	}

	public ICFSecClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	public ICFSecClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( ( requiredOwnerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerCluster = ((ICFBamSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredOwnerCluster );
	}

	public ICFSecHostNodeObj getOptionalContainerHost() {
		return( getOptionalContainerHost( false ) );
	}

	public ICFSecHostNodeObj getOptionalContainerHost( boolean forceRead ) {
		if( ( optionalContainerHost == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalContainerHost = ((ICFBamSchemaObj)schema).getHostNodeTableObj().readHostNodeByIdIdx( getPKey().getRequiredClusterId(),
					getServiceBuff().getRequiredHostNodeId(), forceRead );
			}
		}
		return( optionalContainerHost );
	}

	public ICFSecServiceTypeObj getOptionalParentServiceType() {
		return( getOptionalParentServiceType( false ) );
	}

	public ICFSecServiceTypeObj getOptionalParentServiceType( boolean forceRead ) {
		if( ( optionalParentServiceType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalParentServiceType = ((ICFBamSchemaObj)schema).getServiceTypeTableObj().readServiceTypeByIdIdx( getServiceBuff().getRequiredServiceTypeId(), forceRead );
			}
		}
		return( optionalParentServiceType );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredClusterId( getPKey().getRequiredClusterId() );
			buff.setRequiredServiceId( getPKey().getRequiredServiceId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredClusterId( buff.getRequiredClusterId() );
		getPKey().setRequiredServiceId( buff.getRequiredServiceId() );
	}
}
