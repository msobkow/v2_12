// Description: Java 13 Custom JavaFX Schema.

/*
 *  MSS Code Factory CFBam 2.12 Cust Editor
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

package org.msscf.msscf.cfbamcust.CFBamCustEditor;

import java.util.LinkedList;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.CFReferenceEditor.ICFReferenceCallback;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfsec.CFSecSaxLoader.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfint.CFIntSaxLoader.*;
import org.msscf.msscf.cfint.CFIntJavaFX.*;
import org.msscf.msscf.cfintcust.CFIntCust.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfbam.CFBamSaxLoader.*;
import org.msscf.msscf.cfbam.CFBamJavaFX.*;
import org.msscf.msscf.cfbam.CFBamMssCF.*;
import org.msscf.msscf.cfbam.CFBamRam.*;
import org.msscf.msscf.cfbamcust.MSSBamCF.*;
import org.msscf.msscf.cfbamcust.CFBamXmlLoader.*;
import org.msscf.msscf.cfbamcust.CFBamCust.*;

public class CFBamCustEditorMainPane
extends AnchorPane
implements ICFSecAuthorizationCallbacks
{
	protected ICFBamCustEditorSchema customSchema = null;
	protected CFSplitPane splitPane = null;
	protected CFTitledPane appConsoleTitledPane = null;
	protected CFConsole appConsole = null;
	protected CFPaneFormManager paneFormManager = null;
	protected CFBamCustEditorHierarchyPane paneBamEditorHierarchy = null;
	protected ICFBamCustEditorSchema javafxSchema = null;
	protected String modelName = null;

	public class CFPaneFormManager
	extends CFBorderPane
	implements ICFFormManager
	{
		protected LinkedList<Node> formStack = new LinkedList<Node>();

		public CFPaneFormManager() {
			super();
		}

		/**
		 *	Sometimes you'll want to check to see what the current node
		 *	form being displayed is.
		 */
		public Node getCurrentForm() {
			if( formStack.isEmpty() ) {
				return( null );
			}
			Node retval = formStack.getLast();
			return( retval );
		}

		/**
		 *	Set the currently displayed form, clearing the form stack
		 *	and making the specified the root form for processing.
		 */
		public void setRootForm( Node value ) {
			final String S_ProcName = "setRootForm";
			if( value == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					1,
					"value" );
			}
			if( ! ( value instanceof ICFForm ) ) {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Specified node value can not be cast to ICFForm" );
			}
			while( ! formStack.isEmpty() ) {
				Node top = formStack.getLast();
				ICFForm form = (ICFForm)top;
				try {
					form.forceCancelAndClose();
				}
				catch( RuntimeException e ) {
				}
				if( ! formStack.isEmpty() ) {
					if( top == formStack.getLast() ) {
						// Close wasn't called like it should have been
						formStack.removeLast();
					}
				}
			}
			formStack.add( value );
			setCenter( value );
		}

		/**
		 *	Push a form on the stack.  The specified form becomes the current
		 *	displayed form.  You should never push the same set of nodes
		 *	more than once to the form manager, and you should never push
		 *	a root form on the stack.
		 */
		public void pushForm( Node value ) {
			final String S_ProcName = "pushForm";
			if( value == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					1,
					"value" );
			}
			if( ! ( value instanceof ICFForm ) ) {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Specified node value can not be cast to ICFForm" );
			}
			formStack.add( value );
			setCenter( value );
		}

		/**
		 *	Close the current form.  If you're paranoid, you can use
		 *	getCurrentForm() to make sure you're the current form before
		 *	invoking this method.
		 *
		 *	If the stack is empty and you are logged in, calling
		 *	closeCurrentForm() will cause showRootMainForm() to be
		 *	invoked.
		 */
		public void closeCurrentForm() {
			if( formStack.isEmpty() ) {
				return;
			}
			formStack.removeLast();
			if( formStack.isEmpty() ) {
				showRootMainForm();
			}
			else {
				setCenter( formStack.getLast() );
			}
		}

		/**
		 *	Show the root main form for the facet.
		 */
		public void showRootMainForm() {
			if( paneBamEditorHierarchy == null ) {
				paneBamEditorHierarchy = new CFBamCustEditorHierarchyPane( this, javafxSchema, modelName );
			}
			setRootForm( paneBamEditorHierarchy );
		}
	}

	public CFBamCustEditorMainPane(
		ICFBamCustEditorSchema argSchema,
		String argModelName )
	{
		super();
		final String S_ProcName = "construct";
		if( argModelName == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argModelName" );
		}
		modelName = argModelName;
		customSchema = argSchema;
		setMinHeight( 640 );
		setMinWidth( 1000 );
		splitPane = new CFSplitPane();

		appConsoleTitledPane = new CFTitledPane();
		appConsoleTitledPane.setText( "Console Log" );

		appConsole = new CFConsole();
		appConsole.setMinHeight( 60 );
		appConsoleTitledPane.setContent( appConsole );

		paneFormManager = new CFPaneFormManager();
		paneBamEditorHierarchy = new CFBamCustEditorHierarchyPane( paneFormManager, argSchema, modelName );
		paneFormManager.setRootForm( paneBamEditorHierarchy );
		splitPane.setOrientation( Orientation.VERTICAL );
		splitPane.getItems().add( paneFormManager );
		splitPane.getItems().add( appConsoleTitledPane );
		setTopAnchor( splitPane, 0.0 );
		setLeftAnchor( splitPane, 0.0 );
		setRightAnchor( splitPane, 0.0 );
		setBottomAnchor( splitPane, 0.0 );
		getChildren().addAll( splitPane );
	}

	public ICFBamCustEditorSchema getCustomSchema() {
		return( customSchema );
	}

	public void setCustomSchema( ICFBamCustEditorSchema argSchema ) {
		final String S_ProcName = "setCustomSchema";
		final String S_ArgNameSchema = "argSchema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				S_ArgNameSchema );
		}
		if( ! ( argSchema instanceof ICFBamCustEditorSchema ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				S_ArgNameSchema,
				argSchema,
				"ICFBamCustSchema" );
		}
		customSchema = (ICFBamCustEditorSchema)argSchema;
		if( paneBamEditorHierarchy != null ) {
			paneBamEditorHierarchy.setCustomSchema( customSchema );
		}
	}

	public void loggedIn() {
	}

	public void preLogout() {
	}
}
