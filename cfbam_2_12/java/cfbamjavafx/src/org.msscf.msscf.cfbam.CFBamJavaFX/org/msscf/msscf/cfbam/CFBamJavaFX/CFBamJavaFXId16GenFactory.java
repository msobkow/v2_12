// Description: Java 11 JavaFX Display Element Factory for Id16Gen.

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
 *	CFBamJavaFXId16GenFactory JavaFX Display Element Factory
 *	for Id16Gen.
 */
public class CFBamJavaFXId16GenFactory
implements ICFBamJavaFXId16GenFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXId16GenFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamId16GenObj argFocus ) {
		CFBamJavaFXId16GenAttrPane retnew = new CFBamJavaFXId16GenAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamSchemaDefObj argContainer,
		ICFBamId16GenObj argFocus,
		Collection<ICFBamId16GenObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXId16GenListPane retnew = new CFBamJavaFXId16GenListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamId16GenObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamId16GenObj> argDataCollection,
		ICFBamJavaFXId16GenChosen whenChosen )
	{
		CFBamJavaFXId16GenPickerPane retnew = new CFBamJavaFXId16GenPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamId16GenObj argFocus ) {
		CFBamJavaFXId16GenEltTabPane retnew = new CFBamJavaFXId16GenEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamId16GenObj argFocus ) {
		CFBamJavaFXId16GenAddPane retnew = new CFBamJavaFXId16GenAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamId16GenObj argFocus ) {
		CFBamJavaFXId16GenViewEditPane retnew = new CFBamJavaFXId16GenViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamId16GenObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXId16GenAskDeleteForm retnew = new CFBamJavaFXId16GenAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamId16GenObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamId16GenObj> argDataCollection,
		ICFBamJavaFXId16GenChosen whenChosen )
	{
		CFBamJavaFXId16GenPickerForm retnew = new CFBamJavaFXId16GenPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamId16GenObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXId16GenAddForm retnew = new CFBamJavaFXId16GenAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamId16GenObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXId16GenViewEditForm retnew = new CFBamJavaFXId16GenViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
