// Description: Java 11 Instance Edit Object interface for CFBam Int32Def.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamInt32DefEditObj
	extends ICFBamInt32DefObj,
		ICFBamAtomEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamInt32DefObj.
	 */
	ICFBamInt32DefObj getOrigAsInt32Def();

	/**
	 *	Get the optional Integer attribute InitValue.
	 *
	 *	@return	The Integer value of the attribute InitValue.
	 */
	Integer getOptionalInitValue();

	/**
	 *	Set the optional Integer attribute InitValue.
	 *
	 *	@param	value	the Integer value of the attribute InitValue.
	 */
	void setOptionalInitValue( Integer value );

	/**
	 *	Get the optional Integer attribute MinValue.
	 *
	 *	@return	The Integer value of the attribute MinValue.
	 */
	Integer getOptionalMinValue();

	/**
	 *	Set the optional Integer attribute MinValue.
	 *
	 *	@param	value	the Integer value of the attribute MinValue.
	 */
	void setOptionalMinValue( Integer value );

	/**
	 *	Get the optional Integer attribute MaxValue.
	 *
	 *	@return	The Integer value of the attribute MaxValue.
	 */
	Integer getOptionalMaxValue();

	/**
	 *	Set the optional Integer attribute MaxValue.
	 *
	 *	@param	value	the Integer value of the attribute MaxValue.
	 */
	void setOptionalMaxValue( Integer value );
}
