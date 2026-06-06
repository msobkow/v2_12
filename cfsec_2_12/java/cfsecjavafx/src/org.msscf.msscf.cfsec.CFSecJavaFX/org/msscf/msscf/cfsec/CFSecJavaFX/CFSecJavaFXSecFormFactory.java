// Description: Java 11 JavaFX Display Element Factory for SecForm.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;

/**
 *	CFSecJavaFXSecFormFactory JavaFX Display Element Factory
 *	for SecForm.
 */
public class CFSecJavaFXSecFormFactory
implements ICFSecJavaFXSecFormFactory
{
	protected ICFSecJavaFXSchema javafxSchema = null;

	public CFSecJavaFXSecFormFactory( ICFSecJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFSecSecFormObj argFocus ) {
		CFSecJavaFXSecFormAttrPane retnew = new CFSecJavaFXSecFormAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFSecSecAppObj argContainer,
		ICFSecSecFormObj argFocus,
		ICFSecJavaFXSecFormPageCallback argPageCallback,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFSecJavaFXSecFormListPane retnew = new CFSecJavaFXSecFormListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argPageCallback,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFSecSecFormObj argFocus,
		ICFSecSecAppObj argContainer,
		ICFSecJavaFXSecFormPageCallback argPageCallback,
		ICFSecJavaFXSecFormChosen whenChosen )
	{
		CFSecJavaFXSecFormPickerPane retnew = new CFSecJavaFXSecFormPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFSecSecFormObj argFocus ) {
		CFSecJavaFXSecFormEltTabPane retnew = new CFSecJavaFXSecFormEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFSecSecFormObj argFocus ) {
		CFSecJavaFXSecFormAddPane retnew = new CFSecJavaFXSecFormAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFSecSecFormObj argFocus ) {
		CFSecJavaFXSecFormViewEditPane retnew = new CFSecJavaFXSecFormViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFSecSecFormObj argFocus, ICFDeleteCallback callback ) {
		CFSecJavaFXSecFormAskDeleteForm retnew = new CFSecJavaFXSecFormAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFSecSecFormObj argFocus,
		ICFSecSecAppObj argContainer,
		ICFSecJavaFXSecFormPageCallback argPageCallback,
		ICFSecJavaFXSecFormChosen whenChosen )
	{
		CFSecJavaFXSecFormPickerForm retnew = new CFSecJavaFXSecFormPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argPageCallback,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFSecSecFormObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFSecJavaFXSecFormAddForm retnew = new CFSecJavaFXSecFormAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFSecSecFormObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFSecJavaFXSecFormViewEditForm retnew = new CFSecJavaFXSecFormViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
