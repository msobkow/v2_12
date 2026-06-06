// Description: Java 11 Instance Edit Object interface for CFGenKb GenItem.

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

public interface ICFGenKbGenItemEditObj
	extends ICFGenKbGenItemObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbGenItemObj.
	 */
	ICFGenKbGenItemObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbGenItemObj.
	 */
	ICFGenKbGenItemObj getOrigAsGenItem();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbGenItemObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbGenItemEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbGenItemEditObj deleteInstance();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The String value of the attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param	value	the String value of the attribute Name.
	 */
	void setRequiredName( String value );

	/**
	 *	Get the ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredOwnerTenant();

	/**
	 *	Set the ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFGenKbTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFGenKbTenantObj value );

	/**
	 *	Get the ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 *
	 *	@return	The ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 */
	ICFGenKbRuleCartObj getRequiredContainerCartridge();

	/**
	 *	Set the ICFGenKbRuleCartObj instance referenced by the Cartridge key.
	 *
	 *	@param	value	the ICFGenKbRuleCartObj instance to be referenced by the Cartridge key.
	 */
	void setRequiredContainerCartridge( ICFGenKbRuleCartObj value );

	/**
	 *	Get the ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 *
	 *	@return	The ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 */
	ICFGenKbRuleTypeObj getRequiredLookupRuleType();

	/**
	 *	Set the ICFGenKbRuleTypeObj instance referenced by the RuleType key.
	 *
	 *	@param	value	the ICFGenKbRuleTypeObj instance to be referenced by the RuleType key.
	 */
	void setRequiredLookupRuleType( ICFGenKbRuleTypeObj value );

	/**
	 *	Get the ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 *
	 *	@return	The ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 */
	ICFGenKbToolSetObj getRequiredLookupToolSet();

	/**
	 *	Set the ICFGenKbToolSetObj instance referenced by the ToolSet key.
	 *
	 *	@param	value	the ICFGenKbToolSetObj instance to be referenced by the ToolSet key.
	 */
	void setRequiredLookupToolSet( ICFGenKbToolSetObj value );

	/**
	 *	Get the ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 *
	 *	@return	The ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 */
	ICFGenKbDefClassObj getOptionalLookupScopeDef();

	/**
	 *	Set the ICFGenKbDefClassObj instance referenced by the ScopeDef key.
	 *
	 *	@param	value	the ICFGenKbDefClassObj instance to be referenced by the ScopeDef key.
	 */
	void setOptionalLookupScopeDef( ICFGenKbDefClassObj value );

	/**
	 *	Get the ICFGenKbDefClassObj instance referenced by the GenDef key.
	 *
	 *	@return	The ICFGenKbDefClassObj instance referenced by the GenDef key.
	 */
	ICFGenKbDefClassObj getRequiredLookupGenDef();

	/**
	 *	Set the ICFGenKbDefClassObj instance referenced by the GenDef key.
	 *
	 *	@param	value	the ICFGenKbDefClassObj instance to be referenced by the GenDef key.
	 */
	void setRequiredLookupGenDef( ICFGenKbDefClassObj value );

	/**
	 *	Get the ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 *
	 *	@return	The ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 */
	ICFGenKbGelExecutableObj getOptionalComponentsGelExec();

	/**
	 *	Set the ICFGenKbGelExecutableObj instance referenced by the GelExec key.
	 *
	 *	@param	value	the ICFGenKbGelExecutableObj instance to be referenced by the GelExec key.
	 */
	void setOptionalComponentsGelExec( ICFGenKbGelExecutableObj value );

	/**
	 *	Get the ICFGenKbGenItemObj instance referenced by the Probe key.
	 *
	 *	@return	The ICFGenKbGenItemObj instance referenced by the Probe key.
	 */
	ICFGenKbGenItemObj getOptionalLookupProbe();

	/**
	 *	Set the ICFGenKbGenItemObj instance referenced by the Probe key.
	 *
	 *	@param	value	the ICFGenKbGenItemObj instance to be referenced by the Probe key.
	 */
	void setOptionalLookupProbe( ICFGenKbGenItemObj value );
}
