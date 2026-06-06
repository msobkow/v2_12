// Description: Java 11 Instance Edit Object interface for CFBam PopSubDep3.

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

public interface ICFBamPopSubDep3EditObj
	extends ICFBamPopSubDep3Obj,
		ICFBamPopDepEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamPopSubDep3Obj.
	 */
	ICFBamPopSubDep3Obj getOrigAsPopSubDep3();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The String value of the attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param	value	the String value of the attribute Name.
	 */
	void setRequiredName( String value );

	/**
	 *	Get the ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 *
	 *	@return	The ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 */
	ICFBamPopSubDep2Obj getRequiredContainerPopSubDep2();

	/**
	 *	Set the ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 *
	 *	@param	value	the ICFBamPopSubDep2Obj instance to be referenced by the PopSubDep2 key.
	 */
	void setRequiredContainerPopSubDep2( ICFBamPopSubDep2Obj value );
}
