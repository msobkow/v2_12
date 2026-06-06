// Description: Java 11 JavaFX List of Obj Pane implementation for TopProject.

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
 *	CFIntJavaFXTopProjectListPane JavaFX List of Obj Pane implementation
 *	for TopProject.
 */
public class CFIntJavaFXTopProjectListPane
extends CFBorderPane
implements ICFIntJavaFXTopProjectPaneList
{
	public static String S_FormName = "List TopProject";
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected Collection<ICFIntTopProjectObj> javafxDataCollection = null;
	protected ObservableList<ICFIntTopProjectObj> observableListOfTopProject = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected CFButton buttonAddTopProject = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFIntTopProjectObj> dataTable = null;
	protected TableColumn<ICFIntTopProjectObj, Long> tableColumnId = null;
	protected TableColumn<ICFIntTopProjectObj, String> tableColumnName = null;
	protected TableColumn<ICFIntTopProjectObj, String> tableColumnDescription = null;

	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected ICFIntTopDomainObj javafxContainer = null;
	protected ICFRefreshCallback javafxRefreshCallback = null;
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


	public CFIntJavaFXTopProjectListPane( ICFFormManager formManager,
		ICFIntJavaFXSchema argSchema,
		ICFIntTopDomainObj argContainer,
		ICFIntTopProjectObj argFocus,
		Collection<ICFIntTopProjectObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
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
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		javafxRefreshCallback = refreshCallback;
		javafxSortByChain = sortByChain;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<ICFIntTopProjectObj>();
		tableColumnId = new TableColumn<ICFIntTopProjectObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFIntTopProjectObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFIntTopProjectObj, Long> p ) {
				ICFIntTopProjectObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFIntTopProjectObj,Long>,TableCell<ICFIntTopProjectObj,Long>>() {
			@Override public TableCell<ICFIntTopProjectObj,Long> call(
				TableColumn<ICFIntTopProjectObj,Long> arg)
			{
				return new CFInt64TableCell<ICFIntTopProjectObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFIntTopProjectObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFIntTopProjectObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntTopProjectObj, String> p ) {
				ICFIntTopProjectObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFIntTopProjectObj,String>,TableCell<ICFIntTopProjectObj,String>>() {
			@Override public TableCell<ICFIntTopProjectObj,String> call(
				TableColumn<ICFIntTopProjectObj,String> arg)
			{
				return new CFStringTableCell<ICFIntTopProjectObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDescription = new TableColumn<ICFIntTopProjectObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFIntTopProjectObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFIntTopProjectObj, String> p ) {
				ICFIntTopProjectObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFIntTopProjectObj,String>,TableCell<ICFIntTopProjectObj,String>>() {
			@Override public TableCell<ICFIntTopProjectObj,String> call(
				TableColumn<ICFIntTopProjectObj,String> arg)
			{
				return new CFStringTableCell<ICFIntTopProjectObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFIntTopProjectObj>() {
				@Override public void changed( ObservableValue<? extends ICFIntTopProjectObj> observable,
					ICFIntTopProjectObj oldValue,
					ICFIntTopProjectObj newValue )
				{
					setJavaFXFocus( newValue );
				}
			});

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getPanelHBoxMenu() );

		setTop( scrollMenu );
		setCenter( dataTable );
		javafxIsInitializing = false;
		if( observableListOfTopProject != null ) {
			dataTable.setItems( observableListOfTopProject );
		}
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

	public void setPaneMode( CFPane.PaneMode value ) {
		super.setPaneMode( value );
		adjustListButtons();
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFIntTopProjectObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntTopProjectObj" );
		}
		adjustListButtons();
	}

	public ICFIntTopProjectObj getJavaFXFocusAsTopProject() {
		return( (ICFIntTopProjectObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTopProject( ICFIntTopProjectObj value ) {
		setJavaFXFocus( value );
	}

	public class TopProjectByQualNameComparator
	implements Comparator<ICFIntTopProjectObj>
	{
		public TopProjectByQualNameComparator() {
		}

		public int compare( ICFIntTopProjectObj lhs, ICFIntTopProjectObj rhs ) {
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

	protected TopProjectByQualNameComparator compareTopProjectByQualName = new TopProjectByQualNameComparator();

	public Collection<ICFIntTopProjectObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFIntTopProjectObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTopProject = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFIntTopProjectObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTopProject.add( iter.next() );
				}
				observableListOfTopProject.sort( compareTopProjectByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTopProject );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
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

	public CFHBox getPanelHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );
			buttonAddTopProject = new CFButton();
			buttonAddTopProject.setMinWidth( 200 );
			buttonAddTopProject.setText( "Add TopProject" );
			buttonAddTopProject.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
						ICFIntTopProjectObj obj = (ICFIntTopProjectObj)schemaObj.getTopProjectTableObj().newInstance();
						ICFIntTopProjectEditObj edit = (ICFIntTopProjectEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
								ICFSecTenantObj secTenant = schemaObj.getSecTenant();
								edit.setRequiredOwnerTenant( secTenant );
								ICFIntTopDomainObj container = (ICFIntTopDomainObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new CFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerParentSDom( container );
						CFBorderPane frame = javafxSchema.getTopProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
						ICFIntJavaFXTopProjectPaneCommon jpanelCommon = (ICFIntJavaFXTopProjectPaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddTopProject );
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
						ICFIntTopProjectObj selectedInstance = getJavaFXFocusAsTopProject();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TPRJ".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTopProjectFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFIntJavaFXTopProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFIntTopProjectObj" );
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
						ICFIntTopProjectObj selectedInstance = getJavaFXFocusAsTopProject();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TPRJ".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTopProjectFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFIntJavaFXTopProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFIntTopProjectObj" );
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
						ICFIntTopProjectObj selectedInstance = getJavaFXFocusAsTopProject();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TPRJ".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTopProjectFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFIntJavaFXTopProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFIntTopProjectObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonDeleteSelected );

		}
		return( hboxMenu );
	}

	public ICFIntTopDomainObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFIntTopDomainObj value ) {
		javafxContainer = value;
	}

	public void refreshMe() {
		if( javafxRefreshCallback != null ) {
			javafxRefreshCallback.refreshMe();
		}
	}

	public void adjustListButtons() {
		boolean enableState;
		boolean inEditState;
		boolean allowAdds;
		boolean inAddMode = false;
		ICFIntTopProjectObj selectedObj = getJavaFXFocusAsTopProject();
		CFPane.PaneMode mode = getPaneMode();
		if( mode == CFPane.PaneMode.Edit ) {
			inEditState = true;
			allowAdds = false;
		}
		else {
			inEditState = false;
			if( getJavaFXContainer() != null ) {
				if( getLeft() != null ) {
					allowAdds = false;
					inAddMode = true;
				}
				else {
					allowAdds = true;
				}
			}
			else {
				allowAdds = false;
			}
		}
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			if( ( ! inAddMode ) && ( ! inEditState ) ) {
				enableState = true;
			}
			else {
				enableState = false;
			}
		}

		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( ! enableState );
		}
		if( buttonEditSelected != null ) {
			if( inEditState ) {
				buttonEditSelected.setDisable( true );
			}
			else {
				buttonEditSelected.setDisable( ! enableState );
			}
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( ! enableState );
		}
		if( buttonAddTopProject != null ) {
			buttonAddTopProject.setDisable( ! allowAdds );
		}

	}
}
