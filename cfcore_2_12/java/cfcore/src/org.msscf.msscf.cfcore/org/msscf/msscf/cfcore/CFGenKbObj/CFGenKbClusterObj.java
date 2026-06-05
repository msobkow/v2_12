// Description: Java 11 base object instance implementation for CFGenKb Cluster.

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

public class CFGenKbClusterObj
	implements ICFGenKbClusterObj
{
	public final static String CLASS_CODE = "CLUS";
	protected ICFGenKbSecUserObj createdBy = null;
	protected ICFGenKbSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFGenKbClusterEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbClusterPKey pKey;
	protected CFGenKbClusterBuff buff;

	public CFGenKbClusterObj() {
		isNew = true;
	}

	public CFGenKbClusterObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Cluster" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredFullDomName();
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
			subObj = ((ICFGenKbSchemaObj)getSchema()).getHostNodeTableObj().readHostNodeByHostNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getTenantTableObj().readTenantByUNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getSecAppTableObj().readSecAppByUJEEMountIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFGenKbSchemaObj)getSchema()).getSecGroupTableObj().readSecGroupByUNameIdx( getRequiredId(),
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

	public ICFGenKbClusterObj realise() {
		ICFGenKbClusterObj retobj = ((ICFGenKbSchemaObj)schema).getClusterTableObj().realiseCluster(
			(ICFGenKbClusterObj)this );
		return( (ICFGenKbClusterObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getClusterTableObj().forgetCluster( (ICFGenKbClusterObj)this, forgetSubObjects );
	}

	public ICFGenKbClusterObj read() {
		ICFGenKbClusterObj retobj = ((ICFGenKbSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredId(), false );
		return( (ICFGenKbClusterObj)retobj );
	}

	public ICFGenKbClusterObj read( boolean forceRead ) {
		ICFGenKbClusterObj retobj = ((ICFGenKbSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getPKey().getRequiredId(), forceRead );
		return( (ICFGenKbClusterObj)retobj );
	}

	public ICFGenKbClusterTableObj getClusterTable() {
		return( ((ICFGenKbSchemaObj)schema).getClusterTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbClusterBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableCluster().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbClusterBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbClusterBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbClusterBuff" );
		}
		buff = value;
		copyBuffToPKey();
	}

	public CFGenKbClusterBuff getClusterBuff() {
		return( (CFGenKbClusterBuff)getBuff() );
	}

	public CFGenKbClusterPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryCluster().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbClusterPKey value ) {
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

	public ICFGenKbClusterEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbClusterObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbClusterObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getClusterTableObj().lockCluster( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getClusterTableObj().newEditInstance( lockobj );
		return( (ICFGenKbClusterEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbClusterEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbClusterEditObj getEditAsCluster() {
		return( (ICFGenKbClusterEditObj)edit );
	}

	public ICFGenKbSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFGenKbClusterBuff buff = getBuff();
			createdBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFGenKbSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFGenKbClusterBuff buff = getBuff();
			updatedBy = ((ICFGenKbSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredFullDomName() {
		return( getClusterBuff().getRequiredFullDomName() );
	}

	public String getRequiredDescription() {
		return( getClusterBuff().getRequiredDescription() );
	}

	public List<ICFGenKbHostNodeObj> getOptionalComponentsHostNode() {
		List<ICFGenKbHostNodeObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbHostNodeObj> getOptionalComponentsHostNode( boolean forceRead ) {
		List<ICFGenKbHostNodeObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbTenantObj> getOptionalComponentsTenant() {
		List<ICFGenKbTenantObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbTenantObj> getOptionalComponentsTenant( boolean forceRead ) {
		List<ICFGenKbTenantObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecAppObj> getOptionalComponentsSecApp() {
		List<ICFGenKbSecAppObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().readSecAppByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecAppObj> getOptionalComponentsSecApp( boolean forceRead ) {
		List<ICFGenKbSecAppObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecAppTableObj().readSecAppByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSecGroupObj> getOptionalComponentsSecGroup() {
		List<ICFGenKbSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSecGroupObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ICFGenKbSecGroupObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFGenKbSysClusterObj> getOptionalComponentsSysCluster() {
		List<ICFGenKbSysClusterObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFGenKbSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead ) {
		List<ICFGenKbSysClusterObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredId( getPKey().getRequiredId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}
}
