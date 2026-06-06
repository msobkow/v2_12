// Description: Java 11 JavaFX List of Obj Pane implementation for Table.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamJavaFX;

import java.math.*;
import java.util.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfint.CFIntJavaFX.*;

/**
 *	CFBamJavaFXTableListPane JavaFX List of Obj Pane implementation
 *	for Table.
 */
public class CFBamJavaFXTableListPane
extends CFBorderPane
implements ICFBamJavaFXTablePaneList
{
	public static String S_FormName = "List Table";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTableObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTableObj> observableListOfTable = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected CFButton buttonAddTable = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFBamTableObj> dataTable = null;
	protected TableColumn<ICFBamTableObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnName = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamTableObj, Boolean> tableColumnPageData = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnTableClassCode = null;
	protected TableColumn<ICFBamTableObj, Boolean> tableColumnIsInstantiable = null;
	protected TableColumn<ICFBamTableObj, Boolean> tableColumnHasHistory = null;
	protected TableColumn<ICFBamTableObj, Boolean> tableColumnHasAuditColumns = null;
	protected TableColumn<ICFBamTableObj, ICFBamSchema.LoaderBehaviourEnum> tableColumnLoaderBehaviour = null;
	protected TableColumn<ICFBamTableObj, ICFBamSchema.SecScopeEnum> tableColumnSecScope = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJObjImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJEditObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJEditObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJEditObjImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJEditObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableObjImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJTableObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJDb2LUWTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJDb2LUWTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJDb2LUWTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJMSSqlTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJMSSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJMSSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJMySqlTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJMySqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJMySqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJOracleTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJOracleTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJOracleTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJPgSqlTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJPgSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJPgSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJRamTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJRamTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJRamTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJSaxLoaderImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJSaxLoaderStartElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJSaxLoaderEndElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgTableFormatters = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgRqstTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgRspnTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgClientTableImport = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgRqstTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgRspnTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnJXMsgClientTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppObjInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppEditObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppEditObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppEditObjInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppEditObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableObjInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppTableObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppDb2LUWTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppDb2LUWTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppDb2LUWTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppMSSqlTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppMSSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppMSSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppMySqlTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppMySqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppMySqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppOracleTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppOracleTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppOracleTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppPgSqlTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppPgSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppPgSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppRamTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppRamTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppRamTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppSaxLoaderInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppSaxLoaderStartElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppSaxLoaderEndElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgTableFormatters = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgRqstTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgRspnTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgClientTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgRqstTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgRspnTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCppXMsgClientTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppObjInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppEditObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppEditObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppEditObjInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppEditObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableObjInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppTableObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppDb2LUWTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppDb2LUWTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppDb2LUWTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppMSSqlTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppMSSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppMSSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppMySqlTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppMySqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppMySqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppOracleTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppOracleTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppOracleTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppPgSqlTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppPgSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppPgSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppRamTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppRamTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppRamTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppSaxLoaderInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppSaxLoaderStartElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppSaxLoaderEndElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgTableFormatters = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgRqstTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgRspnTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgClientTableInclude = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgRqstTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgRspnTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnHppXMsgClientTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsObjUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsEditObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsEditObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsEditObjUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsEditObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableObjUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableObjMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableObjInterface = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsTableObjImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsDb2LUWTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsDb2LUWTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsDb2LUWTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsMSSqlTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsMSSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsMSSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsMySqlTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsMySqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsMySqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsOracleTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsOracleTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsOracleTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsPgSqlTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsPgSqlTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsPgSqlTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsRamTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsRamTableMembers = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsRamTableImplementation = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsSaxLoaderUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsSaxLoaderStartElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsSaxLoaderEndElement = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgTableFormatters = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgRqstTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgRspnTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgClientTableUsing = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgRqstTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgRspnTableBody = null;
	protected TableColumn<ICFBamTableObj, String> tableColumnCsXMsgClientTableBody = null;
	protected TableColumn<ICFBamTableObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<ICFBamTableObj, ICFBamIndexObj> tableColumnLookupLookupIndex = null;
	protected TableColumn<ICFBamTableObj, ICFBamIndexObj> tableColumnLookupAltIndex = null;
	protected TableColumn<ICFBamTableObj, ICFBamTableObj> tableColumnLookupQualTable = null;
	protected TableColumn<ICFBamTableObj, ICFBamIndexObj> tableColumnLookupPrimaryIndex = null;

	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected ICFBamSchemaDefObj javafxContainer = null;
	protected ICFRefreshCallback javafxRefreshCallback = null;
	class ViewEditClosedCallback implements ICFFormClosedCallback {
		public ViewEditClosedCallback() {
		}

		@Override
		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected ViewEditClosedCallback viewEditClosedCallback = null;

	public ICFFormClosedCallback getViewEditClosedCallback() {
		if( viewEditClosedCallback == null ) {
			viewEditClosedCallback = new ViewEditClosedCallback();
		}
		return( viewEditClosedCallback );
	}

	class DeleteCallback implements ICFDeleteCallback {
		public DeleteCallback() {
		}
		@Override
		public void deleted( ICFLibAnyObj deletedObject ) {
			if( deletedObject != null ) {
				refreshMe();
			}
		}

		@Override
		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected DeleteCallback deleteCallback = null;

	public ICFDeleteCallback getDeleteCallback() {
		if( deleteCallback == null ) {
			deleteCallback = new DeleteCallback();
		}
		return( deleteCallback );
	}


	public CFBamJavaFXTableListPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamSchemaDefObj argContainer,
		ICFBamTableObj argFocus,
		Collection<ICFBamTableObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
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
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		javafxRefreshCallback = refreshCallback;
		javafxSortByChain = sortByChain;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<ICFBamTableObj>();
		tableColumnId = new TableColumn<ICFBamTableObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamTableObj, Long> p ) {
				ICFBamScopeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					long value = obj.getRequiredId();
					Long wrapped = Long.valueOf( value );
					ReadOnlyObjectWrapper<Long> observable = new ReadOnlyObjectWrapper<Long>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTableObj,Long>,TableCell<ICFBamTableObj,Long>>() {
			@Override public TableCell<ICFBamTableObj,Long> call(
				TableColumn<ICFBamTableObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTableObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDbName = new TableColumn<ICFBamTableObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDbName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnShortName = new TableColumn<ICFBamTableObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalShortName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTableObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalLabel();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTableObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalShortDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTableObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnPageData = new TableColumn<ICFBamTableObj,Boolean>( "PageData" );
		tableColumnPageData.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTableObj, Boolean> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredPageData();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnPageData.setCellFactory( new Callback<TableColumn<ICFBamTableObj,Boolean>,TableCell<ICFBamTableObj,Boolean>>() {
			@Override public TableCell<ICFBamTableObj,Boolean> call(
				TableColumn<ICFBamTableObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPageData );
		tableColumnTableClassCode = new TableColumn<ICFBamTableObj,String>( "Table Class Code" );
		tableColumnTableClassCode.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredTableClassCode();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnTableClassCode.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTableClassCode );
		tableColumnIsInstantiable = new TableColumn<ICFBamTableObj,Boolean>( "Is Instantiable" );
		tableColumnIsInstantiable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTableObj, Boolean> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsInstantiable();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsInstantiable.setCellFactory( new Callback<TableColumn<ICFBamTableObj,Boolean>,TableCell<ICFBamTableObj,Boolean>>() {
			@Override public TableCell<ICFBamTableObj,Boolean> call(
				TableColumn<ICFBamTableObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsInstantiable );
		tableColumnHasHistory = new TableColumn<ICFBamTableObj,Boolean>( "Has History" );
		tableColumnHasHistory.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTableObj, Boolean> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredHasHistory();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnHasHistory.setCellFactory( new Callback<TableColumn<ICFBamTableObj,Boolean>,TableCell<ICFBamTableObj,Boolean>>() {
			@Override public TableCell<ICFBamTableObj,Boolean> call(
				TableColumn<ICFBamTableObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHasHistory );
		tableColumnHasAuditColumns = new TableColumn<ICFBamTableObj,Boolean>( "Has Audit Columns" );
		tableColumnHasAuditColumns.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTableObj, Boolean> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredHasAuditColumns();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnHasAuditColumns.setCellFactory( new Callback<TableColumn<ICFBamTableObj,Boolean>,TableCell<ICFBamTableObj,Boolean>>() {
			@Override public TableCell<ICFBamTableObj,Boolean> call(
				TableColumn<ICFBamTableObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHasAuditColumns );
		tableColumnLoaderBehaviour = new TableColumn<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum>( "Loader Behaviour" );
		tableColumnLoaderBehaviour.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum>,ObservableValue<ICFBamSchema.LoaderBehaviourEnum> >() {
			public ObservableValue<ICFBamSchema.LoaderBehaviourEnum> call( CellDataFeatures<ICFBamTableObj, ICFBamSchema.LoaderBehaviourEnum> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamSchema.LoaderBehaviourEnum value = obj.getRequiredLoaderBehaviour();
					ReadOnlyObjectWrapper<ICFBamSchema.LoaderBehaviourEnum> observable = new ReadOnlyObjectWrapper<ICFBamSchema.LoaderBehaviourEnum>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnLoaderBehaviour.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum>,TableCell<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum> call(
				TableColumn<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum> arg)
			{
				return new CFEnumTableCell<ICFBamTableObj,ICFBamSchema.LoaderBehaviourEnum>();
			}
		});
		dataTable.getColumns().add( tableColumnLoaderBehaviour );
		tableColumnSecScope = new TableColumn<ICFBamTableObj,ICFBamSchema.SecScopeEnum>( "Security Scope" );
		tableColumnSecScope.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamSchema.SecScopeEnum>,ObservableValue<ICFBamSchema.SecScopeEnum> >() {
			public ObservableValue<ICFBamSchema.SecScopeEnum> call( CellDataFeatures<ICFBamTableObj, ICFBamSchema.SecScopeEnum> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamSchema.SecScopeEnum value = obj.getRequiredSecScope();
					ReadOnlyObjectWrapper<ICFBamSchema.SecScopeEnum> observable = new ReadOnlyObjectWrapper<ICFBamSchema.SecScopeEnum>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSecScope.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamSchema.SecScopeEnum>,TableCell<ICFBamTableObj,ICFBamSchema.SecScopeEnum>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamSchema.SecScopeEnum> call(
				TableColumn<ICFBamTableObj,ICFBamSchema.SecScopeEnum> arg)
			{
				return new CFEnumTableCell<ICFBamTableObj,ICFBamSchema.SecScopeEnum>();
			}
		});
		dataTable.getColumns().add( tableColumnSecScope );
		tableColumnJObjMembers = new TableColumn<ICFBamTableObj,String>( "JObjMembers" );
		tableColumnJObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJObjMembers );
		tableColumnJObjInterface = new TableColumn<ICFBamTableObj,String>( "JObjInterface" );
		tableColumnJObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJObjInterface );
		tableColumnJObjImport = new TableColumn<ICFBamTableObj,String>( "JObjImport" );
		tableColumnJObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJObjImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJObjImport );
		tableColumnJObjImplementation = new TableColumn<ICFBamTableObj,String>( "JObjImplementation" );
		tableColumnJObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJObjImplementation );
		tableColumnJEditObjMembers = new TableColumn<ICFBamTableObj,String>( "JEditObjMembers" );
		tableColumnJEditObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJEditObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJEditObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJEditObjMembers );
		tableColumnJEditObjInterface = new TableColumn<ICFBamTableObj,String>( "JEditObjInterface" );
		tableColumnJEditObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJEditObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJEditObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJEditObjInterface );
		tableColumnJEditObjImport = new TableColumn<ICFBamTableObj,String>( "JEditObjImport" );
		tableColumnJEditObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJEditObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJEditObjImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJEditObjImport );
		tableColumnJEditObjImplementation = new TableColumn<ICFBamTableObj,String>( "JEditObjImplementation" );
		tableColumnJEditObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJEditObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJEditObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJEditObjImplementation );
		tableColumnJTableImport = new TableColumn<ICFBamTableObj,String>( "JTableImport" );
		tableColumnJTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableImport );
		tableColumnJTableMembers = new TableColumn<ICFBamTableObj,String>( "JTableMembers" );
		tableColumnJTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableMembers );
		tableColumnJTableInterface = new TableColumn<ICFBamTableObj,String>( "JTableInterface" );
		tableColumnJTableInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableInterface );
		tableColumnJTableImplementation = new TableColumn<ICFBamTableObj,String>( "JTableImplementation" );
		tableColumnJTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableImplementation );
		tableColumnJTableObjImport = new TableColumn<ICFBamTableObj,String>( "JTableObjImport" );
		tableColumnJTableObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableObjImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableObjImport );
		tableColumnJTableObjMembers = new TableColumn<ICFBamTableObj,String>( "JTableObjMembers" );
		tableColumnJTableObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableObjMembers );
		tableColumnJTableObjInterface = new TableColumn<ICFBamTableObj,String>( "JTableObjInterface" );
		tableColumnJTableObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableObjInterface );
		tableColumnJTableObjImplementation = new TableColumn<ICFBamTableObj,String>( "JTableObjImplementation" );
		tableColumnJTableObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJTableObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJTableObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJTableObjImplementation );
		tableColumnJDb2LUWTableImport = new TableColumn<ICFBamTableObj,String>( "JDb2LUWTableImport" );
		tableColumnJDb2LUWTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJDb2LUWTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJDb2LUWTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJDb2LUWTableImport );
		tableColumnJDb2LUWTableMembers = new TableColumn<ICFBamTableObj,String>( "JDb2LUWTableMembers" );
		tableColumnJDb2LUWTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJDb2LUWTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJDb2LUWTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJDb2LUWTableMembers );
		tableColumnJDb2LUWTableImplementation = new TableColumn<ICFBamTableObj,String>( "JDb2LUWTableImplementation" );
		tableColumnJDb2LUWTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJDb2LUWTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJDb2LUWTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJDb2LUWTableImplementation );
		tableColumnJMSSqlTableImport = new TableColumn<ICFBamTableObj,String>( "JMSSqlTableImport" );
		tableColumnJMSSqlTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMSSqlTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMSSqlTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMSSqlTableImport );
		tableColumnJMSSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "JMSSqlTableMembers" );
		tableColumnJMSSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMSSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMSSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMSSqlTableMembers );
		tableColumnJMSSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "JMSSqlTableImplementation" );
		tableColumnJMSSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMSSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMSSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMSSqlTableImplementation );
		tableColumnJMySqlTableImport = new TableColumn<ICFBamTableObj,String>( "JMySqlTableImport" );
		tableColumnJMySqlTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMySqlTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMySqlTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMySqlTableImport );
		tableColumnJMySqlTableMembers = new TableColumn<ICFBamTableObj,String>( "JMySqlTableMembers" );
		tableColumnJMySqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMySqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMySqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMySqlTableMembers );
		tableColumnJMySqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "JMySqlTableImplementation" );
		tableColumnJMySqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMySqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMySqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMySqlTableImplementation );
		tableColumnJOracleTableImport = new TableColumn<ICFBamTableObj,String>( "JOracleTableImport" );
		tableColumnJOracleTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJOracleTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJOracleTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJOracleTableImport );
		tableColumnJOracleTableMembers = new TableColumn<ICFBamTableObj,String>( "JOracleTableMembers" );
		tableColumnJOracleTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJOracleTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJOracleTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJOracleTableMembers );
		tableColumnJOracleTableImplementation = new TableColumn<ICFBamTableObj,String>( "JOracleTableImplementation" );
		tableColumnJOracleTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJOracleTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJOracleTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJOracleTableImplementation );
		tableColumnJPgSqlTableImport = new TableColumn<ICFBamTableObj,String>( "JPgSqlTableImport" );
		tableColumnJPgSqlTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJPgSqlTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJPgSqlTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJPgSqlTableImport );
		tableColumnJPgSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "JPgSqlTableMembers" );
		tableColumnJPgSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJPgSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJPgSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJPgSqlTableMembers );
		tableColumnJPgSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "JPgSqlTableImplementation" );
		tableColumnJPgSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJPgSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJPgSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJPgSqlTableImplementation );
		tableColumnJRamTableImport = new TableColumn<ICFBamTableObj,String>( "JRamTableImport" );
		tableColumnJRamTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJRamTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJRamTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJRamTableImport );
		tableColumnJRamTableMembers = new TableColumn<ICFBamTableObj,String>( "JRamTableMembers" );
		tableColumnJRamTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJRamTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJRamTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJRamTableMembers );
		tableColumnJRamTableImplementation = new TableColumn<ICFBamTableObj,String>( "JRamTableImplementation" );
		tableColumnJRamTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJRamTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJRamTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJRamTableImplementation );
		tableColumnJSaxLoaderImport = new TableColumn<ICFBamTableObj,String>( "JSaxLoaderImport" );
		tableColumnJSaxLoaderImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSaxLoaderImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSaxLoaderImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSaxLoaderImport );
		tableColumnJSaxLoaderStartElement = new TableColumn<ICFBamTableObj,String>( "JSaxLoaderStartElement" );
		tableColumnJSaxLoaderStartElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSaxLoaderStartElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSaxLoaderStartElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSaxLoaderStartElement );
		tableColumnJSaxLoaderEndElement = new TableColumn<ICFBamTableObj,String>( "JSaxLoaderEndElement" );
		tableColumnJSaxLoaderEndElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSaxLoaderEndElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSaxLoaderEndElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSaxLoaderEndElement );
		tableColumnJXMsgTableImport = new TableColumn<ICFBamTableObj,String>( "JXMsgTableImport" );
		tableColumnJXMsgTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgTableImport );
		tableColumnJXMsgTableFormatters = new TableColumn<ICFBamTableObj,String>( "JXMsgTableFormatters" );
		tableColumnJXMsgTableFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgTableFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgTableFormatters.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgTableFormatters );
		tableColumnJXMsgRqstTableImport = new TableColumn<ICFBamTableObj,String>( "JXMsgRqstTableImport" );
		tableColumnJXMsgRqstTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstTableImport );
		tableColumnJXMsgRspnTableImport = new TableColumn<ICFBamTableObj,String>( "JXMsgRspnTableImport" );
		tableColumnJXMsgRspnTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnTableImport );
		tableColumnJXMsgClientTableImport = new TableColumn<ICFBamTableObj,String>( "JXMsgClientTableImport" );
		tableColumnJXMsgClientTableImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgClientTableImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgClientTableImport.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgClientTableImport );
		tableColumnJXMsgRqstTableBody = new TableColumn<ICFBamTableObj,String>( "JXMsgRqstTableBody" );
		tableColumnJXMsgRqstTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstTableBody );
		tableColumnJXMsgRspnTableBody = new TableColumn<ICFBamTableObj,String>( "JXMsgRspnTableBody" );
		tableColumnJXMsgRspnTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnTableBody );
		tableColumnJXMsgClientTableBody = new TableColumn<ICFBamTableObj,String>( "JXMsgClientTableBody" );
		tableColumnJXMsgClientTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgClientTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgClientTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgClientTableBody );
		tableColumnCppObjMembers = new TableColumn<ICFBamTableObj,String>( "CppObjMembers" );
		tableColumnCppObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppObjMembers );
		tableColumnCppObjInterface = new TableColumn<ICFBamTableObj,String>( "CppObjInterface" );
		tableColumnCppObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppObjInterface );
		tableColumnCppObjInclude = new TableColumn<ICFBamTableObj,String>( "CppObjInclude" );
		tableColumnCppObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppObjInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppObjInclude );
		tableColumnCppObjImplementation = new TableColumn<ICFBamTableObj,String>( "CppObjImplementation" );
		tableColumnCppObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppObjImplementation );
		tableColumnCppEditObjMembers = new TableColumn<ICFBamTableObj,String>( "CppEditObjMembers" );
		tableColumnCppEditObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppEditObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppEditObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppEditObjMembers );
		tableColumnCppEditObjInterface = new TableColumn<ICFBamTableObj,String>( "CppEditObjInterface" );
		tableColumnCppEditObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppEditObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppEditObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppEditObjInterface );
		tableColumnCppEditObjInclude = new TableColumn<ICFBamTableObj,String>( "CppEditObjInclude" );
		tableColumnCppEditObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppEditObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppEditObjInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppEditObjInclude );
		tableColumnCppEditObjImplementation = new TableColumn<ICFBamTableObj,String>( "CppEditObjImplementation" );
		tableColumnCppEditObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppEditObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppEditObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppEditObjImplementation );
		tableColumnCppTableInclude = new TableColumn<ICFBamTableObj,String>( "CppTableInclude" );
		tableColumnCppTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableInclude );
		tableColumnCppTableMembers = new TableColumn<ICFBamTableObj,String>( "CppTableMembers" );
		tableColumnCppTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableMembers );
		tableColumnCppTableInterface = new TableColumn<ICFBamTableObj,String>( "CppTableInterface" );
		tableColumnCppTableInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableInterface );
		tableColumnCppTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppTableImplementation" );
		tableColumnCppTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableImplementation );
		tableColumnCppTableObjInclude = new TableColumn<ICFBamTableObj,String>( "CppTableObjInclude" );
		tableColumnCppTableObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableObjInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableObjInclude );
		tableColumnCppTableObjMembers = new TableColumn<ICFBamTableObj,String>( "CppTableObjMembers" );
		tableColumnCppTableObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableObjMembers );
		tableColumnCppTableObjInterface = new TableColumn<ICFBamTableObj,String>( "CppTableObjInterface" );
		tableColumnCppTableObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableObjInterface );
		tableColumnCppTableObjImplementation = new TableColumn<ICFBamTableObj,String>( "CppTableObjImplementation" );
		tableColumnCppTableObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppTableObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppTableObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppTableObjImplementation );
		tableColumnCppDb2LUWTableInclude = new TableColumn<ICFBamTableObj,String>( "CppDb2LUWTableInclude" );
		tableColumnCppDb2LUWTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppDb2LUWTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppDb2LUWTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppDb2LUWTableInclude );
		tableColumnCppDb2LUWTableMembers = new TableColumn<ICFBamTableObj,String>( "CppDb2LUWTableMembers" );
		tableColumnCppDb2LUWTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppDb2LUWTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppDb2LUWTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppDb2LUWTableMembers );
		tableColumnCppDb2LUWTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppDb2LUWTableImplementation" );
		tableColumnCppDb2LUWTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppDb2LUWTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppDb2LUWTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppDb2LUWTableImplementation );
		tableColumnCppMSSqlTableInclude = new TableColumn<ICFBamTableObj,String>( "CppMSSqlTableInclude" );
		tableColumnCppMSSqlTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMSSqlTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMSSqlTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMSSqlTableInclude );
		tableColumnCppMSSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "CppMSSqlTableMembers" );
		tableColumnCppMSSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMSSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMSSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMSSqlTableMembers );
		tableColumnCppMSSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppMSSqlTableImplementation" );
		tableColumnCppMSSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMSSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMSSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMSSqlTableImplementation );
		tableColumnCppMySqlTableInclude = new TableColumn<ICFBamTableObj,String>( "CppMySqlTableInclude" );
		tableColumnCppMySqlTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMySqlTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMySqlTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMySqlTableInclude );
		tableColumnCppMySqlTableMembers = new TableColumn<ICFBamTableObj,String>( "CppMySqlTableMembers" );
		tableColumnCppMySqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMySqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMySqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMySqlTableMembers );
		tableColumnCppMySqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppMySqlTableImplementation" );
		tableColumnCppMySqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMySqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMySqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMySqlTableImplementation );
		tableColumnCppOracleTableInclude = new TableColumn<ICFBamTableObj,String>( "CppOracleTableInclude" );
		tableColumnCppOracleTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppOracleTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppOracleTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppOracleTableInclude );
		tableColumnCppOracleTableMembers = new TableColumn<ICFBamTableObj,String>( "CppOracleTableMembers" );
		tableColumnCppOracleTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppOracleTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppOracleTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppOracleTableMembers );
		tableColumnCppOracleTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppOracleTableImplementation" );
		tableColumnCppOracleTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppOracleTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppOracleTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppOracleTableImplementation );
		tableColumnCppPgSqlTableInclude = new TableColumn<ICFBamTableObj,String>( "CppPgSqlTableInclude" );
		tableColumnCppPgSqlTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppPgSqlTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppPgSqlTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppPgSqlTableInclude );
		tableColumnCppPgSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "CppPgSqlTableMembers" );
		tableColumnCppPgSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppPgSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppPgSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppPgSqlTableMembers );
		tableColumnCppPgSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppPgSqlTableImplementation" );
		tableColumnCppPgSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppPgSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppPgSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppPgSqlTableImplementation );
		tableColumnCppRamTableInclude = new TableColumn<ICFBamTableObj,String>( "CppRamTableInclude" );
		tableColumnCppRamTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppRamTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppRamTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppRamTableInclude );
		tableColumnCppRamTableMembers = new TableColumn<ICFBamTableObj,String>( "CppRamTableMembers" );
		tableColumnCppRamTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppRamTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppRamTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppRamTableMembers );
		tableColumnCppRamTableImplementation = new TableColumn<ICFBamTableObj,String>( "CppRamTableImplementation" );
		tableColumnCppRamTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppRamTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppRamTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppRamTableImplementation );
		tableColumnCppSaxLoaderInclude = new TableColumn<ICFBamTableObj,String>( "CppSaxLoaderInclude" );
		tableColumnCppSaxLoaderInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSaxLoaderInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSaxLoaderInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSaxLoaderInclude );
		tableColumnCppSaxLoaderStartElement = new TableColumn<ICFBamTableObj,String>( "CppSaxLoaderStartElement" );
		tableColumnCppSaxLoaderStartElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSaxLoaderStartElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSaxLoaderStartElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSaxLoaderStartElement );
		tableColumnCppSaxLoaderEndElement = new TableColumn<ICFBamTableObj,String>( "CppSaxLoaderEndElement" );
		tableColumnCppSaxLoaderEndElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSaxLoaderEndElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSaxLoaderEndElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSaxLoaderEndElement );
		tableColumnCppXMsgTableInclude = new TableColumn<ICFBamTableObj,String>( "CppXMsgTableInclude" );
		tableColumnCppXMsgTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgTableInclude );
		tableColumnCppXMsgTableFormatters = new TableColumn<ICFBamTableObj,String>( "CppXMsgTableFormatters" );
		tableColumnCppXMsgTableFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgTableFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgTableFormatters.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgTableFormatters );
		tableColumnCppXMsgRqstTableInclude = new TableColumn<ICFBamTableObj,String>( "CppXMsgRqstTableInclude" );
		tableColumnCppXMsgRqstTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstTableInclude );
		tableColumnCppXMsgRspnTableInclude = new TableColumn<ICFBamTableObj,String>( "CppXMsgRspnTableInclude" );
		tableColumnCppXMsgRspnTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnTableInclude );
		tableColumnCppXMsgClientTableInclude = new TableColumn<ICFBamTableObj,String>( "CppXMsgClientTableInclude" );
		tableColumnCppXMsgClientTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgClientTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgClientTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgClientTableInclude );
		tableColumnCppXMsgRqstTableBody = new TableColumn<ICFBamTableObj,String>( "CppXMsgRqstTableBody" );
		tableColumnCppXMsgRqstTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstTableBody );
		tableColumnCppXMsgRspnTableBody = new TableColumn<ICFBamTableObj,String>( "CppXMsgRspnTableBody" );
		tableColumnCppXMsgRspnTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnTableBody );
		tableColumnCppXMsgClientTableBody = new TableColumn<ICFBamTableObj,String>( "CppXMsgClientTableBody" );
		tableColumnCppXMsgClientTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgClientTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgClientTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgClientTableBody );
		tableColumnHppObjMembers = new TableColumn<ICFBamTableObj,String>( "HppObjMembers" );
		tableColumnHppObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppObjMembers );
		tableColumnHppObjInterface = new TableColumn<ICFBamTableObj,String>( "HppObjInterface" );
		tableColumnHppObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppObjInterface );
		tableColumnHppObjInclude = new TableColumn<ICFBamTableObj,String>( "HppObjInclude" );
		tableColumnHppObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppObjInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppObjInclude );
		tableColumnHppObjImplementation = new TableColumn<ICFBamTableObj,String>( "HppObjImplementation" );
		tableColumnHppObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppObjImplementation );
		tableColumnHppEditObjMembers = new TableColumn<ICFBamTableObj,String>( "HppEditObjMembers" );
		tableColumnHppEditObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppEditObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppEditObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppEditObjMembers );
		tableColumnHppEditObjInterface = new TableColumn<ICFBamTableObj,String>( "HppEditObjInterface" );
		tableColumnHppEditObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppEditObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppEditObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppEditObjInterface );
		tableColumnHppEditObjInclude = new TableColumn<ICFBamTableObj,String>( "HppEditObjInclude" );
		tableColumnHppEditObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppEditObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppEditObjInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppEditObjInclude );
		tableColumnHppEditObjImplementation = new TableColumn<ICFBamTableObj,String>( "HppEditObjImplementation" );
		tableColumnHppEditObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppEditObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppEditObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppEditObjImplementation );
		tableColumnHppTableInclude = new TableColumn<ICFBamTableObj,String>( "HppTableInclude" );
		tableColumnHppTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableInclude );
		tableColumnHppTableMembers = new TableColumn<ICFBamTableObj,String>( "HppTableMembers" );
		tableColumnHppTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableMembers );
		tableColumnHppTableInterface = new TableColumn<ICFBamTableObj,String>( "HppTableInterface" );
		tableColumnHppTableInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableInterface );
		tableColumnHppTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppTableImplementation" );
		tableColumnHppTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableImplementation );
		tableColumnHppTableObjInclude = new TableColumn<ICFBamTableObj,String>( "HppTableObjInclude" );
		tableColumnHppTableObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableObjInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableObjInclude );
		tableColumnHppTableObjMembers = new TableColumn<ICFBamTableObj,String>( "HppTableObjMembers" );
		tableColumnHppTableObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableObjMembers );
		tableColumnHppTableObjInterface = new TableColumn<ICFBamTableObj,String>( "HppTableObjInterface" );
		tableColumnHppTableObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableObjInterface );
		tableColumnHppTableObjImplementation = new TableColumn<ICFBamTableObj,String>( "HppTableObjImplementation" );
		tableColumnHppTableObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppTableObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppTableObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppTableObjImplementation );
		tableColumnHppDb2LUWTableInclude = new TableColumn<ICFBamTableObj,String>( "HppDb2LUWTableInclude" );
		tableColumnHppDb2LUWTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppDb2LUWTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppDb2LUWTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppDb2LUWTableInclude );
		tableColumnHppDb2LUWTableMembers = new TableColumn<ICFBamTableObj,String>( "HppDb2LUWTableMembers" );
		tableColumnHppDb2LUWTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppDb2LUWTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppDb2LUWTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppDb2LUWTableMembers );
		tableColumnHppDb2LUWTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppDb2LUWTableImplementation" );
		tableColumnHppDb2LUWTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppDb2LUWTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppDb2LUWTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppDb2LUWTableImplementation );
		tableColumnHppMSSqlTableInclude = new TableColumn<ICFBamTableObj,String>( "HppMSSqlTableInclude" );
		tableColumnHppMSSqlTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMSSqlTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMSSqlTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMSSqlTableInclude );
		tableColumnHppMSSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "HppMSSqlTableMembers" );
		tableColumnHppMSSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMSSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMSSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMSSqlTableMembers );
		tableColumnHppMSSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppMSSqlTableImplementation" );
		tableColumnHppMSSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMSSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMSSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMSSqlTableImplementation );
		tableColumnHppMySqlTableInclude = new TableColumn<ICFBamTableObj,String>( "HppMySqlTableInclude" );
		tableColumnHppMySqlTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMySqlTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMySqlTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMySqlTableInclude );
		tableColumnHppMySqlTableMembers = new TableColumn<ICFBamTableObj,String>( "HppMySqlTableMembers" );
		tableColumnHppMySqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMySqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMySqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMySqlTableMembers );
		tableColumnHppMySqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppMySqlTableImplementation" );
		tableColumnHppMySqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMySqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMySqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMySqlTableImplementation );
		tableColumnHppOracleTableInclude = new TableColumn<ICFBamTableObj,String>( "HppOracleTableInclude" );
		tableColumnHppOracleTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppOracleTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppOracleTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppOracleTableInclude );
		tableColumnHppOracleTableMembers = new TableColumn<ICFBamTableObj,String>( "HppOracleTableMembers" );
		tableColumnHppOracleTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppOracleTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppOracleTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppOracleTableMembers );
		tableColumnHppOracleTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppOracleTableImplementation" );
		tableColumnHppOracleTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppOracleTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppOracleTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppOracleTableImplementation );
		tableColumnHppPgSqlTableInclude = new TableColumn<ICFBamTableObj,String>( "HppPgSqlTableInclude" );
		tableColumnHppPgSqlTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppPgSqlTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppPgSqlTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppPgSqlTableInclude );
		tableColumnHppPgSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "HppPgSqlTableMembers" );
		tableColumnHppPgSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppPgSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppPgSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppPgSqlTableMembers );
		tableColumnHppPgSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppPgSqlTableImplementation" );
		tableColumnHppPgSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppPgSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppPgSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppPgSqlTableImplementation );
		tableColumnHppRamTableInclude = new TableColumn<ICFBamTableObj,String>( "HppRamTableInclude" );
		tableColumnHppRamTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppRamTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppRamTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppRamTableInclude );
		tableColumnHppRamTableMembers = new TableColumn<ICFBamTableObj,String>( "HppRamTableMembers" );
		tableColumnHppRamTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppRamTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppRamTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppRamTableMembers );
		tableColumnHppRamTableImplementation = new TableColumn<ICFBamTableObj,String>( "HppRamTableImplementation" );
		tableColumnHppRamTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppRamTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppRamTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppRamTableImplementation );
		tableColumnHppSaxLoaderInclude = new TableColumn<ICFBamTableObj,String>( "HppSaxLoaderInclude" );
		tableColumnHppSaxLoaderInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSaxLoaderInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSaxLoaderInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSaxLoaderInclude );
		tableColumnHppSaxLoaderStartElement = new TableColumn<ICFBamTableObj,String>( "HppSaxLoaderStartElement" );
		tableColumnHppSaxLoaderStartElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSaxLoaderStartElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSaxLoaderStartElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSaxLoaderStartElement );
		tableColumnHppSaxLoaderEndElement = new TableColumn<ICFBamTableObj,String>( "HppSaxLoaderEndElement" );
		tableColumnHppSaxLoaderEndElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSaxLoaderEndElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSaxLoaderEndElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSaxLoaderEndElement );
		tableColumnHppXMsgTableInclude = new TableColumn<ICFBamTableObj,String>( "HppXMsgTableInclude" );
		tableColumnHppXMsgTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgTableInclude );
		tableColumnHppXMsgTableFormatters = new TableColumn<ICFBamTableObj,String>( "HppXMsgTableFormatters" );
		tableColumnHppXMsgTableFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgTableFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgTableFormatters.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgTableFormatters );
		tableColumnHppXMsgRqstTableInclude = new TableColumn<ICFBamTableObj,String>( "HppXMsgRqstTableInclude" );
		tableColumnHppXMsgRqstTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstTableInclude );
		tableColumnHppXMsgRspnTableInclude = new TableColumn<ICFBamTableObj,String>( "HppXMsgRspnTableInclude" );
		tableColumnHppXMsgRspnTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnTableInclude );
		tableColumnHppXMsgClientTableInclude = new TableColumn<ICFBamTableObj,String>( "HppXMsgClientTableInclude" );
		tableColumnHppXMsgClientTableInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgClientTableInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgClientTableInclude.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgClientTableInclude );
		tableColumnHppXMsgRqstTableBody = new TableColumn<ICFBamTableObj,String>( "HppXMsgRqstTableBody" );
		tableColumnHppXMsgRqstTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstTableBody );
		tableColumnHppXMsgRspnTableBody = new TableColumn<ICFBamTableObj,String>( "HppXMsgRspnTableBody" );
		tableColumnHppXMsgRspnTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnTableBody );
		tableColumnHppXMsgClientTableBody = new TableColumn<ICFBamTableObj,String>( "HppXMsgClientTableBody" );
		tableColumnHppXMsgClientTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgClientTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgClientTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgClientTableBody );
		tableColumnCsObjMembers = new TableColumn<ICFBamTableObj,String>( "CsObjMembers" );
		tableColumnCsObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsObjMembers );
		tableColumnCsObjInterface = new TableColumn<ICFBamTableObj,String>( "CsObjInterface" );
		tableColumnCsObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsObjInterface );
		tableColumnCsObjUsing = new TableColumn<ICFBamTableObj,String>( "CsObjUsing" );
		tableColumnCsObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsObjUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsObjUsing );
		tableColumnCsObjImplementation = new TableColumn<ICFBamTableObj,String>( "CsObjImplementation" );
		tableColumnCsObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsObjImplementation );
		tableColumnCsEditObjMembers = new TableColumn<ICFBamTableObj,String>( "CsEditObjMembers" );
		tableColumnCsEditObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsEditObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsEditObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsEditObjMembers );
		tableColumnCsEditObjInterface = new TableColumn<ICFBamTableObj,String>( "CsEditObjInterface" );
		tableColumnCsEditObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsEditObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsEditObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsEditObjInterface );
		tableColumnCsEditObjUsing = new TableColumn<ICFBamTableObj,String>( "CsEditObjUsing" );
		tableColumnCsEditObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsEditObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsEditObjUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsEditObjUsing );
		tableColumnCsEditObjImplementation = new TableColumn<ICFBamTableObj,String>( "CsEditObjImplementation" );
		tableColumnCsEditObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsEditObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsEditObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsEditObjImplementation );
		tableColumnCsTableUsing = new TableColumn<ICFBamTableObj,String>( "CsTableUsing" );
		tableColumnCsTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableUsing );
		tableColumnCsTableMembers = new TableColumn<ICFBamTableObj,String>( "CsTableMembers" );
		tableColumnCsTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableMembers );
		tableColumnCsTableInterface = new TableColumn<ICFBamTableObj,String>( "CsTableInterface" );
		tableColumnCsTableInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableInterface );
		tableColumnCsTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsTableImplementation" );
		tableColumnCsTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableImplementation );
		tableColumnCsTableObjUsing = new TableColumn<ICFBamTableObj,String>( "CsTableObjUsing" );
		tableColumnCsTableObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableObjUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableObjUsing );
		tableColumnCsTableObjMembers = new TableColumn<ICFBamTableObj,String>( "CsTableObjMembers" );
		tableColumnCsTableObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableObjMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableObjMembers );
		tableColumnCsTableObjInterface = new TableColumn<ICFBamTableObj,String>( "CsTableObjInterface" );
		tableColumnCsTableObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableObjInterface.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableObjInterface );
		tableColumnCsTableObjImplementation = new TableColumn<ICFBamTableObj,String>( "CsTableObjImplementation" );
		tableColumnCsTableObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsTableObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsTableObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsTableObjImplementation );
		tableColumnCsDb2LUWTableUsing = new TableColumn<ICFBamTableObj,String>( "CsDb2LUWTableUsing" );
		tableColumnCsDb2LUWTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsDb2LUWTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsDb2LUWTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsDb2LUWTableUsing );
		tableColumnCsDb2LUWTableMembers = new TableColumn<ICFBamTableObj,String>( "CsDb2LUWTableMembers" );
		tableColumnCsDb2LUWTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsDb2LUWTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsDb2LUWTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsDb2LUWTableMembers );
		tableColumnCsDb2LUWTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsDb2LUWTableImplementation" );
		tableColumnCsDb2LUWTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsDb2LUWTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsDb2LUWTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsDb2LUWTableImplementation );
		tableColumnCsMSSqlTableUsing = new TableColumn<ICFBamTableObj,String>( "CsMSSqlTableUsing" );
		tableColumnCsMSSqlTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMSSqlTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMSSqlTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMSSqlTableUsing );
		tableColumnCsMSSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "CsMSSqlTableMembers" );
		tableColumnCsMSSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMSSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMSSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMSSqlTableMembers );
		tableColumnCsMSSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsMSSqlTableImplementation" );
		tableColumnCsMSSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMSSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMSSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMSSqlTableImplementation );
		tableColumnCsMySqlTableUsing = new TableColumn<ICFBamTableObj,String>( "CsMySqlTableUsing" );
		tableColumnCsMySqlTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMySqlTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMySqlTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMySqlTableUsing );
		tableColumnCsMySqlTableMembers = new TableColumn<ICFBamTableObj,String>( "CsMySqlTableMembers" );
		tableColumnCsMySqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMySqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMySqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMySqlTableMembers );
		tableColumnCsMySqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsMySqlTableImplementation" );
		tableColumnCsMySqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMySqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMySqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMySqlTableImplementation );
		tableColumnCsOracleTableUsing = new TableColumn<ICFBamTableObj,String>( "CsOracleTableUsing" );
		tableColumnCsOracleTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsOracleTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsOracleTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsOracleTableUsing );
		tableColumnCsOracleTableMembers = new TableColumn<ICFBamTableObj,String>( "CsOracleTableMembers" );
		tableColumnCsOracleTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsOracleTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsOracleTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsOracleTableMembers );
		tableColumnCsOracleTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsOracleTableImplementation" );
		tableColumnCsOracleTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsOracleTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsOracleTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsOracleTableImplementation );
		tableColumnCsPgSqlTableUsing = new TableColumn<ICFBamTableObj,String>( "CsPgSqlTableUsing" );
		tableColumnCsPgSqlTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsPgSqlTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsPgSqlTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsPgSqlTableUsing );
		tableColumnCsPgSqlTableMembers = new TableColumn<ICFBamTableObj,String>( "CsPgSqlTableMembers" );
		tableColumnCsPgSqlTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsPgSqlTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsPgSqlTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsPgSqlTableMembers );
		tableColumnCsPgSqlTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsPgSqlTableImplementation" );
		tableColumnCsPgSqlTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsPgSqlTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsPgSqlTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsPgSqlTableImplementation );
		tableColumnCsRamTableUsing = new TableColumn<ICFBamTableObj,String>( "CsRamTableUsing" );
		tableColumnCsRamTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsRamTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsRamTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsRamTableUsing );
		tableColumnCsRamTableMembers = new TableColumn<ICFBamTableObj,String>( "CsRamTableMembers" );
		tableColumnCsRamTableMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsRamTableMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsRamTableMembers.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsRamTableMembers );
		tableColumnCsRamTableImplementation = new TableColumn<ICFBamTableObj,String>( "CsRamTableImplementation" );
		tableColumnCsRamTableImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsRamTableImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsRamTableImplementation.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsRamTableImplementation );
		tableColumnCsSaxLoaderUsing = new TableColumn<ICFBamTableObj,String>( "CsSaxLoaderUsing" );
		tableColumnCsSaxLoaderUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSaxLoaderUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSaxLoaderUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSaxLoaderUsing );
		tableColumnCsSaxLoaderStartElement = new TableColumn<ICFBamTableObj,String>( "CsSaxLoaderStartElement" );
		tableColumnCsSaxLoaderStartElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSaxLoaderStartElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSaxLoaderStartElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSaxLoaderStartElement );
		tableColumnCsSaxLoaderEndElement = new TableColumn<ICFBamTableObj,String>( "CsSaxLoaderEndElement" );
		tableColumnCsSaxLoaderEndElement.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSaxLoaderEndElement();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSaxLoaderEndElement.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSaxLoaderEndElement );
		tableColumnCsXMsgTableUsing = new TableColumn<ICFBamTableObj,String>( "CsXMsgTableUsing" );
		tableColumnCsXMsgTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgTableUsing );
		tableColumnCsXMsgTableFormatters = new TableColumn<ICFBamTableObj,String>( "CsXMsgTableFormatters" );
		tableColumnCsXMsgTableFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgTableFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgTableFormatters.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgTableFormatters );
		tableColumnCsXMsgRqstTableUsing = new TableColumn<ICFBamTableObj,String>( "CsXMsgRqstTableUsing" );
		tableColumnCsXMsgRqstTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstTableUsing );
		tableColumnCsXMsgRspnTableUsing = new TableColumn<ICFBamTableObj,String>( "CsXMsgRspnTableUsing" );
		tableColumnCsXMsgRspnTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnTableUsing );
		tableColumnCsXMsgClientTableUsing = new TableColumn<ICFBamTableObj,String>( "CsXMsgClientTableUsing" );
		tableColumnCsXMsgClientTableUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgClientTableUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgClientTableUsing.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgClientTableUsing );
		tableColumnCsXMsgRqstTableBody = new TableColumn<ICFBamTableObj,String>( "CsXMsgRqstTableBody" );
		tableColumnCsXMsgRqstTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstTableBody );
		tableColumnCsXMsgRspnTableBody = new TableColumn<ICFBamTableObj,String>( "CsXMsgRspnTableBody" );
		tableColumnCsXMsgRspnTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnTableBody );
		tableColumnCsXMsgClientTableBody = new TableColumn<ICFBamTableObj,String>( "CsXMsgClientTableBody" );
		tableColumnCsXMsgClientTableBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTableObj, String> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgClientTableBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgClientTableBody.setCellFactory( new Callback<TableColumn<ICFBamTableObj,String>,TableCell<ICFBamTableObj,String>>() {
			@Override public TableCell<ICFBamTableObj,String> call(
				TableColumn<ICFBamTableObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgClientTableBody );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTableObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTableObj, ICFBamSchemaDefObj> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamSchemaDefObj ref = obj.getOptionalLookupDefSchema();
					ReadOnlyObjectWrapper<ICFBamSchemaDefObj> observable = new ReadOnlyObjectWrapper<ICFBamSchemaDefObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamSchemaDefObj>,TableCell<ICFBamTableObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTableObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTableObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupLookupIndex = new TableColumn<ICFBamTableObj, ICFBamIndexObj>( "Lookup Index" );
		tableColumnLookupLookupIndex.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamIndexObj>,ObservableValue<ICFBamIndexObj> >() {
			public ObservableValue<ICFBamIndexObj> call( CellDataFeatures<ICFBamTableObj, ICFBamIndexObj> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamIndexObj ref = obj.getOptionalLookupLookupIndex();
					ReadOnlyObjectWrapper<ICFBamIndexObj> observable = new ReadOnlyObjectWrapper<ICFBamIndexObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupLookupIndex.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamIndexObj>,TableCell<ICFBamTableObj,ICFBamIndexObj>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamIndexObj> call(
				TableColumn<ICFBamTableObj,ICFBamIndexObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTableObj,ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupLookupIndex );
		tableColumnLookupAltIndex = new TableColumn<ICFBamTableObj, ICFBamIndexObj>( "Alt Index" );
		tableColumnLookupAltIndex.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamIndexObj>,ObservableValue<ICFBamIndexObj> >() {
			public ObservableValue<ICFBamIndexObj> call( CellDataFeatures<ICFBamTableObj, ICFBamIndexObj> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamIndexObj ref = obj.getOptionalLookupAltIndex();
					ReadOnlyObjectWrapper<ICFBamIndexObj> observable = new ReadOnlyObjectWrapper<ICFBamIndexObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupAltIndex.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamIndexObj>,TableCell<ICFBamTableObj,ICFBamIndexObj>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamIndexObj> call(
				TableColumn<ICFBamTableObj,ICFBamIndexObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTableObj,ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupAltIndex );
		tableColumnLookupQualTable = new TableColumn<ICFBamTableObj, ICFBamTableObj>( "Qualifying Table" );
		tableColumnLookupQualTable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamTableObj>,ObservableValue<ICFBamTableObj> >() {
			public ObservableValue<ICFBamTableObj> call( CellDataFeatures<ICFBamTableObj, ICFBamTableObj> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamTableObj ref = obj.getOptionalLookupQualTable();
					ReadOnlyObjectWrapper<ICFBamTableObj> observable = new ReadOnlyObjectWrapper<ICFBamTableObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupQualTable.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamTableObj>,TableCell<ICFBamTableObj,ICFBamTableObj>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamTableObj> call(
				TableColumn<ICFBamTableObj,ICFBamTableObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTableObj,ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupQualTable );
		tableColumnLookupPrimaryIndex = new TableColumn<ICFBamTableObj, ICFBamIndexObj>( "Primary Index" );
		tableColumnLookupPrimaryIndex.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTableObj,ICFBamIndexObj>,ObservableValue<ICFBamIndexObj> >() {
			public ObservableValue<ICFBamIndexObj> call( CellDataFeatures<ICFBamTableObj, ICFBamIndexObj> p ) {
				ICFBamTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamIndexObj ref = obj.getOptionalLookupPrimaryIndex();
					ReadOnlyObjectWrapper<ICFBamIndexObj> observable = new ReadOnlyObjectWrapper<ICFBamIndexObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupPrimaryIndex.setCellFactory( new Callback<TableColumn<ICFBamTableObj,ICFBamIndexObj>,TableCell<ICFBamTableObj,ICFBamIndexObj>>() {
			@Override public TableCell<ICFBamTableObj,ICFBamIndexObj> call(
				TableColumn<ICFBamTableObj,ICFBamIndexObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTableObj,ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupPrimaryIndex );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTableObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTableObj> observable,
					ICFBamTableObj oldValue,
					ICFBamTableObj newValue )
				{
					setJavaFXFocus( newValue );
				}
			});

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getPanelHBoxMenu() );

		setTop( scrollMenu );
		setCenter( dataTable );
		javafxIsInitializing = false;
		if( observableListOfTable != null ) {
			dataTable.setItems( observableListOfTable );
		}
		adjustListButtons();
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

	public void setPaneMode( CFPane.PaneMode value ) {
		super.setPaneMode( value );
		adjustListButtons();
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
		adjustListButtons();
	}

	public ICFBamTableObj getJavaFXFocusAsTable() {
		return( (ICFBamTableObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTable( ICFBamTableObj value ) {
		setJavaFXFocus( value );
	}

	public class TableByQualNameComparator
	implements Comparator<ICFBamTableObj>
	{
		public TableByQualNameComparator() {
		}

		public int compare( ICFBamTableObj lhs, ICFBamTableObj rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				String lhsValue = lhs.getObjQualifiedName();
				String rhsValue = rhs.getObjQualifiedName();
				if( lhsValue == null ) {
					if( rhsValue == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhsValue == null ) {
					return( 1 );
				}
				else {
					return( lhsValue.compareTo( rhsValue ) );
				}
			}
		}
	}

	protected TableByQualNameComparator compareTableByQualName = new TableByQualNameComparator();

	public Collection<ICFBamTableObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTableObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTable = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTableObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTable.add( iter.next() );
				}
				observableListOfTable.sort( compareTableByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTable );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	protected class CompareCFButtonByText
	implements Comparator<CFButton>
	{
		public CompareCFButtonByText() {
		}

		@Override public int compare( CFButton lhs, CFButton rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				int retval = lhs.getText().compareTo( rhs.getText() );
				return( retval );
			}
		}
	}

	public CFHBox getPanelHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );
			buttonAddTable = new CFButton();
			buttonAddTable.setMinWidth( 200 );
			buttonAddTable.setText( "Add Table" );
			buttonAddTable.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						ICFBamTableObj obj = (ICFBamTableObj)schemaObj.getTableTableObj().newInstance();
						ICFBamTableEditObj edit = (ICFBamTableEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
								ICFSecTenantObj secTenant = schemaObj.getSecTenant();
								edit.setRequiredOwnerTenant( secTenant );
								ICFBamSchemaDefObj container = (ICFBamSchemaDefObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new CFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerSchemaDef( container );
						CFBorderPane frame = javafxSchema.getTableFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
						ICFBamJavaFXTablePaneCommon jpanelCommon = (ICFBamJavaFXTablePaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddTable );
			buttonViewSelected = new CFButton();
			buttonViewSelected.setMinWidth( 200 );
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ICFBamTableObj selectedInstance = getJavaFXFocusAsTable();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TBLD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTableFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTablePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTableObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonViewSelected );

			buttonEditSelected = new CFButton();
			buttonEditSelected.setMinWidth( 200 );
			buttonEditSelected.setText( "Edit Selected" );
			buttonEditSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ICFBamTableObj selectedInstance = getJavaFXFocusAsTable();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TBLD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTableFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTablePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTableObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonEditSelected );

			buttonDeleteSelected = new CFButton();
			buttonDeleteSelected.setMinWidth( 200 );
			buttonDeleteSelected.setText( "Delete Selected" );
			buttonDeleteSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ICFBamTableObj selectedInstance = getJavaFXFocusAsTable();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TBLD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTableFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFBamJavaFXTablePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTableObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonDeleteSelected );

		}
		return( hboxMenu );
	}

	public ICFBamSchemaDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamSchemaDefObj value ) {
		javafxContainer = value;
	}

	public void refreshMe() {
		if( javafxRefreshCallback != null ) {
			javafxRefreshCallback.refreshMe();
		}
	}

	public void adjustListButtons() {
		boolean enableState;
		boolean inEditState;
		boolean allowAdds;
		boolean inAddMode = false;
		ICFBamTableObj selectedObj = getJavaFXFocusAsTable();
		CFPane.PaneMode mode = getPaneMode();
		if( mode == CFPane.PaneMode.Edit ) {
			inEditState = true;
			allowAdds = false;
		}
		else {
			inEditState = false;
			if( getJavaFXContainer() != null ) {
				if( getLeft() != null ) {
					allowAdds = false;
					inAddMode = true;
				}
				else {
					allowAdds = true;
				}
			}
			else {
				allowAdds = false;
			}
		}
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			if( ( ! inAddMode ) && ( ! inEditState ) ) {
				enableState = true;
			}
			else {
				enableState = false;
			}
		}

		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( ! enableState );
		}
		if( buttonEditSelected != null ) {
			if( inEditState ) {
				buttonEditSelected.setDisable( true );
			}
			else {
				buttonEditSelected.setDisable( ! enableState );
			}
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( ! enableState );
		}
		if( buttonAddTable != null ) {
			buttonAddTable.setDisable( ! allowAdds );
		}

	}
}
