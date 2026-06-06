// Description: Java 11 JavaFX Display Element Factory for TokenCol.

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
 *	CFBamJavaFXTokenColFactory JavaFX Display Element Factory
 *	for TokenCol.
 */
public class CFBamJavaFXTokenColFactory
implements ICFBamJavaFXTokenColFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXTokenColFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamTokenColObj argFocus ) {
		CFBamJavaFXTokenColAttrPane retnew = new CFBamJavaFXTokenColAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamTokenColObj argFocus,
		Collection<ICFBamTokenColObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXTokenColListPane retnew = new CFBamJavaFXTokenColListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamTokenColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamTokenColObj> argDataCollection,
		ICFBamJavaFXTokenColChosen whenChosen )
	{
		CFBamJavaFXTokenColPickerPane retnew = new CFBamJavaFXTokenColPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamTokenColObj argFocus ) {
		CFBamJavaFXTokenColEltTabPane retnew = new CFBamJavaFXTokenColEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamTokenColObj argFocus ) {
		CFBamJavaFXTokenColAddPane retnew = new CFBamJavaFXTokenColAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamTokenColObj argFocus ) {
		CFBamJavaFXTokenColViewEditPane retnew = new CFBamJavaFXTokenColViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamTokenColObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXTokenColAskDeleteForm retnew = new CFBamJavaFXTokenColAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamTokenColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamTokenColObj> argDataCollection,
		ICFBamJavaFXTokenColChosen whenChosen )
	{
		CFBamJavaFXTokenColPickerForm retnew = new CFBamJavaFXTokenColPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamTokenColObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXTokenColAddForm retnew = new CFBamJavaFXTokenColAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamTokenColObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXTokenColViewEditForm retnew = new CFBamJavaFXTokenColViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
