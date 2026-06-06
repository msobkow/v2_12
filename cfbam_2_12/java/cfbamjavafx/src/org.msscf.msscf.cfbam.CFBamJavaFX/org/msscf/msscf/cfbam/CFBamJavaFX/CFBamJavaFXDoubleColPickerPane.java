// Description: Java 11 JavaFX Picker of Obj Pane implementation for DoubleCol.

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
 *	CFBamJavaFXDoubleColPickerPane JavaFX Pick Obj Pane implementation
 *	for DoubleCol.
 */
public class CFBamJavaFXDoubleColPickerPane
extends CFBorderPane
implements ICFBamJavaFXDoubleColPaneList
{
	public static String S_FormName = "Choose DoubleCol";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamDoubleColObj> javafxDataCollection = null;
	protected ObservableList<ICFBamDoubleColObj> observableListOfDoubleCol = null;
	protected TableColumn<ICFBamDoubleColObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnName = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamDoubleColObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamDoubleColObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamDoubleColObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamDoubleColObj, Double> tableColumnInitValue = null;
	protected TableColumn<ICFBamDoubleColObj, Double> tableColumnMinValue = null;
	protected TableColumn<ICFBamDoubleColObj, Double> tableColumnMaxValue = null;
	protected TableColumn<ICFBamDoubleColObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamDoubleColObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXDoubleColChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXDoubleColPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamDoubleColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamDoubleColObj> argDataCollection,
		ICFBamJavaFXDoubleColChosen whenChosen )
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
		dataTable = new TableView<ICFBamDoubleColObj>();
		tableColumnId = new TableColumn<ICFBamDoubleColObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamDoubleColObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,Long>,TableCell<ICFBamDoubleColObj,Long>>() {
			@Override public TableCell<ICFBamDoubleColObj,Long> call(
				TableColumn<ICFBamDoubleColObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamDoubleColObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamDoubleColObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamDoubleColObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamDoubleColObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamDoubleColObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamDoubleColObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamDoubleColObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamDoubleColObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,Boolean>,TableCell<ICFBamDoubleColObj,Boolean>>() {
			@Override public TableCell<ICFBamDoubleColObj,Boolean> call(
				TableColumn<ICFBamDoubleColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamDoubleColObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamDoubleColObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,Boolean>,TableCell<ICFBamDoubleColObj,Boolean>>() {
			@Override public TableCell<ICFBamDoubleColObj,Boolean> call(
				TableColumn<ICFBamDoubleColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamDoubleColObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDoubleColObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,String>,TableCell<ICFBamDoubleColObj,String>>() {
			@Override public TableCell<ICFBamDoubleColObj,String> call(
				TableColumn<ICFBamDoubleColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamDoubleColObj,Double>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,Double>,ObservableValue<Double> >() {
			public ObservableValue<Double> call( CellDataFeatures<ICFBamDoubleColObj, Double> p ) {
				ICFBamDoubleDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Double value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Double> observable = new ReadOnlyObjectWrapper<Double>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,Double>,TableCell<ICFBamDoubleColObj,Double>>() {
			@Override public TableCell<ICFBamDoubleColObj,Double> call(
				TableColumn<ICFBamDoubleColObj,Double> arg)
			{
				return new CFDoubleTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamDoubleColObj,Double>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,Double>,ObservableValue<Double> >() {
			public ObservableValue<Double> call( CellDataFeatures<ICFBamDoubleColObj, Double> p ) {
				ICFBamDoubleDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Double value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Double> observable = new ReadOnlyObjectWrapper<Double>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,Double>,TableCell<ICFBamDoubleColObj,Double>>() {
			@Override public TableCell<ICFBamDoubleColObj,Double> call(
				TableColumn<ICFBamDoubleColObj,Double> arg)
			{
				return new CFDoubleTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamDoubleColObj,Double>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,Double>,ObservableValue<Double> >() {
			public ObservableValue<Double> call( CellDataFeatures<ICFBamDoubleColObj, Double> p ) {
				ICFBamDoubleDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Double value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Double> observable = new ReadOnlyObjectWrapper<Double>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,Double>,TableCell<ICFBamDoubleColObj,Double>>() {
			@Override public TableCell<ICFBamDoubleColObj,Double> call(
				TableColumn<ICFBamDoubleColObj,Double> arg)
			{
				return new CFDoubleTableCell<ICFBamDoubleColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamDoubleColObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDoubleColObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamDoubleColObj, ICFBamSchemaDefObj> p ) {
				ICFBamDoubleColObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamDoubleColObj,ICFBamSchemaDefObj>,TableCell<ICFBamDoubleColObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamDoubleColObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamDoubleColObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamDoubleColObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamDoubleColObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamDoubleColObj> observable,
					ICFBamDoubleColObj oldValue,
					ICFBamDoubleColObj newValue )
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
					invokeWhenChosen.choseDoubleCol( null );
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
					ICFBamDoubleColObj selectedInstance = getJavaFXFocusAsDoubleCol();
					invokeWhenChosen.choseDoubleCol( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamDoubleColObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDoubleColObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamDoubleColObj getJavaFXFocusAsDoubleCol() {
		return( (ICFBamDoubleColObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsDoubleCol( ICFBamDoubleColObj value ) {
		setJavaFXFocus( value );
	}

	public class DoubleColByQualNameComparator
	implements Comparator<ICFBamDoubleColObj>
	{
		public DoubleColByQualNameComparator() {
		}

		public int compare( ICFBamDoubleColObj lhs, ICFBamDoubleColObj rhs ) {
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

	protected DoubleColByQualNameComparator compareDoubleColByQualName = new DoubleColByQualNameComparator();

	public Collection<ICFBamDoubleColObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamDoubleColObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfDoubleCol = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamDoubleColObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfDoubleCol.add( iter.next() );
				}
				observableListOfDoubleCol.sort( compareDoubleColByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfDoubleCol );
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
		ICFBamDoubleColObj selectedObj = getJavaFXFocusAsDoubleCol();
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

