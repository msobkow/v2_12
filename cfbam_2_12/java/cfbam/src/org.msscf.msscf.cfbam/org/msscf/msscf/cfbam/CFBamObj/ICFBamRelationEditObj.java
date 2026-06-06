// Description: Java 11 Instance Edit Object interface for CFBam Relation.

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

public interface ICFBamRelationEditObj
	extends ICFBamRelationObj,
		ICFBamScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamRelationObj.
	 */
	ICFBamRelationObj getOrigAsRelation();

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
	 *	Get the required ICFBamSchema.RelationTypeEnum attribute RelationType.
	 *
	 *	@return	The ICFBamSchema.RelationTypeEnum value of the attribute RelationType.
	 */
	ICFBamSchema.RelationTypeEnum getRequiredRelationType();

	/**
	 *	Set the required ICFBamSchema.RelationTypeEnum attribute RelationType.
	 *
	 *	@param	value	the ICFBamSchema.RelationTypeEnum value of the attribute RelationType.
	 */
	void setRequiredRelationType( ICFBamSchema.RelationTypeEnum value );

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The String value of the attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Set the optional String attribute DbName.
	 *
	 *	@param	value	the String value of the attribute DbName.
	 */
	void setOptionalDbName( String value );

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
	 *	Get the required boolean attribute IsRequired.
	 *
	 *	@return	The boolean value of the attribute IsRequired.
	 */
	boolean getRequiredIsRequired();

	/**
	 *	Set the required boolean attribute IsRequired.
	 *
	 *	@param	value	the boolean value of the attribute IsRequired.
	 */
	void setRequiredIsRequired( boolean value );

	/**
	 *	Get the required boolean attribute AllowAddendum.
	 *
	 *	@return	The boolean value of the attribute AllowAddendum.
	 */
	boolean getRequiredAllowAddendum();

	/**
	 *	Set the required boolean attribute AllowAddendum.
	 *
	 *	@param	value	the boolean value of the attribute AllowAddendum.
	 */
	void setRequiredAllowAddendum( boolean value );

	/**
	 *	Get the required boolean attribute IsXsdContainer.
	 *
	 *	@return	The boolean value of the attribute IsXsdContainer.
	 */
	boolean getRequiredIsXsdContainer();

	/**
	 *	Set the required boolean attribute IsXsdContainer.
	 *
	 *	@param	value	the boolean value of the attribute IsXsdContainer.
	 */
	void setRequiredIsXsdContainer( boolean value );

	/**
	 *	Get the required boolean attribute IsLateResolver.
	 *
	 *	@return	The boolean value of the attribute IsLateResolver.
	 */
	boolean getRequiredIsLateResolver();

	/**
	 *	Set the required boolean attribute IsLateResolver.
	 *
	 *	@param	value	the boolean value of the attribute IsLateResolver.
	 */
	void setRequiredIsLateResolver( boolean value );

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
	 *	Get the ICFBamTableObj instance referenced by the FromTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the FromTable key.
	 */
	ICFBamTableObj getRequiredContainerFromTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the FromTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the FromTable key.
	 */
	void setRequiredContainerFromTable( ICFBamTableObj value );

	/**
	 *	Get the ICFSecTenantObj instance referenced by the RelTenant key.
	 *
	 *	@return	The ICFSecTenantObj instance referenced by the RelTenant key.
	 */
	ICFSecTenantObj getRequiredOwnerRelTenant();

	/**
	 *	Set the ICFSecTenantObj instance referenced by the RelTenant key.
	 *
	 *	@param	value	the ICFSecTenantObj instance to be referenced by the RelTenant key.
	 */
	void setRequiredOwnerRelTenant( ICFSecTenantObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the FromIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the FromIndex key.
	 */
	ICFBamIndexObj getRequiredLookupFromIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the FromIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the FromIndex key.
	 */
	void setRequiredLookupFromIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamTableObj instance referenced by the ToTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the ToTable key.
	 */
	ICFBamTableObj getRequiredLookupToTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the ToTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the ToTable key.
	 */
	void setRequiredLookupToTable( ICFBamTableObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the ToIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the ToIndex key.
	 */
	ICFBamIndexObj getRequiredLookupToIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the ToIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the ToIndex key.
	 */
	void setRequiredLookupToIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamRelationObj instance referenced by the Narrowed key.
	 *
	 *	@return	The ICFBamRelationObj instance referenced by the Narrowed key.
	 */
	ICFBamRelationObj getOptionalLookupNarrowed();

	/**
	 *	Set the ICFBamRelationObj instance referenced by the Narrowed key.
	 *
	 *	@param	value	the ICFBamRelationObj instance to be referenced by the Narrowed key.
	 */
	void setOptionalLookupNarrowed( ICFBamRelationObj value );
}
