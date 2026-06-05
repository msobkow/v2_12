// Description: Java 11 JavaFX Picker of Obj Pane implementation for TextType.

/*
 *	org.msscf.msscf.CFBam
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
 *	CFBamJavaFXTextTypePickerPane JavaFX Pick Obj Pane implementation
 *	for TextType.
 */
public class CFBamJavaFXTextTypePickerPane
extends CFBorderPane
implements ICFBamJavaFXTextTypePaneList
{
	public static String S_FormName = "Choose TextType";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTextTypeObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTextTypeObj> observableListOfTextType = null;
	protected TableColumn<ICFBamTextTypeObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnName = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamTextTypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamTextTypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamTextTypeObj, Integer> tableColumnMaxLen = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnInitValue = null;
	protected TableColumn<ICFBamTextTypeObj, String> tableColumnXmlElementName = null;
	protected TableColumn<ICFBamTextTypeObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamTextTypeObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXTextTypeChosen invokeWhenChosen = null;
	protected ICFBamSchemaDefObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXTextTypePickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamTextTypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamTextTypeObj> argDataCollection,
		ICFBamJavaFXTextTypeChosen whenChosen )
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
		dataTable = new TableView<ICFBamTextTypeObj>();
		tableColumnId = new TableColumn<ICFBamTextTypeObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamTextTypeObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,Long>,TableCell<ICFBamTextTypeObj,Long>>() {
			@Override public TableCell<ICFBamTextTypeObj,Long> call(
				TableColumn<ICFBamTextTypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTextTypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamTextTypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTextTypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTextTypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTextTypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamTextTypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamTextTypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTextTypeObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,Boolean>,TableCell<ICFBamTextTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamTextTypeObj,Boolean> call(
				TableColumn<ICFBamTextTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamTextTypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTextTypeObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,Boolean>,TableCell<ICFBamTextTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamTextTypeObj,Boolean> call(
				TableColumn<ICFBamTextTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamTextTypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnMaxLen = new TableColumn<ICFBamTextTypeObj,Integer>( "Max. Length" );
		tableColumnMaxLen.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<ICFBamTextTypeObj, Integer> p ) {
				ICFBamTextDefObj obj = p.getValue();
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
		tableColumnMaxLen.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,Integer>,TableCell<ICFBamTextTypeObj,Integer>>() {
			@Override public TableCell<ICFBamTextTypeObj,Integer> call(
				TableColumn<ICFBamTextTypeObj,Integer> arg)
			{
				return new CFInt32TableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxLen );
		tableColumnInitValue = new TableColumn<ICFBamTextTypeObj,String>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
				ICFBamTextDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFTextTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnXmlElementName = new TableColumn<ICFBamTextTypeObj,String>( "XmlElementName" );
		tableColumnXmlElementName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTextTypeObj, String> p ) {
				ICFBamTextDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalXmlElementName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnXmlElementName.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,String>,TableCell<ICFBamTextTypeObj,String>>() {
			@Override public TableCell<ICFBamTextTypeObj,String> call(
				TableColumn<ICFBamTextTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTextTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnXmlElementName );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTextTypeObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTextTypeObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTextTypeObj, ICFBamSchemaDefObj> p ) {
				ICFBamTextTypeObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTextTypeObj,ICFBamSchemaDefObj>,TableCell<ICFBamTextTypeObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTextTypeObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTextTypeObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTextTypeObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTextTypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTextTypeObj> observable,
					ICFBamTextTypeObj oldValue,
					ICFBamTextTypeObj newValue )
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
					invokeWhenChosen.choseTextType( null );
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
					ICFBamTextTypeObj selectedInstance = getJavaFXFocusAsTextType();
					invokeWhenChosen.choseTextType( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamTextTypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTextTypeObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamTextTypeObj getJavaFXFocusAsTextType() {
		return( (ICFBamTextTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTextType( ICFBamTextTypeObj value ) {
		setJavaFXFocus( value );
	}

	public class TextTypeByQualNameComparator
	implements Comparator<ICFBamTextTypeObj>
	{
		public TextTypeByQualNameComparator() {
		}

		public int compare( ICFBamTextTypeObj lhs, ICFBamTextTypeObj rhs ) {
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

	protected TextTypeByQualNameComparator compareTextTypeByQualName = new TextTypeByQualNameComparator();

	public Collection<ICFBamTextTypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTextTypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTextType = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTextTypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTextType.add( iter.next() );
				}
				observableListOfTextType.sort( compareTextTypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTextType );
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
		ICFBamTextTypeObj selectedObj = getJavaFXFocusAsTextType();
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

