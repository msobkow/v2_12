// Description: Java 11 Object interface for CFBam RelationCol.

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
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamRelationColObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ICFSecSecUserObj instance who created this instance.
	 */
	ICFSecSecUserObj getCreatedBy();

	/**
	 *	Get the Calendar date-time this instance was created.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ICFSecSecUserObj instance who updated this instance.
	 */
	ICFSecSecUserObj getUpdatedBy();

	/**
	 *	Get the Calendar date-time this instance was updated.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getUpdatedAt();
	/**
	 *	Realise this instance of a RelationCol.
	 *
	 *	@return	CFBamRelationColObj instance which should be subsequently referenced.
	 */
	ICFBamRelationColObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();
	void forget( boolean forgetSubObjects );

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamRelationColObj the reference to the cached or read (realised) instance.
	 */
	ICFBamRelationColObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamRelationColObj the reference to the cached or read (realised) instance.
	 */
	ICFBamRelationColObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamRelationColObj the reference to the moved and refreshed instance.
	 */
	ICFBamRelationColObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamRelationColObj the reference to the moved and refreshed instance.
	 */
	ICFBamRelationColObj moveDown();

	/**
	 *	Initialize and return a locked edition of this RelationCol instance.
	 *
	 *	@return	The newly locked ICFBamRelationColEditObj edition of this instance.
	 */
	ICFBamRelationColEditObj beginEdit();

	/**
	 *	End this edition of this RelationCol instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this RelationCol instance.
	 *
	 *	@return	The ICFBamRelationColEditObj edition of this instance.
	 */
	ICFBamRelationColEditObj getEdit();

	/**
	 *	Get the current edition of this RelationCol instance as a ICFBamRelationColEditObj.
	 *
	 *	@return	The ICFBamRelationColEditObj edition of this instance.
	 */
	ICFBamRelationColEditObj getEditAsRelationCol();

	/**
	 *	Get the ICFBamRelationColTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamRelationColTableObj table cache which manages this instance.
	 */
	ICFBamRelationColTableObj getRelationColTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamRelationColBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamRelationColBuff instance which currently backs this object.
	 */
	CFBamRelationColBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamRelationColBuff value );

	/**
	 *	Get the CFBamRelationColBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamRelationColBuff instance which currently backs this object.
	 */
	CFBamRelationColBuff getRelationColBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamRelationColPKey primary key for this instance.
	 */
	CFBamRelationColPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamRelationColPKey primary key value for this instance.
	 */
	void setPKey( CFBamRelationColPKey value );

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required long attribute TenantId.
	 *
	 *	@return	The required long attribute TenantId.
	 */
	long getRequiredTenantId();

	/**
	 *	Get the required long attribute RelationId.
	 *
	 *	@return	The required long attribute RelationId.
	 */
	long getRequiredRelationId();

	/**
	 *	Get the required long attribute Id.
	 *
	 *	@return	The required long attribute Id.
	 */
	long getRequiredId();

	/**
	 *	Get the optional Long attribute DefSchemaTenantId.
	 *
	 *	@return	The optional Long attribute DefSchemaTenantId.
	 */
	Long getOptionalDefSchemaTenantId();

	/**
	 *	Get the optional Long attribute DefSchemaId.
	 *
	 *	@return	The optional Long attribute DefSchemaId.
	 */
	Long getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the required long attribute FromColId.
	 *
	 *	@return	The required long attribute FromColId.
	 */
	long getRequiredFromColId();

	/**
	 *	Get the required long attribute ToColId.
	 *
	 *	@return	The required long attribute ToColId.
	 */
	long getRequiredToColId();

	/**
	 *	Get the optional Long attribute PrevTenantId.
	 *
	 *	@return	The optional Long attribute PrevTenantId.
	 */
	Long getOptionalPrevTenantId();

	/**
	 *	Get the optional Long attribute PrevId.
	 *
	 *	@return	The optional Long attribute PrevId.
	 */
	Long getOptionalPrevId();

	/**
	 *	Get the optional Long attribute NextTenantId.
	 *
	 *	@return	The optional Long attribute NextTenantId.
	 */
	Long getOptionalNextTenantId();

	/**
	 *	Get the optional Long attribute NextId.
	 *
	 *	@return	The optional Long attribute NextId.
	 */
	Long getOptionalNextId();

	/**
	 *	Get the required ICFBamRelationObj instance referenced by the Relation key.
	 *
	 *	@return	The required ICFBamRelationObj instance referenced by the Relation key.
	 */
	ICFBamRelationObj getRequiredContainerRelation();

	/**
	 *	Get the required ICFBamRelationObj instance referenced by the Relation key.
	 *
	 *	@return	The required ICFBamRelationObj instance referenced by the Relation key.
	 */
	ICFBamRelationObj getRequiredContainerRelation( boolean forceRead );

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the optional ICFBamRelationColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamRelationColObj instance referenced by the Prev key.
	 */
	ICFBamRelationColObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamRelationColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamRelationColObj instance referenced by the Prev key.
	 */
	ICFBamRelationColObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamRelationColObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamRelationColObj instance referenced by the Next key.
	 */
	ICFBamRelationColObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamRelationColObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamRelationColObj instance referenced by the Next key.
	 */
	ICFBamRelationColObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required ICFBamIndexColObj instance referenced by the FromCol key.
	 *
	 *	@return	The required ICFBamIndexColObj instance referenced by the FromCol key.
	 */
	ICFBamIndexColObj getRequiredLookupFromCol();

	/**
	 *	Get the required ICFBamIndexColObj instance referenced by the FromCol key.
	 *
	 *	@return	The required ICFBamIndexColObj instance referenced by the FromCol key.
	 */
	ICFBamIndexColObj getRequiredLookupFromCol( boolean forceRead );

	/**
	 *	Get the required ICFBamIndexColObj instance referenced by the ToCol key.
	 *
	 *	@return	The required ICFBamIndexColObj instance referenced by the ToCol key.
	 */
	ICFBamIndexColObj getRequiredLookupToCol();

	/**
	 *	Get the required ICFBamIndexColObj instance referenced by the ToCol key.
	 *
	 *	@return	The required ICFBamIndexColObj instance referenced by the ToCol key.
	 */
	ICFBamIndexColObj getRequiredLookupToCol( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

	ICFBamSubProjectObj getProject();
	ICFBamTopDomainObj getCompany();
	ICFBamSchemaDefObj getSchemaDef();
	ICFBamMinorVersionObj getVersion();
	String getVersionString();
	String getPackedVersionString();
	Boolean isColumnInOwnerRelation();

}
