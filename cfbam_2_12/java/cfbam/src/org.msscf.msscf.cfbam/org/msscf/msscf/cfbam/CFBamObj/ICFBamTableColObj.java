// Description: Java 11 Object interface for CFBam TableCol.

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

public interface ICFBamTableColObj
	extends ICFBamValueObj
{
	/**
	 *	Get the current edition of this TableCol instance as a ICFBamTableColEditObj.
	 *
	 *	@return	The ICFBamTableColEditObj edition of this instance.
	 */
	ICFBamTableColEditObj getEditAsTableCol();

	/**
	 *	Get the ICFBamTableColTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamTableColTableObj table cache which manages this instance.
	 */
	ICFBamTableColTableObj getTableColTable();

	/**
	 *	Get the CFBamTableColBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamTableColBuff instance which currently backs this object.
	 */
	CFBamTableColBuff getTableColBuff();

	/**
	 *	Get the required long attribute TableId.
	 *
	 *	@return	The required long attribute TableId.
	 */
	long getRequiredTableId();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional Long attribute DataTenantId.
	 *
	 *	@return	The optional Long attribute DataTenantId.
	 */
	Long getOptionalDataTenantId();

	/**
	 *	Get the optional Long attribute DataId.
	 *
	 *	@return	The optional Long attribute DataId.
	 */
	Long getOptionalDataId();

	/**
	 *	Get the optional String attribute XmlElementName.
	 *
	 *	@return	The optional String attribute XmlElementName.
	 */
	String getOptionalXmlElementName();

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
	 *	Get the required ICFBamValueObj instance referenced by the DataType key.
	 *
	 *	@return	The required ICFBamValueObj instance referenced by the DataType key.
	 */
	ICFBamValueObj getRequiredParentDataType();

	/**
	 *	Get the required ICFBamValueObj instance referenced by the DataType key.
	 *
	 *	@return	The required ICFBamValueObj instance referenced by the DataType key.
	 */
	ICFBamValueObj getRequiredParentDataType( boolean forceRead );

}
