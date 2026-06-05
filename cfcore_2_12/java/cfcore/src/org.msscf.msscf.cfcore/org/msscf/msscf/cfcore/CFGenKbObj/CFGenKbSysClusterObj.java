// Description: Java 11 base object instance implementation for CFGenKb SysCluster.

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

public class CFGenKbSysClusterObj
	implements ICFGenKbSysClusterObj
{
	public final static String CLASS_CODE = "SYSC";
	protected boolean isNew;
	protected ICFGenKbSysClusterEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbSysClusterPKey pKey;
	protected CFGenKbSysClusterBuff buff;
	protected ICFGenKbClusterObj requiredContainerCluster;

	public CFGenKbSysClusterObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFGenKbSysClusterObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerCluster = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SysCluster" );
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
		int val = getRequiredSingletonId();
		objName = Integer.toString( val );
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

	public ICFGenKbSysClusterObj realise() {
		ICFGenKbSysClusterObj retobj = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().realiseSysCluster(
			(ICFGenKbSysClusterObj)this );
		return( (ICFGenKbSysClusterObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getSysClusterTableObj().forgetSysCluster( (ICFGenKbSysClusterObj)this, forgetSubObjects );
	}

	public ICFGenKbSysClusterObj read() {
		ICFGenKbSysClusterObj retobj = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().readSysClusterByIdIdx( getPKey().getRequiredSingletonId(), false );
		return( (ICFGenKbSysClusterObj)retobj );
	}

	public ICFGenKbSysClusterObj read( boolean forceRead ) {
		ICFGenKbSysClusterObj retobj = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().readSysClusterByIdIdx( getPKey().getRequiredSingletonId(), forceRead );
		return( (ICFGenKbSysClusterObj)retobj );
	}

	public ICFGenKbSysClusterTableObj getSysClusterTable() {
		return( ((ICFGenKbSchemaObj)schema).getSysClusterTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbSysClusterBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySysCluster().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSysCluster().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredSingletonId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbSysClusterBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbSysClusterBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbSysClusterBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFGenKbSysClusterBuff getSysClusterBuff() {
		return( (CFGenKbSysClusterBuff)getBuff() );
	}

	public CFGenKbSysClusterPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySysCluster().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbSysClusterPKey value ) {
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

	public ICFGenKbSysClusterEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbSysClusterObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbSysClusterObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().lockSysCluster( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getSysClusterTableObj().newEditInstance( lockobj );
		return( (ICFGenKbSysClusterEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbSysClusterEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbSysClusterEditObj getEditAsSysCluster() {
		return( (ICFGenKbSysClusterEditObj)edit );
	}

	public int getRequiredSingletonId() {
		return( getPKey().getRequiredSingletonId() );
	}

	public long getRequiredClusterId() {
		return( getSysClusterBuff().getRequiredClusterId() );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = ((ICFGenKbSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getSysClusterBuff().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredContainerCluster );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredSingletonId( getPKey().getRequiredSingletonId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSingletonId( buff.getRequiredSingletonId() );
	}
}
