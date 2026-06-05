// Description: Java 11 Instance Edit Object interface for CFInt SecGroupForm.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntSecGroupFormEditObj
	extends ICFIntSecGroupFormObj,
		ICFSecSecGroupFormEditObj
{
	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecSecGroupFormObj create();

	/*
	 *	Update the instance.
	 */
	CFSecSecGroupFormEditObj update();

	/**
	 *	Get the ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ICFSecClusterObj instance referenced by the Cluster key.
	 */
	ICFSecClusterObj getRequiredOwnerCluster();

	/**
	 *	Set the ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ICFSecClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredOwnerCluster( ICFSecClusterObj value );

	/**
	 *	Get the ICFSecSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The ICFSecSecGroupObj instance referenced by the Group key.
	 */
	ICFSecSecGroupObj getRequiredContainerGroup();

	/**
	 *	Set the ICFSecSecGroupObj instance referenced by the Group key.
	 *
	 *	@param	value	the ICFSecSecGroupObj instance to be referenced by the Group key.
	 */
	void setRequiredContainerGroup( ICFSecSecGroupObj value );

	/**
	 *	Get the ICFSecSecAppObj instance referenced by the App key.
	 *
	 *	@return	The ICFSecSecAppObj instance referenced by the App key.
	 */
	ICFSecSecAppObj getRequiredParentApp();

	/**
	 *	Set the ICFSecSecAppObj instance referenced by the App key.
	 *
	 *	@param	value	the ICFSecSecAppObj instance to be referenced by the App key.
	 */
	void setRequiredParentApp( ICFSecSecAppObj value );

	/**
	 *	Get the ICFSecSecFormObj instance referenced by the Form key.
	 *
	 *	@return	The ICFSecSecFormObj instance referenced by the Form key.
	 */
	ICFSecSecFormObj getRequiredParentForm();

	/**
	 *	Set the ICFSecSecFormObj instance referenced by the Form key.
	 *
	 *	@param	value	the ICFSecSecFormObj instance to be referenced by the Form key.
	 */
	void setRequiredParentForm( ICFSecSecFormObj value );
}
