// Description: Java 11 Object interface for CFGenKb SecDevice.

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

public interface ICFGenKbSecDeviceObj
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
	 *	Realise this instance of a SecDevice.
	 *
	 *	@return	CFGenKbSecDeviceObj instance which should be subsequently referenced.
	 */
	ICFGenKbSecDeviceObj realise();

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
	 *	@return	ICFGenKbSecDeviceObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecDeviceObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbSecDeviceObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecDeviceObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecDevice instance.
	 *
	 *	@return	The newly locked ICFGenKbSecDeviceEditObj edition of this instance.
	 */
	ICFGenKbSecDeviceEditObj beginEdit();

	/**
	 *	End this edition of this SecDevice instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecDevice instance.
	 *
	 *	@return	The ICFGenKbSecDeviceEditObj edition of this instance.
	 */
	ICFGenKbSecDeviceEditObj getEdit();

	/**
	 *	Get the current edition of this SecDevice instance as a ICFGenKbSecDeviceEditObj.
	 *
	 *	@return	The ICFGenKbSecDeviceEditObj edition of this instance.
	 */
	ICFGenKbSecDeviceEditObj getEditAsSecDevice();

	/**
	 *	Get the ICFGenKbSecDeviceTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbSecDeviceTableObj table cache which manages this instance.
	 */
	ICFGenKbSecDeviceTableObj getSecDeviceTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbSecDeviceBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecDeviceBuff instance which currently backs this object.
	 */
	CFGenKbSecDeviceBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbSecDeviceBuff value );

	/**
	 *	Get the CFGenKbSecDeviceBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecDeviceBuff instance which currently backs this object.
	 */
	CFGenKbSecDeviceBuff getSecDeviceBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbSecDevicePKey primary key for this instance.
	 */
	CFGenKbSecDevicePKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbSecDevicePKey primary key value for this instance.
	 */
	void setPKey( CFGenKbSecDevicePKey value );

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
	 *	Get the required UUID attribute SecUserId.
	 *
	 *	@return	The required UUID attribute SecUserId.
	 */
	UUID getRequiredSecUserId();

	/**
	 *	Get the required String attribute DevName.
	 *
	 *	@return	The required String attribute DevName.
	 */
	String getRequiredDevName();

	/**
	 *	Get the optional String attribute PubKey.
	 *
	 *	@return	The optional String attribute PubKey.
	 */
	String getOptionalPubKey();

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 */
	ICFGenKbSecUserObj getRequiredContainerSecUser();

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 */
	ICFGenKbSecUserObj getRequiredContainerSecUser( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
