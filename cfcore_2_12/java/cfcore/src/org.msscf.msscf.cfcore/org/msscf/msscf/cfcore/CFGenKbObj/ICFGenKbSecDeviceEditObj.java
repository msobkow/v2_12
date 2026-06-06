// Description: Java 11 Instance Edit Object interface for CFGenKb SecDevice.

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

public interface ICFGenKbSecDeviceEditObj
	extends ICFGenKbSecDeviceObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbSecDeviceObj.
	 */
	ICFGenKbSecDeviceObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbSecDeviceObj.
	 */
	ICFGenKbSecDeviceObj getOrigAsSecDevice();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbSecDeviceObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbSecDeviceEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbSecDeviceEditObj deleteInstance();

	/**
	 *	Get the required String attribute DevName.
	 *
	 *	@return	The String value of the attribute DevName.
	 */
	String getRequiredDevName();

	/**
	 *	Set the required String attribute DevName.
	 *
	 *	@param	value	the String value of the attribute DevName.
	 */
	void setRequiredDevName( String value );

	/**
	 *	Get the optional String attribute PubKey.
	 *
	 *	@return	The String value of the attribute PubKey.
	 */
	String getOptionalPubKey();

	/**
	 *	Set the optional String attribute PubKey.
	 *
	 *	@param	value	the String value of the attribute PubKey.
	 */
	void setOptionalPubKey( String value );

	/**
	 *	Get the ICFGenKbSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The ICFGenKbSecUserObj instance referenced by the SecUser key.
	 */
	ICFGenKbSecUserObj getRequiredContainerSecUser();

	/**
	 *	Set the ICFGenKbSecUserObj instance referenced by the SecUser key.
	 *
	 *	@param	value	the ICFGenKbSecUserObj instance to be referenced by the SecUser key.
	 */
	void setRequiredContainerSecUser( ICFGenKbSecUserObj value );

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ICFGenKbSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ICFGenKbSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( Calendar value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ICFGenKbSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ICFGenKbSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( Calendar value );}
