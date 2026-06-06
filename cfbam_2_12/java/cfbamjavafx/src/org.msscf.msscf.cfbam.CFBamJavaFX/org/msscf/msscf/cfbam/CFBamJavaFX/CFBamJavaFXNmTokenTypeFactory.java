// Description: Java 11 JavaFX Display Element Factory for NmTokenType.

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
 *	CFBamJavaFXNmTokenTypeFactory JavaFX Display Element Factory
 *	for NmTokenType.
 */
public class CFBamJavaFXNmTokenTypeFactory
implements ICFBamJavaFXNmTokenTypeFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXNmTokenTypeFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus ) {
		CFBamJavaFXNmTokenTypeAttrPane retnew = new CFBamJavaFXNmTokenTypeAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamSchemaDefObj argContainer,
		ICFBamNmTokenTypeObj argFocus,
		Collection<ICFBamNmTokenTypeObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXNmTokenTypeListPane retnew = new CFBamJavaFXNmTokenTypeListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamNmTokenTypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamNmTokenTypeObj> argDataCollection,
		ICFBamJavaFXNmTokenTypeChosen whenChosen )
	{
		CFBamJavaFXNmTokenTypePickerPane retnew = new CFBamJavaFXNmTokenTypePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus ) {
		CFBamJavaFXNmTokenTypeEltTabPane retnew = new CFBamJavaFXNmTokenTypeEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus ) {
		CFBamJavaFXNmTokenTypeAddPane retnew = new CFBamJavaFXNmTokenTypeAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus ) {
		CFBamJavaFXNmTokenTypeViewEditPane retnew = new CFBamJavaFXNmTokenTypeViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXNmTokenTypeAskDeleteForm retnew = new CFBamJavaFXNmTokenTypeAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamNmTokenTypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamNmTokenTypeObj> argDataCollection,
		ICFBamJavaFXNmTokenTypeChosen whenChosen )
	{
		CFBamJavaFXNmTokenTypePickerForm retnew = new CFBamJavaFXNmTokenTypePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXNmTokenTypeAddForm retnew = new CFBamJavaFXNmTokenTypeAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamNmTokenTypeObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXNmTokenTypeViewEditForm retnew = new CFBamJavaFXNmTokenTypeViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
