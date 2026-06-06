// Description: Java 11 Instance Edit Object interface for CFGenKb GelCache.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public interface ICFGenKbGelCacheEditObj
	extends ICFGenKbGelCacheObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbGelCacheObj.
	 */
	ICFGenKbGelCacheObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbGelCacheObj.
	 */
	ICFGenKbGelCacheObj getOrigAsGelCache();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbGelCacheObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbGelCacheEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbGelCacheEditObj deleteInstance();

	/**
	 *	Get the required String attribute CacheName.
	 *
	 *	@return	The String value of the attribute CacheName.
	 */
	String getRequiredCacheName();

	/**
	 *	Set the required String attribute CacheName.
	 *
	 *	@param	value	the String value of the attribute CacheName.
	 */
	void setRequiredCacheName( String value );

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
