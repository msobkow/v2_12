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

import javafx.scene.control.TableCell;

import org.msscf.msscf.cflib.CFLib.*;

public class CFBoolTableCell<T>
extends TableCell<T,Boolean>
{
	@Override protected void updateItem( Boolean item, boolean empty ) {
		super.updateItem( item, empty );
		if( empty ) {
			setText( null );
			setStyle( "" );
		}
		else if( item == null ) {
			setText( "?" );
			setStyle( "-fx-alignment: CENTER" );
		}
		else {
			boolean value = item.booleanValue();
			String cellText;
			if( value ) {
				cellText = "T";
			}
			else {
				cellText = "F";
			}
			setText( cellText );
			setStyle( "-fx-alignment: CENTER" );
		}
	}
}
