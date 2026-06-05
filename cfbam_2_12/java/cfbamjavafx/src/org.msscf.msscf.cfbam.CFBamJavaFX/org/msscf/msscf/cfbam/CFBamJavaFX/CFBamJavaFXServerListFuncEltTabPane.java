// Description: Java 11 JavaFX Element TabPane implementation for ServerListFunc.

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
 *	CFBamJavaFXServerListFuncEltTabPane JavaFX Element TabPane implementation
 *	for ServerListFunc.
 */
public class CFBamJavaFXServerListFuncEltTabPane
extends CFTabPane
implements ICFBamJavaFXServerListFuncPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsParamsList = "Optional Components Parameters";
	protected CFTab tabComponentsParams = null;
	protected CFBorderPane tabViewComponentsParamsListPane = null;

	public CFBamJavaFXServerListFuncEltTabPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamServerListFuncObj argFocus ) {
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
		setJavaFXFocusAsServerListFunc( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsParams = new CFTab();
		tabComponentsParams.setText( LABEL_TabComponentsParamsList );
		tabComponentsParams.setContent( getTabViewComponentsParamsListPane() );
		getTabs().add( tabComponentsParams );
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
		if( ( value == null ) || ( value instanceof ICFBamServerListFuncObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamServerListFuncObj" );
		}
	}

	public void setJavaFXFocusAsServerListFunc( ICFBamServerListFuncObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamServerListFuncObj getJavaFXFocusAsServerListFunc() {
		return( (ICFBamServerListFuncObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsParamsList
	implements ICFRefreshCallback
	{
		public RefreshComponentsParamsList() {
		}

		public void refreshMe() {
			Collection<ICFBamParamObj> dataCollection;
			ICFBamServerListFuncObj focus = (ICFBamServerListFuncObj)getJavaFXFocusAsServerListFunc();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsParams( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsParamsListPane();
			ICFBamJavaFXParamPaneList jpList = (ICFBamJavaFXParamPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsParamsListPane() {
		if( tabViewComponentsParamsListPane == null ) {
			ICFBamServerListFuncObj focus = (ICFBamServerListFuncObj)getJavaFXFocusAsServerListFunc();
			Collection<ICFBamParamObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsParams( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamServerMethodObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamServerMethodObj ) ) {
				javafxContainer = (ICFBamServerMethodObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsParamsListPane = javafxSchema.getParamFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsParamsList(), true );
		}
		return( tabViewComponentsParamsListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsParamsListPane != null ) {
			((ICFBamJavaFXParamPaneCommon)tabViewComponentsParamsListPane).setPaneMode( value );
		}
	}
}
