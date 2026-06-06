// Description: Java 11 Instance Edit Object interface for CFBam Service.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamServiceEditObj
	extends ICFBamServiceObj,
		ICFSecServiceEditObj,
		ICFIntServiceEditObj
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
	ICFSecServiceObj create();

	/*
	 *	Update the instance.
	 */
	CFSecServiceEditObj update();

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
	 *	Get the ICFSecHostNodeObj instance referenced by the Host key.
	 *
	 *	@return	The ICFSecHostNodeObj instance referenced by the Host key.
	 */
	ICFSecHostNodeObj getOptionalContainerHost();

	/**
	 *	Set the ICFSecHostNodeObj instance referenced by the Host key.
	 *
	 *	@param	value	the ICFSecHostNodeObj instance to be referenced by the Host key.
	 */
	void setOptionalContainerHost( ICFSecHostNodeObj value );

	/**
	 *	Get the ICFSecServiceTypeObj instance referenced by the ServiceType key.
	 *
	 *	@return	The ICFSecServiceTypeObj instance referenced by the ServiceType key.
	 */
	ICFSecServiceTypeObj getOptionalParentServiceType();

	/**
	 *	Set the ICFSecServiceTypeObj instance referenced by the ServiceType key.
	 *
	 *	@param	value	the ICFSecServiceTypeObj instance to be referenced by the ServiceType key.
	 */
	void setOptionalParentServiceType( ICFSecServiceTypeObj value );
}
