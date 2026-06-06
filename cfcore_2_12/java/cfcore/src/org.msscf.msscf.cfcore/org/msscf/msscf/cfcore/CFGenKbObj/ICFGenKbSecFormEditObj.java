// Description: Java 11 Instance Edit Object interface for CFGenKb SecForm.

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

public interface ICFGenKbSecFormEditObj
	extends ICFGenKbSecFormObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbSecFormObj.
	 */
	ICFGenKbSecFormObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbSecFormObj.
	 */
	ICFGenKbSecFormObj getOrigAsSecForm();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbSecFormObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbSecFormEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbSecFormEditObj deleteInstance();

	/**
	 *	Get the required String attribute JEEServletMapName.
	 *
	 *	@return	The String value of the attribute JEEServletMapName.
	 */
	String getRequiredJEEServletMapName();

	/**
	 *	Set the required String attribute JEEServletMapName.
	 *
	 *	@param	value	the String value of the attribute JEEServletMapName.
	 */
	void setRequiredJEEServletMapName( String value );

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
	 *	Get the ICFGenKbSecAppObj instance referenced by the Application key.
	 *
	 *	@return	The ICFGenKbSecAppObj instance referenced by the Application key.
	 */
	ICFGenKbSecAppObj getRequiredContainerApplication();

	/**
	 *	Set the ICFGenKbSecAppObj instance referenced by the Application key.
	 *
	 *	@param	value	the ICFGenKbSecAppObj instance to be referenced by the Application key.
	 */
	void setRequiredContainerApplication( ICFGenKbSecAppObj value );

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
