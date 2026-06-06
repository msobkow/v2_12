// Description: Java 11 base object instance implementation for CFGenKb GelPop.

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
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public class CFGenKbGelPopObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelPopObj
{
	public final static String CLASS_CODE = "GPOP";
	protected ICFGenKbGelInstructionObj optionalLookupRemainder;

	public CFGenKbGelPopObj() {
		super();
		optionalLookupRemainder = null;
	}

	public CFGenKbGelPopObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupRemainder = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelPop" );
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
		ICFGenKbGelPopObj retobj = ((ICFGenKbSchemaObj)schema).getGelPopTableObj().realiseGelPop(
			(ICFGenKbGelPopObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelPopTableObj().forgetGelPop( (ICFGenKbGelPopObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelPopObj retobj = ((ICFGenKbSchemaObj)schema).getGelPopTableObj().readGelPopByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelPopObj retobj = ((ICFGenKbSchemaObj)schema).getGelPopTableObj().readGelPopByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelPopTableObj getGelPopTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelPopTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPop().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPop().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredGelCacheId(),
						getPKey().getRequiredGelInstId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelPopBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelPopBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
		optionalLookupRemainder = null;
	}

	public CFGenKbGelPopBuff getGelPopBuff() {
		return( (CFGenKbGelPopBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelPopObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelPopObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelPopTableObj().lockGelPop( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelPopTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelPopEditObj getEditAsGelPop() {
		return( (ICFGenKbGelPopEditObj)edit );
	}

	public String getRequiredGoalTypeName() {
		return( getGelPopBuff().getRequiredGoalTypeName() );
	}

	public Long getOptionalRemainderTenantId() {
		return( getGelPopBuff().getOptionalRemainderTenantId() );
	}

	public long getRequiredRemainderGelCacheId() {
		return( getGelPopBuff().getRequiredRemainderGelCacheId() );
	}

	public Long getOptionalRemainderInstId() {
		return( getGelPopBuff().getOptionalRemainderInstId() );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupRemainder() {
		return( getOptionalLookupRemainder( false ) );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupRemainder( boolean forceRead ) {
		if( ( optionalLookupRemainder == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGelPopBuff().getOptionalRemainderTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelPopBuff().getOptionalRemainderInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupRemainder = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().readGelInstructionByPIdx( getGelPopBuff().getOptionalRemainderTenantId(),
					getGelPopBuff().getRequiredRemainderGelCacheId(),
					getGelPopBuff().getOptionalRemainderInstId(), forceRead );
			}
		}
		return( optionalLookupRemainder );
	}

	public String expand( MssCFGenContext genContext ) {
		throw new RuntimeException( "CFGenKbGelPopObj.expand() must be specialized by the pop implementation" );
	}
}
