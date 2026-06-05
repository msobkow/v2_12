// Description: Java 11 Object interface for CFBam SchemaRef.

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

public interface ICFBamSchemaRefObj
	extends ICFBamScopeObj
{
	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamSchemaRefObj the reference to the moved and refreshed instance.
	 */
	ICFBamSchemaRefObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamSchemaRefObj the reference to the moved and refreshed instance.
	 */
	ICFBamSchemaRefObj moveDown();

	/**
	 *	Get the current edition of this SchemaRef instance as a ICFBamSchemaRefEditObj.
	 *
	 *	@return	The ICFBamSchemaRefEditObj edition of this instance.
	 */
	ICFBamSchemaRefEditObj getEditAsSchemaRef();

	/**
	 *	Get the ICFBamSchemaRefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaRefTableObj table cache which manages this instance.
	 */
	ICFBamSchemaRefTableObj getSchemaRefTable();

	/**
	 *	Get the CFBamSchemaRefBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamSchemaRefBuff instance which currently backs this object.
	 */
	CFBamSchemaRefBuff getSchemaRefBuff();

	/**
	 *	Get the required long attribute SchemaId.
	 *
	 *	@return	The required long attribute SchemaId.
	 */
	long getRequiredSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required String attribute RefModelName.
	 *
	 *	@return	The required String attribute RefModelName.
	 */
	String getRequiredRefModelName();

	/**
	 *	Get the required String attribute IncludeRoot.
	 *
	 *	@return	The required String attribute IncludeRoot.
	 */
	String getRequiredIncludeRoot();

	/**
	 *	Get the optional Long attribute RefSchemaTenantId.
	 *
	 *	@return	The optional Long attribute RefSchemaTenantId.
	 */
	Long getOptionalRefSchemaTenantId();

	/**
	 *	Get the optional Long attribute RefSchemaId.
	 *
	 *	@return	The optional Long attribute RefSchemaId.
	 */
	Long getOptionalRefSchemaId();

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
	 *	Get the required ICFBamSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the Schema key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchema();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the Schema key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the Schema key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchema( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupRefSchema();

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the RefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupRefSchema( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj instance referenced by the Prev key.
	 */
	ICFBamSchemaRefObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamSchemaRefObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj instance referenced by the Prev key.
	 */
	ICFBamSchemaRefObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj instance referenced by the Next key.
	 */
	ICFBamSchemaRefObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamSchemaRefObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj instance referenced by the Next key.
	 */
	ICFBamSchemaRefObj getOptionalLookupNext( boolean forceRead );

}
