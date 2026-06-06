
// Description: Java 11 Factory interface for GelSpread.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

/*
 *	CFGenKbGelSpreadFactory interface for GelSpread
 */
public interface ICFGenKbGelSpreadFactory
{

	/**
	 *	Allocate a BetweenIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByBetweenIdxKey newBetweenIdxKey();

	/**
	 *	Allocate a BeforeIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByBeforeIdxKey newBeforeIdxKey();

	/**
	 *	Allocate a FirstIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByFirstIdxKey newFirstIdxKey();

	/**
	 *	Allocate a EachIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByEachIdxKey newEachIdxKey();

	/**
	 *	Allocate a LastIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByLastIdxKey newLastIdxKey();

	/**
	 *	Allocate a LoneIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByLoneIdxKey newLoneIdxKey();

	/**
	 *	Allocate a EmptyIdx key over GelSpread instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadByEmptyIdxKey newEmptyIdxKey();

	/**
	 *	Allocate a GelSpread instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGelSpreadBuff newBuff();

}
