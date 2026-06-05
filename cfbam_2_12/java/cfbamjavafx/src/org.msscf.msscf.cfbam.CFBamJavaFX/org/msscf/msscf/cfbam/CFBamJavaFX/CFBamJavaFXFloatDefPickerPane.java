// Description: Java 11 JavaFX Picker of Obj Pane implementation for FloatDef.

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
 *	CFBamJavaFXFloatDefPickerPane JavaFX Pick Obj Pane implementation
 *	for FloatDef.
 */
public class CFBamJavaFXFloatDefPickerPane
extends CFBorderPane
implements ICFBamJavaFXFloatDefPaneList
{
	public static String S_FormName = "Choose FloatDef";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamFloatDefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamFloatDefObj> observableListOfFloatDef = null;
	protected TableColumn<ICFBamFloatDefObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamFloatDefObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnName = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamFloatDefObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamFloatDefObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamFloatDefObj, Float> tableColumnInitValue = null;
	protected TableColumn<ICFBamFloatDefObj, Float> tableColumnMinValue = null;
	protected TableColumn<ICFBamFloatDefObj, Float> tableColumnMaxValue = null;
	protected TableColumn<ICFBamFloatDefObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamFloatDefObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXFloatDefChosen invokeWhenChosen = null;
	protected ICFBamScopeObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXFloatDefPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamFloatDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamFloatDefObj> argDataCollection,
		ICFBamJavaFXFloatDefChosen whenChosen )
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
		dataTable = new TableView<ICFBamFloatDefObj>();
		tableColumnObjKind = new TableColumn<ICFBamFloatDefObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
				ICFBamFloatDefObj obj = p.getValue();
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
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamFloatDefObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamFloatDefObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Long>,TableCell<ICFBamFloatDefObj,Long>>() {
			@Override public TableCell<ICFBamFloatDefObj,Long> call(
				TableColumn<ICFBamFloatDefObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamFloatDefObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamFloatDefObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamFloatDefObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamFloatDefObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamFloatDefObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamFloatDefObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamFloatDefObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamFloatDefObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Boolean>,TableCell<ICFBamFloatDefObj,Boolean>>() {
			@Override public TableCell<ICFBamFloatDefObj,Boolean> call(
				TableColumn<ICFBamFloatDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamFloatDefObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamFloatDefObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Boolean>,TableCell<ICFBamFloatDefObj,Boolean>>() {
			@Override public TableCell<ICFBamFloatDefObj,Boolean> call(
				TableColumn<ICFBamFloatDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamFloatDefObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamFloatDefObj,Float>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatDefObj, Float> p ) {
				ICFBamFloatDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Float value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Float> observable = new ReadOnlyObjectWrapper<Float>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Float>,TableCell<ICFBamFloatDefObj,Float>>() {
			@Override public TableCell<ICFBamFloatDefObj,Float> call(
				TableColumn<ICFBamFloatDefObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamFloatDefObj,Float>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatDefObj, Float> p ) {
				ICFBamFloatDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Float value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Float> observable = new ReadOnlyObjectWrapper<Float>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Float>,TableCell<ICFBamFloatDefObj,Float>>() {
			@Override public TableCell<ICFBamFloatDefObj,Float> call(
				TableColumn<ICFBamFloatDefObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamFloatDefObj,Float>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatDefObj, Float> p ) {
				ICFBamFloatDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Float value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Float> observable = new ReadOnlyObjectWrapper<Float>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Float>,TableCell<ICFBamFloatDefObj,Float>>() {
			@Override public TableCell<ICFBamFloatDefObj,Float> call(
				TableColumn<ICFBamFloatDefObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamFloatDefObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamFloatDefObj, ICFBamSchemaDefObj> p ) {
				ICFBamFloatDefObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,ICFBamSchemaDefObj>,TableCell<ICFBamFloatDefObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamFloatDefObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamFloatDefObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamFloatDefObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamFloatDefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamFloatDefObj> observable,
					ICFBamFloatDefObj oldValue,
					ICFBamFloatDefObj newValue )
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
					invokeWhenChosen.choseFloatDef( null );
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
					ICFBamFloatDefObj selectedInstance = getJavaFXFocusAsFloatDef();
					invokeWhenChosen.choseFloatDef( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamFloatDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamFloatDefObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamFloatDefObj getJavaFXFocusAsFloatDef() {
		return( (ICFBamFloatDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsFloatDef( ICFBamFloatDefObj value ) {
		setJavaFXFocus( value );
	}

	public class FloatDefByQualNameComparator
	implements Comparator<ICFBamFloatDefObj>
	{
		public FloatDefByQualNameComparator() {
		}

		public int compare( ICFBamFloatDefObj lhs, ICFBamFloatDefObj rhs ) {
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

	protected FloatDefByQualNameComparator compareFloatDefByQualName = new FloatDefByQualNameComparator();

	public Collection<ICFBamFloatDefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamFloatDefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfFloatDef = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamFloatDefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfFloatDef.add( iter.next() );
				}
				observableListOfFloatDef.sort( compareFloatDefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfFloatDef );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamScopeObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamScopeObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamFloatDefObj selectedObj = getJavaFXFocusAsFloatDef();
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

