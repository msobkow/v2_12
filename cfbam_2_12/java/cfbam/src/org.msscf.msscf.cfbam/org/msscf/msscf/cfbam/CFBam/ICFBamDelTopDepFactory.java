
// Description: Java 11 Factory interface for DelTopDep.

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
 *	CFBamDelTopDepFactory interface for DelTopDep
 */
public interface ICFBamDelTopDepFactory
{

	/**
	 *	Allocate a DelTopDepTblIdx key over DelTopDep instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamDelTopDepByDelTopDepTblIdxKey newDelTopDepTblIdxKey();

	/**
	 *	Allocate a UNameIdx key over DelTopDep instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamDelTopDepByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a PrevIdx key over DelTopDep instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamDelTopDepByPrevIdxKey newPrevIdxKey();

	/**
	 *	Allocate a NextIdx key over DelTopDep instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamDelTopDepByNextIdxKey newNextIdxKey();

	/**
	 *	Allocate a DelTopDep instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamDelTopDepBuff newBuff();

	/**
	 *	Allocate a DelTopDep history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamDelTopDepHBuff newHBuff();

}
