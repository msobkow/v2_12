// Description: Java 13 JavaFX Element TabPane implementation for Table.

/*
 *  MSS Code Factory CFBam 2.12 Cust Editor
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
 */


package org.msscf.msscf.cfbamcust.CFBamCustEditor;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
 *	CFBamJavaFXTableEltTabPane JavaFX Element TabPane implementation
 *	for Table.
 */
public class CFBamCustEditorTableEltTabPane
extends CFTabPane
implements ICFBamJavaFXTablePaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsRelationList = "Optional Components Relation Definitions";
	protected CFTab tabComponentsRelation = null;
	public final String LABEL_TabComponentsIndexList = "Optional Components Index Definitions";
	protected CFTab tabComponentsIndex = null;
	public final String LABEL_TabComponentsColumnsList = "Optional Components Columns";
	protected CFTab tabComponentsColumns = null;
	public final String LABEL_TabComponentsChainsList = "Optional Components Chains";
	protected CFTab tabComponentsChains = null;
	public final String LABEL_TabComponentsDelDepList = "Optional Components Deletion Dependency";
	protected CFTab tabComponentsDelDep = null;
	public final String LABEL_TabComponentsClearDepList = "Optional Components Clear Relationships Dependency";
	protected CFTab tabComponentsClearDep = null;
	public final String LABEL_TabComponentsServerMethodsList = "Optional Components Server Methods";
	protected CFTab tabComponentsServerMethods = null;
	protected CFBorderPane tabViewComponentsRelationListPane = null;
	protected CFBorderPane tabViewComponentsIndexListPane = null;
	protected CFBorderPane tabViewComponentsColumnsListPane = null;
	protected CFBorderPane tabViewComponentsChainsListPane = null;
	protected CFBorderPane tabViewComponentsDelDepListPane = null;
	protected CFBorderPane tabViewComponentsClearDepListPane = null;
	protected CFBorderPane tabViewComponentsServerMethodsListPane = null;

	public CFBamCustEditorTableEltTabPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamTableObj argFocus ) {
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
		setJavaFXFocusAsTable( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsRelation = new CFTab();
		tabComponentsRelation.setText( LABEL_TabComponentsRelationList );
		tabComponentsRelation.setContent( getTabViewComponentsRelationListPane() );
		getTabs().add( tabComponentsRelation );
		tabComponentsIndex = new CFTab();
		tabComponentsIndex.setText( LABEL_TabComponentsIndexList );
		tabComponentsIndex.setContent( getTabViewComponentsIndexListPane() );
		getTabs().add( tabComponentsIndex );
		tabComponentsColumns = new CFTab();
		tabComponentsColumns.setText( LABEL_TabComponentsColumnsList );
		tabComponentsColumns.setContent( getTabViewComponentsColumnsListPane() );
		getTabs().add( tabComponentsColumns );
		tabComponentsChains = new CFTab();
		tabComponentsChains.setText( LABEL_TabComponentsChainsList );
		tabComponentsChains.setContent( getTabViewComponentsChainsListPane() );
		getTabs().add( tabComponentsChains );
		tabComponentsDelDep = new CFTab();
		tabComponentsDelDep.setText( LABEL_TabComponentsDelDepList );
		tabComponentsDelDep.setContent( getTabViewComponentsDelDepListPane() );
		getTabs().add( tabComponentsDelDep );
		tabComponentsClearDep = new CFTab();
		tabComponentsClearDep.setText( LABEL_TabComponentsClearDepList );
		tabComponentsClearDep.setContent( getTabViewComponentsClearDepListPane() );
		getTabs().add( tabComponentsClearDep );
		tabComponentsServerMethods = new CFTab();
		tabComponentsServerMethods.setText( LABEL_TabComponentsServerMethodsList );
		tabComponentsServerMethods.setContent( getTabViewComponentsServerMethodsListPane() );
		getTabs().add( tabComponentsServerMethods );
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
		if( ( value == null ) || ( value instanceof ICFBamTableObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTableObj" );
		}
	}

	public void setJavaFXFocusAsTable( ICFBamTableObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamTableObj getJavaFXFocusAsTable() {
		return( (ICFBamTableObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsRelationList
	implements ICFRefreshCallback
	{
		public RefreshComponentsRelationList() {
		}

		public void refreshMe() {
			Collection<ICFBamRelationObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRelation( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsRelationListPane();
			ICFBamJavaFXRelationPaneList jpList = (ICFBamJavaFXRelationPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsRelationListPane() {
		if( tabViewComponentsRelationListPane == null ) {
			Collection<ICFBamRelationObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRelation( javafxIsInitializing );
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
			tabViewComponentsRelationListPane = javafxSchema.getRelationFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsRelationList(), false );
		}
		return( tabViewComponentsRelationListPane );
	}

	protected class RefreshComponentsIndexList
	implements ICFRefreshCallback
	{
		public RefreshComponentsIndexList() {
		}

		public void refreshMe() {
			Collection<ICFBamIndexObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsIndex( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsIndexListPane();
			ICFBamJavaFXIndexPaneList jpList = (ICFBamJavaFXIndexPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsIndexListPane() {
		if( tabViewComponentsIndexListPane == null ) {
			Collection<ICFBamIndexObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsIndex( javafxIsInitializing );
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
			tabViewComponentsIndexListPane = javafxSchema.getIndexFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsIndexList(), false );
		}
		return( tabViewComponentsIndexListPane );
	}

	protected class RefreshComponentsColumnsList
	implements ICFRefreshCallback
	{
		public RefreshComponentsColumnsList() {
		}

		public void refreshMe() {
			Collection<ICFBamValueObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsColumnsListPane();
			ICFBamJavaFXValuePaneList jpList = (ICFBamJavaFXValuePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsColumnsListPane() {
		if( tabViewComponentsColumnsListPane == null ) {
			Collection<ICFBamValueObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamScopeObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamScopeObj ) ) {
				javafxContainer = (ICFBamScopeObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsColumnsListPane = javafxSchema.getValueFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsColumnsList(), true );
		}
		return( tabViewComponentsColumnsListPane );
	}

	protected class RefreshComponentsChainsList
	implements ICFRefreshCallback
	{
		public RefreshComponentsChainsList() {
		}

		public void refreshMe() {
			Collection<ICFBamChainObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsChains( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsChainsListPane();
			ICFBamJavaFXChainPaneList jpList = (ICFBamJavaFXChainPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsChainsListPane() {
		if( tabViewComponentsChainsListPane == null ) {
			Collection<ICFBamChainObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsChains( javafxIsInitializing );
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
			tabViewComponentsChainsListPane = javafxSchema.getChainFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsChainsList(), false );
		}
		return( tabViewComponentsChainsListPane );
	}

	protected class RefreshComponentsDelDepList
	implements ICFRefreshCallback
	{
		public RefreshComponentsDelDepList() {
		}

		public void refreshMe() {
			Collection<ICFBamDelTopDepObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsDelDepListPane();
			ICFBamJavaFXDelTopDepPaneList jpList = (ICFBamJavaFXDelTopDepPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsDelDepListPane() {
		if( tabViewComponentsDelDepListPane == null ) {
			Collection<ICFBamDelTopDepObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( javafxIsInitializing );
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
			tabViewComponentsDelDepListPane = javafxSchema.getDelTopDepFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsDelDepList(), true );
		}
		return( tabViewComponentsDelDepListPane );
	}

	protected class RefreshComponentsClearDepList
	implements ICFRefreshCallback
	{
		public RefreshComponentsClearDepList() {
		}

		public void refreshMe() {
			Collection<ICFBamClearTopDepObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsClearDepListPane();
			ICFBamJavaFXClearTopDepPaneList jpList = (ICFBamJavaFXClearTopDepPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsClearDepListPane() {
		if( tabViewComponentsClearDepListPane == null ) {
			Collection<ICFBamClearTopDepObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( javafxIsInitializing );
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
			tabViewComponentsClearDepListPane = javafxSchema.getClearTopDepFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsClearDepList(), true );
		}
		return( tabViewComponentsClearDepListPane );
	}

	protected class RefreshComponentsServerMethodsList
	implements ICFRefreshCallback
	{
		public RefreshComponentsServerMethodsList() {
		}

		public void refreshMe() {
			Collection<ICFBamServerMethodObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsServerMethods( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsServerMethodsListPane();
			ICFBamJavaFXServerMethodPaneList jpList = (ICFBamJavaFXServerMethodPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsServerMethodsListPane() {
		if( tabViewComponentsServerMethodsListPane == null ) {
			Collection<ICFBamServerMethodObj> dataCollection;
			ICFBamTableObj focus = (ICFBamTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsServerMethods( javafxIsInitializing );
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
			tabViewComponentsServerMethodsListPane = javafxSchema.getServerMethodFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsServerMethodsList(), false );
		}
		return( tabViewComponentsServerMethodsListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsRelationListPane != null ) {
			((ICFBamJavaFXRelationPaneCommon)tabViewComponentsRelationListPane).setPaneMode( value );
		}
		if( tabViewComponentsIndexListPane != null ) {
			((ICFBamJavaFXIndexPaneCommon)tabViewComponentsIndexListPane).setPaneMode( value );
		}
		if( tabViewComponentsColumnsListPane != null ) {
			((ICFBamJavaFXValuePaneCommon)tabViewComponentsColumnsListPane).setPaneMode( value );
		}
		if( tabViewComponentsChainsListPane != null ) {
			((ICFBamJavaFXChainPaneCommon)tabViewComponentsChainsListPane).setPaneMode( value );
		}
		if( tabViewComponentsDelDepListPane != null ) {
			((ICFBamJavaFXDelTopDepPaneCommon)tabViewComponentsDelDepListPane).setPaneMode( value );
		}
		if( tabViewComponentsClearDepListPane != null ) {
			((ICFBamJavaFXClearTopDepPaneCommon)tabViewComponentsClearDepListPane).setPaneMode( value );
		}
		if( tabViewComponentsServerMethodsListPane != null ) {
			((ICFBamJavaFXServerMethodPaneCommon)tabViewComponentsServerMethodsListPane).setPaneMode( value );
		}
	}
}
