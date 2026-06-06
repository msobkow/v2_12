// Description: Java 11 base object instance implementation for CFBam TSecGrpInc.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamTSecGrpIncObj
	implements ICFBamTSecGrpIncObj
{
	public final static String CLASS_CODE = "TGNC";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecTSecGrpIncEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecTSecGrpIncPKey pKey;
	protected CFSecTSecGrpIncBuff buff;
	protected ICFSecTenantObj requiredOwnerTenant;
	protected ICFSecTSecGroupObj requiredContainerGroup;
	protected ICFSecTSecGroupObj requiredParentSubGroup;

	public CFBamTSecGrpIncObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentSubGroup = null;
	}

	public CFBamTSecGrpIncObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentSubGroup = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TSecGrpInc" );
	}

	public ICFLibAnyObj getScope() {
		ICFSecTSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFSecTSecGroupObj scope = getRequiredContainerGroup();
		return( scope );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredTSecGrpIncId();
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

	public ICFSecTSecGrpIncObj realise() {
		ICFSecTSecGrpIncObj retobj = ((ICFBamSchemaObj)schema).getTSecGrpIncTableObj().realiseTSecGrpInc(
			(ICFSecTSecGrpIncObj)this );
		return( (ICFSecTSecGrpIncObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getTSecGrpIncTableObj().forgetTSecGrpInc( (ICFSecTSecGrpIncObj)this, forgetSubObjects );
	}

	public ICFSecTSecGrpIncObj read() {
		ICFSecTSecGrpIncObj retobj = ((ICFBamSchemaObj)schema).getTSecGrpIncTableObj().readTSecGrpIncByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredTSecGrpIncId(), false );
		return( (ICFSecTSecGrpIncObj)retobj );
	}

	public ICFSecTSecGrpIncObj read( boolean forceRead ) {
		ICFSecTSecGrpIncObj retobj = ((ICFBamSchemaObj)schema).getTSecGrpIncTableObj().readTSecGrpIncByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredTSecGrpIncId(), forceRead );
		return( (ICFSecTSecGrpIncObj)retobj );
	}

	public ICFSecTSecGrpIncTableObj getTSecGrpIncTable() {
		return( ((ICFBamSchemaObj)schema).getTSecGrpIncTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecTSecGrpIncBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableTSecGrpInc().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredTSecGrpIncId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecTSecGrpIncBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecTSecGrpIncBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecTSecGrpIncBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGroup = null;
		requiredParentSubGroup = null;
	}

	public CFSecTSecGrpIncBuff getTSecGrpIncBuff() {
		return( (CFSecTSecGrpIncBuff)getBuff() );
	}

	public CFSecTSecGrpIncPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryTSecGrpInc().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecTSecGrpIncPKey value ) {
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

	public ICFSecTSecGrpIncEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecTSecGrpIncObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecTSecGrpIncObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getTSecGrpIncTableObj().lockTSecGrpInc( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getTSecGrpIncTableObj().newEditInstance( lockobj );
		return( (ICFSecTSecGrpIncEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecTSecGrpIncEditObj getEdit() {
		return( edit );
	}

	public ICFSecTSecGrpIncEditObj getEditAsTSecGrpInc() {
		return( (ICFSecTSecGrpIncEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecTSecGrpIncBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecTSecGrpIncBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredTenantId() {
		return( getPKey().getRequiredTenantId() );
	}

	public long getRequiredTSecGrpIncId() {
		return( getPKey().getRequiredTSecGrpIncId() );
	}

	public int getRequiredTSecGroupId() {
		return( getTSecGrpIncBuff().getRequiredTSecGroupId() );
	}

	public int getRequiredIncludeGroupId() {
		return( getTSecGrpIncBuff().getRequiredIncludeGroupId() );
	}

	public ICFSecTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFSecTSecGroupObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	public ICFSecTSecGroupObj getRequiredContainerGroup( boolean forceRead ) {
		if( ( requiredContainerGroup == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerGroup = ((ICFBamSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
					getTSecGrpIncBuff().getRequiredTSecGroupId(), forceRead );
			}
		}
		return( requiredContainerGroup );
	}

	public ICFSecTSecGroupObj getRequiredParentSubGroup() {
		return( getRequiredParentSubGroup( false ) );
	}

	public ICFSecTSecGroupObj getRequiredParentSubGroup( boolean forceRead ) {
		if( ( requiredParentSubGroup == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentSubGroup = ((ICFBamSchemaObj)schema).getTSecGroupTableObj().readTSecGroupByIdIdx( getPKey().getRequiredTenantId(),
					getTSecGrpIncBuff().getRequiredIncludeGroupId(), forceRead );
			}
		}
		return( requiredParentSubGroup );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredTSecGrpIncId( getPKey().getRequiredTSecGrpIncId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredTSecGrpIncId( buff.getRequiredTSecGrpIncId() );
	}
}
