// Description: Java 11 Instance Edit Object interface for CFGenKb GelIterator.

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

public interface ICFGenKbGelIteratorEditObj
	extends ICFGenKbGelIteratorObj,
		ICFGenKbGelInstructionEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbGelIteratorObj.
	 */
	ICFGenKbGelIteratorObj getOrigAsGelIterator();

	/**
	 *	Get the required String attribute IteratorName.
	 *
	 *	@return	The String value of the attribute IteratorName.
	 */
	String getRequiredIteratorName();

	/**
	 *	Set the required String attribute IteratorName.
	 *
	 *	@param	value	the String value of the attribute IteratorName.
	 */
	void setRequiredIteratorName( String value );

	/**
	 *	Get the optional String attribute ExpandBefore.
	 *
	 *	@return	The String value of the attribute ExpandBefore.
	 */
	String getOptionalExpandBefore();

	/**
	 *	Set the optional String attribute ExpandBefore.
	 *
	 *	@param	value	the String value of the attribute ExpandBefore.
	 */
	void setOptionalExpandBefore( String value );

	/**
	 *	Get the optional String attribute ExpandFirst.
	 *
	 *	@return	The String value of the attribute ExpandFirst.
	 */
	String getOptionalExpandFirst();

	/**
	 *	Set the optional String attribute ExpandFirst.
	 *
	 *	@param	value	the String value of the attribute ExpandFirst.
	 */
	void setOptionalExpandFirst( String value );

	/**
	 *	Get the required String attribute ExpandEach.
	 *
	 *	@return	The String value of the attribute ExpandEach.
	 */
	String getRequiredExpandEach();

	/**
	 *	Set the required String attribute ExpandEach.
	 *
	 *	@param	value	the String value of the attribute ExpandEach.
	 */
	void setRequiredExpandEach( String value );

	/**
	 *	Get the optional String attribute ExpandLast.
	 *
	 *	@return	The String value of the attribute ExpandLast.
	 */
	String getOptionalExpandLast();

	/**
	 *	Set the optional String attribute ExpandLast.
	 *
	 *	@param	value	the String value of the attribute ExpandLast.
	 */
	void setOptionalExpandLast( String value );

	/**
	 *	Get the optional String attribute ExpandLone.
	 *
	 *	@return	The String value of the attribute ExpandLone.
	 */
	String getOptionalExpandLone();

	/**
	 *	Set the optional String attribute ExpandLone.
	 *
	 *	@param	value	the String value of the attribute ExpandLone.
	 */
	void setOptionalExpandLone( String value );

	/**
	 *	Get the optional String attribute ExpandEmpty.
	 *
	 *	@return	The String value of the attribute ExpandEmpty.
	 */
	String getOptionalExpandEmpty();

	/**
	 *	Set the optional String attribute ExpandEmpty.
	 *
	 *	@param	value	the String value of the attribute ExpandEmpty.
	 */
	void setOptionalExpandEmpty( String value );

	/**
	 *	Get the optional String attribute ExpandAfter.
	 *
	 *	@return	The String value of the attribute ExpandAfter.
	 */
	String getOptionalExpandAfter();

	/**
	 *	Set the optional String attribute ExpandAfter.
	 *
	 *	@param	value	the String value of the attribute ExpandAfter.
	 */
	void setOptionalExpandAfter( String value );
}
