// Description: Java 11 Instance Edit Object interface for CFGenKb GelSwitchLimb.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbGelSwitchLimbEditObj
	extends ICFGenKbGelSwitchLimbObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbGelSwitchLimbObj.
	 */
	ICFGenKbGelSwitchLimbObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbGelSwitchLimbObj.
	 */
	ICFGenKbGelSwitchLimbObj getOrigAsGelSwitchLimb();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbGelSwitchLimbObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbGelSwitchLimbEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbGelSwitchLimbEditObj deleteInstance();

	/**
	 *	Get the required String attribute LimbName.
	 *
	 *	@return	The String value of the attribute LimbName.
	 */
	String getRequiredLimbName();

	/**
	 *	Set the required String attribute LimbName.
	 *
	 *	@param	value	the String value of the attribute LimbName.
	 */
	void setRequiredLimbName( String value );

	/**
	 *	Get the required String attribute LimbExpansion.
	 *
	 *	@return	The String value of the attribute LimbExpansion.
	 */
	String getRequiredLimbExpansion();

	/**
	 *	Set the required String attribute LimbExpansion.
	 *
	 *	@param	value	the String value of the attribute LimbExpansion.
	 */
	void setRequiredLimbExpansion( String value );

	/**
	 *	Get the ICFGenKbGelSwitchObj instance referenced by the Switch key.
	 *
	 *	@return	The ICFGenKbGelSwitchObj instance referenced by the Switch key.
	 */
	ICFGenKbGelSwitchObj getRequiredParentSwitch();

	/**
	 *	Set the ICFGenKbGelSwitchObj instance referenced by the Switch key.
	 *
	 *	@param	value	the ICFGenKbGelSwitchObj instance to be referenced by the Switch key.
	 */
	void setRequiredParentSwitch( ICFGenKbGelSwitchObj value );

	/**
	 *	Get the ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredOwnerTenant();

	/**
	 *	Set the ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFGenKbTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFGenKbTenantObj value );
}
