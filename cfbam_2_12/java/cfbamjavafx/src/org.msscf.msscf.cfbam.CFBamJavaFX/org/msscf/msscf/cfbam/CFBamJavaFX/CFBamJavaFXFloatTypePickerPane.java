// Description: Java 11 JavaFX Picker of Obj Pane implementation for FloatType.

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
 *	CFBamJavaFXFloatTypePickerPane JavaFX Pick Obj Pane implementation
 *	for FloatType.
 */
public class CFBamJavaFXFloatTypePickerPane
extends CFBorderPane
implements ICFBamJavaFXFloatTypePaneList
{
	public static String S_FormName = "Choose FloatType";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamFloatTypeObj> javafxDataCollection = null;
	protected ObservableList<ICFBamFloatTypeObj> observableListOfFloatType = null;
	protected TableColumn<ICFBamFloatTypeObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnName = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamFloatTypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamFloatTypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamFloatTypeObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamFloatTypeObj, Float> tableColumnInitValue = null;
	protected TableColumn<ICFBamFloatTypeObj, Float> tableColumnMinValue = null;
	protected TableColumn<ICFBamFloatTypeObj, Float> tableColumnMaxValue = null;
	protected TableColumn<ICFBamFloatTypeObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamFloatTypeObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXFloatTypeChosen invokeWhenChosen = null;
	protected ICFBamSchemaDefObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXFloatTypePickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamFloatTypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamFloatTypeObj> argDataCollection,
		ICFBamJavaFXFloatTypeChosen whenChosen )
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
		dataTable = new TableView<ICFBamFloatTypeObj>();
		tableColumnId = new TableColumn<ICFBamFloatTypeObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamFloatTypeObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,Long>,TableCell<ICFBamFloatTypeObj,Long>>() {
			@Override public TableCell<ICFBamFloatTypeObj,Long> call(
				TableColumn<ICFBamFloatTypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamFloatTypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamFloatTypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamFloatTypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamFloatTypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamFloatTypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamFloatTypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamFloatTypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamFloatTypeObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,Boolean>,TableCell<ICFBamFloatTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamFloatTypeObj,Boolean> call(
				TableColumn<ICFBamFloatTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamFloatTypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamFloatTypeObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,Boolean>,TableCell<ICFBamFloatTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamFloatTypeObj,Boolean> call(
				TableColumn<ICFBamFloatTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamFloatTypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatTypeObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,String>,TableCell<ICFBamFloatTypeObj,String>>() {
			@Override public TableCell<ICFBamFloatTypeObj,String> call(
				TableColumn<ICFBamFloatTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamFloatTypeObj,Float>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatTypeObj, Float> p ) {
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
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,Float>,TableCell<ICFBamFloatTypeObj,Float>>() {
			@Override public TableCell<ICFBamFloatTypeObj,Float> call(
				TableColumn<ICFBamFloatTypeObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamFloatTypeObj,Float>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatTypeObj, Float> p ) {
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
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,Float>,TableCell<ICFBamFloatTypeObj,Float>>() {
			@Override public TableCell<ICFBamFloatTypeObj,Float> call(
				TableColumn<ICFBamFloatTypeObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamFloatTypeObj,Float>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatTypeObj, Float> p ) {
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
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,Float>,TableCell<ICFBamFloatTypeObj,Float>>() {
			@Override public TableCell<ICFBamFloatTypeObj,Float> call(
				TableColumn<ICFBamFloatTypeObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamFloatTypeObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatTypeObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamFloatTypeObj, ICFBamSchemaDefObj> p ) {
				ICFBamFloatTypeObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamFloatTypeObj,ICFBamSchemaDefObj>,TableCell<ICFBamFloatTypeObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamFloatTypeObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamFloatTypeObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamFloatTypeObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamFloatTypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamFloatTypeObj> observable,
					ICFBamFloatTypeObj oldValue,
					ICFBamFloatTypeObj newValue )
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
					invokeWhenChosen.choseFloatType( null );
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
					ICFBamFloatTypeObj selectedInstance = getJavaFXFocusAsFloatType();
					invokeWhenChosen.choseFloatType( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamFloatTypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamFloatTypeObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamFloatTypeObj getJavaFXFocusAsFloatType() {
		return( (ICFBamFloatTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsFloatType( ICFBamFloatTypeObj value ) {
		setJavaFXFocus( value );
	}

	public class FloatTypeByQualNameComparator
	implements Comparator<ICFBamFloatTypeObj>
	{
		public FloatTypeByQualNameComparator() {
		}

		public int compare( ICFBamFloatTypeObj lhs, ICFBamFloatTypeObj rhs ) {
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

	protected FloatTypeByQualNameComparator compareFloatTypeByQualName = new FloatTypeByQualNameComparator();

	public Collection<ICFBamFloatTypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamFloatTypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfFloatType = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamFloatTypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfFloatType.add( iter.next() );
				}
				observableListOfFloatType.sort( compareFloatTypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfFloatType );
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
		ICFBamFloatTypeObj selectedObj = getJavaFXFocusAsFloatType();
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

