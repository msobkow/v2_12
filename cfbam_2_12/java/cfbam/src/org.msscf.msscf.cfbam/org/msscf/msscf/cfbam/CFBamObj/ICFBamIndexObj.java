// Description: Java 11 Object interface for CFBam Index.

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

public interface ICFBamIndexObj
	extends ICFBamScopeObj
{
	/**
	 *	Get the current edition of this Index instance as a ICFBamIndexEditObj.
	 *
	 *	@return	The ICFBamIndexEditObj edition of this instance.
	 */
	ICFBamIndexEditObj getEditAsIndex();

	/**
	 *	Get the ICFBamIndexTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamIndexTableObj table cache which manages this instance.
	 */
	ICFBamIndexTableObj getIndexTable();

	/**
	 *	Get the CFBamIndexBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamIndexBuff instance which currently backs this object.
	 */
	CFBamIndexBuff getIndexBuff();

	/**
	 *	Get the required long attribute TableId.
	 *
	 *	@return	The required long attribute TableId.
	 */
	long getRequiredTableId();

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
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute Suffix.
	 *
	 *	@return	The optional String attribute Suffix.
	 */
	String getOptionalSuffix();

	/**
	 *	Get the required boolean attribute IsUnique.
	 *
	 *	@return	The required boolean attribute IsUnique.
	 */
	boolean getRequiredIsUnique();

	/**
	 *	Get the required boolean attribute IsDbMapped.
	 *
	 *	@return	The required boolean attribute IsDbMapped.
	 */
	boolean getRequiredIsDbMapped();

	/**
	 *	Get the required ICFBamTableObj instance referenced by the Table key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the Table key.
	 */
	ICFBamTableObj getRequiredContainerTable();

	/**
	 *	Get the required ICFBamTableObj instance referenced by the Table key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the Table key.
	 */
	ICFBamTableObj getRequiredContainerTable( boolean forceRead );

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
	 *	Get the array of optional ICFBamIndexColObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamIndexColObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamIndexColObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional ICFBamIndexColObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamIndexColObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamIndexColObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the IdxTenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the IdxTenant key.
	 */
	ICFSecTenantObj getRequiredOwnerIdxTenant();

	/**
	 *	Get the required ICFSecTenantObj instance referenced by the IdxTenant key.
	 *
	 *	@return	The required ICFSecTenantObj instance referenced by the IdxTenant key.
	 */
	ICFSecTenantObj getRequiredOwnerIdxTenant( boolean forceRead );

}
