// Description: Java 11 JavaFX Picker of Obj Pane implementation for EnumTag.

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
 *	CFBamJavaFXEnumTagPickerPane JavaFX Pick Obj Pane implementation
 *	for EnumTag.
 */
public class CFBamJavaFXEnumTagPickerPane
extends CFBorderPane
implements ICFBamJavaFXEnumTagPaneList
{
	public static String S_FormName = "Choose EnumTag";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamEnumTagObj> javafxDataCollection = null;
	protected ObservableList<ICFBamEnumTagObj> observableListOfEnumTag = null;
	protected TableColumn<ICFBamEnumTagObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamEnumTagObj, Short> tableColumnEnumCode = null;
	protected TableColumn<ICFBamEnumTagObj, String> tableColumnName = null;
	protected TableColumn<ICFBamEnumTagObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamEnumTagObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXEnumTagChosen invokeWhenChosen = null;
	protected ICFBamEnumDefObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXEnumTagPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamEnumTagObj argFocus,
		ICFBamEnumDefObj argContainer,
		Collection<ICFBamEnumTagObj> argDataCollection,
		ICFBamJavaFXEnumTagChosen whenChosen )
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
		dataTable = new TableView<ICFBamEnumTagObj>();
		tableColumnId = new TableColumn<ICFBamEnumTagObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamEnumTagObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamEnumTagObj, Long> p ) {
				ICFBamEnumTagObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamEnumTagObj,Long>,TableCell<ICFBamEnumTagObj,Long>>() {
			@Override public TableCell<ICFBamEnumTagObj,Long> call(
				TableColumn<ICFBamEnumTagObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamEnumTagObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnEnumCode = new TableColumn<ICFBamEnumTagObj,Short>( "EnumCode" );
		tableColumnEnumCode.setCellValueFactory( new Callback<CellDataFeatures<ICFBamEnumTagObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamEnumTagObj, Short> p ) {
				ICFBamEnumTagObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalEnumCode();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnEnumCode.setCellFactory( new Callback<TableColumn<ICFBamEnumTagObj,Short>,TableCell<ICFBamEnumTagObj,Short>>() {
			@Override public TableCell<ICFBamEnumTagObj,Short> call(
				TableColumn<ICFBamEnumTagObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamEnumTagObj>();
			}
		});
		dataTable.getColumns().add( tableColumnEnumCode );
		tableColumnName = new TableColumn<ICFBamEnumTagObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamEnumTagObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamEnumTagObj, String> p ) {
				ICFBamEnumTagObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamEnumTagObj,String>,TableCell<ICFBamEnumTagObj,String>>() {
			@Override public TableCell<ICFBamEnumTagObj,String> call(
				TableColumn<ICFBamEnumTagObj,String> arg)
			{
				return new CFStringTableCell<ICFBamEnumTagObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnLookupDefSchema = new TableColumn<ICFBamEnumTagObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamEnumTagObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamEnumTagObj, ICFBamSchemaDefObj> p ) {
				ICFBamEnumTagObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamEnumTagObj,ICFBamSchemaDefObj>,TableCell<ICFBamEnumTagObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamEnumTagObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamEnumTagObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamEnumTagObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamEnumTagObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamEnumTagObj> observable,
					ICFBamEnumTagObj oldValue,
					ICFBamEnumTagObj newValue )
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
					invokeWhenChosen.choseEnumTag( null );
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
					ICFBamEnumTagObj selectedInstance = getJavaFXFocusAsEnumTag();
					invokeWhenChosen.choseEnumTag( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamEnumTagObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamEnumTagObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamEnumTagObj getJavaFXFocusAsEnumTag() {
		return( (ICFBamEnumTagObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsEnumTag( ICFBamEnumTagObj value ) {
		setJavaFXFocus( value );
	}

	public class EnumTagByQualNameComparator
	implements Comparator<ICFBamEnumTagObj>
	{
		public EnumTagByQualNameComparator() {
		}

		public int compare( ICFBamEnumTagObj lhs, ICFBamEnumTagObj rhs ) {
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

	protected EnumTagByQualNameComparator compareEnumTagByQualName = new EnumTagByQualNameComparator();

	public Collection<ICFBamEnumTagObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamEnumTagObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfEnumTag = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamEnumTagObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfEnumTag.add( iter.next() );
				}
				observableListOfEnumTag.sort( compareEnumTagByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfEnumTag );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamEnumDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamEnumDefObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamEnumTagObj selectedObj = getJavaFXFocusAsEnumTag();
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

