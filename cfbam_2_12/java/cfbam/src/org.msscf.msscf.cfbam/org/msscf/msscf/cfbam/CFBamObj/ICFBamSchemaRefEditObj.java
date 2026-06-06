// Description: Java 11 Instance Edit Object interface for CFBam SchemaRef.

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

public interface ICFBamSchemaRefEditObj
	extends ICFBamSchemaRefObj,
		ICFBamScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamSchemaRefObj.
	 */
	ICFBamSchemaRefObj getOrigAsSchemaRef();

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
	 *	Get the required String attribute RefModelName.
	 *
	 *	@return	The String value of the attribute RefModelName.
	 */
	String getRequiredRefModelName();

	/**
	 *	Set the required String attribute RefModelName.
	 *
	 *	@param	value	the String value of the attribute RefModelName.
	 */
	void setRequiredRefModelName( String value );

	/**
	 *	Get the required String attribute IncludeRoot.
	 *
	 *	@return	The String value of the attribute IncludeRoot.
	 */
	String getRequiredIncludeRoot();

	/**
	 *	Set the required String attribute IncludeRoot.
	 *
	 *	@param	value	the String value of the attribute IncludeRoot.
	 */
	void setRequiredIncludeRoot( String value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the Schema key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchema();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the Schema key.
	 */
	void setRequiredContainerSchema( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupRefSchema();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the RefSchema key.
	 */
	void setOptionalLookupRefSchema( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamSchemaRefObj instance referenced by the Prev key.
	 */
	ICFBamSchemaRefObj getOptionalLookupPrev();

	/**
	 *	Set the ICFBamSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamSchemaRefObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamSchemaRefObj value );

	/**
	 *	Get the ICFBamSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamSchemaRefObj instance referenced by the Next key.
	 */
	ICFBamSchemaRefObj getOptionalLookupNext();

	/**
	 *	Set the ICFBamSchemaRefObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamSchemaRefObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamSchemaRefObj value );
}
