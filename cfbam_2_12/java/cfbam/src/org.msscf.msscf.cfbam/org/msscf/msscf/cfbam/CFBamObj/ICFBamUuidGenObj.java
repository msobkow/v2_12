// Description: Java 11 Object interface for CFBam UuidGen.

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
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamUuidGenObj
	extends ICFBamUuidTypeObj
{
	/**
	 *	Get the current edition of this UuidGen instance as a ICFBamUuidGenEditObj.
	 *
	 *	@return	The ICFBamUuidGenEditObj edition of this instance.
	 */
	ICFBamUuidGenEditObj getEditAsUuidGen();

	/**
	 *	Get the ICFBamUuidGenTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamUuidGenTableObj table cache which manages this instance.
	 */
	ICFBamUuidGenTableObj getUuidGenTable();

	/**
	 *	Get the CFBamUuidGenBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamUuidGenBuff instance which currently backs this object.
	 */
	CFBamUuidGenBuff getUuidGenBuff();

	/**
	 *	Get the required short attribute Slice.
	 *
	 *	@return	The required short attribute Slice.
	 */
	short getRequiredSlice();

	/**
	 *	Get the required int attribute BlockSize.
	 *
	 *	@return	The required int attribute BlockSize.
	 */
	int getRequiredBlockSize();

}
