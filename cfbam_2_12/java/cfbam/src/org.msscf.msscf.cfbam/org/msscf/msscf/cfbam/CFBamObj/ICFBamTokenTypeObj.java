// Description: Java 11 Object interface for CFBam TokenType.

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
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamTokenTypeObj
	extends ICFBamTokenDefObj
{
	/**
	 *	Get the current edition of this TokenType instance as a ICFBamTokenTypeEditObj.
	 *
	 *	@return	The ICFBamTokenTypeEditObj edition of this instance.
	 */
	ICFBamTokenTypeEditObj getEditAsTokenType();

	/**
	 *	Get the ICFBamTokenTypeTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamTokenTypeTableObj table cache which manages this instance.
	 */
	ICFBamTokenTypeTableObj getTokenTypeTable();

	/**
	 *	Get the CFBamTokenTypeBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamTokenTypeBuff instance which currently backs this object.
	 */
	CFBamTokenTypeBuff getTokenTypeBuff();

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
