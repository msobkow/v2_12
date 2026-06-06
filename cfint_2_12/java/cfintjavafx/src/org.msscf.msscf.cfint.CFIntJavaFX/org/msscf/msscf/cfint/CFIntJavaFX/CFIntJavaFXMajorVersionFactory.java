// Description: Java 11 JavaFX Display Element Factory for MajorVersion.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/**
 *	CFIntJavaFXMajorVersionFactory JavaFX Display Element Factory
 *	for MajorVersion.
 */
public class CFIntJavaFXMajorVersionFactory
implements ICFIntJavaFXMajorVersionFactory
{
	protected ICFIntJavaFXSchema javafxSchema = null;

	public CFIntJavaFXMajorVersionFactory( ICFIntJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFIntMajorVersionObj argFocus ) {
		CFIntJavaFXMajorVersionAttrPane retnew = new CFIntJavaFXMajorVersionAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFIntSubProjectObj argContainer,
		ICFIntMajorVersionObj argFocus,
		Collection<ICFIntMajorVersionObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFIntJavaFXMajorVersionListPane retnew = new CFIntJavaFXMajorVersionListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFIntMajorVersionObj argFocus,
		ICFIntSubProjectObj argContainer,
		Collection<ICFIntMajorVersionObj> argDataCollection,
		ICFIntJavaFXMajorVersionChosen whenChosen )
	{
		CFIntJavaFXMajorVersionPickerPane retnew = new CFIntJavaFXMajorVersionPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFIntMajorVersionObj argFocus ) {
		CFIntJavaFXMajorVersionEltTabPane retnew = new CFIntJavaFXMajorVersionEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFIntMajorVersionObj argFocus ) {
		CFIntJavaFXMajorVersionAddPane retnew = new CFIntJavaFXMajorVersionAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFIntMajorVersionObj argFocus ) {
		CFIntJavaFXMajorVersionViewEditPane retnew = new CFIntJavaFXMajorVersionViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFIntMajorVersionObj argFocus, ICFDeleteCallback callback ) {
		CFIntJavaFXMajorVersionAskDeleteForm retnew = new CFIntJavaFXMajorVersionAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFIntMajorVersionObj argFocus,
		ICFIntSubProjectObj argContainer,
		Collection<ICFIntMajorVersionObj> argDataCollection,
		ICFIntJavaFXMajorVersionChosen whenChosen )
	{
		CFIntJavaFXMajorVersionPickerForm retnew = new CFIntJavaFXMajorVersionPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFIntMajorVersionObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFIntJavaFXMajorVersionAddForm retnew = new CFIntJavaFXMajorVersionAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFIntMajorVersionObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFIntJavaFXMajorVersionViewEditForm retnew = new CFIntJavaFXMajorVersionViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
