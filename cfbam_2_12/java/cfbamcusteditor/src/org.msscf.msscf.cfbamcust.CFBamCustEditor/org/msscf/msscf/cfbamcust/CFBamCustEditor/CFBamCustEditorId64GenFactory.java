// Description: Java 13 JavaFX Display Element Factory for Id64Gen.

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
 *	CFBamJavaFXId64GenFactory JavaFX Display Element Factory
 *	for Id64Gen.
 */
public class CFBamCustEditorId64GenFactory
extends CFBamJavaFXId64GenFactory
{
	public CFBamCustEditorId64GenFactory( ICFBamJavaFXSchema argSchema ) {
		super( argSchema );
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamId64GenObj argFocus ) {
		CFBamCustEditorId64GenAttrPane retnew = new CFBamCustEditorId64GenAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamSchemaDefObj argContainer,
		ICFBamId64GenObj argFocus,
		Collection<ICFBamId64GenObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXId64GenListPane retnew = new CFBamJavaFXId64GenListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamId64GenObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamId64GenObj> dataCollection,
		ICFBamJavaFXId64GenChosen whenChosen )
	{
		CFBamJavaFXId64GenPickerPane retnew = new CFBamJavaFXId64GenPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			dataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamId64GenObj argFocus ) {
		CFBamJavaFXId64GenEltTabPane retnew = new CFBamJavaFXId64GenEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamId64GenObj argFocus ) {
		CFBamJavaFXId64GenAddPane retnew = new CFBamJavaFXId64GenAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamId64GenObj argFocus ) {
		CFBamJavaFXId64GenViewEditPane retnew = new CFBamJavaFXId64GenViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamId64GenObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXId64GenAskDeleteForm retnew = new CFBamJavaFXId64GenAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamId64GenObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamId64GenObj> argDataCollection,
		ICFBamJavaFXId64GenChosen whenChosen )
	{
		CFBamJavaFXId64GenPickerForm retnew = new CFBamJavaFXId64GenPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamId64GenObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXId64GenAddForm retnew = new CFBamJavaFXId64GenAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamId64GenObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamCustEditorId64GenViewEditForm retnew = new CFBamCustEditorId64GenViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
