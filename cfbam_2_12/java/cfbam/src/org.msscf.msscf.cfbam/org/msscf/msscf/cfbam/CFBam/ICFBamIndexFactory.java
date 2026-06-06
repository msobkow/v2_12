
// Description: Java 11 Factory interface for Index.

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
 *	CFBamIndexFactory interface for Index
 */
public interface ICFBamIndexFactory
{

	/**
	 *	Allocate a UNameIdx key over Index instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a IndexTenantIdx key over Index instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexByIndexTenantIdxKey newIndexTenantIdxKey();

	/**
	 *	Allocate a IdxTableIdx key over Index instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexByIdxTableIdxKey newIdxTableIdxKey();

	/**
	 *	Allocate a DefSchemaIdx key over Index instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexByDefSchemaIdxKey newDefSchemaIdxKey();

	/**
	 *	Allocate a Index instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexBuff newBuff();

	/**
	 *	Allocate a Index history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamIndexHBuff newHBuff();

}
