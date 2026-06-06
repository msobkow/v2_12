// Description: Java 11 Object interface for CFBam SecGroup.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamSecGroupObj
	extends ICFSecSecGroupObj,
		ICFIntSecGroupObj
{
	String getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ICFSecSecUserObj instance who created this instance.
	 */
	ICFSecSecUserObj getCreatedBy();

	/**
	 *	Get the Calendar date-time this instance was created.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ICFSecSecUserObj instance who updated this instance.
	 */
	ICFSecSecUserObj getUpdatedBy();

	/**
	 *	Get the Calendar date-time this instance was updated.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getUpdatedAt();
	/**
	 *	Realise this instance of a SecGroup.
	 *
	 *	@return	CFSecSecGroupObj instance which should be subsequently referenced.
	 */
	ICFSecSecGroupObj realise();

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
	 *	@return	ICFSecSecGroupObj the reference to the cached or read (realised) instance.
	 */
	ICFSecSecGroupObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFSecSecGroupObj the reference to the cached or read (realised) instance.
	 */
	ICFSecSecGroupObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecGroup instance.
	 *
	 *	@return	The newly locked ICFSecSecGroupEditObj edition of this instance.
	 */
	ICFSecSecGroupEditObj beginEdit();

	/**
	 *	End this edition of this SecGroup instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecGroup instance.
	 *
	 *	@return	The ICFSecSecGroupEditObj edition of this instance.
	 */
	ICFSecSecGroupEditObj getEdit();

	/**
	 *	Get the current edition of this SecGroup instance as a ICFSecSecGroupEditObj.
	 *
	 *	@return	The ICFSecSecGroupEditObj edition of this instance.
	 */
	ICFSecSecGroupEditObj getEditAsSecGroup();

	/**
	 *	Get the ICFSecSecGroupTableObj table cache which manages this instance.
	 *
	 *	@return	ICFSecSecGroupTableObj table cache which manages this instance.
	 */
	ICFSecSecGroupTableObj getSecGroupTable();

	/**
	 *	Get the ICFSecSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFSecSchemaObj schema cache which manages this instance.
	 */
	ICFSecSchemaObj getSchema();

	/**
	 *	Get the CFSecSecGroupBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecSecGroupBuff instance which currently backs this object.
	 */
	CFSecSecGroupBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFSecSecGroupBuff value );

	/**
	 *	Get the CFSecSecGroupBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecSecGroupBuff instance which currently backs this object.
	 */
	CFSecSecGroupBuff getSecGroupBuff();

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
	 *	Get the required int attribute SecGroupId.
	 *
	 *	@return	The required int attribute SecGroupId.
	 */
	int getRequiredSecGroupId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required boolean attribute IsVisible.
	 *
	 *	@return	The required boolean attribute IsVisible.
	 */
	boolean getRequiredIsVisible();

	/**
	 *	Get the required ICFBamClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFBamClusterObj instance referenced by the Cluster key.
	 */
	ICFSecClusterObj getRequiredContainerCluster();

	/**
	 *	Get the required ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFSecClusterObj instance referenced by the Cluster key.
	 */
	ICFSecClusterObj getRequiredContainerCluster( boolean forceRead );

	/**
	 *	Get the array of optional ICFSecSecGrpIncObj array of instances referenced by the Include key.
	 *
	 *	@return	The optional ICFSecSecGrpIncObj[] array of instances referenced by the Include key.
	 */
	List<ICFSecSecGrpIncObj> getOptionalComponentsInclude();

	/**
	 *	Get the array of optional ICFSecSecGrpIncObj array of instances referenced by the Include key.
	 *
	 *	@return	The optional ICFSecSecGrpIncObj[] array of instances referenced by the Include key.
	 */
	List<ICFSecSecGrpIncObj> getOptionalComponentsInclude( boolean forceRead );

	/**
	 *	Get the array of optional ICFSecSecGrpMembObj array of instances referenced by the Member key.
	 *
	 *	@return	The optional ICFSecSecGrpMembObj[] array of instances referenced by the Member key.
	 */
	List<ICFSecSecGrpMembObj> getOptionalComponentsMember();

	/**
	 *	Get the array of optional ICFSecSecGrpMembObj array of instances referenced by the Member key.
	 *
	 *	@return	The optional ICFSecSecGrpMembObj[] array of instances referenced by the Member key.
	 */
	List<ICFSecSecGrpMembObj> getOptionalComponentsMember( boolean forceRead );

	/**
	 *	Get the array of required ICFSecSecGrpIncObj array of instances referenced by the IncByGroup key.
	 *
	 *	@return	The required ICFSecSecGrpIncObj[] array of instances referenced by the IncByGroup key.
	 */
	List<ICFSecSecGrpIncObj> getRequiredChildrenIncByGroup();

	/**
	 *	Get the array of required ICFSecSecGrpIncObj array of instances referenced by the IncByGroup key.
	 *
	 *	@return	The required ICFSecSecGrpIncObj[] array of instances referenced by the IncByGroup key.
	 */
	List<ICFSecSecGrpIncObj> getRequiredChildrenIncByGroup( boolean forceRead );

	/**
	 *	Get the array of optional ICFSecSecGroupFormObj array of instances referenced by the Form key.
	 *
	 *	@return	The optional ICFSecSecGroupFormObj[] array of instances referenced by the Form key.
	 */
	List<ICFSecSecGroupFormObj> getOptionalComponentsForm();

	/**
	 *	Get the array of optional ICFSecSecGroupFormObj array of instances referenced by the Form key.
	 *
	 *	@return	The optional ICFSecSecGroupFormObj[] array of instances referenced by the Form key.
	 */
	List<ICFSecSecGroupFormObj> getOptionalComponentsForm( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
