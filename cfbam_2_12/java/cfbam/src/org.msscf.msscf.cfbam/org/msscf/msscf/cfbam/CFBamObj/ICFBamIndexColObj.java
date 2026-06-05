// Description: Java 11 Object interface for CFBam IndexCol.

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

public interface ICFBamIndexColObj
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
	 *	Realise this instance of a IndexCol.
	 *
	 *	@return	CFBamIndexColObj instance which should be subsequently referenced.
	 */
	ICFBamIndexColObj realise();

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
	 *	@return	ICFBamIndexColObj the reference to the cached or read (realised) instance.
	 */
	ICFBamIndexColObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFBamIndexColObj the reference to the cached or read (realised) instance.
	 */
	ICFBamIndexColObj read( boolean forceRead );

	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamIndexColObj the reference to the moved and refreshed instance.
	 */
	ICFBamIndexColObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamIndexColObj the reference to the moved and refreshed instance.
	 */
	ICFBamIndexColObj moveDown();

	/**
	 *	Initialize and return a locked edition of this IndexCol instance.
	 *
	 *	@return	The newly locked ICFBamIndexColEditObj edition of this instance.
	 */
	ICFBamIndexColEditObj beginEdit();

	/**
	 *	End this edition of this IndexCol instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this IndexCol instance.
	 *
	 *	@return	The ICFBamIndexColEditObj edition of this instance.
	 */
	ICFBamIndexColEditObj getEdit();

	/**
	 *	Get the current edition of this IndexCol instance as a ICFBamIndexColEditObj.
	 *
	 *	@return	The ICFBamIndexColEditObj edition of this instance.
	 */
	ICFBamIndexColEditObj getEditAsIndexCol();

	/**
	 *	Get the ICFBamIndexColTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamIndexColTableObj table cache which manages this instance.
	 */
	ICFBamIndexColTableObj getIndexColTable();

	/**
	 *	Get the ICFBamSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaObj schema cache which manages this instance.
	 */
	ICFBamSchemaObj getSchema();

	/**
	 *	Get the CFBamIndexColBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamIndexColBuff instance which currently backs this object.
	 */
	CFBamIndexColBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFBamIndexColBuff value );

	/**
	 *	Get the CFBamIndexColBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamIndexColBuff instance which currently backs this object.
	 */
	CFBamIndexColBuff getIndexColBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFBamIndexColPKey primary key for this instance.
	 */
	CFBamIndexColPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFBamIndexColPKey primary key value for this instance.
	 */
	void setPKey( CFBamIndexColPKey value );

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
	 *	Get the required long attribute IndexId.
	 *
	 *	@return	The required long attribute IndexId.
	 */
	long getRequiredIndexId();

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
	 *	Get the required long attribute ColumnId.
	 *
	 *	@return	The required long attribute ColumnId.
	 */
	long getRequiredColumnId();

	/**
	 *	Get the required boolean attribute IsAscending.
	 *
	 *	@return	The required boolean attribute IsAscending.
	 */
	boolean getRequiredIsAscending();

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
	 *	Get the required ICFBamIndexObj instance referenced by the Index key.
	 *
	 *	@return	The required ICFBamIndexObj instance referenced by the Index key.
	 */
	ICFBamIndexObj getRequiredContainerIndex();

	/**
	 *	Get the required ICFBamIndexObj instance referenced by the Index key.
	 *
	 *	@return	The required ICFBamIndexObj instance referenced by the Index key.
	 */
	ICFBamIndexObj getRequiredContainerIndex( boolean forceRead );

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
	 *	Get the array of optional ICFBamRelationColObj array of instances referenced by the RefRelFromCol key.
	 *
	 *	@return	The optional ICFBamRelationColObj[] array of instances referenced by the RefRelFromCol key.
	 */
	List<ICFBamRelationColObj> getOptionalChildrenRefRelFromCol();

	/**
	 *	Get the array of optional ICFBamRelationColObj array of instances referenced by the RefRelFromCol key.
	 *
	 *	@return	The optional ICFBamRelationColObj[] array of instances referenced by the RefRelFromCol key.
	 */
	List<ICFBamRelationColObj> getOptionalChildrenRefRelFromCol( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamRelationColObj array of instances referenced by the RefRelToCol key.
	 *
	 *	@return	The optional ICFBamRelationColObj[] array of instances referenced by the RefRelToCol key.
	 */
	List<ICFBamRelationColObj> getOptionalChildrenRefRelToCol();

	/**
	 *	Get the array of optional ICFBamRelationColObj array of instances referenced by the RefRelToCol key.
	 *
	 *	@return	The optional ICFBamRelationColObj[] array of instances referenced by the RefRelToCol key.
	 */
	List<ICFBamRelationColObj> getOptionalChildrenRefRelToCol( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamIndexColObj instance referenced by the Prev key.
	 */
	ICFBamIndexColObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamIndexColObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamIndexColObj instance referenced by the Prev key.
	 */
	ICFBamIndexColObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamIndexColObj instance referenced by the Next key.
	 */
	ICFBamIndexColObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamIndexColObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamIndexColObj instance referenced by the Next key.
	 */
	ICFBamIndexColObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required ICFBamValueObj instance referenced by the Column key.
	 *
	 *	@return	The required ICFBamValueObj instance referenced by the Column key.
	 */
	ICFBamValueObj getRequiredLookupColumn();

	/**
	 *	Get the required ICFBamValueObj instance referenced by the Column key.
	 *
	 *	@return	The required ICFBamValueObj instance referenced by the Column key.
	 */
	ICFBamValueObj getRequiredLookupColumn( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
