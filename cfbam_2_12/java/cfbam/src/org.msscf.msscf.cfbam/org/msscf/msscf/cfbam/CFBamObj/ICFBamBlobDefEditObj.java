// Description: Java 11 Instance Edit Object interface for CFBam BlobDef.

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

public interface ICFBamBlobDefEditObj
	extends ICFBamBlobDefObj,
		ICFBamAtomEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamBlobDefObj.
	 */
	ICFBamBlobDefObj getOrigAsBlobDef();

	/**
	 *	Get the required int attribute MaxLen.
	 *
	 *	@return	The int value of the attribute MaxLen.
	 */
	int getRequiredMaxLen();

	/**
	 *	Set the required int attribute MaxLen.
	 *
	 *	@param	value	the int value of the attribute MaxLen.
	 */
	void setRequiredMaxLen( int value );

	/**
	 *	Get the optional byte[] attribute InitValue.
	 *
	 *	@return	The byte[] value of the attribute InitValue.
	 */
	byte[] getOptionalInitValue();

	/**
	 *	Set the optional byte[] attribute InitValue.
	 *
	 *	@param	value	the byte[] value of the attribute InitValue.
	 */
	void setOptionalInitValue( byte[] value );
}
