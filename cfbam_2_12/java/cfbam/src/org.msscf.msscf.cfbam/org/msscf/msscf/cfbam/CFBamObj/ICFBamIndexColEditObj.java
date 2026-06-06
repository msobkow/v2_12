// Description: Java 11 Instance Edit Object interface for CFBam IndexCol.

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

public interface ICFBamIndexColEditObj
	extends ICFBamIndexColObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFBamIndexColObj.
	 */
	ICFBamIndexColObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamIndexColObj.
	 */
	ICFBamIndexColObj getOrigAsIndexCol();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFBamIndexColObj create();

	/*
	 *	Update the instance.
	 */
	CFBamIndexColEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFBamIndexColEditObj deleteInstance();

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
	 *	Get the required boolean attribute IsAscending.
	 *
	 *	@return	The boolean value of the attribute IsAscending.
	 */
	boolean getRequiredIsAscending();

	/**
	 *	Set the required boolean attribute IsAscending.
	 *
	 *	@param	value	the boolean value of the attribute IsAscending.
	 */
	void setRequiredIsAscending( boolean value );

	/**
	 *	Get the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant();

	/**
	 *	Set the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFSecTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFSecTenantObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the Index key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the Index key.
	 */
	ICFBamIndexObj getRequiredContainerIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the Index key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the Index key.
	 */
	void setRequiredContainerIndex( ICFBamIndexObj value );

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
	 *	Get the ICFBamIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamIndexColObj instance referenced by the Prev key.
	 */
	ICFBamIndexColObj getOptionalLookupPrev();

	/**
	 *	Set the ICFBamIndexColObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamIndexColObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamIndexColObj value );

	/**
	 *	Get the ICFBamIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamIndexColObj instance referenced by the Next key.
	 */
	ICFBamIndexColObj getOptionalLookupNext();

	/**
	 *	Set the ICFBamIndexColObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamIndexColObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamIndexColObj value );

	/**
	 *	Get the ICFBamValueObj instance referenced by the Column key.
	 *
	 *	@return	The ICFBamValueObj instance referenced by the Column key.
	 */
	ICFBamValueObj getRequiredLookupColumn();

	/**
	 *	Set the ICFBamValueObj instance referenced by the Column key.
	 *
	 *	@param	value	the ICFBamValueObj instance to be referenced by the Column key.
	 */
	void setRequiredLookupColumn( ICFBamValueObj value );

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ICFSecSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ICFSecSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( Calendar value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ICFSecSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ICFSecSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( Calendar value );}
