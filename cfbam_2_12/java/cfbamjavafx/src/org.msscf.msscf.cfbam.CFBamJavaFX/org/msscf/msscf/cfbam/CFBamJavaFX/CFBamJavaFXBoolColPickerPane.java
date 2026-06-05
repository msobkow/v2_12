// Description: Java 11 JavaFX Picker of Obj Pane implementation for BoolCol.

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
 *	CFBamJavaFXBoolColPickerPane JavaFX Pick Obj Pane implementation
 *	for BoolCol.
 */
public class CFBamJavaFXBoolColPickerPane
extends CFBorderPane
implements ICFBamJavaFXBoolColPaneList
{
	public static String S_FormName = "Choose BoolCol";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamBoolColObj> javafxDataCollection = null;
	protected ObservableList<ICFBamBoolColObj> observableListOfBoolCol = null;
	protected TableColumn<ICFBamBoolColObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnName = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamBoolColObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamBoolColObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamBoolColObj, Boolean> tableColumnInitValue = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnFalseString = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnTrueString = null;
	protected TableColumn<ICFBamBoolColObj, String> tableColumnNullString = null;
	protected TableColumn<ICFBamBoolColObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamBoolColObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXBoolColChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXBoolColPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamBoolColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamBoolColObj> argDataCollection,
		ICFBamJavaFXBoolColChosen whenChosen )
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
		dataTable = new TableView<ICFBamBoolColObj>();
		tableColumnId = new TableColumn<ICFBamBoolColObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamBoolColObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,Long>,TableCell<ICFBamBoolColObj,Long>>() {
			@Override public TableCell<ICFBamBoolColObj,Long> call(
				TableColumn<ICFBamBoolColObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamBoolColObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamBoolColObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamBoolColObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamBoolColObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamBoolColObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamBoolColObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamBoolColObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamBoolColObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,Boolean>,TableCell<ICFBamBoolColObj,Boolean>>() {
			@Override public TableCell<ICFBamBoolColObj,Boolean> call(
				TableColumn<ICFBamBoolColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamBoolColObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamBoolColObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,Boolean>,TableCell<ICFBamBoolColObj,Boolean>>() {
			@Override public TableCell<ICFBamBoolColObj,Boolean> call(
				TableColumn<ICFBamBoolColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamBoolColObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamBoolColObj,Boolean>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamBoolColObj, Boolean> p ) {
				ICFBamBoolDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Boolean value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,Boolean>,TableCell<ICFBamBoolColObj,Boolean>>() {
			@Override public TableCell<ICFBamBoolColObj,Boolean> call(
				TableColumn<ICFBamBoolColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnFalseString = new TableColumn<ICFBamBoolColObj,String>( "FalseString" );
		tableColumnFalseString.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
				ICFBamBoolDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalFalseString();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnFalseString.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnFalseString );
		tableColumnTrueString = new TableColumn<ICFBamBoolColObj,String>( "TrueString" );
		tableColumnTrueString.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
				ICFBamBoolDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalTrueString();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnTrueString.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTrueString );
		tableColumnNullString = new TableColumn<ICFBamBoolColObj,String>( "NullString" );
		tableColumnNullString.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBoolColObj, String> p ) {
				ICFBamBoolDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalNullString();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnNullString.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,String>,TableCell<ICFBamBoolColObj,String>>() {
			@Override public TableCell<ICFBamBoolColObj,String> call(
				TableColumn<ICFBamBoolColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBoolColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnNullString );
		tableColumnLookupDefSchema = new TableColumn<ICFBamBoolColObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBoolColObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamBoolColObj, ICFBamSchemaDefObj> p ) {
				ICFBamBoolColObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamBoolColObj,ICFBamSchemaDefObj>,TableCell<ICFBamBoolColObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamBoolColObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamBoolColObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamBoolColObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamBoolColObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamBoolColObj> observable,
					ICFBamBoolColObj oldValue,
					ICFBamBoolColObj newValue )
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
					invokeWhenChosen.choseBoolCol( null );
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
					ICFBamBoolColObj selectedInstance = getJavaFXFocusAsBoolCol();
					invokeWhenChosen.choseBoolCol( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamBoolColObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamBoolColObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamBoolColObj getJavaFXFocusAsBoolCol() {
		return( (ICFBamBoolColObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsBoolCol( ICFBamBoolColObj value ) {
		setJavaFXFocus( value );
	}

	public class BoolColByQualNameComparator
	implements Comparator<ICFBamBoolColObj>
	{
		public BoolColByQualNameComparator() {
		}

		public int compare( ICFBamBoolColObj lhs, ICFBamBoolColObj rhs ) {
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

	protected BoolColByQualNameComparator compareBoolColByQualName = new BoolColByQualNameComparator();

	public Collection<ICFBamBoolColObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamBoolColObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfBoolCol = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamBoolColObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfBoolCol.add( iter.next() );
				}
				observableListOfBoolCol.sort( compareBoolColByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfBoolCol );
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
		ICFBamBoolColObj selectedObj = getJavaFXFocusAsBoolCol();
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

