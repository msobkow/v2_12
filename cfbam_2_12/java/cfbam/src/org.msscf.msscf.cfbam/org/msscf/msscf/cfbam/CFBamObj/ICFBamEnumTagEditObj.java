// Description: Java 11 Instance Edit Object interface for CFBam EnumTag.

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

public interface ICFBamEnumTagEditObj
	extends ICFBamEnumTagObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFBamEnumTagObj.
	 */
	ICFBamEnumTagObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamEnumTagObj.
	 */
	ICFBamEnumTagObj getOrigAsEnumTag();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFBamEnumTagObj create();

	/*
	 *	Update the instance.
	 */
	CFBamEnumTagEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFBamEnumTagEditObj deleteInstance();

	/**
	 *	Get the optional Short attribute EnumCode.
	 *
	 *	@return	The Short value of the attribute EnumCode.
	 */
	Short getOptionalEnumCode();

	/**
	 *	Set the optional Short attribute EnumCode.
	 *
	 *	@param	value	the Short value of the attribute EnumCode.
	 */
	void setOptionalEnumCode( Short value );

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
	 *	Get the ICFBamEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@return	The ICFBamEnumDefObj instance referenced by the EnumDef key.
	 */
	ICFBamEnumDefObj getRequiredContainerEnumDef();

	/**
	 *	Set the ICFBamEnumDefObj instance referenced by the EnumDef key.
	 *
	 *	@param	value	the ICFBamEnumDefObj instance to be referenced by the EnumDef key.
	 */
	void setRequiredContainerEnumDef( ICFBamEnumDefObj value );

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
	 *	Get the ICFBamEnumTagObj instance referenced by the Prev key.
	 *
	 *	@return	The ICFBamEnumTagObj instance referenced by the Prev key.
	 */
	ICFBamEnumTagObj getOptionalLookupPrev();

	/**
	 *	Set the ICFBamEnumTagObj instance referenced by the Prev key.
	 *
	 *	@param	value	the ICFBamEnumTagObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( ICFBamEnumTagObj value );

	/**
	 *	Get the ICFBamEnumTagObj instance referenced by the Next key.
	 *
	 *	@return	The ICFBamEnumTagObj instance referenced by the Next key.
	 */
	ICFBamEnumTagObj getOptionalLookupNext();

	/**
	 *	Set the ICFBamEnumTagObj instance referenced by the Next key.
	 *
	 *	@param	value	the ICFBamEnumTagObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( ICFBamEnumTagObj value );

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
