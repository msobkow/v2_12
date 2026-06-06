// Description: Java 11 Object interface for CFGenKb SecGrpMemb.

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

public interface ICFGenKbSecGrpMembObj
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
	 *	Realise this instance of a SecGrpMemb.
	 *
	 *	@return	CFGenKbSecGrpMembObj instance which should be subsequently referenced.
	 */
	ICFGenKbSecGrpMembObj realise();

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
	 *	@return	ICFGenKbSecGrpMembObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecGrpMembObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbSecGrpMembObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecGrpMembObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecGrpMemb instance.
	 *
	 *	@return	The newly locked ICFGenKbSecGrpMembEditObj edition of this instance.
	 */
	ICFGenKbSecGrpMembEditObj beginEdit();

	/**
	 *	End this edition of this SecGrpMemb instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecGrpMemb instance.
	 *
	 *	@return	The ICFGenKbSecGrpMembEditObj edition of this instance.
	 */
	ICFGenKbSecGrpMembEditObj getEdit();

	/**
	 *	Get the current edition of this SecGrpMemb instance as a ICFGenKbSecGrpMembEditObj.
	 *
	 *	@return	The ICFGenKbSecGrpMembEditObj edition of this instance.
	 */
	ICFGenKbSecGrpMembEditObj getEditAsSecGrpMemb();

	/**
	 *	Get the ICFGenKbSecGrpMembTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbSecGrpMembTableObj table cache which manages this instance.
	 */
	ICFGenKbSecGrpMembTableObj getSecGrpMembTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbSecGrpMembBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecGrpMembBuff instance which currently backs this object.
	 */
	CFGenKbSecGrpMembBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbSecGrpMembBuff value );

	/**
	 *	Get the CFGenKbSecGrpMembBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecGrpMembBuff instance which currently backs this object.
	 */
	CFGenKbSecGrpMembBuff getSecGrpMembBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbSecGrpMembPKey primary key for this instance.
	 */
	CFGenKbSecGrpMembPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbSecGrpMembPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbSecGrpMembPKey value );

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
	 *	Get the required long attribute ClusterId.
	 *
	 *	@return	The required long attribute ClusterId.
	 */
	long getRequiredClusterId();

	/**
	 *	Get the required long attribute SecGrpMembId.
	 *
	 *	@return	The required long attribute SecGrpMembId.
	 */
	long getRequiredSecGrpMembId();

	/**
	 *	Get the required int attribute SecGroupId.
	 *
	 *	@return	The required int attribute SecGroupId.
	 */
	int getRequiredSecGroupId();

	/**
	 *	Get the required UUID attribute SecUserId.
	 *
	 *	@return	The required UUID attribute SecUserId.
	 */
	UUID getRequiredSecUserId();

	/**
	 *	Get the required ICFGenKbClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFGenKbClusterObj instance referenced by the Cluster key.
	 */
	ICFGenKbClusterObj getRequiredOwnerCluster();

	/**
	 *	Get the required ICFGenKbClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFGenKbClusterObj instance referenced by the Cluster key.
	 */
	ICFGenKbClusterObj getRequiredOwnerCluster( boolean forceRead );

	/**
	 *	Get the required ICFGenKbSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The required ICFGenKbSecGroupObj instance referenced by the Group key.
	 */
	ICFGenKbSecGroupObj getRequiredContainerGroup();

	/**
	 *	Get the required ICFGenKbSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The required ICFGenKbSecGroupObj instance referenced by the Group key.
	 */
	ICFGenKbSecGroupObj getRequiredContainerGroup( boolean forceRead );

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
