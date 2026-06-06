// Description: Java 11 JavaFX Display Element Factory for Int32Col.

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
 *	CFBamJavaFXInt32ColFactory JavaFX Display Element Factory
 *	for Int32Col.
 */
public class CFBamJavaFXInt32ColFactory
implements ICFBamJavaFXInt32ColFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXInt32ColFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamInt32ColObj argFocus ) {
		CFBamJavaFXInt32ColAttrPane retnew = new CFBamJavaFXInt32ColAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamInt32ColObj argFocus,
		Collection<ICFBamInt32ColObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXInt32ColListPane retnew = new CFBamJavaFXInt32ColListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamInt32ColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamInt32ColObj> argDataCollection,
		ICFBamJavaFXInt32ColChosen whenChosen )
	{
		CFBamJavaFXInt32ColPickerPane retnew = new CFBamJavaFXInt32ColPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamInt32ColObj argFocus ) {
		CFBamJavaFXInt32ColEltTabPane retnew = new CFBamJavaFXInt32ColEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamInt32ColObj argFocus ) {
		CFBamJavaFXInt32ColAddPane retnew = new CFBamJavaFXInt32ColAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamInt32ColObj argFocus ) {
		CFBamJavaFXInt32ColViewEditPane retnew = new CFBamJavaFXInt32ColViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamInt32ColObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXInt32ColAskDeleteForm retnew = new CFBamJavaFXInt32ColAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamInt32ColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamInt32ColObj> argDataCollection,
		ICFBamJavaFXInt32ColChosen whenChosen )
	{
		CFBamJavaFXInt32ColPickerForm retnew = new CFBamJavaFXInt32ColPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamInt32ColObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXInt32ColAddForm retnew = new CFBamJavaFXInt32ColAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamInt32ColObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXInt32ColViewEditForm retnew = new CFBamJavaFXInt32ColViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
