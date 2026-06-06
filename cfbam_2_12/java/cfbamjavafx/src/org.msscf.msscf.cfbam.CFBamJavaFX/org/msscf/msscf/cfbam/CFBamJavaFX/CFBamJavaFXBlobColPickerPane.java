// Description: Java 11 JavaFX Picker of Obj Pane implementation for BlobCol.

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
 *	CFBamJavaFXBlobColPickerPane JavaFX Pick Obj Pane implementation
 *	for BlobCol.
 */
public class CFBamJavaFXBlobColPickerPane
extends CFBorderPane
implements ICFBamJavaFXBlobColPaneList
{
	public static String S_FormName = "Choose BlobCol";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamBlobColObj> javafxDataCollection = null;
	protected ObservableList<ICFBamBlobColObj> observableListOfBlobCol = null;
	protected TableColumn<ICFBamBlobColObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnName = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamBlobColObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamBlobColObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamBlobColObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamBlobColObj, Integer> tableColumnMaxLen = null;
	protected TableColumn<ICFBamBlobColObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamBlobColObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXBlobColChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXBlobColPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamBlobColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamBlobColObj> argDataCollection,
		ICFBamJavaFXBlobColChosen whenChosen )
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
		dataTable = new TableView<ICFBamBlobColObj>();
		tableColumnId = new TableColumn<ICFBamBlobColObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamBlobColObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,Long>,TableCell<ICFBamBlobColObj,Long>>() {
			@Override public TableCell<ICFBamBlobColObj,Long> call(
				TableColumn<ICFBamBlobColObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamBlobColObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamBlobColObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamBlobColObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamBlobColObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamBlobColObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamBlobColObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamBlobColObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamBlobColObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,Boolean>,TableCell<ICFBamBlobColObj,Boolean>>() {
			@Override public TableCell<ICFBamBlobColObj,Boolean> call(
				TableColumn<ICFBamBlobColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamBlobColObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamBlobColObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,Boolean>,TableCell<ICFBamBlobColObj,Boolean>>() {
			@Override public TableCell<ICFBamBlobColObj,Boolean> call(
				TableColumn<ICFBamBlobColObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamBlobColObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamBlobColObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,String>,TableCell<ICFBamBlobColObj,String>>() {
			@Override public TableCell<ICFBamBlobColObj,String> call(
				TableColumn<ICFBamBlobColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnMaxLen = new TableColumn<ICFBamBlobColObj,Integer>( "Max. Length" );
		tableColumnMaxLen.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<ICFBamBlobColObj, Integer> p ) {
				ICFBamBlobDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredMaxLen();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnMaxLen.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,Integer>,TableCell<ICFBamBlobColObj,Integer>>() {
			@Override public TableCell<ICFBamBlobColObj,Integer> call(
				TableColumn<ICFBamBlobColObj,Integer> arg)
			{
				return new CFInt32TableCell<ICFBamBlobColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxLen );
		tableColumnLookupDefSchema = new TableColumn<ICFBamBlobColObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamBlobColObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamBlobColObj, ICFBamSchemaDefObj> p ) {
				ICFBamBlobColObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamBlobColObj,ICFBamSchemaDefObj>,TableCell<ICFBamBlobColObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamBlobColObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamBlobColObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamBlobColObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamBlobColObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamBlobColObj> observable,
					ICFBamBlobColObj oldValue,
					ICFBamBlobColObj newValue )
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
					invokeWhenChosen.choseBlobCol( null );
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
					ICFBamBlobColObj selectedInstance = getJavaFXFocusAsBlobCol();
					invokeWhenChosen.choseBlobCol( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamBlobColObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamBlobColObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamBlobColObj getJavaFXFocusAsBlobCol() {
		return( (ICFBamBlobColObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsBlobCol( ICFBamBlobColObj value ) {
		setJavaFXFocus( value );
	}

	public class BlobColByQualNameComparator
	implements Comparator<ICFBamBlobColObj>
	{
		public BlobColByQualNameComparator() {
		}

		public int compare( ICFBamBlobColObj lhs, ICFBamBlobColObj rhs ) {
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

	protected BlobColByQualNameComparator compareBlobColByQualName = new BlobColByQualNameComparator();

	public Collection<ICFBamBlobColObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamBlobColObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfBlobCol = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamBlobColObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfBlobCol.add( iter.next() );
				}
				observableListOfBlobCol.sort( compareBlobColByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfBlobCol );
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
		ICFBamBlobColObj selectedObj = getJavaFXFocusAsBlobCol();
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

