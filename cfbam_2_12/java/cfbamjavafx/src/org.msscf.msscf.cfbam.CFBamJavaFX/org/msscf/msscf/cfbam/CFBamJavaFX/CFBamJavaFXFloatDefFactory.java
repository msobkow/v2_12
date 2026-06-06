// Description: Java 11 JavaFX Display Element Factory for FloatDef.

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
 *	CFBamJavaFXFloatDefFactory JavaFX Display Element Factory
 *	for FloatDef.
 */
public class CFBamJavaFXFloatDefFactory
implements ICFBamJavaFXFloatDefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXFloatDefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamFloatDefObj argFocus ) {
		CFBamJavaFXFloatDefAttrPane retnew = new CFBamJavaFXFloatDefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamFloatDefObj argFocus,
		Collection<ICFBamFloatDefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXFloatDefListPane retnew = new CFBamJavaFXFloatDefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamFloatDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamFloatDefObj> argDataCollection,
		ICFBamJavaFXFloatDefChosen whenChosen )
	{
		CFBamJavaFXFloatDefPickerPane retnew = new CFBamJavaFXFloatDefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamFloatDefObj argFocus ) {
		CFBamJavaFXFloatDefEltTabPane retnew = new CFBamJavaFXFloatDefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamFloatDefObj argFocus ) {
		CFBamJavaFXFloatDefAddPane retnew = new CFBamJavaFXFloatDefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamFloatDefObj argFocus ) {
		CFBamJavaFXFloatDefViewEditPane retnew = new CFBamJavaFXFloatDefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamFloatDefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXFloatDefAskDeleteForm retnew = new CFBamJavaFXFloatDefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamFloatDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamFloatDefObj> argDataCollection,
		ICFBamJavaFXFloatDefChosen whenChosen )
	{
		CFBamJavaFXFloatDefPickerForm retnew = new CFBamJavaFXFloatDefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamFloatDefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXFloatDefAddForm retnew = new CFBamJavaFXFloatDefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamFloatDefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXFloatDefViewEditForm retnew = new CFBamJavaFXFloatDefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
