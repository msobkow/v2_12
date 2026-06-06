
// Description: Java 11 Factory interface for Value.

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
 *	CFBamValueFactory interface for Value
 */
public interface ICFBamValueFactory
{

	/**
	 *	Allocate a primary key for Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValuePKey newPKey();

	/**
	 *	Allocate a primary history key for Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueHPKey newHPKey();

	/**
	 *	Allocate a UNameIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a ValTentIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByValTentIdxKey newValTentIdxKey();

	/**
	 *	Allocate a ScopeIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByScopeIdxKey newScopeIdxKey();

	/**
	 *	Allocate a DefSchemaIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByDefSchemaIdxKey newDefSchemaIdxKey();

	/**
	 *	Allocate a PrevIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByPrevIdxKey newPrevIdxKey();

	/**
	 *	Allocate a NextIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByNextIdxKey newNextIdxKey();

	/**
	 *	Allocate a ContPrevIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByContPrevIdxKey newContPrevIdxKey();

	/**
	 *	Allocate a ContNextIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueByContNextIdxKey newContNextIdxKey();

	/**
	 *	Allocate a Value instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueBuff newBuff();

	/**
	 *	Allocate a Value history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamValueHBuff newHBuff();

}
