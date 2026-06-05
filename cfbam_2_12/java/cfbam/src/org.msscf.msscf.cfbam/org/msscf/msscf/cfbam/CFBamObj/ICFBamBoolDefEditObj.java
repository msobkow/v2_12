// Description: Java 11 Instance Edit Object interface for CFBam BoolDef.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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

public interface ICFBamBoolDefEditObj
	extends ICFBamBoolDefObj,
		ICFBamAtomEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamBoolDefObj.
	 */
	ICFBamBoolDefObj getOrigAsBoolDef();

	/**
	 *	Get the optional Boolean attribute InitValue.
	 *
	 *	@return	The Boolean value of the attribute InitValue.
	 */
	Boolean getOptionalInitValue();

	/**
	 *	Set the optional Boolean attribute InitValue.
	 *
	 *	@param	value	the Boolean value of the attribute InitValue.
	 */
	void setOptionalInitValue( Boolean value );

	/**
	 *	Get the optional String attribute FalseString.
	 *
	 *	@return	The String value of the attribute FalseString.
	 */
	String getOptionalFalseString();

	/**
	 *	Set the optional String attribute FalseString.
	 *
	 *	@param	value	the String value of the attribute FalseString.
	 */
	void setOptionalFalseString( String value );

	/**
	 *	Get the optional String attribute TrueString.
	 *
	 *	@return	The String value of the attribute TrueString.
	 */
	String getOptionalTrueString();

	/**
	 *	Set the optional String attribute TrueString.
	 *
	 *	@param	value	the String value of the attribute TrueString.
	 */
	void setOptionalTrueString( String value );

	/**
	 *	Get the optional String attribute NullString.
	 *
	 *	@return	The String value of the attribute NullString.
	 */
	String getOptionalNullString();

	/**
	 *	Set the optional String attribute NullString.
	 *
	 *	@param	value	the String value of the attribute NullString.
	 */
	void setOptionalNullString( String value );
}
