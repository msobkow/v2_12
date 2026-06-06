// Description: Java 11 JavaFX Display Element Factory for TopDomain.

/*
 *	org.msscf.msscf.CFInt
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
 *	CFIntJavaFXTopDomainFactory JavaFX Display Element Factory
 *	for TopDomain.
 */
public class CFIntJavaFXTopDomainFactory
implements ICFIntJavaFXTopDomainFactory
{
	protected ICFIntJavaFXSchema javafxSchema = null;

	public CFIntJavaFXTopDomainFactory( ICFIntJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFIntTopDomainObj argFocus ) {
		CFIntJavaFXTopDomainAttrPane retnew = new CFIntJavaFXTopDomainAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFIntTldObj argContainer,
		ICFIntTopDomainObj argFocus,
		Collection<ICFIntTopDomainObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFIntJavaFXTopDomainListPane retnew = new CFIntJavaFXTopDomainListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFIntTopDomainObj argFocus,
		ICFIntTldObj argContainer,
		Collection<ICFIntTopDomainObj> argDataCollection,
		ICFIntJavaFXTopDomainChosen whenChosen )
	{
		CFIntJavaFXTopDomainPickerPane retnew = new CFIntJavaFXTopDomainPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFIntTopDomainObj argFocus ) {
		CFIntJavaFXTopDomainEltTabPane retnew = new CFIntJavaFXTopDomainEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFIntTopDomainObj argFocus ) {
		CFIntJavaFXTopDomainAddPane retnew = new CFIntJavaFXTopDomainAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFIntTopDomainObj argFocus ) {
		CFIntJavaFXTopDomainViewEditPane retnew = new CFIntJavaFXTopDomainViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFIntTopDomainObj argFocus, ICFDeleteCallback callback ) {
		CFIntJavaFXTopDomainAskDeleteForm retnew = new CFIntJavaFXTopDomainAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFIntTopDomainObj argFocus,
		ICFIntTldObj argContainer,
		Collection<ICFIntTopDomainObj> argDataCollection,
		ICFIntJavaFXTopDomainChosen whenChosen )
	{
		CFIntJavaFXTopDomainPickerForm retnew = new CFIntJavaFXTopDomainPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFIntTopDomainObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFIntJavaFXTopDomainAddForm retnew = new CFIntJavaFXTopDomainAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFIntTopDomainObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFIntJavaFXTopDomainViewEditForm retnew = new CFIntJavaFXTopDomainViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
