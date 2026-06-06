// Description: Java 11 JavaFX Picker of Obj Pane implementation for Int64Type.

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
 *	CFBamJavaFXInt64TypePickerPane JavaFX Pick Obj Pane implementation
 *	for Int64Type.
 */
public class CFBamJavaFXInt64TypePickerPane
extends CFBorderPane
implements ICFBamJavaFXInt64TypePaneList
{
	public static String S_FormName = "Choose Int64Type";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamInt64TypeObj> javafxDataCollection = null;
	protected ObservableList<ICFBamInt64TypeObj> observableListOfInt64Type = null;
	protected TableColumn<ICFBamInt64TypeObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamInt64TypeObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnName = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamInt64TypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamInt64TypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamInt64TypeObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamInt64TypeObj, Long> tableColumnInitValue = null;
	protected TableColumn<ICFBamInt64TypeObj, Long> tableColumnMinValue = null;
	protected TableColumn<ICFBamInt64TypeObj, Long> tableColumnMaxValue = null;
	protected TableColumn<ICFBamInt64TypeObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamInt64TypeObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXInt64TypeChosen invokeWhenChosen = null;
	protected ICFBamSchemaDefObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXInt64TypePickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamInt64TypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamInt64TypeObj> argDataCollection,
		ICFBamJavaFXInt64TypeChosen whenChosen )
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
		dataTable = new TableView<ICFBamInt64TypeObj>();
		tableColumnObjKind = new TableColumn<ICFBamInt64TypeObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamInt64TypeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String classCode = obj.getClassCode();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( classCode );
					return( observable );
				}
			}
		});
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamInt64TypeObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamInt64TypeObj, Long> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,Long>,TableCell<ICFBamInt64TypeObj,Long>>() {
			@Override public TableCell<ICFBamInt64TypeObj,Long> call(
				TableColumn<ICFBamInt64TypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamInt64TypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamInt64TypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamInt64TypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamInt64TypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamInt64TypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamInt64TypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDefaultXmlValue();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamInt64TypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamInt64TypeObj, Boolean> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsNullable();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,Boolean>,TableCell<ICFBamInt64TypeObj,Boolean>>() {
			@Override public TableCell<ICFBamInt64TypeObj,Boolean> call(
				TableColumn<ICFBamInt64TypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamInt64TypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamInt64TypeObj, Boolean> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Boolean value = obj.getOptionalGenerateId();
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,Boolean>,TableCell<ICFBamInt64TypeObj,Boolean>>() {
			@Override public TableCell<ICFBamInt64TypeObj,Boolean> call(
				TableColumn<ICFBamInt64TypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamInt64TypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamInt64TypeObj, String> p ) {
				ICFBamAtomObj obj = p.getValue();
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,String>,TableCell<ICFBamInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamInt64TypeObj,String> call(
				TableColumn<ICFBamInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamInt64TypeObj,Long>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamInt64TypeObj, Long> p ) {
				ICFBamInt64DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Long value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Long> observable = new ReadOnlyObjectWrapper<Long>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,Long>,TableCell<ICFBamInt64TypeObj,Long>>() {
			@Override public TableCell<ICFBamInt64TypeObj,Long> call(
				TableColumn<ICFBamInt64TypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamInt64TypeObj,Long>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamInt64TypeObj, Long> p ) {
				ICFBamInt64DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Long value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Long> observable = new ReadOnlyObjectWrapper<Long>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,Long>,TableCell<ICFBamInt64TypeObj,Long>>() {
			@Override public TableCell<ICFBamInt64TypeObj,Long> call(
				TableColumn<ICFBamInt64TypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamInt64TypeObj,Long>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamInt64TypeObj, Long> p ) {
				ICFBamInt64DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Long value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Long> observable = new ReadOnlyObjectWrapper<Long>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,Long>,TableCell<ICFBamInt64TypeObj,Long>>() {
			@Override public TableCell<ICFBamInt64TypeObj,Long> call(
				TableColumn<ICFBamInt64TypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamInt64TypeObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamInt64TypeObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamInt64TypeObj, ICFBamSchemaDefObj> p ) {
				ICFBamInt64TypeObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamInt64TypeObj,ICFBamSchemaDefObj>,TableCell<ICFBamInt64TypeObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamInt64TypeObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamInt64TypeObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamInt64TypeObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamInt64TypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamInt64TypeObj> observable,
					ICFBamInt64TypeObj oldValue,
					ICFBamInt64TypeObj newValue )
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
					invokeWhenChosen.choseInt64Type( null );
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
					ICFBamInt64TypeObj selectedInstance = getJavaFXFocusAsInt64Type();
					invokeWhenChosen.choseInt64Type( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamInt64TypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamInt64TypeObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamInt64TypeObj getJavaFXFocusAsInt64Type() {
		return( (ICFBamInt64TypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsInt64Type( ICFBamInt64TypeObj value ) {
		setJavaFXFocus( value );
	}

	public class Int64TypeByQualNameComparator
	implements Comparator<ICFBamInt64TypeObj>
	{
		public Int64TypeByQualNameComparator() {
		}

		public int compare( ICFBamInt64TypeObj lhs, ICFBamInt64TypeObj rhs ) {
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

	protected Int64TypeByQualNameComparator compareInt64TypeByQualName = new Int64TypeByQualNameComparator();

	public Collection<ICFBamInt64TypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamInt64TypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfInt64Type = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamInt64TypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfInt64Type.add( iter.next() );
				}
				observableListOfInt64Type.sort( compareInt64TypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfInt64Type );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamSchemaDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamSchemaDefObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamInt64TypeObj selectedObj = getJavaFXFocusAsInt64Type();
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

