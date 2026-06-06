// Description: Java 11 edit object instance implementation for CFGenKb GelInstruction.

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

public class CFGenKbGelInstructionEditObj
	implements ICFGenKbGelInstructionEditObj
{
	protected ICFGenKbGelInstructionObj orig;
	protected CFGenKbGelInstructionBuff buff;
	protected ICFGenKbTenantObj requiredOwnerTenant;
	protected ICFGenKbGelCacheObj requiredContainerGelCache;
	protected ICFGenKbGelInstructionObj optionalLookupChainInst;

	public CFGenKbGelInstructionEditObj( ICFGenKbGelInstructionObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbGelInstructionBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public String getClassCode() {
		return( CFGenKbGelInstructionObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbGelInstructionObj retobj = getSchema().getGelInstructionTableObj().realiseGelInstruction( (ICFGenKbGelInstructionObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelInstruction().getSchema()).getGelInstructionTableObj().forgetGelInstruction( getOrigAsGelInstruction(), forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelInstructionObj retval = getOrigAsGelInstruction().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelInstructionObj retval = getOrigAsGelInstruction().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbGelInstructionObj create() {
		copyBuffToOrig();
		ICFGenKbGelInstructionObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelInstruction().getSchema()).getGelInstructionTableObj().createGelInstruction( getOrigAsGelInstruction() );
		if( retobj == getOrigAsGelInstruction() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelInstructionEditObj update() {
		getSchema().getGelInstructionTableObj().updateGelInstruction( (ICFGenKbGelInstructionObj)this );
		return( null );
	}

	public CFGenKbGelInstructionEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getGelInstructionTableObj().deleteGelInstruction( getOrigAsGelInstruction() );
		return( null );
	}

	public ICFGenKbGelInstructionTableObj getGelInstructionTable() {
		return( orig.getSchema().getGelInstructionTableObj() );
	}

	public ICFGenKbGelInstructionEditObj getEdit() {
		return( (ICFGenKbGelInstructionEditObj)this );
	}

	public ICFGenKbGelInstructionEditObj getEditAsGelInstruction() {
		return( (ICFGenKbGelInstructionEditObj)this );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbGelInstructionObj getOrig() {
		return( orig );
	}

	public ICFGenKbGelInstructionObj getOrigAsGelInstruction() {
		return( (ICFGenKbGelInstructionObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelInstruction().getSchema().getBackingStore()).getFactoryGelInstruction().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerGelCache = null;
			optionalLookupChainInst = null;
		}
	}

	public CFGenKbGelInstructionBuff getGelInstructionBuff() {
		return( (CFGenKbGelInstructionBuff)getBuff() );
	}

	public CFGenKbGelInstructionPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbGelInstructionPKey value ) {
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

	public void setRequiredSourceText( String value ) {
		if( getGelInstructionBuff().getRequiredSourceText() != value ) {
			getGelInstructionBuff().setRequiredSourceText( value );
		}
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTenantObj obj = ((ICFGenKbSchemaObj)getOrigAsGelInstruction().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFGenKbTenantObj value ) {
			if( buff == null ) {
				getGelInstructionBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getGelInstructionBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFGenKbGelCacheObj getRequiredContainerGelCache() {
		return( getRequiredContainerGelCache( false ) );
	}

	public ICFGenKbGelCacheObj getRequiredContainerGelCache( boolean forceRead ) {
		if( forceRead || ( requiredContainerGelCache == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbGelCacheObj obj = ((ICFGenKbSchemaObj)getOrigAsGelInstruction().getSchema()).getGelCacheTableObj().readGelCacheByIdIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId() );
				requiredContainerGelCache = obj;
				if( obj != null ) {
					getGelInstructionBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getGelInstructionBuff().setRequiredGelCacheId( obj.getRequiredGelCacheId() );
					requiredContainerGelCache = obj;
				}
			}
		}
		return( requiredContainerGelCache );
	}

	public void setRequiredContainerGelCache( ICFGenKbGelCacheObj value ) {
			if( buff == null ) {
				getGelInstructionBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getGelInstructionBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getPKey().setRequiredGelCacheId( value.getRequiredGelCacheId() );
				getGelInstructionBuff().setRequiredGelCacheId( value.getRequiredGelCacheId() );
			}
			requiredContainerGelCache = value;
	}

	public ICFGenKbGelInstructionObj getOptionalLookupChainInst() {
		return( getOptionalLookupChainInst( false ) );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupChainInst( boolean forceRead ) {
		if( forceRead || ( optionalLookupChainInst == null ) ) {
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
				ICFGenKbGelInstructionObj obj = ((ICFGenKbSchemaObj)getOrigAsGelInstruction().getSchema()).getGelInstructionTableObj().readGelInstructionByPIdx( getGelInstructionBuff().getOptionalChainInstTenantId(),
					getGelInstructionBuff().getOptionalChainInstGelCacheId(),
					getGelInstructionBuff().getOptionalChainInstGelInstId() );
				optionalLookupChainInst = obj;
			}
		}
		return( optionalLookupChainInst );
	}

	public void setOptionalLookupChainInst( ICFGenKbGelInstructionObj value ) {
			if( buff == null ) {
				getGelInstructionBuff();
			}
			if( value != null ) {
				getGelInstructionBuff().setOptionalChainInstTenantId( value.getRequiredTenantId() );
				getGelInstructionBuff().setOptionalChainInstGelCacheId( value.getRequiredGelCacheId() );
				getGelInstructionBuff().setOptionalChainInstGelInstId( value.getRequiredGelInstId() );
			}
			else {
				getGelInstructionBuff().setOptionalChainInstTenantId( null );
				getGelInstructionBuff().setOptionalChainInstGelCacheId( null );
				getGelInstructionBuff().setOptionalChainInstGelInstId( null );
			}
			optionalLookupChainInst = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredGelCacheId( getPKey().getRequiredGelCacheId() );
		buff.setRequiredGelInstId( getPKey().getRequiredGelInstId() );
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredGelCacheId( buff.getRequiredGelCacheId() );
		getPKey().setRequiredGelInstId( buff.getRequiredGelInstId() );
	}

	public void copyBuffToOrig() {
		CFGenKbGelInstructionBuff origBuff = getOrigAsGelInstruction().getGelInstructionBuff();
		CFGenKbGelInstructionBuff myBuff = getGelInstructionBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelInstructionBuff origBuff = getOrigAsGelInstruction().getGelInstructionBuff();
		CFGenKbGelInstructionBuff myBuff = getGelInstructionBuff();
		myBuff.set( origBuff );
	}

	public void linkChainInstruction( ICFGenKbGelInstructionObj calledInstruction ) {
		throw new RuntimeException( "CFGenKbGelInstructionEditObj.linkChainInstruction() You are not allowed to link an instruction during edits" );
	}

	public void addCalledInstruction( ICFGenKbGelCacheObj gelCache, ICFGenKbGelInstructionObj calledInstruction ) {
		throw new RuntimeException( "CFGenKbGelInstructionEditObj.linkChainInstruction() You are not allowed to add an instruction during edits" );
	}

	public String expand( MssCFGenContext genContext ) {
		throw new RuntimeException( "CFGenKbGelInstructionEditObj.expand() You are not allowed to expand an object while it is being edited" );
	}
}
