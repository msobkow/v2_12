// Description: Java 11 JavaFX Picker of Obj Pane implementation for MajorVersion.

/*
 *	org.msscf.msscf.CFInt
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
 *	CFIntJavaFXMajorVersionPickerPane JavaFX Pick Obj Pane implementation
 *	for MajorVersion.
 */
public class CFIntJavaFXMajorVersionPickerPane
extends CFBorderPane
implements ICFIntJavaFXMajorVersionPaneList
{
	public static String S_FormName = "Choose MajorVersion";
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected Collection<ICFIntMajorVersionObj> javafxDataCollection = null;
	protected ObservableList<ICFIntMajorVersionObj> observableListOfMajorVersion = null;
	protected TableColumn<ICFIntMajorVersionObj, Long> tableColumnId = null;
	protected TableColumn<ICFIntMajorVersionObj, String> tableColumnName = null;
	protected TableColumn<ICFIntMajorVersionObj, String> tableColumnDescription = null;
	protected TableView<ICFIntMajorVersionObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFIntJavaFXMajorVersionChosen invokeWhenChosen = null;
	protected ICFIntSubProjectObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFIntJavaFXMajorVersionPickerPane( ICFFormManager formManager,
		ICFIntJavaFXSchema argSchema,
		ICFIntMajorVersionObj argFocus,
		ICFIntSubProjectObj argContainer,
		Collection<ICFIntMajorVersionObj> argDataCollection,
		ICFIntJavaFXMajorVersionChosen whenChosen )
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
		dataTable = new TableView<ICFIntMajorVersionObj>();
		tableColumnId = new TableColumn<ICFIntMajorVersionObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFIntMajorVersionObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFIntMajorVersionObj, Long> p ) {
				ICFIntMajorVersionObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFIntMajorVersionObj,Long>,TableCell<ICFIntMajorVersionObj,Long>>() {
			@Override public TableCell<ICFIntMajorVersionObj,Long> call(
				TableColumn<ICFIntMajorVersionObj,Long> arg)
			{
				return new CFInt64TableCell<ICFIntMajorVersionObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFIntMajorVersionObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFIntMajorVersionObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntMajorVersionObj, String> p ) {
				ICFIntMajorVersionObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFIntMajorVersionObj,String>,TableCell<ICFIntMajorVersionObj,String>>() {
			@Override public TableCell<ICFIntMajorVersionObj,String> call(
				TableColumn<ICFIntMajorVersionObj,String> arg)
			{
				return new CFStringTableCell<ICFIntMajorVersionObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDescription = new TableColumn<ICFIntMajorVersionObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFIntMajorVersionObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntMajorVersionObj, String> p ) {
				ICFIntMajorVersionObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFIntMajorVersionObj,String>,TableCell<ICFIntMajorVersionObj,String>>() {
			@Override public TableCell<ICFIntMajorVersionObj,String> call(
				TableColumn<ICFIntMajorVersionObj,String> arg)
			{
				return new CFStringTableCell<ICFIntMajorVersionObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFIntMajorVersionObj>() {
				@Override public void changed( ObservableValue<? extends ICFIntMajorVersionObj> observable,
					ICFIntMajorVersionObj oldValue,
					ICFIntMajorVersionObj newValue )
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
					invokeWhenChosen.choseMajorVersion( null );
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
					ICFIntMajorVersionObj selectedInstance = getJavaFXFocusAsMajorVersion();
					invokeWhenChosen.choseMajorVersion( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFIntMajorVersionObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntMajorVersionObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFIntMajorVersionObj getJavaFXFocusAsMajorVersion() {
		return( (ICFIntMajorVersionObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsMajorVersion( ICFIntMajorVersionObj value ) {
		setJavaFXFocus( value );
	}

	public class MajorVersionByQualNameComparator
	implements Comparator<ICFIntMajorVersionObj>
	{
		public MajorVersionByQualNameComparator() {
		}

		public int compare( ICFIntMajorVersionObj lhs, ICFIntMajorVersionObj rhs ) {
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

	protected MajorVersionByQualNameComparator compareMajorVersionByQualName = new MajorVersionByQualNameComparator();

	public Collection<ICFIntMajorVersionObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFIntMajorVersionObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfMajorVersion = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFIntMajorVersionObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfMajorVersion.add( iter.next() );
				}
				observableListOfMajorVersion.sort( compareMajorVersionByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfMajorVersion );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFIntSubProjectObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFIntSubProjectObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFIntMajorVersionObj selectedObj = getJavaFXFocusAsMajorVersion();
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

