// Description: Java 11 JavaFX Picker of Obj Pane implementation for TZTimestampCol.

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
 *	CFBamJavaFXTZTimestampColPickerPane JavaFX Pick Obj Pane implementation
 *	for TZTimestampCol.
 */
public class CFBamJavaFXTZTimestampColPickerPane
extends CFBorderPane
implements ICFBamJavaFXTZTimestampColPaneList
{
	public static String S_FormName = "Choose TZTimestampCol";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTZTimestampColObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTZTimestampColObj> observableListOfTZTimestampCol = null;
	protected TableColumn<ICFBamTZTimestampColObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnName = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamTZTimestampColObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamTZTimestampColObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamTZTimestampColObj, String> tableColumnDummy = null;
	protected TableColumn<ICFBamTZTimestampColObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamTZTimestampColObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXTZTimestampColChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXTZTimestampColPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamTZTimestampColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamTZTimestampColObj> argDataCollection,
		ICFBamJavaFXTZTimestampColChosen whenChosen )
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
		dataTable = new TableView<ICFBamTZTimestampColObj>();
		tableColumnId = new TableColumn<ICFBamTZTimestampColObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamTZTimestampColObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,Long>,TableCell<ICFBamTZTimestampColObj,Long>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,Long> call(
				TableColumn<ICFBamTZTimestampColObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTZTimestampColObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamTZTimestampColObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTZTimestampColObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTZTimestampColObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTZTimestampColObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamTZTimestampColObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamTZTimestampColObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTZTimestampColObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,Boolean>,TableCell<ICFBamTZTimestampColObj,Boolean>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,Boolean> call(
				TableColumn<ICFBamTZTimestampColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamTZTimestampColObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTZTimestampColObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,Boolean>,TableCell<ICFBamTZTimestampColObj,Boolean>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,Boolean> call(
				TableColumn<ICFBamTZTimestampColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamTZTimestampColObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnDummy = new TableColumn<ICFBamTZTimestampColObj,String>( "Dummy" );
		tableColumnDummy.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampColObj, String> p ) {
				ICFBamTZTimestampDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDummy();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDummy.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,String>,TableCell<ICFBamTZTimestampColObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,String> call(
				TableColumn<ICFBamTZTimestampColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDummy );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTZTimestampColObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampColObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTZTimestampColObj, ICFBamSchemaDefObj> p ) {
				ICFBamTZTimestampColObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampColObj,ICFBamSchemaDefObj>,TableCell<ICFBamTZTimestampColObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTZTimestampColObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTZTimestampColObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTZTimestampColObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTZTimestampColObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTZTimestampColObj> observable,
					ICFBamTZTimestampColObj oldValue,
					ICFBamTZTimestampColObj newValue )
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
					invokeWhenChosen.choseTZTimestampCol( null );
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
					ICFBamTZTimestampColObj selectedInstance = getJavaFXFocusAsTZTimestampCol();
					invokeWhenChosen.choseTZTimestampCol( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamTZTimestampColObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTZTimestampColObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamTZTimestampColObj getJavaFXFocusAsTZTimestampCol() {
		return( (ICFBamTZTimestampColObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTZTimestampCol( ICFBamTZTimestampColObj value ) {
		setJavaFXFocus( value );
	}

	public class TZTimestampColByQualNameComparator
	implements Comparator<ICFBamTZTimestampColObj>
	{
		public TZTimestampColByQualNameComparator() {
		}

		public int compare( ICFBamTZTimestampColObj lhs, ICFBamTZTimestampColObj rhs ) {
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

	protected TZTimestampColByQualNameComparator compareTZTimestampColByQualName = new TZTimestampColByQualNameComparator();

	public Collection<ICFBamTZTimestampColObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTZTimestampColObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTZTimestampCol = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTZTimestampColObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTZTimestampCol.add( iter.next() );
				}
				observableListOfTZTimestampCol.sort( compareTZTimestampColByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTZTimestampCol );
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
		ICFBamTZTimestampColObj selectedObj = getJavaFXFocusAsTZTimestampCol();
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

