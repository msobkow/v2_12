// Description: Java 11 JavaFX Picker of Obj Pane implementation for Id16Gen.

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
 *	CFBamJavaFXId16GenPickerPane JavaFX Pick Obj Pane implementation
 *	for Id16Gen.
 */
public class CFBamJavaFXId16GenPickerPane
extends CFBorderPane
implements ICFBamJavaFXId16GenPaneList
{
	public static String S_FormName = "Choose Id16Gen";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamId16GenObj> javafxDataCollection = null;
	protected ObservableList<ICFBamId16GenObj> observableListOfId16Gen = null;
	protected TableColumn<ICFBamId16GenObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnName = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamId16GenObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamId16GenObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamId16GenObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamId16GenObj, Short> tableColumnInitValue = null;
	protected TableColumn<ICFBamId16GenObj, Short> tableColumnMinValue = null;
	protected TableColumn<ICFBamId16GenObj, Short> tableColumnMaxValue = null;
	protected TableColumn<ICFBamId16GenObj, Short> tableColumnSlice = null;
	protected TableColumn<ICFBamId16GenObj, Short> tableColumnBlockSize = null;
	protected TableColumn<ICFBamId16GenObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<ICFBamId16GenObj, ICFBamTableObj> tableColumnLookupDispenser = null;
	protected TableView<ICFBamId16GenObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXId16GenChosen invokeWhenChosen = null;
	protected ICFBamSchemaDefObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXId16GenPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamId16GenObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamId16GenObj> argDataCollection,
		ICFBamJavaFXId16GenChosen whenChosen )
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
		dataTable = new TableView<ICFBamId16GenObj>();
		tableColumnId = new TableColumn<ICFBamId16GenObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamId16GenObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Long>,TableCell<ICFBamId16GenObj,Long>>() {
			@Override public TableCell<ICFBamId16GenObj,Long> call(
				TableColumn<ICFBamId16GenObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamId16GenObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamId16GenObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamId16GenObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamId16GenObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamId16GenObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamId16GenObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamId16GenObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamId16GenObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Boolean>,TableCell<ICFBamId16GenObj,Boolean>>() {
			@Override public TableCell<ICFBamId16GenObj,Boolean> call(
				TableColumn<ICFBamId16GenObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamId16GenObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamId16GenObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Boolean>,TableCell<ICFBamId16GenObj,Boolean>>() {
			@Override public TableCell<ICFBamId16GenObj,Boolean> call(
				TableColumn<ICFBamId16GenObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamId16GenObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamId16GenObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,String>,TableCell<ICFBamId16GenObj,String>>() {
			@Override public TableCell<ICFBamId16GenObj,String> call(
				TableColumn<ICFBamId16GenObj,String> arg)
			{
				return new CFStringTableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamId16GenObj,Short>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamId16GenObj, Short> p ) {
				ICFBamInt16DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Short>,TableCell<ICFBamId16GenObj,Short>>() {
			@Override public TableCell<ICFBamId16GenObj,Short> call(
				TableColumn<ICFBamId16GenObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamId16GenObj,Short>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamId16GenObj, Short> p ) {
				ICFBamInt16DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Short>,TableCell<ICFBamId16GenObj,Short>>() {
			@Override public TableCell<ICFBamId16GenObj,Short> call(
				TableColumn<ICFBamId16GenObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamId16GenObj,Short>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamId16GenObj, Short> p ) {
				ICFBamInt16DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Short>,TableCell<ICFBamId16GenObj,Short>>() {
			@Override public TableCell<ICFBamId16GenObj,Short> call(
				TableColumn<ICFBamId16GenObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnSlice = new TableColumn<ICFBamId16GenObj,Short>( "Slice" );
		tableColumnSlice.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamId16GenObj, Short> p ) {
				ICFBamId16GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredSlice();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnSlice.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Short>,TableCell<ICFBamId16GenObj,Short>>() {
			@Override public TableCell<ICFBamId16GenObj,Short> call(
				TableColumn<ICFBamId16GenObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSlice );
		tableColumnBlockSize = new TableColumn<ICFBamId16GenObj,Short>( "BlockSize" );
		tableColumnBlockSize.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamId16GenObj, Short> p ) {
				ICFBamId16GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredBlockSize();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnBlockSize.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,Short>,TableCell<ICFBamId16GenObj,Short>>() {
			@Override public TableCell<ICFBamId16GenObj,Short> call(
				TableColumn<ICFBamId16GenObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamId16GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnBlockSize );
		tableColumnLookupDefSchema = new TableColumn<ICFBamId16GenObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamId16GenObj, ICFBamSchemaDefObj> p ) {
				ICFBamId16GenObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,ICFBamSchemaDefObj>,TableCell<ICFBamId16GenObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamId16GenObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamId16GenObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamId16GenObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupDispenser = new TableColumn<ICFBamId16GenObj, ICFBamTableObj>( "Dispensing Table" );
		tableColumnLookupDispenser.setCellValueFactory( new Callback<CellDataFeatures<ICFBamId16GenObj,ICFBamTableObj>,ObservableValue<ICFBamTableObj> >() {
			public ObservableValue<ICFBamTableObj> call( CellDataFeatures<ICFBamId16GenObj, ICFBamTableObj> p ) {
				ICFBamId16GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamTableObj ref = obj.getOptionalLookupDispenser();
					ReadOnlyObjectWrapper<ICFBamTableObj> observable = new ReadOnlyObjectWrapper<ICFBamTableObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupDispenser.setCellFactory( new Callback<TableColumn<ICFBamId16GenObj,ICFBamTableObj>,TableCell<ICFBamId16GenObj,ICFBamTableObj>>() {
			@Override public TableCell<ICFBamId16GenObj,ICFBamTableObj> call(
				TableColumn<ICFBamId16GenObj,ICFBamTableObj> arg)
			{
				return new CFReferenceTableCell<ICFBamId16GenObj,ICFBamTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDispenser );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamId16GenObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamId16GenObj> observable,
					ICFBamId16GenObj oldValue,
					ICFBamId16GenObj newValue )
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
					invokeWhenChosen.choseId16Gen( null );
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
					ICFBamId16GenObj selectedInstance = getJavaFXFocusAsId16Gen();
					invokeWhenChosen.choseId16Gen( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamId16GenObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamId16GenObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamId16GenObj getJavaFXFocusAsId16Gen() {
		return( (ICFBamId16GenObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsId16Gen( ICFBamId16GenObj value ) {
		setJavaFXFocus( value );
	}

	public class Id16GenByQualNameComparator
	implements Comparator<ICFBamId16GenObj>
	{
		public Id16GenByQualNameComparator() {
		}

		public int compare( ICFBamId16GenObj lhs, ICFBamId16GenObj rhs ) {
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

	protected Id16GenByQualNameComparator compareId16GenByQualName = new Id16GenByQualNameComparator();

	public Collection<ICFBamId16GenObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamId16GenObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfId16Gen = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamId16GenObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfId16Gen.add( iter.next() );
				}
				observableListOfId16Gen.sort( compareId16GenByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfId16Gen );
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
		ICFBamId16GenObj selectedObj = getJavaFXFocusAsId16Gen();
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

