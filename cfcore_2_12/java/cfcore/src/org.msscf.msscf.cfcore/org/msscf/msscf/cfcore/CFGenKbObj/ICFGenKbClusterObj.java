// Description: Java 11 Object interface for CFGenKb Cluster.

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

public interface ICFGenKbClusterObj
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
	 *	Realise this instance of a Cluster.
	 *
	 *	@return	CFGenKbClusterObj instance which should be subsequently referenced.
	 */
	ICFGenKbClusterObj realise();

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
	 *	@return	ICFGenKbClusterObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbClusterObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbClusterObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbClusterObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Cluster instance.
	 *
	 *	@return	The newly locked ICFGenKbClusterEditObj edition of this instance.
	 */
	ICFGenKbClusterEditObj beginEdit();

	/**
	 *	End this edition of this Cluster instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Cluster instance.
	 *
	 *	@return	The ICFGenKbClusterEditObj edition of this instance.
	 */
	ICFGenKbClusterEditObj getEdit();

	/**
	 *	Get the current edition of this Cluster instance as a ICFGenKbClusterEditObj.
	 *
	 *	@return	The ICFGenKbClusterEditObj edition of this instance.
	 */
	ICFGenKbClusterEditObj getEditAsCluster();

	/**
	 *	Get the ICFGenKbClusterTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbClusterTableObj table cache which manages this instance.
	 */
	ICFGenKbClusterTableObj getClusterTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbClusterBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbClusterBuff instance which currently backs this object.
	 */
	CFGenKbClusterBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbClusterBuff value );

	/**
	 *	Get the CFGenKbClusterBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbClusterBuff instance which currently backs this object.
	 */
	CFGenKbClusterBuff getClusterBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbClusterPKey primary key for this instance.
	 */
	CFGenKbClusterPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbClusterPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbClusterPKey value );

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
	 *	Get the required long attribute Id.
	 *
	 *	@return	The required long attribute Id.
	 */
	long getRequiredId();

	/**
	 *	Get the required String attribute FullDomName.
	 *
	 *	@return	The required String attribute FullDomName.
	 */
	String getRequiredFullDomName();

	/**
	 *	Get the required String attribute Description.
	 *
	 *	@return	The required String attribute Description.
	 */
	String getRequiredDescription();

	/**
	 *	Get the array of optional ICFGenKbHostNodeObj array of instances referenced by the HostNode key.
	 *
	 *	@return	The optional ICFGenKbHostNodeObj[] array of instances referenced by the HostNode key.
	 */
	List<ICFGenKbHostNodeObj> getOptionalComponentsHostNode();

	/**
	 *	Get the array of optional ICFGenKbHostNodeObj array of instances referenced by the HostNode key.
	 *
	 *	@return	The optional ICFGenKbHostNodeObj[] array of instances referenced by the HostNode key.
	 */
	List<ICFGenKbHostNodeObj> getOptionalComponentsHostNode( boolean forceRead );

	/**
	 *	Get the array of optional ICFGenKbTenantObj array of instances referenced by the Tenant key.
	 *
	 *	@return	The optional ICFGenKbTenantObj[] array of instances referenced by the Tenant key.
	 */
	List<ICFGenKbTenantObj> getOptionalComponentsTenant();

	/**
	 *	Get the array of optional ICFGenKbTenantObj array of instances referenced by the Tenant key.
	 *
	 *	@return	The optional ICFGenKbTenantObj[] array of instances referenced by the Tenant key.
	 */
	List<ICFGenKbTenantObj> getOptionalComponentsTenant( boolean forceRead );

	/**
	 *	Get the array of optional ICFGenKbSecAppObj array of instances referenced by the SecApp key.
	 *
	 *	@return	The optional ICFGenKbSecAppObj[] array of instances referenced by the SecApp key.
	 */
	List<ICFGenKbSecAppObj> getOptionalComponentsSecApp();

	/**
	 *	Get the array of optional ICFGenKbSecAppObj array of instances referenced by the SecApp key.
	 *
	 *	@return	The optional ICFGenKbSecAppObj[] array of instances referenced by the SecApp key.
	 */
	List<ICFGenKbSecAppObj> getOptionalComponentsSecApp( boolean forceRead );

	/**
	 *	Get the array of optional ICFGenKbSecGroupObj array of instances referenced by the SecGroup key.
	 *
	 *	@return	The optional ICFGenKbSecGroupObj[] array of instances referenced by the SecGroup key.
	 */
	List<ICFGenKbSecGroupObj> getOptionalComponentsSecGroup();

	/**
	 *	Get the array of optional ICFGenKbSecGroupObj array of instances referenced by the SecGroup key.
	 *
	 *	@return	The optional ICFGenKbSecGroupObj[] array of instances referenced by the SecGroup key.
	 */
	List<ICFGenKbSecGroupObj> getOptionalComponentsSecGroup( boolean forceRead );

	/**
	 *	Get the array of optional ICFGenKbSysClusterObj array of instances referenced by the SysCluster key.
	 *
	 *	@return	The optional ICFGenKbSysClusterObj[] array of instances referenced by the SysCluster key.
	 */
	List<ICFGenKbSysClusterObj> getOptionalComponentsSysCluster();

	/**
	 *	Get the array of optional ICFGenKbSysClusterObj array of instances referenced by the SysCluster key.
	 *
	 *	@return	The optional ICFGenKbSysClusterObj[] array of instances referenced by the SysCluster key.
	 */
	List<ICFGenKbSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
