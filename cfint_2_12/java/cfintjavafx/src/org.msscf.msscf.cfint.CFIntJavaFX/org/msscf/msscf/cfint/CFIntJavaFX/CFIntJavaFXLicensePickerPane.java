// Description: Java 11 JavaFX Picker of Obj Pane implementation for License.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntJavaFX;

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
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;

/**
 *	CFIntJavaFXLicensePickerPane JavaFX Pick Obj Pane implementation
 *	for License.
 */
public class CFIntJavaFXLicensePickerPane
extends CFBorderPane
implements ICFIntJavaFXLicensePaneList
{
	public static String S_FormName = "Choose License";
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected Collection<ICFIntLicenseObj> javafxDataCollection = null;
	protected ObservableList<ICFIntLicenseObj> observableListOfLicense = null;
	protected TableColumn<ICFIntLicenseObj, Long> tableColumnId = null;
	protected TableColumn<ICFIntLicenseObj, String> tableColumnName = null;
	protected TableColumn<ICFIntLicenseObj, String> tableColumnDescription = null;
	protected TableColumn<ICFIntLicenseObj, String> tableColumnEmbeddedText = null;
	protected TableColumn<ICFIntLicenseObj, String> tableColumnFullText = null;
	protected TableView<ICFIntLicenseObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFIntJavaFXLicenseChosen invokeWhenChosen = null;
	protected ICFIntTopDomainObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFIntJavaFXLicensePickerPane( ICFFormManager formManager,
		ICFIntJavaFXSchema argSchema,
		ICFIntLicenseObj argFocus,
		ICFIntTopDomainObj argContainer,
		Collection<ICFIntLicenseObj> argDataCollection,
		ICFIntJavaFXLicenseChosen whenChosen )
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
		dataTable = new TableView<ICFIntLicenseObj>();
		tableColumnId = new TableColumn<ICFIntLicenseObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFIntLicenseObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFIntLicenseObj, Long> p ) {
				ICFIntLicenseObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFIntLicenseObj,Long>,TableCell<ICFIntLicenseObj,Long>>() {
			@Override public TableCell<ICFIntLicenseObj,Long> call(
				TableColumn<ICFIntLicenseObj,Long> arg)
			{
				return new CFInt64TableCell<ICFIntLicenseObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFIntLicenseObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFIntLicenseObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntLicenseObj, String> p ) {
				ICFIntLicenseObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFIntLicenseObj,String>,TableCell<ICFIntLicenseObj,String>>() {
			@Override public TableCell<ICFIntLicenseObj,String> call(
				TableColumn<ICFIntLicenseObj,String> arg)
			{
				return new CFStringTableCell<ICFIntLicenseObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDescription = new TableColumn<ICFIntLicenseObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFIntLicenseObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntLicenseObj, String> p ) {
				ICFIntLicenseObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFIntLicenseObj,String>,TableCell<ICFIntLicenseObj,String>>() {
			@Override public TableCell<ICFIntLicenseObj,String> call(
				TableColumn<ICFIntLicenseObj,String> arg)
			{
				return new CFStringTableCell<ICFIntLicenseObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnEmbeddedText = new TableColumn<ICFIntLicenseObj,String>( "EmbeddedText" );
		tableColumnEmbeddedText.setCellValueFactory( new Callback<CellDataFeatures<ICFIntLicenseObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntLicenseObj, String> p ) {
				ICFIntLicenseObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalEmbeddedText();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnEmbeddedText.setCellFactory( new Callback<TableColumn<ICFIntLicenseObj,String>,TableCell<ICFIntLicenseObj,String>>() {
			@Override public TableCell<ICFIntLicenseObj,String> call(
				TableColumn<ICFIntLicenseObj,String> arg)
			{
				return new CFTextTableCell<ICFIntLicenseObj>();
			}
		});
		dataTable.getColumns().add( tableColumnEmbeddedText );
		tableColumnFullText = new TableColumn<ICFIntLicenseObj,String>( "FullText" );
		tableColumnFullText.setCellValueFactory( new Callback<CellDataFeatures<ICFIntLicenseObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntLicenseObj, String> p ) {
				ICFIntLicenseObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalFullText();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnFullText.setCellFactory( new Callback<TableColumn<ICFIntLicenseObj,String>,TableCell<ICFIntLicenseObj,String>>() {
			@Override public TableCell<ICFIntLicenseObj,String> call(
				TableColumn<ICFIntLicenseObj,String> arg)
			{
				return new CFTextTableCell<ICFIntLicenseObj>();
			}
		});
		dataTable.getColumns().add( tableColumnFullText );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFIntLicenseObj>() {
				@Override public void changed( ObservableValue<? extends ICFIntLicenseObj> observable,
					ICFIntLicenseObj oldValue,
					ICFIntLicenseObj newValue )
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
					ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					invokeWhenChosen.choseLicense( null );
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
					ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					ICFIntLicenseObj selectedInstance = getJavaFXFocusAsLicense();
					invokeWhenChosen.choseLicense( selectedInstance );
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

	public ICFIntJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFIntLicenseObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntLicenseObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFIntLicenseObj getJavaFXFocusAsLicense() {
		return( (ICFIntLicenseObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsLicense( ICFIntLicenseObj value ) {
		setJavaFXFocus( value );
	}

	public class LicenseByQualNameComparator
	implements Comparator<ICFIntLicenseObj>
	{
		public LicenseByQualNameComparator() {
		}

		public int compare( ICFIntLicenseObj lhs, ICFIntLicenseObj rhs ) {
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

	protected LicenseByQualNameComparator compareLicenseByQualName = new LicenseByQualNameComparator();

	public Collection<ICFIntLicenseObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFIntLicenseObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfLicense = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFIntLicenseObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfLicense.add( iter.next() );
				}
				observableListOfLicense.sort( compareLicenseByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfLicense );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFIntTopDomainObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFIntTopDomainObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFIntLicenseObj selectedObj = getJavaFXFocusAsLicense();
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

