// Description: Java 11 Instance Edit Object interface for CFBam ClearTopDep.

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

public interface ICFBamClearTopDepEditObj
	extends ICFBamClearTopDepObj,
		ICFBamClearDepEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamClearTopDepObj.
	 */
	ICFBamClearTopDepObj getOrigAsClearTopDep();

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
	 *	Get the ICFBamTableObj instance referenced by the Table key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the Table key.
	 */
	ICFBamTableObj getRequiredContainerTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the Table key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the Table key.
	 */
	void setRequiredContainerTable( ICFBamTableObj value );

	/**
	 *	Get the ICFBamClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamClearTopDepObj instance referenced by the Prev key.
	 */
	ICFBamClearTopDepObj getOptionalLookupPrev();

	/**
	 *	Set the ICFBamClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamClearTopDepObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamClearTopDepObj value );

	/**
	 *	Get the ICFBamClearTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamClearTopDepObj instance referenced by the Next key.
	 */
	ICFBamClearTopDepObj getOptionalLookupNext();

	/**
	 *	Set the ICFBamClearTopDepObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamClearTopDepObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamClearTopDepObj value );
}
