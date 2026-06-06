// Description: Java 11 JavaFX Display Element Factory for Int16Def.

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
 *	CFBamJavaFXInt16DefFactory JavaFX Display Element Factory
 *	for Int16Def.
 */
public class CFBamJavaFXInt16DefFactory
implements ICFBamJavaFXInt16DefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXInt16DefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamInt16DefObj argFocus ) {
		CFBamJavaFXInt16DefAttrPane retnew = new CFBamJavaFXInt16DefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamInt16DefObj argFocus,
		Collection<ICFBamInt16DefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXInt16DefListPane retnew = new CFBamJavaFXInt16DefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamInt16DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamInt16DefObj> argDataCollection,
		ICFBamJavaFXInt16DefChosen whenChosen )
	{
		CFBamJavaFXInt16DefPickerPane retnew = new CFBamJavaFXInt16DefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamInt16DefObj argFocus ) {
		CFBamJavaFXInt16DefEltTabPane retnew = new CFBamJavaFXInt16DefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamInt16DefObj argFocus ) {
		CFBamJavaFXInt16DefAddPane retnew = new CFBamJavaFXInt16DefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamInt16DefObj argFocus ) {
		CFBamJavaFXInt16DefViewEditPane retnew = new CFBamJavaFXInt16DefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamInt16DefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXInt16DefAskDeleteForm retnew = new CFBamJavaFXInt16DefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamInt16DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamInt16DefObj> argDataCollection,
		ICFBamJavaFXInt16DefChosen whenChosen )
	{
		CFBamJavaFXInt16DefPickerForm retnew = new CFBamJavaFXInt16DefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamInt16DefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXInt16DefAddForm retnew = new CFBamJavaFXInt16DefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamInt16DefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXInt16DefViewEditForm retnew = new CFBamJavaFXInt16DefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
