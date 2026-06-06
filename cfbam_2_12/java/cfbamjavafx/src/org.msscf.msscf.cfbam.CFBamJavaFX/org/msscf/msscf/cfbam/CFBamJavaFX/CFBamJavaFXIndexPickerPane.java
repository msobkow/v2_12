// Description: Java 11 JavaFX Picker of Obj Pane implementation for Index.

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
 *	CFBamJavaFXIndexPickerPane JavaFX Pick Obj Pane implementation
 *	for Index.
 */
public class CFBamJavaFXIndexPickerPane
extends CFBorderPane
implements ICFBamJavaFXIndexPaneList
{
	public static String S_FormName = "Choose Index";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamIndexObj> javafxDataCollection = null;
	protected ObservableList<ICFBamIndexObj> observableListOfIndex = null;
	protected TableColumn<ICFBamIndexObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnName = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamIndexObj, String> tableColumnSuffix = null;
	protected TableColumn<ICFBamIndexObj, Boolean> tableColumnIsUnique = null;
	protected TableColumn<ICFBamIndexObj, Boolean> tableColumnIsDbMapped = null;
	protected TableColumn<ICFBamIndexObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamIndexObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXIndexChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXIndexPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamIndexObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamIndexObj> argDataCollection,
		ICFBamJavaFXIndexChosen whenChosen )
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
		dataTable = new TableView<ICFBamIndexObj>();
		tableColumnId = new TableColumn<ICFBamIndexObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamIndexObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,Long>,TableCell<ICFBamIndexObj,Long>>() {
			@Override public TableCell<ICFBamIndexObj,Long> call(
				TableColumn<ICFBamIndexObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamIndexObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamIndexObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamIndexObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamIndexObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamIndexObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDbName = new TableColumn<ICFBamIndexObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnSuffix = new TableColumn<ICFBamIndexObj,String>( "Suffix" );
		tableColumnSuffix.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamIndexObj, String> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnSuffix.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,String>,TableCell<ICFBamIndexObj,String>>() {
			@Override public TableCell<ICFBamIndexObj,String> call(
				TableColumn<ICFBamIndexObj,String> arg)
			{
				return new CFStringTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSuffix );
		tableColumnIsUnique = new TableColumn<ICFBamIndexObj,Boolean>( "Is Unique" );
		tableColumnIsUnique.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamIndexObj, Boolean> p ) {
				ICFBamIndexObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsUnique();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsUnique.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,Boolean>,TableCell<ICFBamIndexObj,Boolean>>() {
			@Override public TableCell<ICFBamIndexObj,Boolean> call(
				TableColumn<ICFBamIndexObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsUnique );
		tableColumnIsDbMapped = new TableColumn<ICFBamIndexObj,Boolean>( "Is Db Mapped" );
		tableColumnIsDbMapped.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamIndexObj, Boolean> p ) {
				ICFBamIndexObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsDbMapped();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsDbMapped.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,Boolean>,TableCell<ICFBamIndexObj,Boolean>>() {
			@Override public TableCell<ICFBamIndexObj,Boolean> call(
				TableColumn<ICFBamIndexObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsDbMapped );
		tableColumnLookupDefSchema = new TableColumn<ICFBamIndexObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamIndexObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamIndexObj, ICFBamSchemaDefObj> p ) {
				ICFBamIndexObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamIndexObj,ICFBamSchemaDefObj>,TableCell<ICFBamIndexObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamIndexObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamIndexObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamIndexObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamIndexObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamIndexObj> observable,
					ICFBamIndexObj oldValue,
					ICFBamIndexObj newValue )
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
					invokeWhenChosen.choseIndex( null );
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
					ICFBamIndexObj selectedInstance = getJavaFXFocusAsIndex();
					invokeWhenChosen.choseIndex( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamIndexObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamIndexObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamIndexObj getJavaFXFocusAsIndex() {
		return( (ICFBamIndexObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsIndex( ICFBamIndexObj value ) {
		setJavaFXFocus( value );
	}

	public class IndexByQualNameComparator
	implements Comparator<ICFBamIndexObj>
	{
		public IndexByQualNameComparator() {
		}

		public int compare( ICFBamIndexObj lhs, ICFBamIndexObj rhs ) {
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

	protected IndexByQualNameComparator compareIndexByQualName = new IndexByQualNameComparator();

	public Collection<ICFBamIndexObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamIndexObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfIndex = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamIndexObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfIndex.add( iter.next() );
				}
				observableListOfIndex.sort( compareIndexByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfIndex );
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
		ICFBamIndexObj selectedObj = getJavaFXFocusAsIndex();
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

