// Description: Java 11 JavaFX Picker of Obj Pane implementation for TimeDef.

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
 *	CFBamJavaFXTimeDefPickerPane JavaFX Pick Obj Pane implementation
 *	for TimeDef.
 */
public class CFBamJavaFXTimeDefPickerPane
extends CFBorderPane
implements ICFBamJavaFXTimeDefPaneList
{
	public static String S_FormName = "Choose TimeDef";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTimeDefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTimeDefObj> observableListOfTimeDef = null;
	protected TableColumn<ICFBamTimeDefObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamTimeDefObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnName = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamTimeDefObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamTimeDefObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamTimeDefObj, String> tableColumnDummy = null;
	protected TableColumn<ICFBamTimeDefObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamTimeDefObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXTimeDefChosen invokeWhenChosen = null;
	protected ICFBamScopeObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXTimeDefPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamTimeDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamTimeDefObj> argDataCollection,
		ICFBamJavaFXTimeDefChosen whenChosen )
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
		dataTable = new TableView<ICFBamTimeDefObj>();
		tableColumnObjKind = new TableColumn<ICFBamTimeDefObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
				ICFBamTimeDefObj obj = p.getValue();
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
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamTimeDefObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamTimeDefObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,Long>,TableCell<ICFBamTimeDefObj,Long>>() {
			@Override public TableCell<ICFBamTimeDefObj,Long> call(
				TableColumn<ICFBamTimeDefObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTimeDefObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamTimeDefObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTimeDefObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTimeDefObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTimeDefObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamTimeDefObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamTimeDefObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTimeDefObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,Boolean>,TableCell<ICFBamTimeDefObj,Boolean>>() {
			@Override public TableCell<ICFBamTimeDefObj,Boolean> call(
				TableColumn<ICFBamTimeDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamTimeDefObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTimeDefObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,Boolean>,TableCell<ICFBamTimeDefObj,Boolean>>() {
			@Override public TableCell<ICFBamTimeDefObj,Boolean> call(
				TableColumn<ICFBamTimeDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamTimeDefObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnDummy = new TableColumn<ICFBamTimeDefObj,String>( "Dummy" );
		tableColumnDummy.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTimeDefObj, String> p ) {
				ICFBamTimeDefObj obj = p.getValue();
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
		tableColumnDummy.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,String>,TableCell<ICFBamTimeDefObj,String>>() {
			@Override public TableCell<ICFBamTimeDefObj,String> call(
				TableColumn<ICFBamTimeDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTimeDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDummy );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTimeDefObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTimeDefObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTimeDefObj, ICFBamSchemaDefObj> p ) {
				ICFBamTimeDefObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTimeDefObj,ICFBamSchemaDefObj>,TableCell<ICFBamTimeDefObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTimeDefObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTimeDefObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTimeDefObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTimeDefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTimeDefObj> observable,
					ICFBamTimeDefObj oldValue,
					ICFBamTimeDefObj newValue )
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
					invokeWhenChosen.choseTimeDef( null );
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
					ICFBamTimeDefObj selectedInstance = getJavaFXFocusAsTimeDef();
					invokeWhenChosen.choseTimeDef( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamTimeDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTimeDefObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamTimeDefObj getJavaFXFocusAsTimeDef() {
		return( (ICFBamTimeDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTimeDef( ICFBamTimeDefObj value ) {
		setJavaFXFocus( value );
	}

	public class TimeDefByQualNameComparator
	implements Comparator<ICFBamTimeDefObj>
	{
		public TimeDefByQualNameComparator() {
		}

		public int compare( ICFBamTimeDefObj lhs, ICFBamTimeDefObj rhs ) {
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

	protected TimeDefByQualNameComparator compareTimeDefByQualName = new TimeDefByQualNameComparator();

	public Collection<ICFBamTimeDefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTimeDefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTimeDef = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTimeDefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTimeDef.add( iter.next() );
				}
				observableListOfTimeDef.sort( compareTimeDefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTimeDef );
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
		ICFBamTimeDefObj selectedObj = getJavaFXFocusAsTimeDef();
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

