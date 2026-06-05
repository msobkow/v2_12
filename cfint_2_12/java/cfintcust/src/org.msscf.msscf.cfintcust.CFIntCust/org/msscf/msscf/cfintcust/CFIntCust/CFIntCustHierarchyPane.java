// Description: Java 13 Cust JavaFX Schema.

/*
 *	CF Int Cust JavaFX Implementation
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
 */

package org.msscf.msscf.cfintcust.CFIntCust;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfsec.CFSecObj.ICFSecTenantObj;
import org.msscf.msscf.cfint.CFIntJavaFX.*;
import org.msscf.msscf.cfint.CFIntObj.*;

public class CFIntCustHierarchyPane
extends CFBorderPane
implements ICFForm
{
	protected final String S_FormName = "Network Hierarchy";
	protected ICFFormManager cfFormManager = null;
	protected ICFIntCustSchema custSchema = null;

	protected CFLabel labelTitle = null;
	protected CFBorderPane borderSub = null;

	public class CFIntCustHierarchyItem
	extends TreeItem<CFIntCustHierarchyNode>
	{
		public CFIntCustHierarchyItem() {
			super();
		}
	}

	public class CFIntCustHierarchyNode
	implements ICFLibAnyObj
	{
		protected ICFLibAnyObj obj = null;

		public CFIntCustHierarchyNode() {
		}

		public ICFLibAnyObj getObj() {
			return( obj );
		}

		public void setObj( ICFLibAnyObj value ) {
			final String S_ProcName = "setObj";
			if( value == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					1,
					"value" );
			}
			if( value instanceof ICFIntTldObj ) {
				obj = value;
			}
			else if( value instanceof ICFIntTopDomainObj ) {
				obj = value;
			}
			else if( value instanceof ICFIntTopProjectObj ) {
				obj = value;
			}
			else if( value instanceof ICFIntSubProjectObj ) {
				obj = value;
			}
			else if( value instanceof ICFIntMajorVersionObj ) {
				obj = value;
			}
			else if( value instanceof ICFIntMinorVersionObj ) {
				obj = value;
			}
			else if( value instanceof ICFIntLicenseObj ) {
				obj = value;
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"value",
					value,
					"ICFIntTldObj, ICFIntTopDomainObj, ICFIntTopDomainObj, ICFIntTopProjectObj, ICFIntSubProjectObj, ICFIntMajorVersionObj, ICFIntMinorVersionObj, ICFIntLicenseObj" );
			}
		}

		public ICFIntTldObj getObjAsTld() {
			ICFIntTldObj retval = (ICFIntTldObj)obj;
			return( retval );
		}

		public ICFIntLicenseObj getObjAsLicense() {
			ICFIntLicenseObj retval = (ICFIntLicenseObj)obj;
			return( retval );
		}

		@Override
		public String getGenDefName() {
			String retval;
			if( obj != null ) {
				retval = obj.getGenDefName();
			}
			else {
				retval = "Object";
			}
			return( retval );
		}

		@Override
		public ICFLibAnyObj getObjScope() {
			ICFLibAnyObj retval;
			if( obj != null ) {
				retval = obj.getObjScope();
			}
			else {
				retval = null;
			}
			return( retval );
		}

		@Override
		public String getObjName() {
			String retval;
			if( obj != null ) {
				retval = obj.getObjName();
			}
			else {
				retval = ".";
			}
			return( retval );
		}

		@Override
		public String getObjQualifiedName() {
			String retval;
			if( obj != null ) {
				retval = obj.getObjQualifiedName();
			}
			else {
				retval = ".";
			}
			return( retval );
		}

		@Override
		public String getObjFullName() {
			String retval;
			if( obj != null ) {
				retval = obj.getObjFullName();
			}
			else {
				retval = ".";
			}
			return( retval );
		}

		@Override
		public ICFLibAnyObj getNamedObject(Class qualifyingClass, String objName) {
			ICFLibAnyObj retval;
			if( obj != null ) {
				retval = obj.getNamedObject( qualifyingClass, objName );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		@Override
		public ICFLibAnyObj getNamedObject(String objName) {
			ICFLibAnyObj retval;
			if( obj != null ) {
				retval = obj.getNamedObject( objName );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		@Override
		public ICFLibAnyObj getObjQualifier(Class qualifyingClass) {
			ICFLibAnyObj retval;
			if( obj != null ) {
				retval = obj.getObjQualifier( qualifyingClass );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public ICFIntTldObj getOptionalContainerTld() {
			ICFIntTldObj retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntTopDomainObj ) {
				retval = ((ICFIntTopDomainObj)obj).getRequiredContainerParentTld();
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public ICFIntTldObj getOptionalContainerTld( boolean forceRead ) {
			ICFIntTldObj retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntTopDomainObj ) {
				retval = ((ICFIntTopDomainObj)obj).getRequiredContainerParentTld( forceRead );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public ICFIntTopDomainObj getOptionalContainerParentDomain() {
			ICFIntTopDomainObj retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntTopProjectObj ) {
				retval = ((ICFIntTopProjectObj)obj).getRequiredContainerParentSDom();
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFIntSubProjectObj> getOptionalComponentsSubProject() {
			List<ICFIntSubProjectObj> retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntTopProjectObj ) {
				retval = ((ICFIntTopProjectObj)obj).getOptionalComponentsSubProject();
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFIntSubProjectObj> getOptionalComponentsSubProject( boolean forceRead ) {
			List<ICFIntSubProjectObj> retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntTopProjectObj ) {
				retval = ((ICFIntTopProjectObj)obj).getOptionalComponentsSubProject( forceRead );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFIntMajorVersionObj> getOptionalComponentsMajorVersion() {
			List<ICFIntMajorVersionObj> retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntSubProjectObj ) {
				retval = ((ICFIntSubProjectObj)obj).getOptionalComponentsMajorVer();
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFIntMajorVersionObj> getOptionalComponentsMajorVersion( boolean forceRead ) {
			List<ICFIntMajorVersionObj> retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntSubProjectObj ) {
				retval = ((ICFIntSubProjectObj)obj).getOptionalComponentsMajorVer( forceRead );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFIntMinorVersionObj> getOptionalComponentsMinorVersion() {
			List<ICFIntMinorVersionObj> retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntMajorVersionObj ) {
				retval = ((ICFIntMajorVersionObj)obj).getOptionalComponentsMinorVer();
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFIntMinorVersionObj> getOptionalComponentsMinorVersion( boolean forceRead ) {
			List<ICFIntMinorVersionObj> retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntMajorVersionObj ) {
				retval = ((ICFIntMajorVersionObj)obj).getOptionalComponentsMinorVer( forceRead );
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFLibAnyObj> getOptionalComponentsChildren() {
			List<ICFLibAnyObj> retval;
			if( obj == null ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntTldObj> tldlist = ((ICFIntSchemaObj)custSchema).getTldTableObj().readTldByTenantIdx( custSchema.getTenantObj().getRequiredId() );
				if( tldlist != null ) {
					Iterator<ICFIntTldObj> tlditer = tldlist.iterator();
					while( tlditer.hasNext() ) {
						CFIntCustHierarchyNode node = new CFIntCustHierarchyNode();
						node.setObj( tlditer.next() );
						retval.add( node );
					}
				}
			}
			else if( obj instanceof ICFIntTopProjectObj ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntSubProjectObj> subprojectlist = ((ICFIntTopProjectObj)obj).getOptionalComponentsSubProject();
				if( subprojectlist != null ) {
					Iterator<ICFIntSubProjectObj> subprojectiter = subprojectlist.iterator();
					while( subprojectiter.hasNext() ) {
						retval.add( subprojectiter.next() );
					}
				}
			}
			else if( obj instanceof ICFIntSubProjectObj ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntMajorVersionObj> majorversionlist = ((ICFIntSubProjectObj)obj).getOptionalComponentsMajorVer();
				if( majorversionlist != null ) {
					Iterator<ICFIntMajorVersionObj> majorversioniter = majorversionlist.iterator();
					while( majorversioniter.hasNext() ) {
						retval.add( majorversioniter.next() );
					}
				}
			}
			else if( obj instanceof ICFIntMajorVersionObj ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntMinorVersionObj> sublist = ((ICFIntMajorVersionObj)obj).getOptionalComponentsMinorVer();
				if( sublist != null ) {
					Iterator<ICFIntMinorVersionObj> subiter = sublist.iterator();
					while( subiter.hasNext() ) {
						retval.add( subiter.next() );
					}
				}
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public List<ICFLibAnyObj> getOptionalComponentsChildren( boolean forceRead ) {
			List<ICFLibAnyObj> retval;
			if( obj == null ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntTldObj> tldlist = ((ICFIntSchemaObj)custSchema).getTldTableObj().readTldByTenantIdx( custSchema.getTenantObj().getRequiredId(), forceRead );
				if( tldlist != null ) {
					Iterator<ICFIntTldObj> tlditer = tldlist.iterator();
					while( tlditer.hasNext() ) {
						CFIntCustHierarchyNode node = new CFIntCustHierarchyNode();
						node.setObj( tlditer.next() );
						retval.add( node );
					}
				}
			}
			if( obj instanceof ICFIntTopProjectObj ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntSubProjectObj> subprojectlist = ((ICFIntTopProjectObj)obj).getOptionalComponentsSubProject( forceRead );
				if( subprojectlist != null ) {
					Iterator<ICFIntSubProjectObj> subprojectiter = subprojectlist.iterator();
					while( subprojectiter.hasNext() ) {
						retval.add( subprojectiter.next() );
					}
				}
			}
			else if( obj instanceof ICFIntSubProjectObj ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntMajorVersionObj> majorversionlist = ((ICFIntSubProjectObj)obj).getOptionalComponentsMajorVer( forceRead );
				if( majorversionlist != null ) {
					Iterator<ICFIntMajorVersionObj> majorversioniter = majorversionlist.iterator();
					while( majorversioniter.hasNext() ) {
						retval.add( majorversioniter.next() );
					}
				}
			}
			else if( obj instanceof ICFIntMajorVersionObj ) {
				retval = new ArrayList<ICFLibAnyObj>();
				List<ICFIntMinorVersionObj> sublist = ((ICFIntMajorVersionObj)obj).getOptionalComponentsMinorVer( forceRead );
				if( sublist != null ) {
					Iterator<ICFIntMinorVersionObj> subiter = sublist.iterator();
					while( subiter.hasNext() ) {
						retval.add( subiter.next() );
					}
				}
			}
			else {
				retval = null;
			}
			return( retval );
		}

		public String getOptionalDescription() {
			String retval;
			if( obj == null ) {
				retval = null;
			}
			else if( obj instanceof ICFIntTopDomainObj ) {
				retval = ((ICFIntTopDomainObj)obj).getOptionalDescription();
			}
			else if( obj instanceof ICFIntLicenseObj ) {
				retval = ((ICFIntLicenseObj)obj).getOptionalDescription();
			}
			else {
				retval = null;
			}
			return( retval );
		}
	}

	protected CFIntCustHierarchyItem rootTreeItem = null;
	protected TreeTableView<CFIntCustHierarchyNode> treeTableView = null;

	protected CFHBox hboxMenu = null;
	protected CFButton buttonAdd = null;
	protected CFButton buttonAddTld = null;
	protected CFButton buttonAddTopDomain = null;
	protected CFButton buttonAddDomain = null;
	protected CFButton buttonAddTopProject = null;
	protected CFButton buttonAddSubProject = null;
	protected CFButton buttonAddMajorVersion = null;
	protected CFButton buttonAddMinorVersion = null;
	protected CFButton buttonAddLicense = null;
	protected CFButton buttonCancelAdd = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected CFButton buttonClose = null;

	boolean addingObject = false;

	public CFIntCustHierarchyPane(
		ICFFormManager formManager, 
		ICFIntCustSchema argSchema )
	{
		super();
		final String S_ProcName = "construct";
		if( formManager == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		cfFormManager = formManager;
		custSchema = argSchema;
		setMinWidth( 640.0 );

		labelTitle = new CFLabel();
		labelTitle.setText( "Int Hierarchy" );
		Font f = labelTitle.getFont();
		Font largeBold = Font.font( f.getFamily(), FontWeight.BOLD, 20 );
		labelTitle.setFont( largeBold );
		labelTitle.setMinHeight( 35 );
		labelTitle.setMaxHeight( 35 );
		labelTitle.setMinWidth( 200 );
		labelTitle.setAlignment( Pos.CENTER );

		rootTreeItem = buildRootItem();

		TreeTableColumn<CFIntCustHierarchyNode,String> columnName = new TreeTableColumn<>( "Name" );
		columnName.setPrefWidth( 250 );
		columnName.setCellValueFactory((CellDataFeatures<CFIntCustHierarchyNode,String> p ) ->
			new ReadOnlyStringWrapper(
				( ( p.getValue().getValue() == null )
					? "."
					: p.getValue().getValue().getObjName() ) ) );

		TreeTableColumn<CFIntCustHierarchyNode,String> columnClass = new TreeTableColumn<>( "Class" );
		columnClass.setPrefWidth( 200 );
		columnClass.setCellValueFactory((CellDataFeatures<CFIntCustHierarchyNode,String> p ) ->
			new ReadOnlyStringWrapper(
				( ( p.getValue().getValue() == null )
					? "."
					: p.getValue().getValue().getGenDefName() ) ) );

		TreeTableColumn<CFIntCustHierarchyNode,String> columnDescription = new TreeTableColumn<>( "Description" );
		columnDescription.setPrefWidth( 300 );
		columnDescription.setCellValueFactory((CellDataFeatures<CFIntCustHierarchyNode,String> p ) ->
			new ReadOnlyStringWrapper(
				( ( p.getValue().getValue() == null )
					? "."
					: p.getValue().getValue().getOptionalDescription() ) ) );

		treeTableView = new TreeTableView<>();
		treeTableView.setRoot( rootTreeItem );
		treeTableView.getColumns().add( columnName );
		treeTableView.getColumns().add( columnClass );
		treeTableView.getColumns().add( columnDescription );
		treeTableView.setPrefWidth( 500 );
		treeTableView.setMinWidth( 300 );
		treeTableView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<TreeItem<CFIntCustHierarchyNode>>() {
					@Override public void changed( ObservableValue<? extends TreeItem<CFIntCustHierarchyNode>> observable,
						TreeItem<CFIntCustHierarchyNode> oldValue,
						TreeItem<CFIntCustHierarchyNode> newValue )
					{
						if( newValue != null ) {
							setJavaFXFocus( newValue.getValue() );
						}
						else {
							setJavaFXFocus( null );
						}
					}
				});

		borderSub = new CFBorderPane();
		borderSub.setTop( getPanelHBoxMenu() );
		borderSub.setCenter( treeTableView );

		setTop( labelTitle );
		setCenter( borderSub );
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

	public void forceCancelAndClose() {
		if( cfFormManager != null ) {
			if( cfFormManager.getCurrentForm() == this ) {
				cfFormManager.closeCurrentForm();
			}
		}
	}

	public ICFIntCustSchema getCustSchema() {
		return( custSchema );
	}

	public void setCustSchema( ICFIntCustSchema argSchema ) {
		final String S_ProcName = "setCustSchema";
		final String S_ArgNameSchema = "argSchema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				S_ArgNameSchema );
		}
		custSchema = argSchema;
	}

	public CFIntCustHierarchyItem buildRootItem() {

		CFIntCustHierarchyItem rootItem = new CFIntCustHierarchyItem();
		List<ICFIntTldObj> tldlist = ((ICFIntSchemaObj)custSchema.getSchema()).getTldTableObj().readTldByTenantIdx( custSchema.getSchema().getAuthorization().getSecTenantId(), true );
		if( tldlist == null ) {
			return( rootItem );
		}

		ObservableList<TreeItem<CFIntCustHierarchyNode>> children = rootItem.getChildren();
		ICFIntTldObj tldobj;
		CFIntCustHierarchyNode node;
		TreeItem<CFIntCustHierarchyNode> treeItem;
		List<ICFIntTopDomainObj> topdomainlist;
		Iterator<ICFIntTopDomainObj> topdomainiter;
		ICFIntTopDomainObj topdomainobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> topdomainchildren;
		CFIntCustHierarchyNode topdomainnode;
		List<ICFIntLicenseObj> licenselist;
		Iterator<ICFIntLicenseObj> licenseiter;
		ICFIntLicenseObj licenseobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> licensechildren;
		CFIntCustHierarchyNode licensenode;
		List<ICFIntTopDomainObj> domainlist;
		Iterator<ICFIntTopDomainObj> domainiter;
		ICFIntTopDomainObj domainobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> domainchildren;
		CFIntCustHierarchyNode domainnode;
		List<ICFIntTopProjectObj> topprojectlist;
		Iterator<ICFIntTopProjectObj> topprojectiter;
		ICFIntTopProjectObj topprojectobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> topprojectchildren;
		CFIntCustHierarchyNode topprojectnode;
		List<ICFIntSubProjectObj> subprojectlist;
		Iterator<ICFIntSubProjectObj> subprojectiter;
		ICFIntSubProjectObj subprojectobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> subprojectchildren;
		CFIntCustHierarchyNode subprojectnode;
		List<ICFIntMajorVersionObj> majorversionlist;
		Iterator<ICFIntMajorVersionObj> majorversioniter;
		ICFIntMajorVersionObj majorversionobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> majorversionchildren;
		CFIntCustHierarchyNode majorversionnode;
		List<ICFIntMinorVersionObj> minorversionlist;
		Iterator<ICFIntMinorVersionObj> minorversioniter;
		ICFIntMinorVersionObj minorversionobj;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> minorversionchildren;
		CFIntCustHierarchyNode minorversionnode;
		ObservableList<TreeItem<CFIntCustHierarchyNode>> tldchildren;

		Iterator<ICFIntTldObj> tlditer = tldlist.iterator();
		while( tlditer.hasNext() ) {
			tldobj = tlditer.next();
			if( tldobj != null ) {
				node = new CFIntCustHierarchyNode();
				node.setObj( tldobj );
				treeItem = new TreeItem<CFIntCustHierarchyNode>();
				treeItem.setValue( node );
				treeItem.setExpanded( false );
				children.add( treeItem );
				tldchildren = treeItem.getChildren();
				topdomainlist = tldobj.getOptionalComponentsTopDomain();
				if( topdomainlist != null ) {
					topdomainiter = topdomainlist.iterator();
					if( topdomainiter != null ) {
						while( topdomainiter.hasNext() ) {
							topdomainobj = topdomainiter.next();
							if( topdomainobj != null ) {
								topdomainnode = new CFIntCustHierarchyNode();
								topdomainnode.setObj( topdomainobj );
								treeItem = new TreeItem<CFIntCustHierarchyNode>();
								treeItem.setValue( topdomainnode );
								treeItem.setExpanded( false );
								tldchildren.add( treeItem );
								topdomainchildren = treeItem.getChildren();
								licenselist = topdomainobj.getOptionalComponentsLicense();
								if( licenselist != null ) {
									licenseiter = licenselist.iterator();
									if( licenseiter != null ) {
										while( licenseiter.hasNext() ) {
											licenseobj = licenseiter.next();
											if( licenseobj != null ) {
												licensenode = new CFIntCustHierarchyNode();
												licensenode.setObj( licenseobj );
												treeItem = new TreeItem<CFIntCustHierarchyNode>();
												treeItem.setValue( licensenode );
												treeItem.setExpanded( false );
												topdomainchildren.add( treeItem );
												licensechildren = treeItem.getChildren();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		rootItem.setExpanded( true );
		return( rootItem );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof CFIntCustHierarchyNode ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"CFIntCustHierarchyNode" );
		}
		adjustListButtons();
	}

	public CFIntCustHierarchyNode getJavaFXFocusAsCustHierarchyNode() {
		return( (CFIntCustHierarchyNode)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsCustHierarchyNode( CFIntCustHierarchyNode value ) {
		setJavaFXFocus( value );
	}

	class ViewEditClosedCallback implements ICFFormClosedCallback {
		public ViewEditClosedCallback() {
		}

		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				if( addingObject ) {
					TreeItem<CFIntCustHierarchyNode> selectedItem;
					if( affectedObject instanceof ICFIntTldObj ) {
						selectedItem = treeTableView.getRoot();
					}
					else {
						selectedItem = treeTableView.getSelectionModel().getSelectedItem();
						if( selectedItem == null ) {
							selectedItem = treeTableView.getRoot();
						}
					}

					CFIntCustHierarchyNode newNode = new CFIntCustHierarchyNode();
					newNode.setObj( affectedObject );
					TreeItem<CFIntCustHierarchyNode> treeItem = new TreeItem<CFIntCustHierarchyNode>();
					treeItem.setValue( newNode );
					treeItem.setExpanded( false );
					selectedItem.getChildren().add( treeItem );
					selectedItem.setExpanded( true );

					addingObject = false;
				}
				// Hack from stackoverflow to fix JavaFX TableView refresh issue
				((TreeTableColumn)treeTableView.getColumns().get(1)).setVisible( false );
				((TreeTableColumn)treeTableView.getColumns().get(1)).setVisible( true );
			}
			adjustListButtons();
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
		public void deleted( ICFLibAnyObj deletedObject ) {
			if( deletedObject != null ) {
				TreeItem<CFIntCustHierarchyNode> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
				if( selectedItem != null ) {
					CFIntCustHierarchyNode node = selectedItem.getValue();
					if( node.getObj() == deletedObject ) {
						TreeItem<CFIntCustHierarchyNode> parentItem = selectedItem.getParent();
						if( parentItem != null ) {
							ObservableList<TreeItem<CFIntCustHierarchyNode>> children = parentItem.getChildren();
							int len = children.size();
							TreeItem<CFIntCustHierarchyNode> cur;
							CFIntCustHierarchyNode curNode;
							for( int idx = 0; idx < len; idx ++ ) {
								cur = children.get( idx );
								if( cur != null ) {
									curNode = cur.getValue();
									if( curNode != null ) {
										if( deletedObject == curNode.getObj() ) {
											children.remove( idx );
											break;
										}
									}
								}
							}
							treeTableView.getSelectionModel().clearSelection();
							setJavaFXFocus( null );
							if( len == 1 ) {
								parentItem.setExpanded( false );
							}
							// Hack from stackoverflow to fix JavaFX TableView refresh issue
							((TreeTableColumn)treeTableView.getColumns().get(1)).setVisible( false );
							((TreeTableColumn)treeTableView.getColumns().get(1)).setVisible( true );
						}
					}
				}
			}
			adjustListButtons();
		}

		public void formClosed( ICFLibAnyObj affectedObject ) {
		}
	}

	protected DeleteCallback deleteCallback = null;

	public ICFDeleteCallback getDeleteCallback() {
		if( deleteCallback == null ) {
			deleteCallback = new DeleteCallback();
		}
		return( deleteCallback );
	}

	public CFHBox getPanelHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );

				buttonAddTld = new CFButton();
				buttonAddTld.setText( "Add TLD" );
				buttonAddTld.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntTldObj obj = (ICFIntTldObj)schemaObj.getTldTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getTldFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntTldEditObj edit = (ICFIntTldEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredContainerTenant( secTenant );

							ICFIntJavaFXTldPaneCommon jpanelCommon = (ICFIntJavaFXTldPaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				} );
				buttonAddTld.setMinWidth( 200 );
				buttonAddTld.setMaxWidth( 200 );

				buttonAddTopDomain = new CFButton();
				buttonAddTopDomain.setText( "Add Top Domain" );
				buttonAddTopDomain.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntTopDomainObj obj = (ICFIntTopDomainObj)schemaObj.getTopDomainTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getTopDomainFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntTopDomainEditObj edit = (ICFIntTopDomainEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredOwnerTenant( secTenant );
							ICFIntTldObj container = (ICFIntTldObj)getJavaFXFocusAsCustHierarchyNode().getObj();
							if( container == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"JavaFXContainer" );
							}
							edit.setRequiredContainerParentTld( container );
							ICFIntJavaFXTopDomainPaneCommon jpanelCommon = (ICFIntJavaFXTopDomainPaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				buttonAddTopDomain.setMinWidth( 200 );
				buttonAddTopDomain.setMaxWidth( 200 );

				buttonAddTopProject = new CFButton();
				buttonAddTopProject.setText( "Add Top Project" );
				buttonAddTopProject.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntTopProjectObj obj = (ICFIntTopProjectObj)schemaObj.getTopProjectTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getTopProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntTopProjectEditObj edit = (ICFIntTopProjectEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredOwnerTenant( secTenant );
							ICFLibAnyObj container = getJavaFXFocusAsCustHierarchyNode().getObj();
							if( container == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"JavaFXContainer" );
							}
							if( container instanceof ICFIntTopDomainObj ) {
								edit.setRequiredContainerParentSDom( (ICFIntTopDomainObj)container );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"container",
									container,
									"ICIntTopDomainObj, ICFIntTopDomainObj" );
							}
							ICFIntJavaFXTopProjectPaneCommon jpanelCommon = (ICFIntJavaFXTopProjectPaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				buttonAddTopProject.setMinWidth( 200 );
				buttonAddTopProject.setMaxWidth( 200 );

				buttonAddSubProject = new CFButton();
				buttonAddSubProject.setText( "Add Sub-Project" );
				buttonAddSubProject.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntSubProjectObj obj = (ICFIntSubProjectObj)schemaObj.getSubProjectTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getSubProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntSubProjectEditObj edit = (ICFIntSubProjectEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredOwnerTenant( secTenant );
							ICFIntTopProjectObj container = (ICFIntTopProjectObj)getJavaFXFocusAsCustHierarchyNode().getObj();
							if( container == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"JavaFXContainer" );
							}
							edit.setRequiredContainerParentTPrj( container );
							ICFIntJavaFXSubProjectPaneCommon jpanelCommon = (ICFIntJavaFXSubProjectPaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				buttonAddSubProject.setMinWidth( 200 );
				buttonAddSubProject.setMaxWidth( 200 );

				buttonAddMajorVersion = new CFButton();
				buttonAddMajorVersion.setText( "Add Major Version" );
				buttonAddMajorVersion.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntMajorVersionObj obj = (ICFIntMajorVersionObj)schemaObj.getMajorVersionTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getMajorVersionFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntMajorVersionEditObj edit = (ICFIntMajorVersionEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredOwnerTenant( secTenant );
							ICFIntSubProjectObj container = (ICFIntSubProjectObj)getJavaFXFocusAsCustHierarchyNode().getObj();
							if( container == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"JavaFXContainer" );
							}
							edit.setRequiredContainerParentSPrj( container );
							ICFIntJavaFXMajorVersionPaneCommon jpanelCommon = (ICFIntJavaFXMajorVersionPaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				buttonAddMajorVersion.setMinWidth( 200 );
				buttonAddMajorVersion.setMaxWidth( 200 );

				buttonAddMinorVersion = new CFButton();
				buttonAddMinorVersion.setText( "Add Minor Version" );
				buttonAddMinorVersion.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntMinorVersionObj obj = (ICFIntMinorVersionObj)schemaObj.getMinorVersionTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getMinorVersionFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntMinorVersionEditObj edit = (ICFIntMinorVersionEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredOwnerTenant( secTenant );
							ICFIntMajorVersionObj container = (ICFIntMajorVersionObj)getJavaFXFocusAsCustHierarchyNode().getObj();
							if( container == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"JavaFXContainer" );
							}
							edit.setRequiredContainerParentMajVer( container );
							ICFIntJavaFXMinorVersionPaneCommon jpanelCommon = (ICFIntJavaFXMinorVersionPaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				buttonAddMinorVersion.setMinWidth( 200 );
				buttonAddMinorVersion.setMaxWidth( 200 );

				buttonAddLicense = new CFButton();
				buttonAddLicense.setText( "Add License" );
				buttonAddLicense.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
							ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
							ICFIntLicenseObj obj = (ICFIntLicenseObj)schemaObj.getLicenseTableObj().newInstance();
							CFBorderPane frame = javafxSchema.getLicenseFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
							ICFIntLicenseEditObj edit = (ICFIntLicenseEditObj)( obj.beginEdit() );
							if( edit == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"edit" );
							}
							ICFSecTenantObj secTenant = schemaObj.getSecTenant();
							edit.setRequiredOwnerTenant( secTenant );
							ICFIntTopDomainObj container = (ICFIntTopDomainObj)getJavaFXFocusAsCustHierarchyNode().getObj();
							if( container == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"JavaFXContainer" );
							}
							edit.setRequiredContainerTopDomain( container );
							ICFIntJavaFXLicensePaneCommon jpanelCommon = (ICFIntJavaFXLicensePaneCommon)frame;
							jpanelCommon.setJavaFXFocus( obj );
							jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
							cfFormManager.pushForm( frame );
							borderSub.setLeft( null );
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				buttonAddLicense.setMinWidth( 200 );
				buttonAddLicense.setMaxWidth( 200 );

				buttonCancelAdd = new CFButton();
				buttonCancelAdd.setText( "Cancel Add..." );
				buttonCancelAdd.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							borderSub.setLeft( null );
							addingObject = false;
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});

			buttonAdd = new CFButton();
			buttonAdd.setText( "Add..." );
			buttonAdd.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ScrollPane scrollMenuAdd = null;
						CFVBox vboxMenuAdd = new CFVBox( 10 );
						vboxMenuAdd.getChildren().add( buttonAddTld );
						CFIntCustHierarchyNode node = getJavaFXFocusAsCustHierarchyNode();
						if( node != null ) {
							ICFLibAnyObj container = node.getObj();
							if( container != null ) {
								if( container instanceof ICFIntTldObj ) {
									vboxMenuAdd.getChildren().add( buttonAddTopDomain );
								}
								else if( container instanceof ICFIntTopDomainObj ) {
									vboxMenuAdd.getChildren().add( buttonAddTopProject );
									vboxMenuAdd.getChildren().add( buttonAddLicense );
								}
								else if( container instanceof ICFIntTopProjectObj ) {
									vboxMenuAdd.getChildren().add( buttonAddSubProject );
								}
								else if( container instanceof ICFIntSubProjectObj ) {
									vboxMenuAdd.getChildren().add( buttonAddMajorVersion );
								}
								else if( container instanceof ICFIntMajorVersionObj ) {
									vboxMenuAdd.getChildren().add( buttonAddMinorVersion );
								}
								else if( container instanceof ICFIntMinorVersionObj ) {
								}
								else if( container instanceof ICFIntLicenseObj ) {
								}
								else {
									throw new CFLibUnsupportedClassException( getClass(),
										S_ProcName,
										"container",
										container,
										"ICFIntTldObj, ICFIntTopDomainObj, ICFIntTopDomainObj, ICFIntTopProjectObj, ICFIntSubProjectObj, ICFIntMajorVersionObj, ICFIntMinorVersionObj, ICFIntLicenseObj" );
								}
							}
						}
						vboxMenuAdd.getChildren().add( buttonCancelAdd );

						scrollMenuAdd = new ScrollPane();
						scrollMenuAdd.setMinWidth( 240 );
						scrollMenuAdd.setMaxWidth( 240 );
						scrollMenuAdd.setHbarPolicy( ScrollBarPolicy.NEVER );
						scrollMenuAdd.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
						scrollMenuAdd.setFitToWidth( true );
						scrollMenuAdd.setContent( vboxMenuAdd );

						borderSub.setLeft( scrollMenuAdd );
						addingObject = true;
						adjustListButtons();
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAdd );

			buttonViewSelected = new CFButton();
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						addingObject = false;
						ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
						ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						CFIntCustHierarchyNode node = getJavaFXFocusAsCustHierarchyNode();
						if( node != null ) {
							ICFLibAnyObj selectedInstance = node.getObj();
							if( selectedInstance != null ) {
								if( selectedInstance instanceof ICFIntTldObj ) {
									ICFIntTldObj obj = (ICFIntTldObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTldFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXTldPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntTopDomainObj ) {
									ICFIntTopDomainObj obj = (ICFIntTopDomainObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTopDomainFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXTopDomainPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntTopProjectObj ) {
									ICFIntTopProjectObj obj = (ICFIntTopProjectObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTopProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXTopProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntSubProjectObj ) {
									ICFIntSubProjectObj obj = (ICFIntSubProjectObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getSubProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXSubProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntMajorVersionObj ) {
									ICFIntMajorVersionObj obj = (ICFIntMajorVersionObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getMajorVersionFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXMajorVersionPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntMinorVersionObj ) {
									ICFIntMinorVersionObj obj = (ICFIntMinorVersionObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getMinorVersionFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXMinorVersionPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntLicenseObj ) {
									ICFIntLicenseObj obj = (ICFIntLicenseObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getLicenseFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXLicensePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else {
									throw new CFLibUnsupportedClassException( getClass(),
										S_ProcName,
										"selectedInstance",
										selectedInstance,
										"ICFIntTldObj, ICFIntTopDomainObj, ICFIntTopDomainObj, ICFIntTopProjectObj, ICFIntSubProjectObj, ICFIntMajorVersionObj, ICFIntMinorVersionObj, ICFIntLicenseObj" );
								}
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
			buttonEditSelected.setText( "Edit Selected" );
			buttonEditSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						addingObject = false;
						ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
						ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						CFIntCustHierarchyNode node = getJavaFXFocusAsCustHierarchyNode();
						if( node != null ) {
							ICFLibAnyObj selectedInstance = node.getObj();
							if( selectedInstance != null ) {
								if( selectedInstance instanceof ICFIntTldObj ) {
									ICFIntTldObj obj = (ICFIntTldObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTldFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXTldPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntTopDomainObj ) {
									ICFIntTopDomainObj obj = (ICFIntTopDomainObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTopDomainFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXTopDomainPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntTopProjectObj ) {
									ICFIntTopProjectObj obj = (ICFIntTopProjectObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTopProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXTopProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntSubProjectObj ) {
									ICFIntSubProjectObj obj = (ICFIntSubProjectObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getSubProjectFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXSubProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntMajorVersionObj ) {
									ICFIntMajorVersionObj obj = (ICFIntMajorVersionObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getMajorVersionFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXMajorVersionPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntMinorVersionObj ) {
									ICFIntMinorVersionObj obj = (ICFIntMinorVersionObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getMinorVersionFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXMinorVersionPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntLicenseObj ) {
									ICFIntLicenseObj obj = (ICFIntLicenseObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getLicenseFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), false );
									((ICFIntJavaFXLicensePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
									cfFormManager.pushForm( frame );
								}
								else {
									throw new CFLibUnsupportedClassException( getClass(),
										S_ProcName,
										"selectedInstance",
										selectedInstance,
										"ICFIntTldObj, ICFIntTopDomainObj, ICFIntTopDomainObj, ICFIntTopProjectObj, ICFIntSubProjectObj, ICFIntMajorVersionObj, ICFIntMinorVersionObj, ICFIntLicenseObj" );
								}
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
			buttonDeleteSelected.setText( "Delete Selected" );
			buttonDeleteSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						addingObject = false;
						ICFIntJavaFXSchema javafxSchema = (ICFIntJavaFXSchema)custSchema.getJavaFXSchema();
						ICFIntSchemaObj schemaObj = (ICFIntSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						CFIntCustHierarchyNode node = getJavaFXFocusAsCustHierarchyNode();
						if( node != null ) {
							ICFLibAnyObj selectedInstance = node.getObj();
							if( selectedInstance != null ) {
								if( selectedInstance instanceof ICFIntTldObj ) {
									ICFIntTldObj obj = (ICFIntTldObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTldFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXTldPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntTopDomainObj ) {
									ICFIntTopDomainObj obj = (ICFIntTopDomainObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTopDomainFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXTopDomainPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntTopProjectObj ) {
									ICFIntTopProjectObj obj = (ICFIntTopProjectObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getTopProjectFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXTopProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntSubProjectObj ) {
									ICFIntSubProjectObj obj = (ICFIntSubProjectObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getSubProjectFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXSubProjectPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntMajorVersionObj ) {
									ICFIntMajorVersionObj obj = (ICFIntMajorVersionObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getMajorVersionFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXMajorVersionPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntMinorVersionObj ) {
									ICFIntMinorVersionObj obj = (ICFIntMinorVersionObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getMinorVersionFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXMinorVersionPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else if( selectedInstance instanceof ICFIntLicenseObj ) {
									ICFIntLicenseObj obj = (ICFIntLicenseObj)selectedInstance;
									CFBorderPane frame = javafxSchema.getLicenseFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
									((ICFIntJavaFXLicensePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
									cfFormManager.pushForm( frame );
								}
								else {
									throw new CFLibUnsupportedClassException( getClass(),
										S_ProcName,
										"selectedInstance",
										selectedInstance,
										"ICFIntTldObj, ICFIntTopDomainObj, ICFIntTopDomainObj, ICFIntTopProjectObj, ICFIntSubProjectObj, ICFIntMajorVersionObj, ICFIntMinorVersionObj, ICFIntLicenseObj" );
								}
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
			buttonClose.setVisible( true );
			buttonClose.setMinWidth( 200 );
			buttonClose.setMaxWidth( 200 );
			buttonClose.setPrefWidth( 200 );
			buttonClose.setMinHeight( 25 );
			buttonClose.setMaxHeight( 25 );
			buttonClose.setPrefHeight( 25 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					try {
						if( cfFormManager != null ) {
							cfFormManager.closeCurrentForm();
						}
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

	public void adjustListButtons() {
		boolean enableState;
		boolean allowAdds;
		CFIntCustHierarchyNode selectedObj = getJavaFXFocusAsCustHierarchyNode();
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = ! addingObject;
		}

		if( borderSub.getLeft() != null ) {
			allowAdds = false;
		}
		else {
			allowAdds = true;
		}

		if( buttonAdd != null ) {
			buttonAdd.setDisable( ! allowAdds );
		}
		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( ! enableState );
		}
		if( buttonEditSelected != null ) {
			buttonEditSelected.setDisable( ! enableState );
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( ! enableState );
		}
	}
}
