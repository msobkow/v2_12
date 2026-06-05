// Description: Java 11 Object interface for CFBam Value.

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
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamValueObj
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
	 *	Realise this instance of a Value.
	 *
	 *	@return	CFBamValueObj instance which should be subsequently referenced.
	 */
	ICFBamValueObj realise();

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
	 *	@return	ICFBamValueObj the reference to the cached or read (realised) instance.
	 */
	ICFBamValueObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamValueObj the reference to the cached or read (realised) instance.
	 */
	ICFBamValueObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamValueObj the reference to the moved and refreshed instance.
	 */
	ICFBamValueObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamValueObj the reference to the moved and refreshed instance.
	 */
	ICFBamValueObj moveDown();

	/**
	 *	Initialize and return a locked edition of this Value instance.
	 *
	 *	@return	The newly locked ICFBamValueEditObj edition of this instance.
	 */
	ICFBamValueEditObj beginEdit();

	/**
	 *	End this edition of this Value instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Value instance.
	 *
	 *	@return	The ICFBamValueEditObj edition of this instance.
	 */
	ICFBamValueEditObj getEdit();

	/**
	 *	Get the current edition of this Value instance as a ICFBamValueEditObj.
	 *
	 *	@return	The ICFBamValueEditObj edition of this instance.
	 */
	ICFBamValueEditObj getEditAsValue();

	/**
	 *	Get the ICFBamValueTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamValueTableObj table cache which manages this instance.
	 */
	ICFBamValueTableObj getValueTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamValueBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamValueBuff instance which currently backs this object.
	 */
	CFBamValueBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamValueBuff value );

	/**
	 *	Get the CFBamValueBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamValueBuff instance which currently backs this object.
	 */
	CFBamValueBuff getValueBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamValuePKey primary key for this instance.
	 */
	CFBamValuePKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamValuePKey primary key value for this instance.
	 */
	void setPKey( CFBamValuePKey value );

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
	 *	Get the required long attribute ScopeId.
	 *
	 *	@return	The required long attribute ScopeId.
	 */
	long getRequiredScopeId();

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
	 *	Get the optional String attribute DefaultXmlValue.
	 *
	 *	@return	The optional String attribute DefaultXmlValue.
	 */
	String getOptionalDefaultXmlValue();

	/**
	 *	Get the required boolean attribute IsNullable.
	 *
	 *	@return	The required boolean attribute IsNullable.
	 */
	boolean getRequiredIsNullable();

	/**
	 *	Get the optional Boolean attribute GenerateId.
	 *
	 *	@return	The optional Boolean attribute GenerateId.
	 */
	Boolean getOptionalGenerateId();

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
	 *	Get the required ICFBamScopeObj instance referenced by the Scope key.
	 *
	 *	@return	The required ICFBamScopeObj instance referenced by the Scope key.
	 */
	ICFBamScopeObj getRequiredContainerScope();

	/**
	 *	Get the required ICFBamScopeObj instance referenced by the Scope key.
	 *
	 *	@return	The required ICFBamScopeObj instance referenced by the Scope key.
	 */
	ICFBamScopeObj getRequiredContainerScope( boolean forceRead );

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
	 *	Get the array of optional ICFBamTableColObj array of instances referenced by the RefTableCol key.
	 *
	 *	@return	The optional ICFBamTableColObj[] array of instances referenced by the RefTableCol key.
	 */
	List<ICFBamTableColObj> getOptionalChildrenRefTableCol();

	/**
	 *	Get the array of optional ICFBamTableColObj array of instances referenced by the RefTableCol key.
	 *
	 *	@return	The optional ICFBamTableColObj[] array of instances referenced by the RefTableCol key.
	 */
	List<ICFBamTableColObj> getOptionalChildrenRefTableCol( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamIndexColObj array of instances referenced by the RefIndexCol key.
	 *
	 *	@return	The optional ICFBamIndexColObj[] array of instances referenced by the RefIndexCol key.
	 */
	List<ICFBamIndexColObj> getOptionalChildrenRefIndexCol();

	/**
	 *	Get the array of optional ICFBamIndexColObj array of instances referenced by the RefIndexCol key.
	 *
	 *	@return	The optional ICFBamIndexColObj[] array of instances referenced by the RefIndexCol key.
	 */
	List<ICFBamIndexColObj> getOptionalChildrenRefIndexCol( boolean forceRead );

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Prev key.
	 */
	ICFBamValueObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Prev key.
	 */
	ICFBamValueObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Next key.
	 */
	ICFBamValueObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamValueObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamValueObj instance referenced by the Next key.
	 */
	ICFBamValueObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

	List<ICFBamIndexObj> getAffectedIndexes();
	List<ICFBamRelationObj> getAffectedRelations();
	List<ICFBamIndexObj> getAffectedUniqueIndexes();
	List<ICFBamRelationObj> getColumnInMemberRelations();
	List<ICFBamRelationObj> getColumnInComponentsRelations();
	boolean getGenerateId();

}
