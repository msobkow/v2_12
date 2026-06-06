// Description: Java 11 JavaFX Display Element Factory for Int64Def.

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
 *	CFBamJavaFXInt64DefFactory JavaFX Display Element Factory
 *	for Int64Def.
 */
public class CFBamJavaFXInt64DefFactory
implements ICFBamJavaFXInt64DefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXInt64DefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamInt64DefObj argFocus ) {
		CFBamJavaFXInt64DefAttrPane retnew = new CFBamJavaFXInt64DefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamInt64DefObj argFocus,
		Collection<ICFBamInt64DefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXInt64DefListPane retnew = new CFBamJavaFXInt64DefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamInt64DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamInt64DefObj> argDataCollection,
		ICFBamJavaFXInt64DefChosen whenChosen )
	{
		CFBamJavaFXInt64DefPickerPane retnew = new CFBamJavaFXInt64DefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamInt64DefObj argFocus ) {
		CFBamJavaFXInt64DefEltTabPane retnew = new CFBamJavaFXInt64DefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamInt64DefObj argFocus ) {
		CFBamJavaFXInt64DefAddPane retnew = new CFBamJavaFXInt64DefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamInt64DefObj argFocus ) {
		CFBamJavaFXInt64DefViewEditPane retnew = new CFBamJavaFXInt64DefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamInt64DefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXInt64DefAskDeleteForm retnew = new CFBamJavaFXInt64DefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamInt64DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamInt64DefObj> argDataCollection,
		ICFBamJavaFXInt64DefChosen whenChosen )
	{
		CFBamJavaFXInt64DefPickerForm retnew = new CFBamJavaFXInt64DefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamInt64DefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXInt64DefAddForm retnew = new CFBamJavaFXInt64DefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamInt64DefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXInt64DefViewEditForm retnew = new CFBamJavaFXInt64DefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
