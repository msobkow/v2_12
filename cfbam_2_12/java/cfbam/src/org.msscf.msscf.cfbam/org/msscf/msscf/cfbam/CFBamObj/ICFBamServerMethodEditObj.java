// Description: Java 11 Instance Edit Object interface for CFBam ServerMethod.

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

public interface ICFBamServerMethodEditObj
	extends ICFBamServerMethodObj,
		ICFBamScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamServerMethodObj.
	 */
	ICFBamServerMethodObj getOrigAsServerMethod();

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
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The String value of the attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Set the optional String attribute ShortName.
	 *
	 *	@param	value	the String value of the attribute ShortName.
	 */
	void setOptionalShortName( String value );

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The String value of the attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Set the optional String attribute Label.
	 *
	 *	@param	value	the String value of the attribute Label.
	 */
	void setOptionalLabel( String value );

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The String value of the attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Set the optional String attribute ShortDescription.
	 *
	 *	@param	value	the String value of the attribute ShortDescription.
	 */
	void setOptionalShortDescription( String value );

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The String value of the attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Set the optional String attribute Description.
	 *
	 *	@param	value	the String value of the attribute Description.
	 */
	void setOptionalDescription( String value );

	/**
	 *	Get the optional String attribute Suffix.
	 *
	 *	@return	The String value of the attribute Suffix.
	 */
	String getOptionalSuffix();

	/**
	 *	Set the optional String attribute Suffix.
	 *
	 *	@param	value	the String value of the attribute Suffix.
	 */
	void setOptionalSuffix( String value );

	/**
	 *	Get the required boolean attribute IsInstanceMethod.
	 *
	 *	@return	The boolean value of the attribute IsInstanceMethod.
	 */
	boolean getRequiredIsInstanceMethod();

	/**
	 *	Set the required boolean attribute IsInstanceMethod.
	 *
	 *	@param	value	the boolean value of the attribute IsInstanceMethod.
	 */
	void setRequiredIsInstanceMethod( boolean value );

	/**
	 *	Get the required boolean attribute IsClientMethod.
	 *
	 *	@return	The boolean value of the attribute IsClientMethod.
	 */
	boolean getRequiredIsClientMethod();

	/**
	 *	Set the required boolean attribute IsClientMethod.
	 *
	 *	@param	value	the boolean value of the attribute IsClientMethod.
	 */
	void setRequiredIsClientMethod( boolean value );

	/**
	 *	Get the required String attribute JMethodBody.
	 *
	 *	@return	The String value of the attribute JMethodBody.
	 */
	String getRequiredJMethodBody();

	/**
	 *	Set the required String attribute JMethodBody.
	 *
	 *	@param	value	the String value of the attribute JMethodBody.
	 */
	void setRequiredJMethodBody( String value );

	/**
	 *	Get the required String attribute CppMethodBody.
	 *
	 *	@return	The String value of the attribute CppMethodBody.
	 */
	String getRequiredCppMethodBody();

	/**
	 *	Set the required String attribute CppMethodBody.
	 *
	 *	@param	value	the String value of the attribute CppMethodBody.
	 */
	void setRequiredCppMethodBody( String value );

	/**
	 *	Get the required String attribute CsMethodBody.
	 *
	 *	@return	The String value of the attribute CsMethodBody.
	 */
	String getRequiredCsMethodBody();

	/**
	 *	Set the required String attribute CsMethodBody.
	 *
	 *	@param	value	the String value of the attribute CsMethodBody.
	 */
	void setRequiredCsMethodBody( String value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamTableObj instance referenced by the ForTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the ForTable key.
	 */
	ICFBamTableObj getRequiredContainerForTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the ForTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the ForTable key.
	 */
	void setRequiredContainerForTable( ICFBamTableObj value );
}
