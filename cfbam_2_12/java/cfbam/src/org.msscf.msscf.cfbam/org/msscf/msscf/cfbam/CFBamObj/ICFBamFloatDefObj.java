// Description: Java 11 Object interface for CFBam FloatDef.

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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamFloatDefObj
	extends ICFBamAtomObj
{
	/**
	 *	Get the current edition of this FloatDef instance as a ICFBamFloatDefEditObj.
	 *
	 *	@return	The ICFBamFloatDefEditObj edition of this instance.
	 */
	ICFBamFloatDefEditObj getEditAsFloatDef();

	/**
	 *	Get the ICFBamFloatDefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamFloatDefTableObj table cache which manages this instance.
	 */
	ICFBamFloatDefTableObj getFloatDefTable();

	/**
	 *	Get the CFBamFloatDefBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamFloatDefBuff instance which currently backs this object.
	 */
	CFBamFloatDefBuff getFloatDefBuff();

	/**
	 *	Get the optional Float attribute InitValue.
	 *
	 *	@return	The optional Float attribute InitValue.
	 */
	Float getOptionalInitValue();

	/**
	 *	Get the optional Float attribute MinValue.
	 *
	 *	@return	The optional Float attribute MinValue.
	 */
	Float getOptionalMinValue();

	/**
	 *	Get the optional Float attribute MaxValue.
	 *
	 *	@return	The optional Float attribute MaxValue.
	 */
	Float getOptionalMaxValue();

}
