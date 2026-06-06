// Description: Java 11 JavaFX Finder Form implementation for MimeType.

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
import java.util.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

/**
 *	CFIntJavaFXMimeTypeFinderForm JavaFX Finder Form implementation
 *	for MimeType.
 */
public class CFIntJavaFXMimeTypeFinderForm
extends CFBorderPane
implements ICFIntJavaFXMimeTypePaneCommon,
	ICFForm
{
	public static String S_FormName = "Find MIME Type";
	protected ICFFormManager cfFormManager = null;
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected CFVBox vboxMenuAdd = null;
	protected ScrollPane scrollMenuAdd = null;
	protected CFButton buttonAdd = null;
	protected CFButton buttonCancelAdd = null;
	protected CFButton buttonAddMimeType = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonClose = null;
	protected CFButton buttonDeleteSelected = null;
	protected List<ICFIntMimeTypeObj> listOfMimeType = null;
	protected ObservableList<ICFIntMimeTypeObj> observableListOfMimeType = null;
	protected TableColumn<ICFIntMimeTypeObj, Integer> tableColumnMimeTypeId = null;
	protected TableColumn<ICFIntMimeTypeObj, String> tableColumnName = null;
	protected TableColumn<ICFIntMimeTypeObj, String> tableColumnFileTypes = null;
	protected TableView<ICFIntMimeTypeObj> dataTable = null;

	class ViewEditClosedCallback implements ICFFormClosedCallback {
		public ViewEditClosedCallback() {
		}

		@Override
		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected ViewEditClosedCallback viewEditClosedCallback = null;

	public ICFFormClosedCallback getViewEditClosedCallback() {
		if( viewEditClosedCallback == null ) {
			viewEditClosedCallback = new ViewEditClosedCallback();
		}
		return( viewEditClosedCallback );
	}

	class DeleteCallback implements ICFDeleteCallback {
		public DeleteCallback() {
		}

		@Override
		public void deleted( ICFLibAnyObj deletedObject ) {
			if( deletedObject != null ) {
				refreshMe();
			}
		}

		@Override
		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected DeleteCallback deleteCallback = null;

	public ICFDeleteCallback getDeleteCallback() {
		if( deleteCallback == null ) {
			deleteCallback = new DeleteCallback();
		}
		return( deleteCallback );
	}

	public CFIntJavaFXMimeTypeFinderForm( ICFFormManager formManager, ICFIntJavaFXSchema argSchema ) {
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
		javafxSchema = argSchema;
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
				}
			});

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getHBoxMenu() );

		setTop( scrollMenu );
		setCenter( dataTable );

		refreshMe();
		javafxIsInitializing = false;
		adjustFinderButtons();
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

	public void forceCancelAndClose() {
		if( cfFormManager != null ) {
			if( cfFormManager.getCurrentForm() == this ) {
				cfFormManager.closeCurrentForm();
			}
		}
	}

	public ICFIntJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	protected class CompareCFButtonByText
	implements Comparator<CFButton>
	{
		public CompareCFButtonByText() {
		}

		@Override public int compare( CFButton lhs, CFButton rhs ) {
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
				int retval = lhs.getText().compareTo( rhs.getText() );
				return( retval );
			}
		}
	}

	public CFHBox getHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );

			buttonAddMimeType = new CFButton();
			buttonAddMimeType.setMinWidth( 200 );
			buttonAddMimeType.setText( "Add MIME Type..." );
			buttonAddMimeType.setOnAction( new EventHandler<ActionEvent>() {
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
						ICFIntMimeTypeObj obj = (ICFIntMimeTypeObj)schemaObj.getMimeTypeTableObj().newInstance();
						ICFIntMimeTypeEditObj edit = (ICFIntMimeTypeEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
						CFBorderPane frame = javafxSchema.getMimeTypeFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
						ICFIntJavaFXMimeTypePaneCommon jpanelCommon = (ICFIntJavaFXMimeTypePaneCommon)frame;
						jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddMimeType );

			buttonViewSelected = new CFButton();
			buttonViewSelected.setMinWidth( 200 );
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
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
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "MIME".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getMimeTypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFIntJavaFXMimeTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFIntMimeTypeObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonViewSelected );

			buttonEditSelected = new CFButton();
			buttonEditSelected.setMinWidth( 200 );
			buttonEditSelected.setText( "Edit Selected" );
			buttonEditSelected.setOnAction( new EventHandler<ActionEvent>() {
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
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "MIME".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getMimeTypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFIntJavaFXMimeTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFIntMimeTypeObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonEditSelected );

			buttonDeleteSelected = new CFButton();
			buttonDeleteSelected.setMinWidth( 200 );
			buttonDeleteSelected.setText( "Delete Selected" );
			buttonDeleteSelected.setOnAction( new EventHandler<ActionEvent>() {
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
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "MIME".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getMimeTypeFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFIntJavaFXMimeTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFIntMimeTypeObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonDeleteSelected );

			buttonClose = new CFButton();
			buttonClose.setMinWidth( 200 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
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
			hboxMenu.getChildren().add( buttonClose );
		}
		return( hboxMenu );
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
		adjustFinderButtons();
	}

	public ICFIntMimeTypeObj getJavaFXFocusAsMimeType() {
		return( (ICFIntMimeTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsMimeType( ICFIntMimeTypeObj value ) {
		setJavaFXFocus( value );
	}

	public void adjustFinderButtons() {
		ICFIntMimeTypeObj selectedObj = getJavaFXFocusAsMimeType();
		boolean disableState;
		if( selectedObj == null ) {
			disableState = true;
		}
		else {
			disableState = false;
		}
		boolean inAddMode;
		if( getLeft() == null ) {
			inAddMode = false;
		}
		else {
			inAddMode = true;
			disableState = true;
		}

		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( disableState );
		}
		if( buttonEditSelected != null ) {
			buttonEditSelected.setDisable( disableState );
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( disableState );
		}
		if( buttonAddMimeType != null ) {
			buttonAddMimeType.setDisable( false );
		}

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

	public void loadData( boolean forceReload ) {
		ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
		if( ( listOfMimeType == null ) || forceReload ) {
			observableListOfMimeType = null;
			listOfMimeType = schemaObj.getMimeTypeTableObj().readAllMimeType( javafxIsInitializing );
			if( listOfMimeType != null ) {
				observableListOfMimeType = FXCollections.observableArrayList( listOfMimeType );
				observableListOfMimeType.sort( compareMimeTypeByQualName );
			}
			else {
				observableListOfMimeType = FXCollections.observableArrayList();
			}
			dataTable.setItems( observableListOfMimeType );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public void refreshMe() {
		loadData( true );
	}
}
