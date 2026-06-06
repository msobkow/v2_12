// Description: Java 13 JavaFX Display Element Factory for UInt32Type.

/*
 *  MSS Code Factory CFBam 2.12 Cust Editor
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


package org.msscf.msscf.cfbamcust.CFBamCustEditor;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.CFReferenceEditor.ICFReferenceCallback;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfsec.CFSecSaxLoader.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfint.CFIntSaxLoader.*;
import org.msscf.msscf.cfint.CFIntJavaFX.*;
import org.msscf.msscf.cfintcust.CFIntCust.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfbam.CFBamSaxLoader.*;
import org.msscf.msscf.cfbam.CFBamJavaFX.*;
import org.msscf.msscf.cfbam.CFBamMssCF.*;
import org.msscf.msscf.cfbam.CFBamRam.*;
import org.msscf.msscf.cfbamcust.MSSBamCF.*;
import org.msscf.msscf.cfbamcust.CFBamXmlLoader.*;
import org.msscf.msscf.cfbamcust.CFBamCust.*;

/**
 *	CFBamJavaFXUInt32TypeFactory JavaFX Display Element Factory
 *	for UInt32Type.
 */
public class CFBamCustEditorUInt32TypeFactory
extends CFBamJavaFXUInt32TypeFactory
{
	public CFBamCustEditorUInt32TypeFactory( ICFBamJavaFXSchema argSchema ) {
		super( argSchema );
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus ) {
		CFBamCustEditorUInt32TypeAttrPane retnew = new CFBamCustEditorUInt32TypeAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamSchemaDefObj argContainer,
		ICFBamUInt32TypeObj argFocus,
		Collection<ICFBamUInt32TypeObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXUInt32TypeListPane retnew = new CFBamJavaFXUInt32TypeListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamUInt32TypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamUInt32TypeObj> dataCollection,
		ICFBamJavaFXUInt32TypeChosen whenChosen )
	{
		CFBamJavaFXUInt32TypePickerPane retnew = new CFBamJavaFXUInt32TypePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			dataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus ) {
		CFBamJavaFXUInt32TypeEltTabPane retnew = new CFBamJavaFXUInt32TypeEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus ) {
		CFBamJavaFXUInt32TypeAddPane retnew = new CFBamJavaFXUInt32TypeAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus ) {
		CFBamJavaFXUInt32TypeViewEditPane retnew = new CFBamJavaFXUInt32TypeViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXUInt32TypeAskDeleteForm retnew = new CFBamJavaFXUInt32TypeAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamUInt32TypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamUInt32TypeObj> argDataCollection,
		ICFBamJavaFXUInt32TypeChosen whenChosen )
	{
		CFBamJavaFXUInt32TypePickerForm retnew = new CFBamJavaFXUInt32TypePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXUInt32TypeAddForm retnew = new CFBamJavaFXUInt32TypeAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamUInt32TypeObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamCustEditorUInt32TypeViewEditForm retnew = new CFBamCustEditorUInt32TypeViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
