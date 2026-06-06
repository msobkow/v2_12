// Description: Java 11 JavaFX Display Element Factory for TZTimestampDef.

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
 *	CFBamJavaFXTZTimestampDefFactory JavaFX Display Element Factory
 *	for TZTimestampDef.
 */
public class CFBamJavaFXTZTimestampDefFactory
implements ICFBamJavaFXTZTimestampDefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXTZTimestampDefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus ) {
		CFBamJavaFXTZTimestampDefAttrPane retnew = new CFBamJavaFXTZTimestampDefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamTZTimestampDefObj argFocus,
		Collection<ICFBamTZTimestampDefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXTZTimestampDefListPane retnew = new CFBamJavaFXTZTimestampDefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamTZTimestampDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamTZTimestampDefObj> argDataCollection,
		ICFBamJavaFXTZTimestampDefChosen whenChosen )
	{
		CFBamJavaFXTZTimestampDefPickerPane retnew = new CFBamJavaFXTZTimestampDefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus ) {
		CFBamJavaFXTZTimestampDefEltTabPane retnew = new CFBamJavaFXTZTimestampDefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus ) {
		CFBamJavaFXTZTimestampDefAddPane retnew = new CFBamJavaFXTZTimestampDefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus ) {
		CFBamJavaFXTZTimestampDefViewEditPane retnew = new CFBamJavaFXTZTimestampDefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXTZTimestampDefAskDeleteForm retnew = new CFBamJavaFXTZTimestampDefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamTZTimestampDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamTZTimestampDefObj> argDataCollection,
		ICFBamJavaFXTZTimestampDefChosen whenChosen )
	{
		CFBamJavaFXTZTimestampDefPickerForm retnew = new CFBamJavaFXTZTimestampDefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXTZTimestampDefAddForm retnew = new CFBamJavaFXTZTimestampDefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamTZTimestampDefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXTZTimestampDefViewEditForm retnew = new CFBamJavaFXTZTimestampDefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
