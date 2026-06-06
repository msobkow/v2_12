
// Description: Java 11 Factory interface for IndexCol.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

/*
 *	CFBamIndexColFactory interface for IndexCol
 */
public interface ICFBamIndexColFactory
{

	/**
	 *	Allocate a primary key for IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColPKey newPKey();

	/**
	 *	Allocate a primary history key for IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColHPKey newHPKey();

	/**
	 *	Allocate a UNameIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a IdxColTenantIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByIdxColTenantIdxKey newIdxColTenantIdxKey();

	/**
	 *	Allocate a IndexIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByIndexIdxKey newIndexIdxKey();

	/**
	 *	Allocate a DefSchemaIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByDefSchemaIdxKey newDefSchemaIdxKey();

	/**
	 *	Allocate a ColIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByColIdxKey newColIdxKey();

	/**
	 *	Allocate a PrevIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByPrevIdxKey newPrevIdxKey();

	/**
	 *	Allocate a NextIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByNextIdxKey newNextIdxKey();

	/**
	 *	Allocate a IdxPrevIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByIdxPrevIdxKey newIdxPrevIdxKey();

	/**
	 *	Allocate a IdxNextIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColByIdxNextIdxKey newIdxNextIdxKey();

	/**
	 *	Allocate a IndexCol instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColBuff newBuff();

	/**
	 *	Allocate a IndexCol history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexColHBuff newHBuff();

}
