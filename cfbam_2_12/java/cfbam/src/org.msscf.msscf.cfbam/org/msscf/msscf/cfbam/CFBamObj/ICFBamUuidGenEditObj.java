// Description: Java 11 Instance Edit Object interface for CFBam UuidGen.

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

public interface ICFBamUuidGenEditObj
	extends ICFBamUuidGenObj,
		ICFBamUuidTypeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamUuidGenObj.
	 */
	ICFBamUuidGenObj getOrigAsUuidGen();

	/**
	 *	Get the required short attribute Slice.
	 *
	 *	@return	The short value of the attribute Slice.
	 */
	short getRequiredSlice();

	/**
	 *	Set the required short attribute Slice.
	 *
	 *	@param	value	the short value of the attribute Slice.
	 */
	void setRequiredSlice( short value );

	/**
	 *	Get the required int attribute BlockSize.
	 *
	 *	@return	The int value of the attribute BlockSize.
	 */
	int getRequiredBlockSize();

	/**
	 *	Set the required int attribute BlockSize.
	 *
	 *	@param	value	the int value of the attribute BlockSize.
	 */
	void setRequiredBlockSize( int value );
}
