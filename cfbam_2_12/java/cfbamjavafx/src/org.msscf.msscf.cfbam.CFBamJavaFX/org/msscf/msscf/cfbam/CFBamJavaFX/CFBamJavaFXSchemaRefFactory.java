// Description: Java 11 JavaFX Display Element Factory for SchemaRef.

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

package org.msscf.msscf.cfbam.CFBamJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/**
 *	CFBamJavaFXSchemaRefFactory JavaFX Display Element Factory
 *	for SchemaRef.
 */
public class CFBamJavaFXSchemaRefFactory
implements ICFBamJavaFXSchemaRefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXSchemaRefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamSchemaRefObj argFocus ) {
		CFBamJavaFXSchemaRefAttrPane retnew = new CFBamJavaFXSchemaRefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamSchemaDefObj argContainer,
		ICFBamSchemaRefObj argFocus,
		Collection<ICFBamSchemaRefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXSchemaRefListPane retnew = new CFBamJavaFXSchemaRefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamSchemaRefObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamSchemaRefObj> argDataCollection,
		ICFBamJavaFXSchemaRefChosen whenChosen )
	{
		CFBamJavaFXSchemaRefPickerPane retnew = new CFBamJavaFXSchemaRefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamSchemaRefObj argFocus ) {
		CFBamJavaFXSchemaRefEltTabPane retnew = new CFBamJavaFXSchemaRefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamSchemaRefObj argFocus ) {
		CFBamJavaFXSchemaRefAddPane retnew = new CFBamJavaFXSchemaRefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamSchemaRefObj argFocus ) {
		CFBamJavaFXSchemaRefViewEditPane retnew = new CFBamJavaFXSchemaRefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamSchemaRefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXSchemaRefAskDeleteForm retnew = new CFBamJavaFXSchemaRefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamSchemaRefObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamSchemaRefObj> argDataCollection,
		ICFBamJavaFXSchemaRefChosen whenChosen )
	{
		CFBamJavaFXSchemaRefPickerForm retnew = new CFBamJavaFXSchemaRefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamSchemaRefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXSchemaRefAddForm retnew = new CFBamJavaFXSchemaRefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamSchemaRefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXSchemaRefViewEditForm retnew = new CFBamJavaFXSchemaRefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
