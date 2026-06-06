// Description: Java 11 JavaFX Element TabPane implementation for TextDef.

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
 *	CFBamJavaFXTextDefEltTabPane JavaFX Element TabPane implementation
 *	for TextDef.
 */
public class CFBamJavaFXTextDefEltTabPane
extends CFTabPane
implements ICFBamJavaFXTextDefPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabChildrenRefTableColList = "Optional Children Referencing Table Columns";
	protected CFTab tabChildrenRefTableCol = null;
	public final String LABEL_TabChildrenRefIndexColList = "Optional Children Referencing Index Columns";
	protected CFTab tabChildrenRefIndexCol = null;
	protected CFBorderPane tabViewChildrenRefTableColListPane = null;
	protected CFBorderPane tabViewChildrenRefIndexColListPane = null;

	public CFBamJavaFXTextDefEltTabPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamTextDefObj argFocus ) {
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
		setJavaFXFocusAsTextDef( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabChildrenRefTableCol = new CFTab();
		tabChildrenRefTableCol.setText( LABEL_TabChildrenRefTableColList );
		tabChildrenRefTableCol.setContent( getTabViewChildrenRefTableColListPane() );
		getTabs().add( tabChildrenRefTableCol );
		tabChildrenRefIndexCol = new CFTab();
		tabChildrenRefIndexCol.setText( LABEL_TabChildrenRefIndexColList );
		tabChildrenRefIndexCol.setContent( getTabViewChildrenRefIndexColListPane() );
		getTabs().add( tabChildrenRefIndexCol );
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
		if( ( value == null ) || ( value instanceof ICFBamTextDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTextDefObj" );
		}
	}

	public void setJavaFXFocusAsTextDef( ICFBamTextDefObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamTextDefObj getJavaFXFocusAsTextDef() {
		return( (ICFBamTextDefObj)getJavaFXFocus() );
	}

	protected class RefreshChildrenRefTableColList
	implements ICFRefreshCallback
	{
		public RefreshChildrenRefTableColList() {
		}

		public void refreshMe() {
			Collection<ICFBamTableColObj> dataCollection;
			ICFBamTextDefObj focus = (ICFBamTextDefObj)getJavaFXFocusAsTextDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenRefTableCol( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewChildrenRefTableColListPane();
			ICFBamJavaFXTableColPaneList jpList = (ICFBamJavaFXTableColPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewChildrenRefTableColListPane() {
		if( tabViewChildrenRefTableColListPane == null ) {
			ICFBamTextDefObj focus = (ICFBamTextDefObj)getJavaFXFocusAsTextDef();
			Collection<ICFBamTableColObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenRefTableCol( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamTableObj ) ) {
				javafxContainer = (ICFBamTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenRefTableColListPane = javafxSchema.getTableColFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshChildrenRefTableColList(), false );
		}
		return( tabViewChildrenRefTableColListPane );
	}

	protected class RefreshChildrenRefIndexColList
	implements ICFRefreshCallback
	{
		public RefreshChildrenRefIndexColList() {
		}

		public void refreshMe() {
			Collection<ICFBamIndexColObj> dataCollection;
			ICFBamTextDefObj focus = (ICFBamTextDefObj)getJavaFXFocusAsTextDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenRefIndexCol( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewChildrenRefIndexColListPane();
			ICFBamJavaFXIndexColPaneList jpList = (ICFBamJavaFXIndexColPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewChildrenRefIndexColListPane() {
		if( tabViewChildrenRefIndexColListPane == null ) {
			ICFBamTextDefObj focus = (ICFBamTextDefObj)getJavaFXFocusAsTextDef();
			Collection<ICFBamIndexColObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenRefIndexCol( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamIndexObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamIndexObj ) ) {
				javafxContainer = (ICFBamIndexObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenRefIndexColListPane = javafxSchema.getIndexColFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshChildrenRefIndexColList(), false );
		}
		return( tabViewChildrenRefIndexColListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewChildrenRefTableColListPane != null ) {
			((ICFBamJavaFXTableColPaneCommon)tabViewChildrenRefTableColListPane).setPaneMode( value );
		}
		if( tabViewChildrenRefIndexColListPane != null ) {
			((ICFBamJavaFXIndexColPaneCommon)tabViewChildrenRefIndexColListPane).setPaneMode( value );
		}
	}
}
