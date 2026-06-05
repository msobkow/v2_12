// Description: Java 11 Object interface for CFGenKb SecGrpInc.

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

public interface ICFGenKbSecGrpIncObj
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
	 *	Realise this instance of a SecGrpInc.
	 *
	 *	@return	CFGenKbSecGrpIncObj instance which should be subsequently referenced.
	 */
	ICFGenKbSecGrpIncObj realise();

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
	 *	@return	ICFGenKbSecGrpIncObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecGrpIncObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbSecGrpIncObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecGrpIncObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecGrpInc instance.
	 *
	 *	@return	The newly locked ICFGenKbSecGrpIncEditObj edition of this instance.
	 */
	ICFGenKbSecGrpIncEditObj beginEdit();

	/**
	 *	End this edition of this SecGrpInc instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecGrpInc instance.
	 *
	 *	@return	The ICFGenKbSecGrpIncEditObj edition of this instance.
	 */
	ICFGenKbSecGrpIncEditObj getEdit();

	/**
	 *	Get the current edition of this SecGrpInc instance as a ICFGenKbSecGrpIncEditObj.
	 *
	 *	@return	The ICFGenKbSecGrpIncEditObj edition of this instance.
	 */
	ICFGenKbSecGrpIncEditObj getEditAsSecGrpInc();

	/**
	 *	Get the ICFGenKbSecGrpIncTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbSecGrpIncTableObj table cache which manages this instance.
	 */
	ICFGenKbSecGrpIncTableObj getSecGrpIncTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbSecGrpIncBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecGrpIncBuff instance which currently backs this object.
	 */
	CFGenKbSecGrpIncBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbSecGrpIncBuff value );

	/**
	 *	Get the CFGenKbSecGrpIncBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecGrpIncBuff instance which currently backs this object.
	 */
	CFGenKbSecGrpIncBuff getSecGrpIncBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbSecGrpIncPKey primary key for this instance.
	 */
	CFGenKbSecGrpIncPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbSecGrpIncPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbSecGrpIncPKey value );

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
	 *	Get the required long attribute SecGrpIncId.
	 *
	 *	@return	The required long attribute SecGrpIncId.
	 */
	long getRequiredSecGrpIncId();

	/**
	 *	Get the required int attribute SecGroupId.
	 *
	 *	@return	The required int attribute SecGroupId.
	 */
	int getRequiredSecGroupId();

	/**
	 *	Get the required int attribute IncludeGroupId.
	 *
	 *	@return	The required int attribute IncludeGroupId.
	 */
	int getRequiredIncludeGroupId();

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
	 *	Get the required ICFGenKbSecGroupObj instance referenced by the SubGroup key.
	 *
	 *	@return	The required ICFGenKbSecGroupObj instance referenced by the SubGroup key.
	 */
	ICFGenKbSecGroupObj getRequiredParentSubGroup();

	/**
	 *	Get the required ICFGenKbSecGroupObj instance referenced by the SubGroup key.
	 *
	 *	@return	The required ICFGenKbSecGroupObj instance referenced by the SubGroup key.
	 */
	ICFGenKbSecGroupObj getRequiredParentSubGroup( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
