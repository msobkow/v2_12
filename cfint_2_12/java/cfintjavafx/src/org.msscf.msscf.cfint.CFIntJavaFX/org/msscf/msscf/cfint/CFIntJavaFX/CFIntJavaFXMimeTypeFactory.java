// Description: Java 11 JavaFX Display Element Factory for MimeType.

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
 *	CFIntJavaFXMimeTypeFactory JavaFX Display Element Factory
 *	for MimeType.
 */
public class CFIntJavaFXMimeTypeFactory
implements ICFIntJavaFXMimeTypeFactory
{
	protected ICFIntJavaFXSchema javafxSchema = null;

	public CFIntJavaFXMimeTypeFactory( ICFIntJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFIntMimeTypeObj argFocus ) {
		CFIntJavaFXMimeTypeAttrPane retnew = new CFIntJavaFXMimeTypeAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFLibAnyObj argContainer,
		ICFIntMimeTypeObj argFocus,
		Collection<ICFIntMimeTypeObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFIntJavaFXMimeTypeListPane retnew = new CFIntJavaFXMimeTypeListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFIntMimeTypeObj argFocus,
		ICFLibAnyObj argContainer,
		Collection<ICFIntMimeTypeObj> argDataCollection,
		ICFIntJavaFXMimeTypeChosen whenChosen )
	{
		CFIntJavaFXMimeTypePickerPane retnew = new CFIntJavaFXMimeTypePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFIntMimeTypeObj argFocus ) {
		CFIntJavaFXMimeTypeEltTabPane retnew = new CFIntJavaFXMimeTypeEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFIntMimeTypeObj argFocus ) {
		CFIntJavaFXMimeTypeAddPane retnew = new CFIntJavaFXMimeTypeAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFIntMimeTypeObj argFocus ) {
		CFIntJavaFXMimeTypeViewEditPane retnew = new CFIntJavaFXMimeTypeViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFIntMimeTypeObj argFocus, ICFDeleteCallback callback ) {
		CFIntJavaFXMimeTypeAskDeleteForm retnew = new CFIntJavaFXMimeTypeAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newFinderForm( ICFFormManager formManager ) {
		CFIntJavaFXMimeTypeFinderForm retnew = new CFIntJavaFXMimeTypeFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFIntMimeTypeObj argFocus,
		ICFLibAnyObj argContainer,
		Collection<ICFIntMimeTypeObj> argDataCollection,
		ICFIntJavaFXMimeTypeChosen whenChosen )
	{
		CFIntJavaFXMimeTypePickerForm retnew = new CFIntJavaFXMimeTypePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFIntMimeTypeObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFIntJavaFXMimeTypeAddForm retnew = new CFIntJavaFXMimeTypeAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFIntMimeTypeObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFIntJavaFXMimeTypeViewEditForm retnew = new CFIntJavaFXMimeTypeViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
