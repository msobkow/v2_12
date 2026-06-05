// Description: Java 11 JavaFX Picker of Obj Pane implementation for UInt32Def.

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
 *	CFBamJavaFXUInt32DefPickerPane JavaFX Pick Obj Pane implementation
 *	for UInt32Def.
 */
public class CFBamJavaFXUInt32DefPickerPane
extends CFBorderPane
implements ICFBamJavaFXUInt32DefPaneList
{
	public static String S_FormName = "Choose UInt32Def";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamUInt32DefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamUInt32DefObj> observableListOfUInt32Def = null;
	protected TableColumn<ICFBamUInt32DefObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamUInt32DefObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnName = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamUInt32DefObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamUInt32DefObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamUInt32DefObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamUInt32DefObj, Long> tableColumnInitValue = null;
	protected TableColumn<ICFBamUInt32DefObj, Long> tableColumnMinValue = null;
	protected TableColumn<ICFBamUInt32DefObj, Long> tableColumnMaxValue = null;
	protected TableColumn<ICFBamUInt32DefObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamUInt32DefObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXUInt32DefChosen invokeWhenChosen = null;
	protected ICFBamScopeObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXUInt32DefPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamUInt32DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamUInt32DefObj> argDataCollection,
		ICFBamJavaFXUInt32DefChosen whenChosen )
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
		dataTable = new TableView<ICFBamUInt32DefObj>();
		tableColumnObjKind = new TableColumn<ICFBamUInt32DefObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
				ICFBamUInt32DefObj obj = p.getValue();
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
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamUInt32DefObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamUInt32DefObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,Long>,TableCell<ICFBamUInt32DefObj,Long>>() {
			@Override public TableCell<ICFBamUInt32DefObj,Long> call(
				TableColumn<ICFBamUInt32DefObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamUInt32DefObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamUInt32DefObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamUInt32DefObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamUInt32DefObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamUInt32DefObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamUInt32DefObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamUInt32DefObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamUInt32DefObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,Boolean>,TableCell<ICFBamUInt32DefObj,Boolean>>() {
			@Override public TableCell<ICFBamUInt32DefObj,Boolean> call(
				TableColumn<ICFBamUInt32DefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamUInt32DefObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamUInt32DefObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,Boolean>,TableCell<ICFBamUInt32DefObj,Boolean>>() {
			@Override public TableCell<ICFBamUInt32DefObj,Boolean> call(
				TableColumn<ICFBamUInt32DefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamUInt32DefObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt32DefObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,String>,TableCell<ICFBamUInt32DefObj,String>>() {
			@Override public TableCell<ICFBamUInt32DefObj,String> call(
				TableColumn<ICFBamUInt32DefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamUInt32DefObj,Long>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamUInt32DefObj, Long> p ) {
				ICFBamUInt32DefObj obj = p.getValue();
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
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,Long>,TableCell<ICFBamUInt32DefObj,Long>>() {
			@Override public TableCell<ICFBamUInt32DefObj,Long> call(
				TableColumn<ICFBamUInt32DefObj,Long> arg)
			{
				return new CFUInt32TableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamUInt32DefObj,Long>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamUInt32DefObj, Long> p ) {
				ICFBamUInt32DefObj obj = p.getValue();
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
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,Long>,TableCell<ICFBamUInt32DefObj,Long>>() {
			@Override public TableCell<ICFBamUInt32DefObj,Long> call(
				TableColumn<ICFBamUInt32DefObj,Long> arg)
			{
				return new CFUInt32TableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamUInt32DefObj,Long>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamUInt32DefObj, Long> p ) {
				ICFBamUInt32DefObj obj = p.getValue();
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
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,Long>,TableCell<ICFBamUInt32DefObj,Long>>() {
			@Override public TableCell<ICFBamUInt32DefObj,Long> call(
				TableColumn<ICFBamUInt32DefObj,Long> arg)
			{
				return new CFUInt32TableCell<ICFBamUInt32DefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamUInt32DefObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt32DefObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamUInt32DefObj, ICFBamSchemaDefObj> p ) {
				ICFBamUInt32DefObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamUInt32DefObj,ICFBamSchemaDefObj>,TableCell<ICFBamUInt32DefObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamUInt32DefObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamUInt32DefObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamUInt32DefObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamUInt32DefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamUInt32DefObj> observable,
					ICFBamUInt32DefObj oldValue,
					ICFBamUInt32DefObj newValue )
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
					invokeWhenChosen.choseUInt32Def( null );
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
					ICFBamUInt32DefObj selectedInstance = getJavaFXFocusAsUInt32Def();
					invokeWhenChosen.choseUInt32Def( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamUInt32DefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamUInt32DefObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamUInt32DefObj getJavaFXFocusAsUInt32Def() {
		return( (ICFBamUInt32DefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsUInt32Def( ICFBamUInt32DefObj value ) {
		setJavaFXFocus( value );
	}

	public class UInt32DefByQualNameComparator
	implements Comparator<ICFBamUInt32DefObj>
	{
		public UInt32DefByQualNameComparator() {
		}

		public int compare( ICFBamUInt32DefObj lhs, ICFBamUInt32DefObj rhs ) {
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

	protected UInt32DefByQualNameComparator compareUInt32DefByQualName = new UInt32DefByQualNameComparator();

	public Collection<ICFBamUInt32DefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamUInt32DefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfUInt32Def = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamUInt32DefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfUInt32Def.add( iter.next() );
				}
				observableListOfUInt32Def.sort( compareUInt32DefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfUInt32Def );
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
		ICFBamUInt32DefObj selectedObj = getJavaFXFocusAsUInt32Def();
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

