// Description: Java 11 Object interface for CFGenKb TSecGrpMemb.

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
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbTSecGrpMembObj
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
	 *	Realise this instance of a TSecGrpMemb.
	 *
	 *	@return	CFGenKbTSecGrpMembObj instance which should be subsequently referenced.
	 */
	ICFGenKbTSecGrpMembObj realise();

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
	 *	@return	ICFGenKbTSecGrpMembObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbTSecGrpMembObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbTSecGrpMembObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbTSecGrpMembObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this TSecGrpMemb instance.
	 *
	 *	@return	The newly locked ICFGenKbTSecGrpMembEditObj edition of this instance.
	 */
	ICFGenKbTSecGrpMembEditObj beginEdit();

	/**
	 *	End this edition of this TSecGrpMemb instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this TSecGrpMemb instance.
	 *
	 *	@return	The ICFGenKbTSecGrpMembEditObj edition of this instance.
	 */
	ICFGenKbTSecGrpMembEditObj getEdit();

	/**
	 *	Get the current edition of this TSecGrpMemb instance as a ICFGenKbTSecGrpMembEditObj.
	 *
	 *	@return	The ICFGenKbTSecGrpMembEditObj edition of this instance.
	 */
	ICFGenKbTSecGrpMembEditObj getEditAsTSecGrpMemb();

	/**
	 *	Get the ICFGenKbTSecGrpMembTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbTSecGrpMembTableObj table cache which manages this instance.
	 */
	ICFGenKbTSecGrpMembTableObj getTSecGrpMembTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbTSecGrpMembBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbTSecGrpMembBuff instance which currently backs this object.
	 */
	CFGenKbTSecGrpMembBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbTSecGrpMembBuff value );

	/**
	 *	Get the CFGenKbTSecGrpMembBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbTSecGrpMembBuff instance which currently backs this object.
	 */
	CFGenKbTSecGrpMembBuff getTSecGrpMembBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbTSecGrpMembPKey primary key for this instance.
	 */
	CFGenKbTSecGrpMembPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbTSecGrpMembPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbTSecGrpMembPKey value );

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
	 *	Get the required long attribute TSecGrpMembId.
	 *
	 *	@return	The required long attribute TSecGrpMembId.
	 */
	long getRequiredTSecGrpMembId();

	/**
	 *	Get the required int attribute TSecGroupId.
	 *
	 *	@return	The required int attribute TSecGroupId.
	 */
	int getRequiredTSecGroupId();

	/**
	 *	Get the required UUID attribute SecUserId.
	 *
	 *	@return	The required UUID attribute SecUserId.
	 */
	UUID getRequiredSecUserId();

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
	 *	Get the required ICFGenKbSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the User key.
	 */
	ICFGenKbSecUserObj getRequiredParentUser();

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the User key.
	 */
	ICFGenKbSecUserObj getRequiredParentUser( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
