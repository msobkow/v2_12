/*
 *  MSS Code Factory CFLib 2.12
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

package org.msscf.msscf.cflib.CFLib.JavaFX;

import javafx.scene.Node;

import org.msscf.msscf.cflib.CFLib.*;

/**
 *	The ICFDesktopManager specifies the interface from an application's
 *	forms to the desktop display manager in charge of that facet of forms.
 */
public interface ICFFormManager
{
	/**
	 *	Sometimes you'll want to check to see what the current node
	 *	form being displayed is.
	 */
	Node getCurrentForm();
	
	/**
	 *	Set the currently displayed form, clearing the form stack
	 *	and making the specified the root form for processing.
	 */
	void setRootForm( Node value );
	
	/**
	 *	Push a form on the stack.  The specified form becomes the current
	 *	displayed form.  You should never push the same set of nodes
	 *	more than once to the form manager, and you should never push
	 *	a root form on the stack.
	 */
	void pushForm( Node value );
	
	/**
	 *	Close the current form.  If you're paranoid, you can use
	 *	getCurrentForm() to make sure you're the current form before
	 *	invoking this method.
	 *
	 *	If the stack is empty and you are logged in, calling
	 *	closeCurrentForm() will cause showRootMainForm() to be
	 *	invoked.
	 */
	void closeCurrentForm();
	
	/**
	 *	Show the root main form for the facet.
	 */
	void showRootMainForm();
}
