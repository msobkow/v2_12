// Description: Java 11 base object instance implementation for CFGenKb GenItem.

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

public class CFGenKbGenItemObj
	implements ICFGenKbGenItemObj
{
	public final static String CLASS_CODE = "ITM";
	protected boolean isNew;
	protected ICFGenKbGenItemEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbGenItemPKey pKey;
	protected CFGenKbGenItemBuff buff;
	protected ICFGenKbTenantObj requiredOwnerTenant;
	protected ICFGenKbRuleCartObj requiredContainerCartridge;
	protected ICFGenKbRuleTypeObj requiredLookupRuleType;
	protected ICFGenKbToolSetObj requiredLookupToolSet;
	protected ICFGenKbDefClassObj optionalLookupScopeDef;
	protected ICFGenKbDefClassObj requiredLookupGenDef;
	protected ICFGenKbGelExecutableObj optionalComponentsGelExec;
	protected ICFGenKbGenItemObj optionalLookupProbe;

	public CFGenKbGenItemObj() {
		getPKey().setClassCode( getClassCode() );
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public CFGenKbGenItemObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		getPKey().setClassCode( getClassCode() );
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbGenItemObj retobj = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().realiseGenItem(
			(ICFGenKbGenItemObj)this );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGenItemTableObj().forgetGenItem( (ICFGenKbGenItemObj)this, forgetSubObjects );
	}

	public ICFGenKbGenItemObj read() {
		ICFGenKbGenItemObj retobj = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().readGenItemByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), false );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenItemObj read( boolean forceRead ) {
		ICFGenKbGenItemObj retobj = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().readGenItemByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), forceRead );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenItemTableObj getGenItemTable() {
		return( ((ICFGenKbSchemaObj)schema).getGenItemTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenItem().readDerivedByItemIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredCartridgeId(),
						getPKey().getRequiredItemId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGenItemBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGenItemBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public CFGenKbGenItemBuff getGenItemBuff() {
		return( (CFGenKbGenItemBuff)getBuff() );
	}

	public CFGenKbGenItemPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenItem().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbGenItemPKey value ) {
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

	public ICFGenKbGenItemEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGenItemObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGenItemObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().lockGenItem( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGenItemEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbGenItemEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbGenItemEditObj getEditAsGenItem() {
		return( (ICFGenKbGenItemEditObj)edit );
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
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((ICFGenKbSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	public ICFGenKbRuleCartObj getRequiredContainerCartridge() {
		return( getRequiredContainerCartridge( false ) );
	}

	public ICFGenKbRuleCartObj getRequiredContainerCartridge( boolean forceRead ) {
		if( ( requiredContainerCartridge == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerCartridge = ((ICFGenKbSchemaObj)schema).getRuleCartTableObj().readRuleCartByIdIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredCartridgeId(), forceRead );
			}
		}
		return( requiredContainerCartridge );
	}

	public ICFGenKbRuleTypeObj getRequiredLookupRuleType() {
		return( getRequiredLookupRuleType( false ) );
	}

	public ICFGenKbRuleTypeObj getRequiredLookupRuleType( boolean forceRead ) {
		if( ( requiredLookupRuleType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupRuleType = ((ICFGenKbSchemaObj)schema).getRuleTypeTableObj().readRuleTypeByIdIdx( getGenItemBuff().getRequiredRuleTypeId(), forceRead );
			}
		}
		return( requiredLookupRuleType );
	}

	public ICFGenKbToolSetObj getRequiredLookupToolSet() {
		return( getRequiredLookupToolSet( false ) );
	}

	public ICFGenKbToolSetObj getRequiredLookupToolSet( boolean forceRead ) {
		if( ( requiredLookupToolSet == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToolSet = ((ICFGenKbSchemaObj)schema).getToolSetTableObj().readToolSetByIdIdx( getGenItemBuff().getRequiredToolSetId(), forceRead );
			}
		}
		return( requiredLookupToolSet );
	}

	public ICFGenKbDefClassObj getOptionalLookupScopeDef() {
		return( getOptionalLookupScopeDef( false ) );
	}

	public ICFGenKbDefClassObj getOptionalLookupScopeDef( boolean forceRead ) {
		if( ( optionalLookupScopeDef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGenItemBuff().getOptionalScopeDefId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupScopeDef = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().readDefClassByIdIdx( getGenItemBuff().getOptionalScopeDefId(), forceRead );
			}
		}
		return( optionalLookupScopeDef );
	}

	public ICFGenKbDefClassObj getRequiredLookupGenDef() {
		return( getRequiredLookupGenDef( false ) );
	}

	public ICFGenKbDefClassObj getRequiredLookupGenDef( boolean forceRead ) {
		if( ( requiredLookupGenDef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupGenDef = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().readDefClassByIdIdx( getGenItemBuff().getRequiredGenDefId(), forceRead );
			}
		}
		return( requiredLookupGenDef );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsGelExec() {
		return( getOptionalComponentsGelExec( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsGelExec( boolean forceRead ) {
		if( ( optionalComponentsGelExec == null ) || forceRead ) {
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
				optionalComponentsGelExec = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenItemBuff().getOptionalGelExecutableTenantId(),
					getGenItemBuff().getOptionalGelExecutableGelCacheId(),
					getGenItemBuff().getOptionalGelExecutableId(), forceRead );
			}
		}
		return( optionalComponentsGelExec );
	}

	public ICFGenKbGenItemObj getOptionalLookupProbe() {
		return( getOptionalLookupProbe( false ) );
	}

	public ICFGenKbGenItemObj getOptionalLookupProbe( boolean forceRead ) {
		if( ( optionalLookupProbe == null ) || forceRead ) {
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
				optionalLookupProbe = ((ICFGenKbSchemaObj)schema).getGenItemTableObj().readGenItemByItemIdIdx( getGenItemBuff().getOptionalProbeTenantId(),
					getGenItemBuff().getOptionalProbeCartridgeId(),
					getGenItemBuff().getOptionalProbeGenItemId(), forceRead );
			}
		}
		return( optionalLookupProbe );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredTenantId( getPKey().getRequiredTenantId() );
			buff.setRequiredCartridgeId( getPKey().getRequiredCartridgeId() );
			buff.setRequiredItemId( getPKey().getRequiredItemId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setClassCode( buff.getClassCode() );
		getPKey().setRequiredTenantId( buff.getRequiredTenantId() );
		getPKey().setRequiredCartridgeId( buff.getRequiredCartridgeId() );
		getPKey().setRequiredItemId( buff.getRequiredItemId() );
	}
}
