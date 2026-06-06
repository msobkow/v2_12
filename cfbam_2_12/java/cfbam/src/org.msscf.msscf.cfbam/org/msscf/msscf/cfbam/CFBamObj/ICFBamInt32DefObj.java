// Description: Java 11 Object interface for CFBam Int32Def.

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

public interface ICFBamInt32DefObj
	extends ICFBamAtomObj
{
	/**
	 *	Get the current edition of this Int32Def instance as a ICFBamInt32DefEditObj.
	 *
	 *	@return	The ICFBamInt32DefEditObj edition of this instance.
	 */
	ICFBamInt32DefEditObj getEditAsInt32Def();

	/**
	 *	Get the ICFBamInt32DefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamInt32DefTableObj table cache which manages this instance.
	 */
	ICFBamInt32DefTableObj getInt32DefTable();

	/**
	 *	Get the CFBamInt32DefBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamInt32DefBuff instance which currently backs this object.
	 */
	CFBamInt32DefBuff getInt32DefBuff();

	/**
	 *	Get the optional Integer attribute InitValue.
	 *
	 *	@return	The optional Integer attribute InitValue.
	 */
	Integer getOptionalInitValue();

	/**
	 *	Get the optional Integer attribute MinValue.
	 *
	 *	@return	The optional Integer attribute MinValue.
	 */
	Integer getOptionalMinValue();

	/**
	 *	Get the optional Integer attribute MaxValue.
	 *
	 *	@return	The optional Integer attribute MaxValue.
	 */
	Integer getOptionalMaxValue();

}
