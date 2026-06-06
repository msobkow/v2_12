// Description: Java 11 Instance Edit Object interface for CFBam Int16Def.

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

public interface ICFBamInt16DefEditObj
	extends ICFBamInt16DefObj,
		ICFBamAtomEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamInt16DefObj.
	 */
	ICFBamInt16DefObj getOrigAsInt16Def();

	/**
	 *	Get the optional Short attribute InitValue.
	 *
	 *	@return	The Short value of the attribute InitValue.
	 */
	Short getOptionalInitValue();

	/**
	 *	Set the optional Short attribute InitValue.
	 *
	 *	@param	value	the Short value of the attribute InitValue.
	 */
	void setOptionalInitValue( Short value );

	/**
	 *	Get the optional Short attribute MinValue.
	 *
	 *	@return	The Short value of the attribute MinValue.
	 */
	Short getOptionalMinValue();

	/**
	 *	Set the optional Short attribute MinValue.
	 *
	 *	@param	value	the Short value of the attribute MinValue.
	 */
	void setOptionalMinValue( Short value );

	/**
	 *	Get the optional Short attribute MaxValue.
	 *
	 *	@return	The Short value of the attribute MaxValue.
	 */
	Short getOptionalMaxValue();

	/**
	 *	Set the optional Short attribute MaxValue.
	 *
	 *	@param	value	the Short value of the attribute MaxValue.
	 */
	void setOptionalMaxValue( Short value );
}
