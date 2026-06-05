// Description: Java 11 Instance Edit Object interface for CFGenKb GelConstrain.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbGelConstrainEditObj
	extends ICFGenKbGelConstrainObj,
		ICFGenKbGelInstructionEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbGelConstrainObj.
	 */
	ICFGenKbGelConstrainObj getOrigAsGelConstrain();

	/**
	 *	Get the optional Long attribute HardConstraint.
	 *
	 *	@return	The Long value of the attribute HardConstraint.
	 */
	Long getOptionalHardConstraint();

	/**
	 *	Set the optional Long attribute HardConstraint.
	 *
	 *	@param	value	the Long value of the attribute HardConstraint.
	 */
	void setOptionalHardConstraint( Long value );

	/**
	 *	Get the optional String attribute ConstrainingName.
	 *
	 *	@return	The String value of the attribute ConstrainingName.
	 */
	String getOptionalConstrainingName();

	/**
	 *	Set the optional String attribute ConstrainingName.
	 *
	 *	@param	value	the String value of the attribute ConstrainingName.
	 */
	void setOptionalConstrainingName( String value );

	/**
	 *	Get the ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 *
	 *	@return	The ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupRemainder();

	/**
	 *	Set the ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 *
	 *	@param	value	the ICFGenKbGelInstructionObj instance to be referenced by the Remainder key.
	 */
	void setOptionalLookupRemainder( ICFGenKbGelInstructionObj value );
}
