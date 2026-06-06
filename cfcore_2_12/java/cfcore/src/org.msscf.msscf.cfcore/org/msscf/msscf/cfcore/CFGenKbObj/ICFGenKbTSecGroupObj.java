// Description: Java 11 Object interface for CFGenKb TSecGroup.

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

public interface ICFGenKbTSecGroupObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ICFGenKbSecUserObj instance who created this instance.
	 */
	ICFGenKbSecUserObj getCreatedBy();

	/**
	 *	Get the Calendar date-time this instance was created.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ICFGenKbSecUserObj instance who updated this instance.
	 */
	ICFGenKbSecUserObj getUpdatedBy();

	/**
	 *	Get the Calendar date-time this instance was updated.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getUpdatedAt();
	/**
	 *	Realise this instance of a TSecGroup.
	 *
	 *	@return	CFGenKbTSecGroupObj instance which should be subsequently referenced.
	 */
	ICFGenKbTSecGroupObj realise();

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
	 *	@return	ICFGenKbTSecGroupObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbTSecGroupObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbTSecGroupObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbTSecGroupObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this TSecGroup instance.
	 *
	 *	@return	The newly locked ICFGenKbTSecGroupEditObj edition of this instance.
	 */
	ICFGenKbTSecGroupEditObj beginEdit();

	/**
	 *	End this edition of this TSecGroup instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this TSecGroup instance.
	 *
	 *	@return	The ICFGenKbTSecGroupEditObj edition of this instance.
	 */
	ICFGenKbTSecGroupEditObj getEdit();

	/**
	 *	Get the current edition of this TSecGroup instance as a ICFGenKbTSecGroupEditObj.
	 *
	 *	@return	The ICFGenKbTSecGroupEditObj edition of this instance.
	 */
	ICFGenKbTSecGroupEditObj getEditAsTSecGroup();

	/**
	 *	Get the ICFGenKbTSecGroupTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbTSecGroupTableObj table cache which manages this instance.
	 */
	ICFGenKbTSecGroupTableObj getTSecGroupTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbTSecGroupBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbTSecGroupBuff instance which currently backs this object.
	 */
	CFGenKbTSecGroupBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbTSecGroupBuff value );

	/**
	 *	Get the CFGenKbTSecGroupBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbTSecGroupBuff instance which currently backs this object.
	 */
	CFGenKbTSecGroupBuff getTSecGroupBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbTSecGroupPKey primary key for this instance.
	 */
	CFGenKbTSecGroupPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbTSecGroupPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbTSecGroupPKey value );

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
	 *	Get the required int attribute TSecGroupId.
	 *
	 *	@return	The required int attribute TSecGroupId.
	 */
	int getRequiredTSecGroupId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required boolean attribute IsVisible.
	 *
	 *	@return	The required boolean attribute IsVisible.
	 */
	boolean getRequiredIsVisible();

	/**
	 *	Get the required ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredContainerTenant();

	/**
	 *	Get the required ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredContainerTenant( boolean forceRead );

	/**
	 *	Get the array of optional ICFGenKbTSecGrpIncObj array of instances referenced by the Include key.
	 *
	 *	@return	The optional ICFGenKbTSecGrpIncObj[] array of instances referenced by the Include key.
	 */
	List<ICFGenKbTSecGrpIncObj> getOptionalComponentsInclude();

	/**
	 *	Get the array of optional ICFGenKbTSecGrpIncObj array of instances referenced by the Include key.
	 *
	 *	@return	The optional ICFGenKbTSecGrpIncObj[] array of instances referenced by the Include key.
	 */
	List<ICFGenKbTSecGrpIncObj> getOptionalComponentsInclude( boolean forceRead );

	/**
	 *	Get the array of optional ICFGenKbTSecGrpMembObj array of instances referenced by the Member key.
	 *
	 *	@return	The optional ICFGenKbTSecGrpMembObj[] array of instances referenced by the Member key.
	 */
	List<ICFGenKbTSecGrpMembObj> getOptionalComponentsMember();

	/**
	 *	Get the array of optional ICFGenKbTSecGrpMembObj array of instances referenced by the Member key.
	 *
	 *	@return	The optional ICFGenKbTSecGrpMembObj[] array of instances referenced by the Member key.
	 */
	List<ICFGenKbTSecGrpMembObj> getOptionalComponentsMember( boolean forceRead );

	/**
	 *	Get the array of required ICFGenKbTSecGrpIncObj array of instances referenced by the IncByGroup key.
	 *
	 *	@return	The required ICFGenKbTSecGrpIncObj[] array of instances referenced by the IncByGroup key.
	 */
	List<ICFGenKbTSecGrpIncObj> getRequiredChildrenIncByGroup();

	/**
	 *	Get the array of required ICFGenKbTSecGrpIncObj array of instances referenced by the IncByGroup key.
	 *
	 *	@return	The required ICFGenKbTSecGrpIncObj[] array of instances referenced by the IncByGroup key.
	 */
	List<ICFGenKbTSecGrpIncObj> getRequiredChildrenIncByGroup( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
