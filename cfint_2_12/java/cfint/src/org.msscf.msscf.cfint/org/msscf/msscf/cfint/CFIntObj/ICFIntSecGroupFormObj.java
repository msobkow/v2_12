// Description: Java 11 Object interface for CFInt SecGroupForm.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntSecGroupFormObj
	extends ICFSecSecGroupFormObj
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
	 *	Realise this instance of a SecGroupForm.
	 *
	 *	@return	CFSecSecGroupFormObj instance which should be subsequently referenced.
	 */
	ICFSecSecGroupFormObj realise();

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
	 *	@return	ICFSecSecGroupFormObj the reference to the cached or read (realised) instance.
	 */
	ICFSecSecGroupFormObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFSecSecGroupFormObj the reference to the cached or read (realised) instance.
	 */
	ICFSecSecGroupFormObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecGroupForm instance.
	 *
	 *	@return	The newly locked ICFSecSecGroupFormEditObj edition of this instance.
	 */
	ICFSecSecGroupFormEditObj beginEdit();

	/**
	 *	End this edition of this SecGroupForm instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecGroupForm instance.
	 *
	 *	@return	The ICFSecSecGroupFormEditObj edition of this instance.
	 */
	ICFSecSecGroupFormEditObj getEdit();

	/**
	 *	Get the current edition of this SecGroupForm instance as a ICFSecSecGroupFormEditObj.
	 *
	 *	@return	The ICFSecSecGroupFormEditObj edition of this instance.
	 */
	ICFSecSecGroupFormEditObj getEditAsSecGroupForm();

	/**
	 *	Get the ICFSecSecGroupFormTableObj table cache which manages this instance.
	 *
	 *	@return	ICFSecSecGroupFormTableObj table cache which manages this instance.
	 */
	ICFSecSecGroupFormTableObj getSecGroupFormTable();

	/**
	 *	Get the ICFSecSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFSecSchemaObj schema cache which manages this instance.
	 */
	ICFSecSchemaObj getSchema();

	/**
	 *	Get the CFSecSecGroupFormBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecSecGroupFormBuff instance which currently backs this object.
	 */
	CFSecSecGroupFormBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFSecSecGroupFormBuff value );

	/**
	 *	Get the CFSecSecGroupFormBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecSecGroupFormBuff instance which currently backs this object.
	 */
	CFSecSecGroupFormBuff getSecGroupFormBuff();

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
	 *	Get the required long attribute SecGroupFormId.
	 *
	 *	@return	The required long attribute SecGroupFormId.
	 */
	long getRequiredSecGroupFormId();

	/**
	 *	Get the required int attribute SecGroupId.
	 *
	 *	@return	The required int attribute SecGroupId.
	 */
	int getRequiredSecGroupId();

	/**
	 *	Get the required int attribute SecAppId.
	 *
	 *	@return	The required int attribute SecAppId.
	 */
	int getRequiredSecAppId();

	/**
	 *	Get the required int attribute SecFormId.
	 *
	 *	@return	The required int attribute SecFormId.
	 */
	int getRequiredSecFormId();

	/**
	 *	Get the required ICFIntClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFIntClusterObj instance referenced by the Cluster key.
	 */
	ICFSecClusterObj getRequiredOwnerCluster();

	/**
	 *	Get the required ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The required ICFSecClusterObj instance referenced by the Cluster key.
	 */
	ICFSecClusterObj getRequiredOwnerCluster( boolean forceRead );

	/**
	 *	Get the required ICFIntSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The required ICFIntSecGroupObj instance referenced by the Group key.
	 */
	ICFSecSecGroupObj getRequiredContainerGroup();

	/**
	 *	Get the required ICFSecSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The required ICFSecSecGroupObj instance referenced by the Group key.
	 */
	ICFSecSecGroupObj getRequiredContainerGroup( boolean forceRead );

	/**
	 *	Get the required ICFIntSecAppObj instance referenced by the App key.
	 *
	 *	@return	The required ICFIntSecAppObj instance referenced by the App key.
	 */
	ICFSecSecAppObj getRequiredParentApp();

	/**
	 *	Get the required ICFSecSecAppObj instance referenced by the App key.
	 *
	 *	@return	The required ICFSecSecAppObj instance referenced by the App key.
	 */
	ICFSecSecAppObj getRequiredParentApp( boolean forceRead );

	/**
	 *	Get the required ICFIntSecFormObj instance referenced by the Form key.
	 *
	 *	@return	The required ICFIntSecFormObj instance referenced by the Form key.
	 */
	ICFSecSecFormObj getRequiredParentForm();

	/**
	 *	Get the required ICFSecSecFormObj instance referenced by the Form key.
	 *
	 *	@return	The required ICFSecSecFormObj instance referenced by the Form key.
	 */
	ICFSecSecFormObj getRequiredParentForm( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
