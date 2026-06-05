// Description: Java 11 Object interface for CFGenKb SecApp.

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

public interface ICFGenKbSecAppObj
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
	 *	Realise this instance of a SecApp.
	 *
	 *	@return	CFGenKbSecAppObj instance which should be subsequently referenced.
	 */
	ICFGenKbSecAppObj realise();

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
	 *	@return	ICFGenKbSecAppObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecAppObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbSecAppObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecAppObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecApp instance.
	 *
	 *	@return	The newly locked ICFGenKbSecAppEditObj edition of this instance.
	 */
	ICFGenKbSecAppEditObj beginEdit();

	/**
	 *	End this edition of this SecApp instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecApp instance.
	 *
	 *	@return	The ICFGenKbSecAppEditObj edition of this instance.
	 */
	ICFGenKbSecAppEditObj getEdit();

	/**
	 *	Get the current edition of this SecApp instance as a ICFGenKbSecAppEditObj.
	 *
	 *	@return	The ICFGenKbSecAppEditObj edition of this instance.
	 */
	ICFGenKbSecAppEditObj getEditAsSecApp();

	/**
	 *	Get the ICFGenKbSecAppTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbSecAppTableObj table cache which manages this instance.
	 */
	ICFGenKbSecAppTableObj getSecAppTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbSecAppBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecAppBuff instance which currently backs this object.
	 */
	CFGenKbSecAppBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbSecAppBuff value );

	/**
	 *	Get the CFGenKbSecAppBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecAppBuff instance which currently backs this object.
	 */
	CFGenKbSecAppBuff getSecAppBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbSecAppPKey primary key for this instance.
	 */
	CFGenKbSecAppPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbSecAppPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbSecAppPKey value );

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
	 *	Get the required int attribute SecAppId.
	 *
	 *	@return	The required int attribute SecAppId.
	 */
	int getRequiredSecAppId();

	/**
	 *	Get the required String attribute JEEMountName.
	 *
	 *	@return	The required String attribute JEEMountName.
	 */
	String getRequiredJEEMountName();

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
	 *	Get the array of optional ICFGenKbSecFormObj array of instances referenced by the Form key.
	 *
	 *	@return	The optional ICFGenKbSecFormObj[] array of instances referenced by the Form key.
	 */
	List<ICFGenKbSecFormObj> getOptionalComponentsForm();

	/**
	 *	Get the array of optional ICFGenKbSecFormObj array of instances referenced by the Form key.
	 *
	 *	@return	The optional ICFGenKbSecFormObj[] array of instances referenced by the Form key.
	 */
	List<ICFGenKbSecFormObj> getOptionalComponentsForm( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
