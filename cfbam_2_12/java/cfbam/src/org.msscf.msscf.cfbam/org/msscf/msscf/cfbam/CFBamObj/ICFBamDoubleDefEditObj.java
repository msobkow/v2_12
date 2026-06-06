// Description: Java 11 Instance Edit Object interface for CFBam DoubleDef.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

public interface ICFBamDoubleDefEditObj
	extends ICFBamDoubleDefObj,
		ICFBamAtomEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamDoubleDefObj.
	 */
	ICFBamDoubleDefObj getOrigAsDoubleDef();

	/**
	 *	Get the optional Double attribute InitValue.
	 *
	 *	@return	The Double value of the attribute InitValue.
	 */
	Double getOptionalInitValue();

	/**
	 *	Set the optional Double attribute InitValue.
	 *
	 *	@param	value	the Double value of the attribute InitValue.
	 */
	void setOptionalInitValue( Double value );

	/**
	 *	Get the optional Double attribute MinValue.
	 *
	 *	@return	The Double value of the attribute MinValue.
	 */
	Double getOptionalMinValue();

	/**
	 *	Set the optional Double attribute MinValue.
	 *
	 *	@param	value	the Double value of the attribute MinValue.
	 */
	void setOptionalMinValue( Double value );

	/**
	 *	Get the optional Double attribute MaxValue.
	 *
	 *	@return	The Double value of the attribute MaxValue.
	 */
	Double getOptionalMaxValue();

	/**
	 *	Set the optional Double attribute MaxValue.
	 *
	 *	@param	value	the Double value of the attribute MaxValue.
	 */
	void setOptionalMaxValue( Double value );
}
