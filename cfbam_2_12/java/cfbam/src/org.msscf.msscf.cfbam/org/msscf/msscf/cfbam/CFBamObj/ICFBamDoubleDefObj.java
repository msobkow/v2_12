// Description: Java 11 Object interface for CFBam DoubleDef.

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

public interface ICFBamDoubleDefObj
	extends ICFBamAtomObj
{
	/**
	 *	Get the current edition of this DoubleDef instance as a ICFBamDoubleDefEditObj.
	 *
	 *	@return	The ICFBamDoubleDefEditObj edition of this instance.
	 */
	ICFBamDoubleDefEditObj getEditAsDoubleDef();

	/**
	 *	Get the ICFBamDoubleDefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamDoubleDefTableObj table cache which manages this instance.
	 */
	ICFBamDoubleDefTableObj getDoubleDefTable();

	/**
	 *	Get the CFBamDoubleDefBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamDoubleDefBuff instance which currently backs this object.
	 */
	CFBamDoubleDefBuff getDoubleDefBuff();

	/**
	 *	Get the optional Double attribute InitValue.
	 *
	 *	@return	The optional Double attribute InitValue.
	 */
	Double getOptionalInitValue();

	/**
	 *	Get the optional Double attribute MinValue.
	 *
	 *	@return	The optional Double attribute MinValue.
	 */
	Double getOptionalMinValue();

	/**
	 *	Get the optional Double attribute MaxValue.
	 *
	 *	@return	The optional Double attribute MaxValue.
	 */
	Double getOptionalMaxValue();

}
