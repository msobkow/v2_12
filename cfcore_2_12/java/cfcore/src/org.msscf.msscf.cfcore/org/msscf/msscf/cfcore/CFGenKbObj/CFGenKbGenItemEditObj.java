// Description: Java 11 edit object instance implementation for CFGenKb GenItem.

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

public class CFGenKbGenItemEditObj
	implements ICFGenKbGenItemEditObj
{
	protected ICFGenKbGenItemObj orig;
	protected CFGenKbGenItemBuff buff;
	protected ICFGenKbTenantObj requiredOwnerTenant;
	protected ICFGenKbRuleCartObj requiredContainerCartridge;
	protected ICFGenKbRuleTypeObj requiredLookupRuleType;
	protected ICFGenKbToolSetObj requiredLookupToolSet;
	protected ICFGenKbDefClassObj optionalLookupScopeDef;
	protected ICFGenKbDefClassObj requiredLookupGenDef;
	protected ICFGenKbGelExecutableObj optionalComponentsGelExec;
	protected ICFGenKbGenItemObj optionalLookupProbe;

	public CFGenKbGenItemEditObj( ICFGenKbGenItemObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbGenItemBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public String getClassCode() {
		return( CFGenKbGenItemObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GenItem" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbRuleCartObj scope = getRequiredContainerCartridge();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbRuleCartObj scope = getRequiredContainerCartridge();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
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

	public ICFGenKbGenItemObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbGenItemObj retobj = getSchema().getGenItemTableObj().realiseGenItem( (ICFGenKbGenItemObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getGenItemTableObj().forgetGenItem( getOrigAsGenItem(), forgetSubObjects );
	}

	public ICFGenKbGenItemObj read() {
		ICFGenKbGenItemObj retval = getOrigAsGenItem().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbGenItemObj read( boolean forceRead ) {
		ICFGenKbGenItemObj retval = getOrigAsGenItem().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbGenItemObj create() {
		copyBuffToOrig();
		ICFGenKbGenItemObj retobj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getGenItemTableObj().createGenItem( getOrigAsGenItem() );
		if( retobj == getOrigAsGenItem() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGenItemEditObj update() {
		getSchema().getGenItemTableObj().updateGenItem( (ICFGenKbGenItemObj)this );
		return( null );
	}

	public CFGenKbGenItemEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getGenItemTableObj().deleteGenItem( getOrigAsGenItem() );
		return( null );
	}

	public ICFGenKbGenItemTableObj getGenItemTable() {
		return( orig.getSchema().getGenItemTableObj() );
	}

	public ICFGenKbGenItemEditObj getEdit() {
		return( (ICFGenKbGenItemEditObj)this );
	}

	public ICFGenKbGenItemEditObj getEditAsGenItem() {
		return( (ICFGenKbGenItemEditObj)this );
	}

	public ICFGenKbGenItemEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbGenItemObj getOrig() {
		return( orig );
	}

	public ICFGenKbGenItemObj getOrigAsGenItem() {
		return( (ICFGenKbGenItemObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGenItem().getSchema().getBackingStore()).getFactoryGenItem().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredOwnerTenant = null;
			requiredContainerCartridge = null;
			requiredLookupRuleType = null;
			requiredLookupToolSet = null;
			optionalLookupScopeDef = null;
			requiredLookupGenDef = null;
			optionalLookupProbe = null;
		}
	}

	public CFGenKbGenItemBuff getGenItemBuff() {
		return( (CFGenKbGenItemBuff)getBuff() );
	}

	public CFGenKbGenItemPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbGenItemPKey value ) {
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

	public long getRequiredCartridgeId() {
		return( getPKey().getRequiredCartridgeId() );
	}

	public long getRequiredItemId() {
		return( getPKey().getRequiredItemId() );
	}

	public short getRequiredRuleTypeId() {
		return( getGenItemBuff().getRequiredRuleTypeId() );
	}

	public String getRequiredName() {
		return( getGenItemBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getGenItemBuff().getRequiredName() != value ) {
			getGenItemBuff().setRequiredName( value );
		}
	}

	public short getRequiredToolSetId() {
		return( getGenItemBuff().getRequiredToolSetId() );
	}

	public Short getOptionalScopeDefId() {
		return( getGenItemBuff().getOptionalScopeDefId() );
	}

	public short getRequiredGenDefId() {
		return( getGenItemBuff().getRequiredGenDefId() );
	}

	public Long getOptionalGelExecutableTenantId() {
		return( getGenItemBuff().getOptionalGelExecutableTenantId() );
	}

	public Long getOptionalGelExecutableGelCacheId() {
		return( getGenItemBuff().getOptionalGelExecutableGelCacheId() );
	}

	public Long getOptionalGelExecutableId() {
		return( getGenItemBuff().getOptionalGelExecutableId() );
	}

	public Long getOptionalProbeTenantId() {
		return( getGenItemBuff().getOptionalProbeTenantId() );
	}

	public Long getOptionalProbeCartridgeId() {
		return( getGenItemBuff().getOptionalProbeCartridgeId() );
	}

	public Long getOptionalProbeGenItemId() {
		return( getGenItemBuff().getOptionalProbeGenItemId() );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	public ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbTenantObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	public void setRequiredOwnerTenant( ICFGenKbTenantObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getGenItemBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerTenant = value;
	}

	public ICFGenKbRuleCartObj getRequiredContainerCartridge() {
		return( getRequiredContainerCartridge( false ) );
	}

	public ICFGenKbRuleCartObj getRequiredContainerCartridge( boolean forceRead ) {
		if( forceRead || ( requiredContainerCartridge == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbRuleCartObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getRuleCartTableObj().readRuleCartByIdIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredCartridgeId() );
				requiredContainerCartridge = obj;
				if( obj != null ) {
					getGenItemBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getGenItemBuff().setRequiredCartridgeId( obj.getRequiredId() );
					requiredContainerCartridge = obj;
				}
			}
		}
		return( requiredContainerCartridge );
	}

	public void setRequiredContainerCartridge( ICFGenKbRuleCartObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getGenItemBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getPKey().setRequiredCartridgeId( value.getRequiredId() );
				getGenItemBuff().setRequiredCartridgeId( value.getRequiredId() );
			}
			requiredContainerCartridge = value;
	}

	public ICFGenKbRuleTypeObj getRequiredLookupRuleType() {
		return( getRequiredLookupRuleType( false ) );
	}

	public ICFGenKbRuleTypeObj getRequiredLookupRuleType( boolean forceRead ) {
		if( forceRead || ( requiredLookupRuleType == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbRuleTypeObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getRuleTypeTableObj().readRuleTypeByIdIdx( getGenItemBuff().getRequiredRuleTypeId() );
				requiredLookupRuleType = obj;
			}
		}
		return( requiredLookupRuleType );
	}

	public void setRequiredLookupRuleType( ICFGenKbRuleTypeObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getGenItemBuff().setRequiredRuleTypeId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupRuleType = value;
	}

	public ICFGenKbToolSetObj getRequiredLookupToolSet() {
		return( getRequiredLookupToolSet( false ) );
	}

	public ICFGenKbToolSetObj getRequiredLookupToolSet( boolean forceRead ) {
		if( forceRead || ( requiredLookupToolSet == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbToolSetObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getToolSetTableObj().readToolSetByIdIdx( getGenItemBuff().getRequiredToolSetId() );
				requiredLookupToolSet = obj;
			}
		}
		return( requiredLookupToolSet );
	}

	public void setRequiredLookupToolSet( ICFGenKbToolSetObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getGenItemBuff().setRequiredToolSetId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupToolSet = value;
	}

	public ICFGenKbDefClassObj getOptionalLookupScopeDef() {
		return( getOptionalLookupScopeDef( false ) );
	}

	public ICFGenKbDefClassObj getOptionalLookupScopeDef( boolean forceRead ) {
		if( forceRead || ( optionalLookupScopeDef == null ) ) {
			boolean anyMissing = false;
			if( getGenItemBuff().getOptionalScopeDefId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbDefClassObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getDefClassTableObj().readDefClassByIdIdx( getGenItemBuff().getOptionalScopeDefId() );
				optionalLookupScopeDef = obj;
			}
		}
		return( optionalLookupScopeDef );
	}

	public void setOptionalLookupScopeDef( ICFGenKbDefClassObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getGenItemBuff().setOptionalScopeDefId( value.getRequiredId() );
			}
			else {
				getGenItemBuff().setOptionalScopeDefId( null );
			}
			optionalLookupScopeDef = value;
	}

	public ICFGenKbDefClassObj getRequiredLookupGenDef() {
		return( getRequiredLookupGenDef( false ) );
	}

	public ICFGenKbDefClassObj getRequiredLookupGenDef( boolean forceRead ) {
		if( forceRead || ( requiredLookupGenDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbDefClassObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getDefClassTableObj().readDefClassByIdIdx( getGenItemBuff().getRequiredGenDefId() );
				requiredLookupGenDef = obj;
			}
		}
		return( requiredLookupGenDef );
	}

	public void setRequiredLookupGenDef( ICFGenKbDefClassObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getGenItemBuff().setRequiredGenDefId( value.getRequiredId() );
			}
			else {
			}
			requiredLookupGenDef = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsGelExec() {
		return( getOptionalComponentsGelExec( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsGelExec( boolean forceRead ) {
		if( forceRead || ( optionalComponentsGelExec == null ) ) {
			boolean anyMissing = false;
			if( getGenItemBuff().getOptionalGelExecutableTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenItemBuff().getOptionalGelExecutableGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenItemBuff().getOptionalGelExecutableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenItemBuff().getOptionalGelExecutableTenantId(),
					getGenItemBuff().getOptionalGelExecutableGelCacheId(),
					getGenItemBuff().getOptionalGelExecutableId() );
				optionalComponentsGelExec = obj;
			}
		}
		return( optionalComponentsGelExec );
	}

	public void setOptionalComponentsGelExec( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getGenItemBuff().setOptionalGelExecutableTenantId( value.getRequiredTenantId() );
				getGenItemBuff().setOptionalGelExecutableGelCacheId( value.getRequiredGelCacheId() );
				getGenItemBuff().setOptionalGelExecutableId( value.getRequiredGelInstId() );
			}
			else {
				getGenItemBuff().setOptionalGelExecutableTenantId( null );
				getGenItemBuff().setOptionalGelExecutableGelCacheId( null );
				getGenItemBuff().setOptionalGelExecutableId( null );
			}
			optionalComponentsGelExec = value;
	}

	public ICFGenKbGenItemObj getOptionalLookupProbe() {
		return( getOptionalLookupProbe( false ) );
	}

	public ICFGenKbGenItemObj getOptionalLookupProbe( boolean forceRead ) {
		if( forceRead || ( optionalLookupProbe == null ) ) {
			boolean anyMissing = false;
			if( getGenItemBuff().getOptionalProbeTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenItemBuff().getOptionalProbeCartridgeId() == null ) {
				anyMissing = true;
			}
			if( getGenItemBuff().getOptionalProbeGenItemId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGenItemObj obj = ((ICFGenKbSchemaObj)getOrigAsGenItem().getSchema()).getGenItemTableObj().readGenItemByItemIdIdx( getGenItemBuff().getOptionalProbeTenantId(),
					getGenItemBuff().getOptionalProbeCartridgeId(),
					getGenItemBuff().getOptionalProbeGenItemId() );
				optionalLookupProbe = obj;
			}
		}
		return( optionalLookupProbe );
	}

	public void setOptionalLookupProbe( ICFGenKbGenItemObj value ) {
			if( buff == null ) {
				getGenItemBuff();
			}
			if( value != null ) {
				getGenItemBuff().setOptionalProbeTenantId( value.getRequiredTenantId() );
				getGenItemBuff().setOptionalProbeCartridgeId( value.getRequiredCartridgeId() );
				getGenItemBuff().setOptionalProbeGenItemId( value.getRequiredItemId() );
			}
			else {
				getGenItemBuff().setOptionalProbeTenantId( null );
				getGenItemBuff().setOptionalProbeCartridgeId( null );
				getGenItemBuff().setOptionalProbeGenItemId( null );
			}
			optionalLookupProbe = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
		buff.setRequiredCartridgeId( getPKey().getRequiredCartridgeId() );
		buff.setRequiredItemId( getPKey().getRequiredItemId() );
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredCartridgeId( buff.getRequiredCartridgeId() );
		getPKey().setRequiredItemId( buff.getRequiredItemId() );
	}

	public void copyBuffToOrig() {
		CFGenKbGenItemBuff origBuff = getOrigAsGenItem().getGenItemBuff();
		CFGenKbGenItemBuff myBuff = getGenItemBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGenItemBuff origBuff = getOrigAsGenItem().getGenItemBuff();
		CFGenKbGenItemBuff myBuff = getGenItemBuff();
		myBuff.set( origBuff );
	}
}
