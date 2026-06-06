// Description: Java 11 Instance Edit Object interface for CFGenKb SecGroupForm.

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

public interface ICFGenKbSecGroupFormEditObj
	extends ICFGenKbSecGroupFormObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbSecGroupFormObj.
	 */
	ICFGenKbSecGroupFormObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbSecGroupFormObj.
	 */
	ICFGenKbSecGroupFormObj getOrigAsSecGroupForm();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbSecGroupFormObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbSecGroupFormEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbSecGroupFormEditObj deleteInstance();

	/**
	 *	Get the ICFGenKbClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ICFGenKbClusterObj instance referenced by the Cluster key.
	 */
	ICFGenKbClusterObj getRequiredOwnerCluster();

	/**
	 *	Set the ICFGenKbClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ICFGenKbClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredOwnerCluster( ICFGenKbClusterObj value );

	/**
	 *	Get the ICFGenKbSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The ICFGenKbSecGroupObj instance referenced by the Group key.
	 */
	ICFGenKbSecGroupObj getRequiredContainerGroup();

	/**
	 *	Set the ICFGenKbSecGroupObj instance referenced by the Group key.
	 *
	 *	@param	value	the ICFGenKbSecGroupObj instance to be referenced by the Group key.
	 */
	void setRequiredContainerGroup( ICFGenKbSecGroupObj value );

	/**
	 *	Get the ICFGenKbSecAppObj instance referenced by the App key.
	 *
	 *	@return	The ICFGenKbSecAppObj instance referenced by the App key.
	 */
	ICFGenKbSecAppObj getRequiredParentApp();

	/**
	 *	Set the ICFGenKbSecAppObj instance referenced by the App key.
	 *
	 *	@param	value	the ICFGenKbSecAppObj instance to be referenced by the App key.
	 */
	void setRequiredParentApp( ICFGenKbSecAppObj value );

	/**
	 *	Get the ICFGenKbSecFormObj instance referenced by the Form key.
	 *
	 *	@return	The ICFGenKbSecFormObj instance referenced by the Form key.
	 */
	ICFGenKbSecFormObj getRequiredParentForm();

	/**
	 *	Set the ICFGenKbSecFormObj instance referenced by the Form key.
	 *
	 *	@param	value	the ICFGenKbSecFormObj instance to be referenced by the Form key.
	 */
	void setRequiredParentForm( ICFGenKbSecFormObj value );

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
