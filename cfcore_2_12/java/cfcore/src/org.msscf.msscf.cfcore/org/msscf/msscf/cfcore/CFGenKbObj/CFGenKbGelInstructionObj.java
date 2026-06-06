// Description: Java 11 base object instance implementation for CFGenKb GelInstruction.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbGelInstructionObj
	implements ICFGenKbGelInstructionObj
{
	public final static String CLASS_CODE = "GINS";
	protected boolean isNew;
	protected ICFGenKbGelInstructionEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbGelInstructionPKey pKey;
	protected CFGenKbGelInstructionBuff buff;
	protected ICFGenKbTenantObj requiredOwnerTenant;
	protected ICFGenKbGelCacheObj requiredContainerGelCache;
	protected ICFGenKbGelInstructionObj optionalLookupChainInst;

	public CFGenKbGelInstructionObj() {
		getPKey().setClassCode( getClassCode() );
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public CFGenKbGelInstructionObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		getPKey().setClassCode( getClassCode() );
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelInstruction" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbGelCacheObj scope = getRequiredContainerGelCache();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbGelCacheObj scope = getRequiredContainerGelCache();
		return( scope );
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

	public ICFGenKbGelInstructionObj realise() {
		ICFGenKbGelInstructionObj retobj = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().realiseGelInstruction(
			(ICFGenKbGelInstructionObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().forgetGelInstruction( (ICFGenKbGelInstructionObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelInstructionObj retobj = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().readGelInstructionByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelInstructionObj retobj = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().readGelInstructionByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionTableObj getGelInstructionTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelInstruction().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelInstructionBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelInstructionBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public CFGenKbGelInstructionBuff getGelInstructionBuff() {
		return( (CFGenKbGelInstructionBuff)getBuff() );
	}

	public CFGenKbGelInstructionPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelInstruction().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbGelInstructionPKey value ) {
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

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelInstructionObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelInstructionObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().lockGelInstruction( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbGelInstructionEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbGelInstructionEditObj getEditAsGelInstruction() {
		return( (ICFGenKbGelInstructionEditObj)edit );
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

	public Long getOptionalChainInstTenantId() {
		return( getGelInstructionBuff().getOptionalChainInstTenantId() );
	}

	public Long getOptionalChainInstGelCacheId() {
		return( getGelInstructionBuff().getOptionalChainInstGelCacheId() );
	}

	public Long getOptionalChainInstGelInstId() {
		return( getGelInstructionBuff().getOptionalChainInstGelInstId() );
	}

	public String getRequiredSourceText() {
		return( getGelInstructionBuff().getRequiredSourceText() );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFGenKbGelCacheObj getRequiredContainerGelCache() {
		return( getRequiredContainerGelCache( false ) );
	}

	public ICFGenKbGelCacheObj getRequiredContainerGelCache( boolean forceRead ) {
		if( ( requiredContainerGelCache == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerGelCache = ((ICFGenKbSchemaObj)schema).getGelCacheTableObj().readGelCacheByIdIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(), forceRead );
			}
		}
		return( requiredContainerGelCache );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupChainInst() {
		return( getOptionalLookupChainInst( false ) );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupChainInst( boolean forceRead ) {
		if( ( optionalLookupChainInst == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGelInstructionBuff().getOptionalChainInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelInstructionBuff().getOptionalChainInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelInstructionBuff().getOptionalChainInstGelInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupChainInst = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().readGelInstructionByPIdx( getGelInstructionBuff().getOptionalChainInstTenantId(),
					getGelInstructionBuff().getOptionalChainInstGelCacheId(),
					getGelInstructionBuff().getOptionalChainInstGelInstId(), forceRead );
			}
		}
		return( optionalLookupChainInst );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredGelCacheId( getPKey().getRequiredGelCacheId() );
			buff.setRequiredGelInstId( getPKey().getRequiredGelInstId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredGelCacheId( buff.getRequiredGelCacheId() );
		getPKey().setRequiredGelInstId( buff.getRequiredGelInstId() );
	}

	public void linkChainInstruction( ICFGenKbGelInstructionObj calledInstruction ) {
		final String S_ProcName = "linkChainInstruction";
		final String S_ChainInstAlreadySet = "ChainInst lookup already set for instruction ";
		if( null != getOptionalLookupChainInst() ) {
			throw new CFLibUsageException( getClass(), S_ProcName, S_ChainInstAlreadySet + getPKey().toString() );
		}
		ICFGenKbGelInstructionEditObj editSelf = (ICFGenKbGelInstructionEditObj)beginEdit();
		editSelf.setOptionalLookupChainInst( calledInstruction );
		editSelf.update();
		editSelf = null;
	}

	public void addCalledInstruction( ICFGenKbGelCacheObj gelCache, ICFGenKbGelInstructionObj calledInstruction ) {
		final String S_ProcName = "addCalledInstruction";
		final String S_ChainInstAlreadySet = "ChainInst lookup already set for instruction ";
		if( null != getOptionalLookupChainInst() ) {
			throw new CFLibUsageException( getClass(), S_ProcName, S_ChainInstAlreadySet + getPKey().toString() );
		}
		ICFGenKbGelInstructionEditObj editSelf = (ICFGenKbGelInstructionEditObj)beginEdit();
		editSelf.setOptionalLookupChainInst( calledInstruction );
		editSelf.update();
		editSelf = null;
	}

	public String expand( MssCFGenContext genContext ) {
		throw new RuntimeException( "CFGenKbGelInstructionObj.expand() Must be overloaded by specializing instruction implementation" );
	}
}
