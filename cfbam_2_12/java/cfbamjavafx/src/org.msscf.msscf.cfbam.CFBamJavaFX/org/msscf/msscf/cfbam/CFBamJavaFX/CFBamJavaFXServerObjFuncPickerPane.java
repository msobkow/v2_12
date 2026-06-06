// Description: Java 11 JavaFX Picker of Obj Pane implementation for ServerObjFunc.

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
 *	CFBamJavaFXServerObjFuncPickerPane JavaFX Pick Obj Pane implementation
 *	for ServerObjFunc.
 */
public class CFBamJavaFXServerObjFuncPickerPane
extends CFBorderPane
implements ICFBamJavaFXServerObjFuncPaneList
{
	public static String S_FormName = "Choose ServerObjFunc";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamServerObjFuncObj> javafxDataCollection = null;
	protected ObservableList<ICFBamServerObjFuncObj> observableListOfServerObjFunc = null;
	protected TableColumn<ICFBamServerObjFuncObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnName = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnSuffix = null;
	protected TableColumn<ICFBamServerObjFuncObj, Boolean> tableColumnIsInstanceMethod = null;
	protected TableColumn<ICFBamServerObjFuncObj, Boolean> tableColumnIsClientMethod = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnJMethodBody = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnCppMethodBody = null;
	protected TableColumn<ICFBamServerObjFuncObj, String> tableColumnCsMethodBody = null;
	protected TableColumn<ICFBamServerObjFuncObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<ICFBamServerObjFuncObj, ICFBamTableObj> tableColumnLookupRetTable = null;
	protected TableView<ICFBamServerObjFuncObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXServerObjFuncChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXServerObjFuncPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamServerObjFuncObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerObjFuncObj> argDataCollection,
		ICFBamJavaFXServerObjFuncChosen whenChosen )
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
		if( whenChosen == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				6,
				"whenChosen" );
		}
		invokeWhenChosen = whenChosen;
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<ICFBamServerObjFuncObj>();
		tableColumnId = new TableColumn<ICFBamServerObjFuncObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamServerObjFuncObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,Long>,TableCell<ICFBamServerObjFuncObj,Long>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,Long> call(
				TableColumn<ICFBamServerObjFuncObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamServerObjFuncObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFStringTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamServerObjFuncObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFStringTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamServerObjFuncObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFStringTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamServerObjFuncObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFStringTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamServerObjFuncObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFStringTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnSuffix = new TableColumn<ICFBamServerObjFuncObj,String>( "Suffix" );
		tableColumnSuffix.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalSuffix();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSuffix.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFStringTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSuffix );
		tableColumnIsInstanceMethod = new TableColumn<ICFBamServerObjFuncObj,Boolean>( "Is Instance Method" );
		tableColumnIsInstanceMethod.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamServerObjFuncObj, Boolean> p ) {
				ICFBamServerMethodObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsInstanceMethod();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsInstanceMethod.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,Boolean>,TableCell<ICFBamServerObjFuncObj,Boolean>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,Boolean> call(
				TableColumn<ICFBamServerObjFuncObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsInstanceMethod );
		tableColumnIsClientMethod = new TableColumn<ICFBamServerObjFuncObj,Boolean>( "Is Client Method" );
		tableColumnIsClientMethod.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamServerObjFuncObj, Boolean> p ) {
				ICFBamServerMethodObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsClientMethod();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsClientMethod.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,Boolean>,TableCell<ICFBamServerObjFuncObj,Boolean>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,Boolean> call(
				TableColumn<ICFBamServerObjFuncObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsClientMethod );
		tableColumnJMethodBody = new TableColumn<ICFBamServerObjFuncObj,String>( "Java Method Body" );
		tableColumnJMethodBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredJMethodBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMethodBody.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFTextTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMethodBody );
		tableColumnCppMethodBody = new TableColumn<ICFBamServerObjFuncObj,String>( "C++ Method Body" );
		tableColumnCppMethodBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredCppMethodBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMethodBody.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFTextTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMethodBody );
		tableColumnCsMethodBody = new TableColumn<ICFBamServerObjFuncObj,String>( "C-Sharp Method Body" );
		tableColumnCsMethodBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamServerObjFuncObj, String> p ) {
				ICFBamServerMethodObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredCsMethodBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMethodBody.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,String>,TableCell<ICFBamServerObjFuncObj,String>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,String> call(
				TableColumn<ICFBamServerObjFuncObj,String> arg)
			{
				return new CFTextTableCell<ICFBamServerObjFuncObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMethodBody );
		tableColumnLookupDefSchema = new TableColumn<ICFBamServerObjFuncObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamServerObjFuncObj, ICFBamSchemaDefObj> p ) {
				ICFBamServerObjFuncObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,ICFBamSchemaDefObj>,TableCell<ICFBamServerObjFuncObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamServerObjFuncObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamServerObjFuncObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupRetTable = new TableColumn<ICFBamServerObjFuncObj, ICFBamTableObj>( "Ret Table" );
		tableColumnLookupRetTable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamServerObjFuncObj,ICFBamTableObj>,ObservableValue<ICFBamTableObj> >() {
			public ObservableValue<ICFBamTableObj> call( CellDataFeatures<ICFBamServerObjFuncObj, ICFBamTableObj> p ) {
				ICFBamServerObjFuncObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamTableObj ref = obj.getOptionalLookupRetTable();
					ReadOnlyObjectWrapper<ICFBamTableObj> observable = new ReadOnlyObjectWrapper<ICFBamTableObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupRetTable.setCellFactory( new Callback<TableColumn<ICFBamServerObjFuncObj,ICFBamTableObj>,TableCell<ICFBamServerObjFuncObj,ICFBamTableObj>>() {
			@Override public TableCell<ICFBamServerObjFuncObj,ICFBamTableObj> call(
				TableColumn<ICFBamServerObjFuncObj,ICFBamTableObj> arg)
			{
				return new CFReferenceTableCell<ICFBamServerObjFuncObj,ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupRetTable );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamServerObjFuncObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamServerObjFuncObj> observable,
					ICFBamServerObjFuncObj oldValue,
					ICFBamServerObjFuncObj newValue )
				{
					setJavaFXFocus( newValue );
					if( buttonChooseSelected != null ) {
						if( newValue != null ) {
							buttonChooseSelected.setDisable( false );
						}
						else {
							buttonChooseSelected.setDisable( true );
						}
					}
				}
			});
		hboxMenu = new CFHBox( 10 );
		buttonCancel = new CFButton();
		buttonCancel.setMinWidth( 200 );
		buttonCancel.setText( "Cancel" );
		buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonCancel );
		buttonChooseNone = new CFButton();
		buttonChooseNone.setMinWidth( 200 );
		buttonChooseNone.setText( "ChooseNone" );
		buttonChooseNone.setOnAction( new EventHandler<ActionEvent>() {
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
					invokeWhenChosen.choseServerObjFunc( null );
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseNone );
		buttonChooseSelected = new CFButton();
		buttonChooseSelected.setMinWidth( 200 );
		buttonChooseSelected.setText( "ChooseSelected" );
		buttonChooseSelected.setOnAction( new EventHandler<ActionEvent>() {
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
					ICFBamServerObjFuncObj selectedInstance = getJavaFXFocusAsServerObjFunc();
					invokeWhenChosen.choseServerObjFunc( selectedInstance );
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseSelected );
		if( argFocus != null ) {
			dataTable.getSelectionModel().select( argFocus );
		}

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( hboxMenu );

		setTop( scrollMenu );
		setCenter( dataTable );
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

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamServerObjFuncObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamServerObjFuncObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamServerObjFuncObj getJavaFXFocusAsServerObjFunc() {
		return( (ICFBamServerObjFuncObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsServerObjFunc( ICFBamServerObjFuncObj value ) {
		setJavaFXFocus( value );
	}

	public class ServerObjFuncByQualNameComparator
	implements Comparator<ICFBamServerObjFuncObj>
	{
		public ServerObjFuncByQualNameComparator() {
		}

		public int compare( ICFBamServerObjFuncObj lhs, ICFBamServerObjFuncObj rhs ) {
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

	protected ServerObjFuncByQualNameComparator compareServerObjFuncByQualName = new ServerObjFuncByQualNameComparator();

	public Collection<ICFBamServerObjFuncObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamServerObjFuncObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfServerObjFunc = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamServerObjFuncObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfServerObjFunc.add( iter.next() );
				}
				observableListOfServerObjFunc.sort( compareServerObjFuncByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfServerObjFunc );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamTableObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamTableObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamServerObjFuncObj selectedObj = getJavaFXFocusAsServerObjFunc();
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( buttonChooseSelected != null ) {
			buttonChooseSelected.setDisable( ! enableState );
		}
		if( buttonChooseNone != null ) {
			buttonChooseNone.setDisable( false );
		}
		if( buttonCancel != null ) {
			buttonCancel.setDisable( false );
		}

	}
}

