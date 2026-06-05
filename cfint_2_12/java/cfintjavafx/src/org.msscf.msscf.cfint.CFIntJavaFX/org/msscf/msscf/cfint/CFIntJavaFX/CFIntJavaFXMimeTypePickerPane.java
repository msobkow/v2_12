// Description: Java 11 JavaFX Picker of Obj Pane implementation for MimeType.

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
 *	CFIntJavaFXMimeTypePickerPane JavaFX Pick Obj Pane implementation
 *	for MimeType.
 */
public class CFIntJavaFXMimeTypePickerPane
extends CFBorderPane
implements ICFIntJavaFXMimeTypePaneList
{
	public static String S_FormName = "Choose MIME Type";
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected Collection<ICFIntMimeTypeObj> javafxDataCollection = null;
	protected ObservableList<ICFIntMimeTypeObj> observableListOfMimeType = null;
	protected TableColumn<ICFIntMimeTypeObj, Integer> tableColumnMimeTypeId = null;
	protected TableColumn<ICFIntMimeTypeObj, String> tableColumnName = null;
	protected TableColumn<ICFIntMimeTypeObj, String> tableColumnFileTypes = null;
	protected TableView<ICFIntMimeTypeObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFIntJavaFXMimeTypeChosen invokeWhenChosen = null;
	protected ICFLibAnyObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFIntJavaFXMimeTypePickerPane( ICFFormManager formManager,
		ICFIntJavaFXSchema argSchema,
		ICFIntMimeTypeObj argFocus,
		ICFLibAnyObj argContainer,
		Collection<ICFIntMimeTypeObj> argDataCollection,
		ICFIntJavaFXMimeTypeChosen whenChosen )
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
		dataTable = new TableView<ICFIntMimeTypeObj>();
		tableColumnMimeTypeId = new TableColumn<ICFIntMimeTypeObj,Integer>( "MIME Type Id" );
		tableColumnMimeTypeId.setCellValueFactory( new Callback<CellDataFeatures<ICFIntMimeTypeObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<ICFIntMimeTypeObj, Integer> p ) {
				ICFIntMimeTypeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredMimeTypeId();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnMimeTypeId.setCellFactory( new Callback<TableColumn<ICFIntMimeTypeObj,Integer>,TableCell<ICFIntMimeTypeObj,Integer>>() {
			@Override public TableCell<ICFIntMimeTypeObj,Integer> call(
				TableColumn<ICFIntMimeTypeObj,Integer> arg)
			{
				return new CFInt32TableCell<ICFIntMimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMimeTypeId );
		tableColumnName = new TableColumn<ICFIntMimeTypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFIntMimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntMimeTypeObj, String> p ) {
				ICFIntMimeTypeObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFIntMimeTypeObj,String>,TableCell<ICFIntMimeTypeObj,String>>() {
			@Override public TableCell<ICFIntMimeTypeObj,String> call(
				TableColumn<ICFIntMimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFIntMimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnFileTypes = new TableColumn<ICFIntMimeTypeObj,String>( "FileTypes" );
		tableColumnFileTypes.setCellValueFactory( new Callback<CellDataFeatures<ICFIntMimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntMimeTypeObj, String> p ) {
				ICFIntMimeTypeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalFileTypes();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnFileTypes.setCellFactory( new Callback<TableColumn<ICFIntMimeTypeObj,String>,TableCell<ICFIntMimeTypeObj,String>>() {
			@Override public TableCell<ICFIntMimeTypeObj,String> call(
				TableColumn<ICFIntMimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFIntMimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnFileTypes );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFIntMimeTypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFIntMimeTypeObj> observable,
					ICFIntMimeTypeObj oldValue,
					ICFIntMimeTypeObj newValue )
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
					invokeWhenChosen.choseMimeType( null );
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
					ICFIntMimeTypeObj selectedInstance = getJavaFXFocusAsMimeType();
					invokeWhenChosen.choseMimeType( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFIntMimeTypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntMimeTypeObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFIntMimeTypeObj getJavaFXFocusAsMimeType() {
		return( (ICFIntMimeTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsMimeType( ICFIntMimeTypeObj value ) {
		setJavaFXFocus( value );
	}

	public class MimeTypeByQualNameComparator
	implements Comparator<ICFIntMimeTypeObj>
	{
		public MimeTypeByQualNameComparator() {
		}

		public int compare( ICFIntMimeTypeObj lhs, ICFIntMimeTypeObj rhs ) {
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

	protected MimeTypeByQualNameComparator compareMimeTypeByQualName = new MimeTypeByQualNameComparator();

	public Collection<ICFIntMimeTypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFIntMimeTypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfMimeType = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFIntMimeTypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfMimeType.add( iter.next() );
				}
				observableListOfMimeType.sort( compareMimeTypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfMimeType );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFLibAnyObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFLibAnyObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFIntMimeTypeObj selectedObj = getJavaFXFocusAsMimeType();
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

