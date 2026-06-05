// Description: Java 11 JavaFX Element TabPane implementation for PopSubDep2.

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
 *	CFBamJavaFXPopSubDep2EltTabPane JavaFX Element TabPane implementation
 *	for PopSubDep2.
 */
public class CFBamJavaFXPopSubDep2EltTabPane
extends CFTabPane
implements ICFBamJavaFXPopSubDep2PaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsPopDepList = "Optional Components Population Dependency";
	protected CFTab tabComponentsPopDep = null;
	protected CFBorderPane tabViewComponentsPopDepListPane = null;

	public CFBamJavaFXPopSubDep2EltTabPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamPopSubDep2Obj argFocus ) {
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
		setJavaFXFocusAsPopSubDep2( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsPopDep = new CFTab();
		tabComponentsPopDep.setText( LABEL_TabComponentsPopDepList );
		tabComponentsPopDep.setContent( getTabViewComponentsPopDepListPane() );
		getTabs().add( tabComponentsPopDep );
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
		if( ( value == null ) || ( value instanceof ICFBamPopSubDep2Obj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamPopSubDep2Obj" );
		}
	}

	public void setJavaFXFocusAsPopSubDep2( ICFBamPopSubDep2Obj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamPopSubDep2Obj getJavaFXFocusAsPopSubDep2() {
		return( (ICFBamPopSubDep2Obj)getJavaFXFocus() );
	}

	protected class RefreshComponentsPopDepList
	implements ICFRefreshCallback
	{
		public RefreshComponentsPopDepList() {
		}

		public void refreshMe() {
			Collection<ICFBamPopSubDep3Obj> dataCollection;
			ICFBamPopSubDep2Obj focus = (ICFBamPopSubDep2Obj)getJavaFXFocusAsPopSubDep2();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsPopDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsPopDepListPane();
			ICFBamJavaFXPopSubDep3PaneList jpList = (ICFBamJavaFXPopSubDep3PaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsPopDepListPane() {
		if( tabViewComponentsPopDepListPane == null ) {
			ICFBamPopSubDep2Obj focus = (ICFBamPopSubDep2Obj)getJavaFXFocusAsPopSubDep2();
			Collection<ICFBamPopSubDep3Obj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsPopDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamPopSubDep2Obj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamPopSubDep2Obj ) ) {
				javafxContainer = (ICFBamPopSubDep2Obj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsPopDepListPane = javafxSchema.getPopSubDep3Factory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsPopDepList(), false );
		}
		return( tabViewComponentsPopDepListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsPopDepListPane != null ) {
			((ICFBamJavaFXPopSubDep3PaneCommon)tabViewComponentsPopDepListPane).setPaneMode( value );
		}
	}
}
