// Description: Java 11 JavaFX Element TabPane implementation for ClearTopDep.

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
import java.util.List;
import javafx.scene.Parent;
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
 *	CFBamJavaFXClearTopDepEltTabPane JavaFX Element TabPane implementation
 *	for ClearTopDep.
 */
public class CFBamJavaFXClearTopDepEltTabPane
extends CFTabPane
implements ICFBamJavaFXClearTopDepPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsClearDepList = "Optional Components Clear Dependency";
	protected CFTab tabComponentsClearDep = null;
	protected CFBorderPane tabViewComponentsClearDepListPane = null;

	public CFBamJavaFXClearTopDepEltTabPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamClearTopDepObj argFocus ) {
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
		setJavaFXFocusAsClearTopDep( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsClearDep = new CFTab();
		tabComponentsClearDep.setText( LABEL_TabComponentsClearDepList );
		tabComponentsClearDep.setContent( getTabViewComponentsClearDepListPane() );
		getTabs().add( tabComponentsClearDep );
		javafxIsInitializing = false;
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

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamClearTopDepObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamClearTopDepObj" );
		}
	}

	public void setJavaFXFocusAsClearTopDep( ICFBamClearTopDepObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamClearTopDepObj getJavaFXFocusAsClearTopDep() {
		return( (ICFBamClearTopDepObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsClearDepList
	implements ICFRefreshCallback
	{
		public RefreshComponentsClearDepList() {
		}

		public void refreshMe() {
			Collection<ICFBamClearSubDep1Obj> dataCollection;
			ICFBamClearTopDepObj focus = (ICFBamClearTopDepObj)getJavaFXFocusAsClearTopDep();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsClearDepListPane();
			ICFBamJavaFXClearSubDep1PaneList jpList = (ICFBamJavaFXClearSubDep1PaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsClearDepListPane() {
		if( tabViewComponentsClearDepListPane == null ) {
			ICFBamClearTopDepObj focus = (ICFBamClearTopDepObj)getJavaFXFocusAsClearTopDep();
			Collection<ICFBamClearSubDep1Obj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamClearTopDepObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamClearTopDepObj ) ) {
				javafxContainer = (ICFBamClearTopDepObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsClearDepListPane = javafxSchema.getClearSubDep1Factory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsClearDepList(), false );
		}
		return( tabViewComponentsClearDepListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsClearDepListPane != null ) {
			((ICFBamJavaFXClearSubDep1PaneCommon)tabViewComponentsClearDepListPane).setPaneMode( value );
		}
	}
}
