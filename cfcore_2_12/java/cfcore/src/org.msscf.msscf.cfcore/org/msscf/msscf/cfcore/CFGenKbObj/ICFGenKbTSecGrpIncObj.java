// Description: Java 11 Object interface for CFGenKb TSecGrpInc.

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
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbTSecGrpIncObj
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
	 *	Realise this instance of a TSecGrpInc.
	 *
	 *	@return	CFGenKbTSecGrpIncObj instance which should be subsequently referenced.
	 */
	ICFGenKbTSecGrpIncObj realise();

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
	 *	@return	ICFGenKbTSecGrpIncObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbTSecGrpIncObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbTSecGrpIncObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbTSecGrpIncObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this TSecGrpInc instance.
	 *
	 *	@return	The newly locked ICFGenKbTSecGrpIncEditObj edition of this instance.
	 */
	ICFGenKbTSecGrpIncEditObj beginEdit();

	/**
	 *	End this edition of this TSecGrpInc instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this TSecGrpInc instance.
	 *
	 *	@return	The ICFGenKbTSecGrpIncEditObj edition of this instance.
	 */
	ICFGenKbTSecGrpIncEditObj getEdit();

	/**
	 *	Get the current edition of this TSecGrpInc instance as a ICFGenKbTSecGrpIncEditObj.
	 *
	 *	@return	The ICFGenKbTSecGrpIncEditObj edition of this instance.
	 */
	ICFGenKbTSecGrpIncEditObj getEditAsTSecGrpInc();

	/**
	 *	Get the ICFGenKbTSecGrpIncTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbTSecGrpIncTableObj table cache which manages this instance.
	 */
	ICFGenKbTSecGrpIncTableObj getTSecGrpIncTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbTSecGrpIncBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbTSecGrpIncBuff instance which currently backs this object.
	 */
	CFGenKbTSecGrpIncBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbTSecGrpIncBuff value );

	/**
	 *	Get the CFGenKbTSecGrpIncBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbTSecGrpIncBuff instance which currently backs this object.
	 */
	CFGenKbTSecGrpIncBuff getTSecGrpIncBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbTSecGrpIncPKey primary key for this instance.
	 */
	CFGenKbTSecGrpIncPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbTSecGrpIncPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbTSecGrpIncPKey value );

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
	 *	Get the required long attribute TSecGrpIncId.
	 *
	 *	@return	The required long attribute TSecGrpIncId.
	 */
	long getRequiredTSecGrpIncId();

	/**
	 *	Get the required int attribute TSecGroupId.
	 *
	 *	@return	The required int attribute TSecGroupId.
	 */
	int getRequiredTSecGroupId();

	/**
	 *	Get the required int attribute IncludeGroupId.
	 *
	 *	@return	The required int attribute IncludeGroupId.
	 */
	int getRequiredIncludeGroupId();

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
	 *	Get the required ICFGenKbTSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The required ICFGenKbTSecGroupObj instance referenced by the Group key.
	 */
	ICFGenKbTSecGroupObj getRequiredContainerGroup();

	/**
	 *	Get the required ICFGenKbTSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The required ICFGenKbTSecGroupObj instance referenced by the Group key.
	 */
	ICFGenKbTSecGroupObj getRequiredContainerGroup( boolean forceRead );

	/**
	 *	Get the required ICFGenKbTSecGroupObj instance referenced by the SubGroup key.
	 *
	 *	@return	The required ICFGenKbTSecGroupObj instance referenced by the SubGroup key.
	 */
	ICFGenKbTSecGroupObj getRequiredParentSubGroup();

	/**
	 *	Get the required ICFGenKbTSecGroupObj instance referenced by the SubGroup key.
	 *
	 *	@return	The required ICFGenKbTSecGroupObj instance referenced by the SubGroup key.
	 */
	ICFGenKbTSecGroupObj getRequiredParentSubGroup( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
