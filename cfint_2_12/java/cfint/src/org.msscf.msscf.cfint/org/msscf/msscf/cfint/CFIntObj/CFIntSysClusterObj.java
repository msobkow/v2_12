// Description: Java 11 base object instance implementation for CFInt SysCluster.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntSysClusterObj
	implements ICFIntSysClusterObj
{
	public final static String CLASS_CODE = "SYSC";
	protected boolean isNew;
	protected ICFSecSysClusterEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecSysClusterPKey pKey;
	protected CFSecSysClusterBuff buff;
	protected ICFSecClusterObj requiredContainerCluster;

	public CFIntSysClusterObj() {
		isNew = true;
		requiredContainerCluster = null;
	}

	public CFIntSysClusterObj( ICFSecSchemaObj argSchema ) {
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
		ICFSecClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFSecClusterObj scope = getRequiredContainerCluster();
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
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
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
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
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

	public ICFSecSysClusterObj realise() {
		ICFSecSysClusterObj retobj = ((ICFIntSchemaObj)schema).getSysClusterTableObj().realiseSysCluster(
			(ICFSecSysClusterObj)this );
		return( (ICFSecSysClusterObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getSysClusterTableObj().forgetSysCluster( (ICFSecSysClusterObj)this, forgetSubObjects );
	}

	public ICFSecSysClusterObj read() {
		ICFSecSysClusterObj retobj = ((ICFIntSchemaObj)schema).getSysClusterTableObj().readSysClusterByIdIdx( getPKey().getRequiredSingletonId(), false );
		return( (ICFSecSysClusterObj)retobj );
	}

	public ICFSecSysClusterObj read( boolean forceRead ) {
		ICFSecSysClusterObj retobj = ((ICFIntSchemaObj)schema).getSysClusterTableObj().readSysClusterByIdIdx( getPKey().getRequiredSingletonId(), forceRead );
		return( (ICFSecSysClusterObj)retobj );
	}

	public ICFSecSysClusterTableObj getSysClusterTable() {
		return( ((ICFIntSchemaObj)schema).getSysClusterTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecSysClusterBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactorySysCluster().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableSysCluster().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredSingletonId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecSysClusterBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecSysClusterBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecSysClusterBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerCluster = null;
	}

	public CFSecSysClusterBuff getSysClusterBuff() {
		return( (CFSecSysClusterBuff)getBuff() );
	}

	public CFSecSysClusterPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactorySysCluster().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecSysClusterPKey value ) {
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

	public ICFSecSysClusterEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecSysClusterObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSysClusterObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getSysClusterTableObj().lockSysCluster( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getSysClusterTableObj().newEditInstance( lockobj );
		return( (ICFSecSysClusterEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecSysClusterEditObj getEdit() {
		return( edit );
	}

	public ICFSecSysClusterEditObj getEditAsSysCluster() {
		return( (ICFSecSysClusterEditObj)edit );
	}

	public int getRequiredSingletonId() {
		return( getPKey().getRequiredSingletonId() );
	}

	public long getRequiredClusterId() {
		return( getSysClusterBuff().getRequiredClusterId() );
	}

	public ICFSecClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	public ICFSecClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( ( requiredContainerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCluster = ((ICFIntSchemaObj)schema).getClusterTableObj().readClusterByIdIdx( getSysClusterBuff().getRequiredClusterId(), forceRead );
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
