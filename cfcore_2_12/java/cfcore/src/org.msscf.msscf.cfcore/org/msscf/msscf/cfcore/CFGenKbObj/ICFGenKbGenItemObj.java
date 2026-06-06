// Description: Java 11 Object interface for CFGenKb GenItem.

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
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbGenItemObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a GenItem.
	 *
	 *	@return	CFGenKbGenItemObj instance which should be subsequently referenced.
	 */
	ICFGenKbGenItemObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();
	void forget( boolean forgetSubObjects );

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbGenItemObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbGenItemObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbGenItemObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbGenItemObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this GenItem instance.
	 *
	 *	@return	The newly locked ICFGenKbGenItemEditObj edition of this instance.
	 */
	ICFGenKbGenItemEditObj beginEdit();

	/**
	 *	End this edition of this GenItem instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this GenItem instance.
	 *
	 *	@return	The ICFGenKbGenItemEditObj edition of this instance.
	 */
	ICFGenKbGenItemEditObj getEdit();

	/**
	 *	Get the current edition of this GenItem instance as a ICFGenKbGenItemEditObj.
	 *
	 *	@return	The ICFGenKbGenItemEditObj edition of this instance.
	 */
	ICFGenKbGenItemEditObj getEditAsGenItem();

	/**
	 *	Get the ICFGenKbGenItemTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGenItemTableObj table cache which manages this instance.
	 */
	ICFGenKbGenItemTableObj getGenItemTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbGenItemBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGenItemBuff instance which currently backs this object.
	 */
	CFGenKbGenItemBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbGenItemBuff value );

	/**
	 *	Get the CFGenKbGenItemBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGenItemBuff instance which currently backs this object.
	 */
	CFGenKbGenItemBuff getGenItemBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbGenItemPKey primary key for this instance.
	 */
	CFGenKbGenItemPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbGenItemPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbGenItemPKey value );

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required long attribute TenantId.
	 *
	 *	@return	The required long attribute TenantId.
	 */
	long getRequiredTenantId();

	/**
	 *	Get the required long attribute CartridgeId.
	 *
	 *	@return	The required long attribute CartridgeId.
	 */
	long getRequiredCartridgeId();

	/**
	 *	Get the required long attribute ItemId.
	 *
	 *	@return	The required long attribute ItemId.
	 */
	long getRequiredItemId();

	/**
	 *	Get the required short attribute RuleTypeId.
	 *
	 *	@return	The required short attribute RuleTypeId.
	 */
	short getRequiredRuleTypeId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required short attribute ToolSetId.
	 *
	 *	@return	The required short attribute ToolSetId.
	 */
	short getRequiredToolSetId();

	/**
	 *	Get the optional Short attribute ScopeDefId.
	 *
	 *	@return	The optional Short attribute ScopeDefId.
	 */
	Short getOptionalScopeDefId();

	/**
	 *	Get the required short attribute GenDefId.
	 *
	 *	@return	The required short attribute GenDefId.
	 */
	short getRequiredGenDefId();

	/**
	 *	Get the optional Long attribute GelExecutableTenantId.
	 *
	 *	@return	The optional Long attribute GelExecutableTenantId.
	 */
	Long getOptionalGelExecutableTenantId();

	/**
	 *	Get the optional Long attribute GelExecutableGelCacheId.
	 *
	 *	@return	The optional Long attribute GelExecutableGelCacheId.
	 */
	Long getOptionalGelExecutableGelCacheId();

	/**
	 *	Get the optional Long attribute GelExecutableId.
	 *
	 *	@return	The optional Long attribute GelExecutableId.
	 */
	Long getOptionalGelExecutableId();

	/**
	 *	Get the optional Long attribute ProbeTenantId.
	 *
	 *	@return	The optional Long attribute ProbeTenantId.
	 */
	Long getOptionalProbeTenantId();

	/**
	 *	Get the optional Long attribute ProbeCartridgeId.
	 *
	 *	@return	The optional Long attribute ProbeCartridgeId.
	 */
	Long getOptionalProbeCartridgeId();

	/**
	 *	Get the optional Long attribute ProbeGenItemId.
	 *
	 *	@return	The optional Long attribute ProbeGenItemId.
	 */
	Long getOptionalProbeGenItemId();

	/**
	 *	Get the required ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 *
	 *	@return	The required ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 */
	ICFGenKbRuleCartObj getRequiredContainerCartridge();

	/**
	 *	Get the required ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 *
	 *	@return	The required ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 */
	ICFGenKbRuleCartObj getRequiredContainerCartridge( boolean forceRead );

	/**
	 *	Get the required ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 *
	 *	@return	The required ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 */
	ICFGenKbRuleTypeObj getRequiredLookupRuleType();

	/**
	 *	Get the required ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 *
	 *	@return	The required ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 */
	ICFGenKbRuleTypeObj getRequiredLookupRuleType( boolean forceRead );

	/**
	 *	Get the required ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 *
	 *	@return	The required ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 */
	ICFGenKbToolSetObj getRequiredLookupToolSet();

	/**
	 *	Get the required ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 *
	 *	@return	The required ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 */
	ICFGenKbToolSetObj getRequiredLookupToolSet( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 *
	 *	@return	The optional ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 */
	ICFGenKbDefClassObj getOptionalLookupScopeDef();

	/**
	 *	Get the optional ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 *
	 *	@return	The optional ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 */
	ICFGenKbDefClassObj getOptionalLookupScopeDef( boolean forceRead );

	/**
	 *	Get the required ICFGenKbDefClassObj instance referenced by the GenDef key.
	 *
	 *	@return	The required ICFGenKbDefClassObj instance referenced by the GenDef key.
	 */
	ICFGenKbDefClassObj getRequiredLookupGenDef();

	/**
	 *	Get the required ICFGenKbDefClassObj instance referenced by the GenDef key.
	 *
	 *	@return	The required ICFGenKbDefClassObj instance referenced by the GenDef key.
	 */
	ICFGenKbDefClassObj getRequiredLookupGenDef( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 *
	 *	@return	The optional ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 */
	ICFGenKbGelExecutableObj getOptionalComponentsGelExec();

	/**
	 *	Get the optional ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 *
	 *	@return	The optional ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 */
	ICFGenKbGelExecutableObj getOptionalComponentsGelExec( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbGenItemObj instance referenced by the Probe key.
	 *
	 *	@return	The optional ICFGenKbGenItemObj instance referenced by the Probe key.
	 */
	ICFGenKbGenItemObj getOptionalLookupProbe();

	/**
	 *	Get the optional ICFGenKbGenItemObj instance referenced by the Probe key.
	 *
	 *	@return	The optional ICFGenKbGenItemObj instance referenced by the Probe key.
	 */
	ICFGenKbGenItemObj getOptionalLookupProbe( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
