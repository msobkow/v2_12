// Description: Java 11 Object interface for CFGenKb SysCluster.

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

public interface ICFGenKbSysClusterObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a SysCluster.
	 *
	 *	@return	CFGenKbSysClusterObj instance which should be subsequently referenced.
	 */
	ICFGenKbSysClusterObj realise();

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
	 *	@return	ICFGenKbSysClusterObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSysClusterObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbSysClusterObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSysClusterObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SysCluster instance.
	 *
	 *	@return	The newly locked ICFGenKbSysClusterEditObj edition of this instance.
	 */
	ICFGenKbSysClusterEditObj beginEdit();

	/**
	 *	End this edition of this SysCluster instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SysCluster instance.
	 *
	 *	@return	The ICFGenKbSysClusterEditObj edition of this instance.
	 */
	ICFGenKbSysClusterEditObj getEdit();

	/**
	 *	Get the current edition of this SysCluster instance as a ICFGenKbSysClusterEditObj.
	 *
	 *	@return	The ICFGenKbSysClusterEditObj edition of this instance.
	 */
	ICFGenKbSysClusterEditObj getEditAsSysCluster();

	/**
	 *	Get the ICFGenKbSysClusterTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbSysClusterTableObj table cache which manages this instance.
	 */
	ICFGenKbSysClusterTableObj getSysClusterTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbSysClusterBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSysClusterBuff instance which currently backs this object.
	 */
	CFGenKbSysClusterBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbSysClusterBuff value );

	/**
	 *	Get the CFGenKbSysClusterBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSysClusterBuff instance which currently backs this object.
	 */
	CFGenKbSysClusterBuff getSysClusterBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbSysClusterPKey primary key for this instance.
	 */
	CFGenKbSysClusterPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbSysClusterPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbSysClusterPKey value );

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
	 *	Get the required int attribute SingletonId.
	 *
	 *	@return	The required int attribute SingletonId.
	 */
	int getRequiredSingletonId();

	/**
	 *	Get the required long attribute ClusterId.
	 *
	 *	@return	The required long attribute ClusterId.
	 */
	long getRequiredClusterId();

	/**
	 *	Get the required ICFGenKbClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFGenKbClusterObj instance referenced by the Cluster key.
	 */
	ICFGenKbClusterObj getRequiredContainerCluster();

	/**
	 *	Get the required ICFGenKbClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFGenKbClusterObj instance referenced by the Cluster key.
	 */
	ICFGenKbClusterObj getRequiredContainerCluster( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
