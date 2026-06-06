// Description: Java 11 JavaFX Display Element Factory for NmTokenCol.

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
 *	CFBamJavaFXNmTokenColFactory JavaFX Display Element Factory
 *	for NmTokenCol.
 */
public class CFBamJavaFXNmTokenColFactory
implements ICFBamJavaFXNmTokenColFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXNmTokenColFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamNmTokenColObj argFocus ) {
		CFBamJavaFXNmTokenColAttrPane retnew = new CFBamJavaFXNmTokenColAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamNmTokenColObj argFocus,
		Collection<ICFBamNmTokenColObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXNmTokenColListPane retnew = new CFBamJavaFXNmTokenColListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamNmTokenColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamNmTokenColObj> argDataCollection,
		ICFBamJavaFXNmTokenColChosen whenChosen )
	{
		CFBamJavaFXNmTokenColPickerPane retnew = new CFBamJavaFXNmTokenColPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamNmTokenColObj argFocus ) {
		CFBamJavaFXNmTokenColEltTabPane retnew = new CFBamJavaFXNmTokenColEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamNmTokenColObj argFocus ) {
		CFBamJavaFXNmTokenColAddPane retnew = new CFBamJavaFXNmTokenColAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamNmTokenColObj argFocus ) {
		CFBamJavaFXNmTokenColViewEditPane retnew = new CFBamJavaFXNmTokenColViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamNmTokenColObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXNmTokenColAskDeleteForm retnew = new CFBamJavaFXNmTokenColAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamNmTokenColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamNmTokenColObj> argDataCollection,
		ICFBamJavaFXNmTokenColChosen whenChosen )
	{
		CFBamJavaFXNmTokenColPickerForm retnew = new CFBamJavaFXNmTokenColPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamNmTokenColObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXNmTokenColAddForm retnew = new CFBamJavaFXNmTokenColAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamNmTokenColObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXNmTokenColViewEditForm retnew = new CFBamJavaFXNmTokenColViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
