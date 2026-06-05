// Description: Java 11 Object interface for CFBam EnumType.

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

public interface ICFBamEnumTypeObj
	extends ICFBamEnumDefObj
{
	/**
	 *	Get the current edition of this EnumType instance as a ICFBamEnumTypeEditObj.
	 *
	 *	@return	The ICFBamEnumTypeEditObj edition of this instance.
	 */
	ICFBamEnumTypeEditObj getEditAsEnumType();

	/**
	 *	Get the ICFBamEnumTypeTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamEnumTypeTableObj table cache which manages this instance.
	 */
	ICFBamEnumTypeTableObj getEnumTypeTable();

	/**
	 *	Get the CFBamEnumTypeBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamEnumTypeBuff instance which currently backs this object.
	 */
	CFBamEnumTypeBuff getEnumTypeBuff();

	/**
	 *	Get the required long attribute SchemaDefId.
	 *
	 *	@return	The required long attribute SchemaDefId.
	 */
	long getRequiredSchemaDefId();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

}
