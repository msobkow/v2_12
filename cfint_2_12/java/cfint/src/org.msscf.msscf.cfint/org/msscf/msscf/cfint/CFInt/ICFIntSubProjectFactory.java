
// Description: Java 11 Factory interface for SubProject.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFInt;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

/*
 *	CFIntSubProjectFactory interface for SubProject
 */
public interface ICFIntSubProjectFactory
{

	/**
	 *	Allocate a primary key for SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectPKey newPKey();

	/**
	 *	Allocate a primary history key for SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectHPKey newHPKey();

	/**
	 *	Allocate a TenantIdx key over SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectByTenantIdxKey newTenantIdxKey();

	/**
	 *	Allocate a TopProjectIdx key over SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectByTopProjectIdxKey newTopProjectIdxKey();

	/**
	 *	Allocate a NameIdx key over SubProject instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectByNameIdxKey newNameIdxKey();

	/**
	 *	Allocate a SubProject instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectBuff newBuff();

	/**
	 *	Allocate a SubProject history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFIntSubProjectHBuff newHBuff();

}
