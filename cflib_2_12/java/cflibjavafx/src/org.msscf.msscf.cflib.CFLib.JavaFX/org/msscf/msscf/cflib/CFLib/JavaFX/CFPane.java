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

import javafx.scene.layout.Pane;

import org.msscf.msscf.cflib.CFLib.*;

public class CFPane
extends Pane
implements ICFPaneCommon
{
	/**
	 *	Panels all start in an Unknown or View state.
	 *
	 *	public void AttrJPanel.setPanelMode( CFJPanel.PanelMode value ) {
	 *		CFJPanel.PanelMode.oldMode = getPanelMode();
	 *		if( value != CFJPanel.PanelMode.Unknown ) {
	 *			if( SwingFocus is null ) {
	 *				RAISE NullParameterException;
	 *			}
	 *		}
	 *		super.setPanelMode( value );
	 *		switch( value ) {
	 *			case Unknown:
	 *				if( swingFocus is not null ) {
	 *					if( editing SwingFocus ) {
	 *						swingFocus.Edit.endEdit();
	 *					}
	 *				}
	 *				break;
	 *			case View:
	 *				if( editing SwingFocus ) {
	 *					switch( oldMode ) {
	 *						case Unknown:
	 *							break;
	 *						case View:
	 *							break;
	 *						case Edit:
	 *							if( editing SwingFocus ) {
	 *								SwingFocus.Edit.endEdit();
	 *							}
	 *							break;
	 *						case Update:
	 *							if( editing SwingFocus ) {
	 *								SwingFocus.Edit.endEdit();
	 *							}
	 *							break;
	 *						case Delete:
	 *							if( SwingFocus is not null ) {
	 *								if( editing SwingFocus ) {
	 *									SwingFocus.Edit.endEdit();
	 *								}
	 *								SwingFocus = null;
	 *							}
	 *							break;
	 *				}
	 *				break;
	 *			case Edit:
	 *				if not editing SwingFocus
	 *				then
	 *					SwingFocus.beginEdit()
	 *				end if
	 *				break;
	 *			case Update:
	 *				switch( oldMode ) {
	 *					case View:
	 *						if( editing SwingFocus ) {
	 *							SwingFocus.Edit.endEdit();
	 *						}
	 *						break;
	 *					case Edit:
	 *						PostDisplayChangesToEditObj
	 *						SwingFocus.Edit.update();
	 *						SwingFocus.Edit.endEdit();
	 *						break;
	 *					default:
	 *						RAISE UsageException
	 *						break;
	 *				}
	 *				if( SwingFocus is null ) {
	 *					setPanelMode( CFJPanel.PanelMode.Unknown );
	 *				}
	 *				else {
	 *					setPanelMode( CFJPanel.PanelMode.View );
	 *				}
	 *				break;
	 *			case Delete:
	 *				if( oldMode != CFJPanel.PanelMode.Edit ) {
	 *					RAISE UsageException
	 *				}
	 *				SwingFocus.Edit.delete();
	 *				SwingFocus.Edit.endEdit();
	 *				SwingFocus = null;
	 *				setPanelMode( CFJPanel.PanelMode.Unknown );
	 *				break;
	 *		}
	 *		RefreshDisplayedValues
	 *	}
	 */
	public enum PaneMode {
		Unknown,
		Add,
		View,
		Edit,
		Update,
		Delete
	};

	protected ICFLibAnyObj javaFXFocus = null;
	protected CFPane.PaneMode paneMode = CFPane.PaneMode.Unknown;
	
	public CFPane() {
		super();
	}

	public ICFLibAnyObj getJavaFXFocus() {
		return( javaFXFocus );
	}
	
	public void setJavaFXFocus( ICFLibAnyObj value ) {
		javaFXFocus = value;
	}
	
	public CFPane.PaneMode getPaneMode() {
		return( paneMode );
	}
	
	public void setPaneMode( CFPane.PaneMode value ) {
		paneMode = value;
	}
}
