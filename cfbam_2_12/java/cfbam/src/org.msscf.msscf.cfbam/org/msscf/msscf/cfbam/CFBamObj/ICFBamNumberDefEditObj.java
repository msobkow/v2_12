// Description: Java 11 Instance Edit Object interface for CFBam NumberDef.

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

public interface ICFBamNumberDefEditObj
	extends ICFBamNumberDefObj,
		ICFBamAtomEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamNumberDefObj.
	 */
	ICFBamNumberDefObj getOrigAsNumberDef();

	/**
	 *	Get the required short attribute Digits.
	 *
	 *	@return	The short value of the attribute Digits.
	 */
	short getRequiredDigits();

	/**
	 *	Set the required short attribute Digits.
	 *
	 *	@param	value	the short value of the attribute Digits.
	 */
	void setRequiredDigits( short value );

	/**
	 *	Get the required short attribute Precis.
	 *
	 *	@return	The short value of the attribute Precis.
	 */
	short getRequiredPrecis();

	/**
	 *	Set the required short attribute Precis.
	 *
	 *	@param	value	the short value of the attribute Precis.
	 */
	void setRequiredPrecis( short value );

	/**
	 *	Get the optional BigDecimal attribute InitValue.
	 *
	 *	@return	The BigDecimal value of the attribute InitValue.
	 */
	BigDecimal getOptionalInitValue();

	/**
	 *	Set the optional BigDecimal attribute InitValue.
	 *
	 *	@param	value	the BigDecimal value of the attribute InitValue.
	 */
	void setOptionalInitValue( BigDecimal value );

	/**
	 *	Get the optional BigDecimal attribute MinValue.
	 *
	 *	@return	The BigDecimal value of the attribute MinValue.
	 */
	BigDecimal getOptionalMinValue();

	/**
	 *	Set the optional BigDecimal attribute MinValue.
	 *
	 *	@param	value	the BigDecimal value of the attribute MinValue.
	 */
	void setOptionalMinValue( BigDecimal value );

	/**
	 *	Get the optional BigDecimal attribute MaxValue.
	 *
	 *	@return	The BigDecimal value of the attribute MaxValue.
	 */
	BigDecimal getOptionalMaxValue();

	/**
	 *	Set the optional BigDecimal attribute MaxValue.
	 *
	 *	@param	value	the BigDecimal value of the attribute MaxValue.
	 */
	void setOptionalMaxValue( BigDecimal value );
}
