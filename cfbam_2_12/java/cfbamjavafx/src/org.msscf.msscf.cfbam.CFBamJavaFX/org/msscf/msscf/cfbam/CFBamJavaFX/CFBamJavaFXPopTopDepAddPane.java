// Description: Java 11 JavaFX Add Pane implementation for PopTopDep.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfbam.CFBamJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
 *	CFBamJavaFXPopTopDepAddPane JavaFX Add Pane implementation
 *	for PopTopDep.
 */
public class CFBamJavaFXPopTopDepAddPane
extends CFSplitPane
implements ICFBamJavaFXPopTopDepPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected ScrollPane attrScrollPane = null;
	protected CFGridPane attrPane = null;

	public CFBamJavaFXPopTopDepAddPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamPopTopDepObj argFocus ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( formManager == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		cfFormManager = formManager;
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argSchema" );
		}
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		setJavaFXFocus( argFocus );
		attrPane = argSchema.getPopTopDepFactory().newAttrPane( cfFormManager, argFocus );
		attrScrollPane = new ScrollPane( attrPane );
		attrScrollPane.setFitToWidth( true );
		attrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
		attrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
		attrScrollPane.setContent( attrPane );
		setOrientation( Orientation.VERTICAL );
		getItems().add( attrScrollPane );
	}

	public ICFFormManager getCFFormManager() {
		return( cfFormManager );
	}

	public void setCFFormManager( ICFFormManager value ) {
		final String S_ProcName = "setCFFormManager";
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		cfFormManager = value;
	}

	public ICFBamJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public ICFLibAnyObj getJavaFXFocus() {
		ICFLibAnyObj obj;
		if( attrPane != null ) {
			obj = attrPane.getJavaFXFocus();
		}
		else {
			obj = null;
		}
		return( obj );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamPopTopDepObj ) ) {
			super.setJavaFXFocus( value );
			if( ( attrPane != null ) && ( attrPane.getJavaFXFocus() != value ) ) {
				attrPane.setJavaFXFocus( value );
			}
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamPopTopDepObj" );
		}
	}

	public void setJavaFXFocusAsPopTopDep( ICFBamPopTopDepObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamPopTopDepObj getJavaFXFocusAsPopTopDep() {
		return( (ICFBamPopTopDepObj)getJavaFXFocus() );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldValue = getPaneMode();
		if( value == oldValue ) {
			return;
		}
		try {
			super.setPaneMode( value );
			((ICFBamJavaFXPopTopDepPaneCommon)attrPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldValue );
			((ICFBamJavaFXPopTopDepPaneCommon)attrPane).setPaneMode( oldValue );
			throw t;
		}
	}
}
